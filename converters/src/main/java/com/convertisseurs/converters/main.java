package com.convertisseurs.converters;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

public class main {

	public static void main(String[] args) {
		
		GenericConversionService cs = new DefaultConversionService();
		testObject(cs);
	}

	//Declaration du convertisseur
	private static void testObject(GenericConversionService convrsionService) {
		
		convrsionService.addConverter(new UserToString());
		User utileObject=new User("Gaoussou", "Koita");
		String UtilAsString = convrsionService.convert(new User[] {utileObject}, String.class);
		System.out.println(UtilAsString);
		
		UserToString usToString = new UserToString();
		System.out.println(usToString.convert(utileObject));
	}
}
