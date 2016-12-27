package ru.nkuzin.bencode;

import ru.nkuzin.bencode.element.Element;

public class App {

	public static void main(String[] args) {

		String someInputString = "d3:bar4:spam3:fooi42ee";
		SourceString sourceString = new SourceString(someInputString, 0);

		Element<?> element = Decoder.decode(sourceString);

		System.out.println(element);

		System.out.println(element.encode());

	}

}
