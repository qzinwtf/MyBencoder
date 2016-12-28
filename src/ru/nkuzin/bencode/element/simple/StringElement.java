package ru.nkuzin.bencode.element.simple;

import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.Element;

/**
 * Содержит строку bencode
 * @author nkuzin
 *
 */
public class StringElement extends Element<String> {

	private static final String COLON = ":";
	
	public StringElement(String value) {

		this.value = value;
	}

	@Override
	public String encode() {

		return value.length()+COLON+value;
	}

	/**
	 * Десериализация в объект
	 * @param sourceString
	 * @return
	 */
	public static StringElement decode(SourceString sourceString) {

		int colonIndex = sourceString.getSourceString().indexOf(COLON,sourceString.getIndex());
		
		int length = Integer.valueOf(sourceString.getSourceString().substring(sourceString.getIndex(), colonIndex));
		
		sourceString.setIndex(colonIndex + 1);
		
		String value = sourceString.getSourceString().substring(sourceString.getIndex(), sourceString.getIndex() + length);
		
		sourceString.setIndex(sourceString.getIndex()+length);

		return new StringElement(value);
	}
	
	
	
}
