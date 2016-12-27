package ru.nkuzin.bencode;

public class LongElement extends Element<Long> {

	private static final String INTEGER_END = "e";
	private static final String INTEGER_START = "i";

	public LongElement(Long value){
		
		this.value = value;
	}
	
	@Override
	public String encode() {

		return INTEGER_START + value + INTEGER_END;
	}

	public static Element decode(String inputString) {

		int startIndex = inputString.indexOf(INTEGER_START)+1;
		int endIndex = inputString.indexOf(INTEGER_END);

		return new LongElement(Long.valueOf(inputString.substring(startIndex, endIndex)));
	}
}
