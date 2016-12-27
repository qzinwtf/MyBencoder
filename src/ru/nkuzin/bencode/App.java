package ru.nkuzin.bencode;

import ru.nkuzin.bencode.element.Element;

public class App {

	public static void main(String[] args) {

SourceString  sourceString = new SourceString();
		
		String someInputString = "d3:bar4:spam3:fooi42ee";
		
		sourceString.setSourceString(someInputString);
		sourceString.setIndex(0);
		
		Element<?> element = Decoder.decode(sourceString);
		
		System.out.println(element);
		
		System.out.println(element.encode());

	}

}
