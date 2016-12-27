package ru.nkuzin.bencode;

import java.util.Map;

public class DictionaryElement extends Element<Map<StringElement,Element<?>>> {

	private static final String DICTIONARY_START = "d";
	
	private static final String DICTIONARY_END = "e";

	public DictionaryElement(Map<StringElement,Element<?>> value){
		
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

}
