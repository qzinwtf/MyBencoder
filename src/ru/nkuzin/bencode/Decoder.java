package ru.nkuzin.bencode;

import java.util.ArrayList;
import java.util.List;

import ru.nkuzin.bencode.element.Element;
import ru.nkuzin.bencode.element.complex.DictionaryElement;
import ru.nkuzin.bencode.element.complex.ListElement;
import ru.nkuzin.bencode.element.simple.IntegerElement;
import ru.nkuzin.bencode.element.simple.StringElement;

public class Decoder {
	private static final String FIRST_SYMBOL_OF_BENCODE_ELEMENT_IS_NOT_VALID = "first symbol of bencode element is not valid";

	/**
	 * Метод предназначен для декодирования одиночной структуры в строке, то
	 * есть в строке может быть одна структура, содержащая мвложенные структуры
	 * или простые типы
	 * 
	 * @param sourceString исходная строка
	 * @return Элемент bencod'а
	 * @throws Exception в случае, если невозможно определить тип элемента
	 */
	public static Element<?> decode(SourceString sourceString) throws Exception {
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

			return IntegerElement.decode(sourceString);

		default:
			throw new Exception(FIRST_SYMBOL_OF_BENCODE_ELEMENT_IS_NOT_VALID);
		}

	}
/**
 * Метод, предназначенный для чтения множества объектов bencode из строки
 * @param sourceString
 * @return список bencode элементов
 */
	public static List<Element<?>> decodeAll(SourceString sourceString) {

		List<Element<?>> list = new ArrayList<Element<?>>();
		while (sourceString.getIndex() != sourceString.getSourceString()
				.length()) {

			try {
				list.add(decode(sourceString));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return list;

	}

	/**
	 * Для энкода множества объектов (сериализации)
	 * @param список element объектов, который мы хотим заэнкодить
	 * @return строку bencode
	 */
	public static String encodeAll(List<Element<?>> elements){
		
		StringBuilder  stringBuilder = new StringBuilder();
		
		elements.forEach(element ->  stringBuilder.append(element.encode()));
		

		return stringBuilder.toString();
		
	}
	
}
