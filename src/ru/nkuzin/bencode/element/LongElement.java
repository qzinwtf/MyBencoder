package ru.nkuzin.bencode.element;

import ru.nkuzin.bencode.SourceString;

public class LongElement extends Element<Long> {
	private static final String INTEGER_START = "i";
	private static final String INTEGER_END = "e";
	

	public LongElement(Long value){
		
		this.value = value;
	}
	
	@Override
	public String encode() {

		return INTEGER_START + value + INTEGER_END;
	}

	public static LongElement decode(SourceString sourceString) {

		sourceString.setIndex(sourceString.getIndex() +1 );
		
		int endIndex = sourceString.getSourceString().indexOf(INTEGER_END, sourceString.getIndex());
		Long value = Long.valueOf( sourceString.getSourceString().substring(sourceString.getIndex(), endIndex));

		sourceString.setIndex(endIndex+1);
		
		return new LongElement(value);
	}
}
