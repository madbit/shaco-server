package org.madbit.shaco.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class AddressBookService {
	
	public String handlePhoneNumbers(int uid, String numbers) {
		String[] splittedNumbers = numbers.split(";");
		
		// list of unique phone numbers
		Set<String> phoneNumbers = new HashSet<String>(Arrays.asList(splittedNumbers));
		
		
		// TODO save contact list
		
		// TODO retrieve shaco users in contact list
		
		return null;
	}

}
