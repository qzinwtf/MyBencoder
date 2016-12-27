import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ru.nkuzin.bencode.DictionaryElement;
import ru.nkuzin.bencode.Element;
import ru.nkuzin.bencode.ListElement;
import ru.nkuzin.bencode.LongElement;
import ru.nkuzin.bencode.StringElement;


public class BenCoderTest {

	@Test
	public void listTest(){
		
		Element<Long> longElement1 = new LongElement(55L);
		
		Element<Long> longElement2 = new LongElement(60L);
		
		Element<Long> longElement3 = new LongElement(70L);
		
		
		Element<String> stringElement1 = new StringElement("hello");
		
		Element<String> stringElement2 = new StringElement("how");
		
		Element<String> stringElement3 = new StringElement("are");
		
		Element<String> stringElement4 = new StringElement("you");
		
		
		List<Element<?>> list = Arrays.asList(longElement1,longElement2,longElement3,stringElement1,stringElement2,stringElement3,stringElement4);
		
		ListElement listElement = new ListElement(list);
		
		
		System.out.println(listElement.encode());
	}
	
	@Test
	public void mapTest(){
		
		Element<Long> longElement1 = new LongElement(55L);
		
		Element<Long> longElement2 = new LongElement(60L);
		
		Element<Long> longElement3 = new LongElement(70L);
		
		
		Element<String> stringElement1 = new StringElement("hello");
		
		Element<String> stringElement2 = new StringElement("how");
		
		Element<String> stringElement3 = new StringElement("are");
		
		Element<String> stringElement4 = new StringElement("you");
		
		
		StringElement stringKey = new StringElement("stringKey");
		
		
		
		List<Element<?>> list = Arrays.asList(longElement1,longElement2,longElement3,stringElement1,stringElement2,stringElement3,stringElement4);
		
		ListElement listElement = new ListElement(list);
		
		Map<StringElement,Element<?>> map = new HashMap<StringElement, Element<?>>();
		
		map.put(stringKey, listElement);
		
		DictionaryElement dictionaryElement = new DictionaryElement(map);
		
		
		System.out.println(dictionaryElement.encode());
	}
	
	@Test
	public void decodeStringTest(){
		
		String inputString = "10:testString";
		
		String expectedString = "testString";
		
		Assert.assertTrue(StringElement.decode(inputString).getValue().equalsIgnoreCase(expectedString));
		
	}
	
	
	@Test
	public void decodeLongTest(){
		
		String inputString = "i15251e";
		Long expectedLong = 15251L;
		
		Assert.assertEquals(expectedLong, LongElement.decode(inputString).getValue());
		
	}
}
