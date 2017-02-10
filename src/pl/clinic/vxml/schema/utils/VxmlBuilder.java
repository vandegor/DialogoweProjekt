package pl.clinic.vxml.schema.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

	public static JAXBElement<Grammar> buildGrammar(String fieldName, List<ModelInterface> strings) {
		Grammar grammar = factory.createGrammar();
		grammar.setLang("en-us");

		Rule rule = factory.createRule();
		rule.setScope(ScopeDatatype.PUBLIC);
		grammar.getRule().add(rule);

		OneOf oneOf = factory.createOneOf();
		rule.getContent().add(factory.createRuleOneOf(oneOf));

		for (ModelInterface modelObject : strings) {
			Item item = factory.createItem();
			oneOf.getItem().add(item);
			item.getContent().add(modelObject.toString());
			if (fieldName != null && !"".equals(fieldName)) {
				item.getContent().add(buildItemTag(fieldName, modelObject));
			}
		}
		return factory.createGrammar(grammar);
	}

	public static JAXBElement<String> buildItemTag(String fieldName, ModelInterface modelObject) {
		String s = "out." + fieldName + " = \"" + modelObject.getId().toString() + "\"";
		return factory.createItemTag(s);
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(String speakString) {
		return buildVxmlSpeak(speakString, new ArrayList<ModelInterface>());
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(List<ModelInterface> strings) {
		return buildVxmlSpeak(null, strings);
	}

	public static JAXBElement<VxmlSpeak> buildVxmlSpeak(String speakString, List<ModelInterface> strings) {
		VxmlSpeak speak = factory.createVxmlSpeak();
		if (speakString != null) {
			speak.getContent().add(speakString);
		}
		for (Iterator<ModelInterface> i = strings.iterator(); i.hasNext();) {
			ModelInterface modelObject = (ModelInterface) i.next();
			speak.getContent().add(modelObject.toString() + (i.hasNext() ? "," : "."));
		}
		return factory.createPrompt(speak);
	}

	public static List<String> getStringList(Iterator<?> i) {
		List<String> list = new ArrayList<String>();
		while (i.hasNext()) {
			Object obj = i.next();
			list.add(obj.toString());
		}
		return list;
	}

	public static List<String> getStringListWithDots(Iterator<?> i) {
		List<String> list = new ArrayList<String>();
		while (i.hasNext()) {
			Object obj = i.next();
			list.add(obj.toString() + (i.hasNext() ? "," : "."));
		}
		return list;
	}
}
