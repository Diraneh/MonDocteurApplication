package org.poeiscrumproject.gp2.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewsTest {

	News newsTest;

    @Before
    public void init(){
        newsTest = new News("titre", "abstract", "corps", 0);
    }
    
	@Test
	public void testToString() {
		assertEquals("News{id=0, title='titre', abs='abstract', body='corps', priority=0}", newsTest.toString());
	}
	
	@Test
	public void testId() {
		newsTest.setId(245);
		assertEquals(245, newsTest.getId());
	}
	
	@Test
	public void testTitle() {
		newsTest.setTitle("un autre titre");
		assertEquals("un autre titre", newsTest.getTitle());
	}
	
	@Test
	public void testAbs() {
		newsTest.setAbs("un autre abstract");
		assertEquals("un autre abstract", newsTest.getAbs());
	}
	
	@Test
	public void testBody() {
		newsTest.setBody("un autre corps");
		assertEquals("un autre corps", newsTest.getBody());
	}
	
	@Test
	public void testPriority() {
		newsTest.setPriority(2);
		assertEquals(2, newsTest.getPriority());
	}
}
