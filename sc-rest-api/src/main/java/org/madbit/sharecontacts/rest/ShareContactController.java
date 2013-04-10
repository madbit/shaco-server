/**
* ShareContact v1.0
*
* @author Alessio Fiore
* @email  alessio.fiore@gmail.com
* 
* Created on 22/gen/2013
*
*/

package org.madbit.sharecontacts.rest;

import org.apache.log4j.Logger;
import org.madbit.shaco.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShareContactController {
	
	@Autowired
	private NewUserService newUserService;
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/shareContact", method = RequestMethod.POST)   
	public String shareContact(
			@RequestParam String sender, 
			@RequestParam String receiver, 
			@RequestParam String contactToShare) {
		
		logger.debug(sender + " " + receiver + " " + contactToShare);
			
		return "0";
	}
	
	@RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)   
	public String registerNewUser(@RequestParam String msisdn) {
		
		logger.debug("Received registration request for MSISDN " + msisdn);
		
		newUserService.createNewUser(msisdn);
		logger.debug("Registration request saved " + msisdn);
		
		return "0";
	}
	
	@RequestMapping(value = "/echo", method = RequestMethod.GET)   
	public String echo() {		
		return "ciao";
	}

}
