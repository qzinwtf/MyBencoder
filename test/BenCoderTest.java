import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.Element;
import ru.nkuzin.bencode.element.complex.DictionaryElement;
import ru.nkuzin.bencode.element.complex.ListElement;
import ru.nkuzin.bencode.element.simple.IntegerElement;
import ru.nkuzin.bencode.element.simple.StringElement;

public class BenCoderTest {

	@Test
	public void listTest() {

		String expectedString  = "li55ei60ei70e5:hello3:how3:are3:youe";
		
		Element<BigInteger> longElement1 = new IntegerElement(new  BigInteger("55"));

		Element<BigInteger> longElement2 = new IntegerElement(new  BigInteger("60"));

		Element<BigInteger> longElement3 = new IntegerElement(new  BigInteger("70"));

		Element<String> stringElement1 = new StringElement("hello");

		Element<String> stringElement2 = new StringElement("how");

		Element<String> stringElement3 = new StringElement("are");

		Element<String> stringElement4 = new StringElement("you");

		List<Element<?>> list = Arrays.asList(longElement1, longElement2,
				longElement3, stringElement1, stringElement2, stringElement3,
				stringElement4);

		ListElement listElement = new ListElement(list);

		
		Assert.assertTrue(listElement.encode().equalsIgnoreCase(expectedString));
	}

	@Test
	public void mapTest() {

		String expectedString = "d9:stringKeyli55ei60ei70e5:hello3:how3:are3:youee";
		
		Element<BigInteger> longElement1 = new IntegerElement(new  BigInteger("55"));

		Element<BigInteger> longElement2 = new IntegerElement(new  BigInteger("60"));

		Element<BigInteger> longElement3 = new IntegerElement(new  BigInteger("70"));

		Element<String> stringElement1 = new StringElement("hello");

		Element<String> stringElement2 = new StringElement("how");

		Element<String> stringElement3 = new StringElement("are");

		Element<String> stringElement4 = new StringElement("you");

		StringElement stringKey = new StringElement("stringKey");

		List<Element<?>> list = Arrays.asList(longElement1, longElement2,
				longElement3, stringElement1, stringElement2, stringElement3,
				stringElement4);

		ListElement listElement = new ListElement(list);

		Map<StringElement, Element<?>> map = new HashMap<StringElement, Element<?>>();

		map.put(stringKey, listElement);

		DictionaryElement dictionaryElement = new DictionaryElement(map);
		
		Assert.assertTrue(dictionaryElement.encode().equalsIgnoreCase(expectedString));

	}

	@Test
	public void decodeStringTest() {

		String inputString = "10:testString";

		String expectedString = "testString";

		SourceString sourceString = new SourceString(inputString,0);
		

		String result = StringElement.decode(sourceString).getValue();

		Assert.assertTrue(result.equalsIgnoreCase(expectedString));

	}

	@Test
	public void decodeLongTest() {

		String inputString = "i15251e";
		BigInteger expectedLong = new BigInteger("15251");

		SourceString sourceString = new SourceString(inputString,0);
		
		BigInteger result = IntegerElement.decode(sourceString).getValue();

		Assert.assertEquals(expectedLong, result);

	}

	@Test
	public void decodeTest() throws Exception {
		String expectedString = "d3:bar4:spam3:fooi42ee";
		SourceString sourceString = new SourceString(expectedString,0);


		
		Element<?> element = Decoder.decode(sourceString);

		Assert.assertEquals(expectedString, element.encode());

	}
}
