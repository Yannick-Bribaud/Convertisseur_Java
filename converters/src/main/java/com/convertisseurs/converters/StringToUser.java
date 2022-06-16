package com.convertisseurs.converters;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

public class StringToUser implements Converter<String, User>{

	@Override
	public User convert(String UserAsString) {
		if(UserAsString.equals(null)) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(String.class), 
					TypeDescriptor.valueOf(String.class), UserAsString, null);
		}
		
		String [] tempArray = UserAsString.split(",");
		User user = new User(tempArray[0], tempArray[1]);
		
		return user;
	}

}
