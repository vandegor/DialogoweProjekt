package pl.clinic.vxml.schema.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import javax.xml.bind.JAXBElement;

import pl.clinic.model.ModelInterface;
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
		grammar.setLang("en-us");

		Rule rule = factory.createRule();
		rule.setScope(ScopeDatatype.PUBLIC);
		rule.setId(fieldName);
		grammar.getRule().add(rule);

		OneOf oneOf = factory.createOneOf();
		rule.getContent().add(factory.createRuleOneOf(oneOf));

		for (ModelInterface modelObject : modelObjects) {
			List<Item> item = buildItem(modelObject);
			oneOf.getItem().addAll(item);
		}
		return factory.createGrammar(grammar);
	}

	public static List<JAXBElement<String>> buildItemTags(ModelInterface modelObject) {
		List<JAXBElement<String>> list = new ArrayList<JAXBElement<String>>();
		for (Entry<String, Object> entry : modelObject.getFieldsMap().entrySet()) {
			//if(entry.getKey().equals("id"))
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
		//item.getContent().add(buildItemTag(fieldName, fieldValue));
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
