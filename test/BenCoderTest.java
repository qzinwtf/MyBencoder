import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ru.nkuzin.bencode.Decoder;
import ru.nkuzin.bencode.SourceString;
import ru.nkuzin.bencode.element.DictionaryElement;
import ru.nkuzin.bencode.element.Element;
import ru.nkuzin.bencode.element.ListElement;
import ru.nkuzin.bencode.element.LongElement;
import ru.nkuzin.bencode.element.StringElement;

public class BenCoderTest {

	@Test
	public void listTest() {

		Element<Long> longElement1 = new LongElement(55L);

		Element<Long> longElement2 = new LongElement(60L);

		Element<Long> longElement3 = new LongElement(70L);

		Element<String> stringElement1 = new StringElement("hello");

		Element<String> stringElement2 = new StringElement("how");

		Element<String> stringElement3 = new StringElement("are");

		Element<String> stringElement4 = new StringElement("you");

		List<Element<?>> list = Arrays.asList(longElement1, longElement2,
				longElement3, stringElement1, stringElement2, stringElement3,
				stringElement4);

		ListElement listElement = new ListElement(list);

	}

	@Test
	public void mapTest() {

		Element<Long> longElement1 = new LongElement(55L);

		Element<Long> longElement2 = new LongElement(60L);

		Element<Long> longElement3 = new LongElement(70L);

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

	}

	@Test
	public void decodeStringTest() {

		String inputString = "10:testString";

		String expectedString = "testString";

		SourceString sourceString = new SourceString();
		sourceString.setSourceString(inputString);
		sourceString.setIndex(0);

		String result = StringElement.decode(sourceString).getValue();

		Assert.assertTrue(result.equalsIgnoreCase(expectedString));

	}

	@Test
	public void decodeLongTest() {

		String inputString = "i15251e";
		Long expectedLong = 15251L;

		SourceString sourceString = new SourceString();
		sourceString.setSourceString(inputString);
		sourceString.setIndex(0);
		Long result = LongElement.decode(sourceString).getValue();

		Assert.assertEquals(expectedLong, result);

	}

	@Test
	public void decodeTest() {

		SourceString sourceString = new SourceString();

		String expectedString = "d3:bar4:spam3:fooi42ee";

		sourceString.setSourceString(expectedString);
		sourceString.setIndex(0);

		Element<?> element = Decoder.decode(sourceString);

		Assert.assertEquals(expectedString, element.encode());

	}
}
