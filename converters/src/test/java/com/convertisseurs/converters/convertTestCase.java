package com.convertisseurs.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;



public class convertTestCase {
	
//	@BeforeAll
//	static void TestConvert(){
//		System.out.println("Before All");
//		Assertions.assertTrue(true);
//	}
//	
//	@BeforeEach
//	void TestCnver() {
//		System.out.println("Before Each");
//	}
//	
//	@AfterEach
//	void TestCnvert() {
//		System.out.println("After Each");
//	}
//	@AfterAll
//	static void TestConverSion() {
//		System.out.println("After All");
//	}
	
	
	@Test
	@DisplayName("My Test")
	void myTest() {
		GenericConversionService cs = new DefaultConversionService();
		String machaine = cs.convert(5,String.class);
		assertEquals("5", machaine);
		Character car = cs.convert('Y', Character.class);
		assertEquals('Y',car);
		
		
		try {
			car=cs.convert("Exception", Character.class);
			fail("Devrait lever une exception car la chaine n'est pas un Character");
			
		}catch(ConversionFailedException aExcep) {
			assert aExcep.getMessage().contains("Failed to convert from type [java.lang.String] to type [java.lang.Character]");
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Le so")
	void TestSecond() {
		GenericConversionService cs = new DefaultConversionService();
		String [] tabchaine = cs.convert("Tailleurs,voiture,Mure", String[].class);
		assertEquals("Tailleurs", tabchaine[0]);
		assertEquals("voiture", tabchaine[1]);
		assertEquals("Mure", tabchaine[2]);
		
		
	  
	// conversion d'une chaine en une liste
	List<String> lstChaine = cs.convert("Tailleurs,voiture,Mure", List.class);
		assertEquals("Tailleurs", lstChaine.get(0));
		assertEquals("voiture", lstChaine.get(1));
		assertEquals("Mure", lstChaine.get(2));
		
		//conversion d'un tableau en une List
		lstChaine = cs.convert(new String[]{"Tailleurs","voiture","Mure"}, List.class);
		assertEquals("Tailleurs", lstChaine.get(0));
		assertEquals("voiture", lstChaine.get(1));
		assertEquals("Mure", lstChaine.get(2));
		
		
		String chaine = cs.convert(new String[]{"Tailleurs","voiture","Mure"}, String.class);
		assertEquals("Tailleurs,voiture,Mure", chaine);
		
		System.out.println(chaine);
		
	}
	
	@Test
	void convertObject() {
		UserToString usertoString = new UserToString();
		User user =new User("Jim","HignSmith");
		usertoString.convert(user);
		
	}
	

}
