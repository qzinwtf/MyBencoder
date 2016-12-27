package ru.nkuzin.bencode;

public class StringElement extends Element<String> {

	private static final String COLON = ":";
	
	public StringElement(String value) {

		this.value = value;
	}

	@Override
	public String encode() {

		return value.length()+COLON+value;
	}

	public static Element<String> decode(String inputString) {

		int colonIndex = inputString.indexOf(COLON);

		return new StringElement(inputString.substring(colonIndex + 1,
				inputString.length()));
	}
	
}
