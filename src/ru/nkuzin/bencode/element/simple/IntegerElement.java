package ru.nkuzin.bencode.element.simple;

import java.math.BigInteger;

import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.Element;
/**
 * Содержит целые числа bencode.
 * Размер не определен спецификацией, поэтому BigInteger
 * @see <a href="http://www.bittorrent.org/beps/bep_0003.html">Спецификация с сайта bittorrent.org</a>
 * @author nkuzin
 *
 */
public class IntegerElement extends Element<BigInteger>  {
	private static final String INTEGER_START = "i";
	private static final String INTEGER_END = "e";
	

	public IntegerElement(BigInteger value){
		
		this.value = value;
	}
	
	@Override
	public String encode() {

		return INTEGER_START + value + INTEGER_END;
	}

	/**
	 * Десериализация в объект
	 * @param sourceString
	 * @return
	 */
	public static IntegerElement decode(SourceString sourceString) {

		sourceString.setIndex(sourceString.getIndex() +1 );
		
		int endIndex = sourceString.getSourceString().indexOf(INTEGER_END, sourceString.getIndex());
		BigInteger value = new  BigInteger( sourceString.getSourceString().substring(sourceString.getIndex(), endIndex));

		sourceString.setIndex(endIndex+1);
		
		return new IntegerElement(value);
	}
}
