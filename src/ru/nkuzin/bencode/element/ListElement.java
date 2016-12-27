package ru.nkuzin.bencode.element;

import java.util.ArrayList;
import java.util.List;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;

public class ListElement extends Element<List<Element<?>>> {

	private static final char LIST_START = 'l';
	private static final char LIST_END = 'e';
	
	public ListElement(List<Element<?>> value){
		
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

		sourceString.setIndex(sourceString.getIndex()+1);
		List<Element<?>> list = new ArrayList<Element<?>>();

		while (sourceString.getSourceString().charAt(sourceString.getIndex()) != LIST_END) {

			list.add(Decoder.decode(sourceString));
		}

		sourceString.setIndex(sourceString.getIndex() + 1);
		

		return new ListElement(list);

	}

}
