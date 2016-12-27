package ru.nkuzin.bencode;

import ru.nkuzin.bencode.element.DictionaryElement;
import ru.nkuzin.bencode.element.Element;
import ru.nkuzin.bencode.element.ListElement;
import ru.nkuzin.bencode.element.LongElement;
import ru.nkuzin.bencode.element.StringElement;

public class Decoder {

	public static Element<?> decode(SourceString sourceString) {
		switch (sourceString.getCurrentLetter()) {

		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case '0':

			return StringElement.decode(sourceString);
		case 'l':

			return ListElement.decode(sourceString);

		case 'd':

			return DictionaryElement.decode(sourceString);
		case 'i':

			return LongElement.decode(sourceString);

		}

		return null;
	}

	public static String encode(Element<?> element) {

		return element.encode();
	}

}
