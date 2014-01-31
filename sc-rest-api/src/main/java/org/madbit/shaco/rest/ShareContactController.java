/**
 * ShareContact v1.0
 *
 * @author Alessio Fiore
 * @email  alessio.fiore@gmail.com
 * 
 * Created on 22/gen/2013
 *
 */

package org.madbit.shaco.rest;

import org.apache.log4j.Logger;
import org.madbit.shaco.common.StaticValues;
import org.madbit.shaco.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShareContactController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/shareContact", method = RequestMethod.POST)   
	public String shareContact(
			@RequestParam String sender, 
			@RequestParam String receiver, 
			@RequestParam String contactToShare) {

		logger.debug(sender + " " + receiver + " " + contactToShare);

		return StaticValues.RESPONSE_REGISTRATION_OK;
	}

	@RequestMapping(value = "/registerNewUser", method = RequestMethod.POST)
	@ResponseBody
	public String registerNewUser(@RequestParam String msisdn) {

		logger.debug("Received registration request for MSISDN " + msisdn);

		userRegistrationService.createNewUser(msisdn);
		logger.debug("Registration request saved " + msisdn);

		return StaticValues.RESPONSE_REGISTRATION_OK;
	}

	@RequestMapping(value = "/echo", method = RequestMethod.GET)  
	@ResponseBody
	public String echo() {		
		return "ciao";
	}

	@RequestMapping(value = "/confirmRegistrationCode", method = RequestMethod.POST)
	@ResponseBody
	public String confirmRegistrationCode(@RequestParam int regCode, @RequestParam String msisdn) {

		logger.debug("Received registration code " + regCode + " for confirmation");

		boolean isConfirmed = userRegistrationService.confirmRegistrationCode(regCode, msisdn);

		if(isConfirmed) {
			return StaticValues.RESPONSE_REGISTRATION_OK;
		} else {
			return StaticValues.RESPONSE_REGISTRATION_KO;
		}


	}
}
