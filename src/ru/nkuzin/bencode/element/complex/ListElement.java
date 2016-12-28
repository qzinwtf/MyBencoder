package ru.nkuzin.bencode.element.complex;

import java.util.ArrayList;
import java.util.List;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.Element;
/**
 * Содержит список элементов bencode
 * @author nkuzin
 *
 */
public class ListElement extends Element<List<Element<?>>> {

	private static final char LIST_START = 'l';
	private static final char LIST_END = 'e';

	public ListElement(List<Element<?>> value) {

		this.value = value;

	}

	@Override
	public String encode() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(LIST_START);

		this.value.forEach(element -> stringBuilder.append(element.encode()));

		stringBuilder.append(LIST_END);

		return stringBuilder.toString();
	}

	public static ListElement decode(SourceString sourceString) {

		sourceString.setIndex(sourceString.getIndex() + 1);
		List<Element<?>> list = new ArrayList<Element<?>>();
		try {
			while (sourceString.getCurrentLetter() != LIST_END) {

				list.add(Decoder.decode(sourceString));

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		sourceString.setIndex(sourceString.getIndex() + 1);

		return new ListElement(list);

	}

}
