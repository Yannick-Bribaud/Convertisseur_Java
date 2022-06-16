package com.convertisseurs.converters;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

public class UserToString implements Converter<User, String>{

	@Override
	public String convert(User user) {
		
		if(user==null) {
			throw new ConversionFailedException(TypeDescriptor.valueOf(User.class), 
					TypeDescriptor.valueOf(User.class), user, null);
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(user.getNom());
		builder.append(",");
		builder.append(user.getPrenom());
		
		return builder.toString();
	}
	
	
	

}
