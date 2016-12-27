package ru.nkuzin.bencode.element;

import java.util.HashMap;
import java.util.Map;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;

public class DictionaryElement extends Element<Map<StringElement,Element<?>>> {

	private static final char DICTIONARY_START = 'd';
	
	private static final char DICTIONARY_END = 'e';

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
	
	public static DictionaryElement decode(SourceString sourceString){
		
		sourceString.setIndex(sourceString.getIndex() +1);
		
		
		Map<StringElement,Element<?>> map = new HashMap<>();
		
		while(sourceString.getSourceString().charAt(sourceString.getIndex()) != DICTIONARY_END){
			
			StringElement key = StringElement.decode(sourceString);
			
			System.out.println("key :: "+key.getValue());
			Element<?> value = Decoder.decode(sourceString);
			
			System.out.println("value :: "+value.getValue());
			
			map.put(key, value);
			
		}
		sourceString.setIndex(sourceString.getIndex() +1);
		
		
		return new DictionaryElement(map);
	}

}
