package ru.nkuzin.bencode;

import java.util.List;

public class ListElement extends Element<List<Element<?>>> {

	private static final String LIST_START = "l";
	private static final String LIST_END = "e";
	
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

}
