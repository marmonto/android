package aarddict;

import java.net.URISyntaxException;

import junit.framework.TestCase;

public class TestSplitWord extends TestCase {

	public void testSimpleSplitPlainWord() {
		LookupWord result = LookupWord.splitWordSimple("abc");
		assertEquals("abc", result.word);
		assertNull(result.section);
		assertNull(result.nameSpace);
	}

	public void testSimpleSplitWithSection() {
		LookupWord result = LookupWord.splitWordSimple("abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertNull(result.nameSpace);
	}

	public void testSimpleSplitWithNS() {
		LookupWord result = LookupWord.splitWordSimple("w:abc");
		assertEquals("abc", result.word);
		assertEquals("w", result.nameSpace);
		assertNull(result.section);
	}
	
	public void testSimpleSplitWithSectionAndNS() {
		LookupWord result = LookupWord.splitWordSimple("w:abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertEquals("w", result.nameSpace);
	}		
	
	public void testURISplitPlainWord() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("abc");
		assertEquals("abc", result.word);
		assertNull(result.section);
		assertNull(result.nameSpace);
	}
	
	public void testURISplitWithSection() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertNull(result.nameSpace);
	}

	public void testURISplitWithNS() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:abc");
		assertEquals("abc", result.word);
		assertEquals("w", result.nameSpace);
		assertNull(result.section);
	}
	
	public void testURISplitWithSectionAndNS() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:abc#def");
		assertEquals("abc", result.word);
		assertEquals("def", result.section);
		assertEquals("w", result.nameSpace);
	}		

	public void testURISplitWithURLEncoding() throws URISyntaxException {
		LookupWord result = LookupWord.splitWordAsURI("w:abc%20123%2F456#def%20ghi");
		assertEquals("abc 123/456", result.word);
		assertEquals("def ghi", result.section);
		assertEquals("w", result.nameSpace);
	}		

	public void testURISplitWithBadURLEncoding(){
		try {
			LookupWord.splitWordAsURI("w:ab c");
		} catch (URISyntaxException e) {
			return;
		}
		fail();
	}			
}