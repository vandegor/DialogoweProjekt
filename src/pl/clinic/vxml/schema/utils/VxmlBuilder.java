package pl.clinic.vxml.schema.utils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;

import pl.clinic.model.ModelInterface;
import pl.clinic.model.impl.Visit;
import pl.clinic.vxml.schema.impl.Grammar;
import pl.clinic.vxml.schema.impl.Item;
import pl.clinic.vxml.schema.impl.ObjectFactory;
import pl.clinic.vxml.schema.impl.OneOf;
import pl.clinic.vxml.schema.impl.Rule;
import pl.clinic.vxml.schema.impl.ScopeDatatype;
import pl.clinic.vxml.schema.impl.VxmlSpeak;

public class VxmlBuilder {

	private static ObjectFactory factory = new ObjectFactory();

	public static JAXBElement<Grammar> buildGrammar(String fieldName, List<ModelInterface> modelObjects) {
		Grammar grammar = factory.createGrammar();
		OneOf oneOf = prebuildGrammar(fieldName, grammar);

		for (ModelInterface modelObject : modelObjects) {
			List<Item> item = buildItem(modelObject);
			oneOf.getItem().addAll(item);
		}
		return factory.createGrammar(grammar);
	}

	public static JAXBElement<Grammar> buildGrammarForVisit(String fieldName, List<Visit> visits) {
		Grammar grammar = factory.createGrammar();
		OneOf oneOf = prebuildGrammar(fieldName, grammar);

		for (Visit visit : visits) {
			Item item = buildVisitItem(visit);
			oneOf.getItem().add(item);
		}
		return factory.createGrammar(grammar);
	}

	private static Map<String, String> getVisitFieldsMap(Visit visit) {
		Map<String, String> map = new HashMap<String, String>();
		String[] date = new SimpleDateFormat("yyyy MMMMM dd", Locale.US).format(visit.getDate()).split(" ");

		buildMap(map, "visitId", visit.getId().toString());
		//buildMap(map, "doctorId", visit.getDoctor().getId().toString());
		//buildMap(map, "doctorName", visit.getDoctor().getName());
		//buildMap(map, "doctorSurname", visit.getDoctor().getSurname());
		//buildMap(map, "year", date[0]);
		//buildMap(map, "month", date[1]);
		//buildMap(map, "day", date[2]);
		//buildMap(map, "timeOfDayId", visit.getTime().getId().toString());
		//buildMap(map, "timeOfDayName", visit.getTime().getName().toString());

		return map;
	}

	private static Item buildVisitItem(Visit visit) {
		Item root = factory.createItem();
		Map<String, String> map = getVisitFieldsMap(visit);
		root.getContent().add(map.get("visitId"));
		root.getContent().addAll(buildItemTags(map));

		return root;
	}

	public static VxmlSpeak buildVisitVxmlSpeak(Visit visit) {
		VxmlSpeak speak = factory.createVxmlSpeak();
		String speakString = "";
		speakString += ", ID ,"+visit.getId().toString();
		speakString += ", doctor: " + visit.getDoctor().getName() + ", " + visit.getDoctor().getSurname();
		speakString += ", date: " + new SimpleDateFormat("dd, MMMMM, yyyy", Locale.US).format(visit.getDate());
		speakString += ", Time Of Day: " + visit.getTime().getName().toString() + ",";
		speak.getContent().add(speakString);
		return speak;

	}

	public static List<JAXBElement<VxmlSpeak>> buildVxmlSpeakForVisit(String string, List<Visit> visitList) {
		List<JAXBElement<VxmlSpeak>> prompts = new ArrayList<JAXBElement<VxmlSpeak>>();
		VxmlSpeak speakFirst = factory.createVxmlSpeak();
		speakFirst.getContent().add(string);
		prompts.add(factory.createPrompt(speakFirst));

		for (Visit visit : visitList) {
			prompts.add(factory.createPrompt(buildVisitVxmlSpeak(visit)));
		}
		return prompts;
	}

	private static List<JAXBElement<String>> buildItemTags(Map<String, String> map) {
		List<JAXBElement<String>> list = new ArrayList<JAXBElement<String>>();
		for (Entry<String, String> entry : map.entrySet()) {
			list.add(buildItemTag(entry.getKey(), entry.getValue()));
		}
		return list;
	}

	private static String buildMap(Map<String, String> map, String key, String value) {
		map.put(key, value);
		return value;
	}

	private static OneOf prebuildGrammar(String fieldName, Grammar grammar) {

		grammar.setLang("en-us");

		Rule rule = factory.createRule();
		rule.setScope(ScopeDatatype.PUBLIC);
		rule.setId(fieldName);
		grammar.getRule().add(rule);

		OneOf oneOf = factory.createOneOf();
		rule.getContent().add(factory.createRuleOneOf(oneOf));
		return oneOf;
	}

	public static List<JAXBElement<String>> buildItemTags(ModelInterface modelObject) {
		List<JAXBElement<String>> list = new ArrayList<JAXBElement<String>>();
		for (Entry<String, Object> entry : modelObject.getFieldsMap().entrySet()) {
			// if(entry.getKey().equals("id"))
			list.add(buildItemTag(entry.getKey(), entry.getValue()));
		}
		return list;
	}

	public static JAXBElement<String> buildItemTag(String fieldName, Object fieldValue) {
		String s = "out." + fieldName + " = \"" + fieldValue.toString() + "\";";
		return factory.createItemTag(s);
	}

	public static List<Item> buildItem(ModelInterface modelObject) {
		List<Item> rootItemList = new ArrayList<Item>();

		Item rootItem = null;
		LinkedList<Entry<String, Object>> fieldsWithoutId = new LinkedList<Entry<String, Object>>(
				modelObject.getFieldsMapWithoutId().entrySet());
		if (fieldsWithoutId.size() == 2) {

			rootItem = factory.createItem();
			rootItem.getContent().addAll(buildItemTags(modelObject));
			rootItemList.add(rootItem);

			buildItem(rootItem, fieldsWithoutId.iterator());

			rootItem = factory.createItem();
			rootItem.getContent().addAll(buildItemTags(modelObject));
			rootItemList.add(rootItem);

			buildItem(rootItem, fieldsWithoutId.descendingIterator());

		} else if (fieldsWithoutId.size() == 1) {

			rootItem = factory.createItem();
			rootItem.getContent().addAll(buildItemTags(modelObject));
			rootItemList.add(rootItem);

			Entry<String, Object> entry = fieldsWithoutId.get(0);
			rootItem.getContent().add((Serializable) buildItemItem(entry.getKey(), entry.getValue()));
		}
		return rootItemList;
	}

	public static void buildItem(Item rootItem, Iterator<Entry<String, Object>> i) {
		for (; i.hasNext();) {
			Entry<String, Object> entry = i.next();
			rootItem.getContent().add((Serializable) buildItemItem(entry.getKey(), entry.getValue()));
		}
	}

	public static JAXBElement<Item> buildItemItem(String fieldName, Object fieldValue) {
		Item item = factory.createItem();
		item.getContent().add((Serializable) fieldValue);
		// item.getContent().add(buildItemTag(fieldName, fieldValue));
		return factory.createItemItem(item);
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(String speakString) {
		return buildVxmlSpeak(speakString, new ArrayList<ModelInterface>());
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(List<ModelInterface> strings) {
		return buildVxmlSpeak(null, strings);
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(String speakString, List<ModelInterface> modelObjects) {
		VxmlSpeak speak = factory.createVxmlSpeak();
		if (speakString != null) {
			speak.getContent().add(speakString);
		}
		for (Iterator<ModelInterface> i = modelObjects.iterator(); i.hasNext();) {
			ModelInterface modelObject = (ModelInterface) i.next();
			speak.getContent().addAll(buildVxmlSpeak(modelObject));
		}
		return factory.createPrompt(speak);
	}

	public static List<String> buildVxmlSpeak(ModelInterface modelObject) {
		List<String> list = new ArrayList<String>();
		for (Iterator<Entry<String, Object>> i = modelObject.getFieldsMapWithoutId().entrySet().iterator(); i
				.hasNext();) {
			Entry<String, Object> entry = i.next();
			list.add(entry.getValue() + (i.hasNext() ? "," : ";"));
		}
		return list;
	}

	@Deprecated
	public static List<String> getStringList(Iterator<?> i) {
		List<String> list = new ArrayList<String>();
		while (i.hasNext()) {
			Object obj = i.next();
			list.add(obj.toString());
		}
		return list;
	}

	@Deprecated
	public static List<String> getStringListWithDots(Iterator<?> i) {
		List<String> list = new ArrayList<String>();
		while (i.hasNext()) {
			Object obj = i.next();
			list.add(obj.toString() + (i.hasNext() ? "," : "."));
		}
		return list;
	}

}
