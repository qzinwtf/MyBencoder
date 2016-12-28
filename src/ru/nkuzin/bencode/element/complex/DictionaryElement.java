package ru.nkuzin.bencode.element.complex;

import java.util.HashMap;
import java.util.Map;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.Element;
import ru.nkuzin.bencode.element.simple.StringElement;
/**
 * Содержит bencode словарь == Map
 * @author nkuzin
 *
 */
public class DictionaryElement extends Element<Map<StringElement, Element<?>>> {

	private static final char DICTIONARY_START = 'd';

	private static final char DICTIONARY_END = 'e';

	public DictionaryElement(Map<StringElement, Element<?>> value) {

		this.value = value;
	}

	@Override
	public String encode() {

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(DICTIONARY_START);

		value.entrySet().forEach(entry -> {

			stringBuilder.append(entry.getKey().encode());
			stringBuilder.append(entry.getValue().encode());

		});

		stringBuilder.append(DICTIONARY_END);

		return stringBuilder.toString();
	}

	public static DictionaryElement decode(SourceString sourceString) {

		sourceString.setIndex(sourceString.getIndex() + 1);

		Map<StringElement, Element<?>> map = new HashMap<>();
		try {
			while (sourceString.getSourceString().charAt(
					sourceString.getIndex()) != DICTIONARY_END) {

				StringElement key = StringElement.decode(sourceString);

				Element<?> value;

				value = Decoder.decode(sourceString);

				map.put(key, value);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		sourceString.setIndex(sourceString.getIndex() + 1);

		return new DictionaryElement(map);
	}

}
