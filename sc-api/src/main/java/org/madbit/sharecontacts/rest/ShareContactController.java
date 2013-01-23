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
import org.madbit.sharecontacts.rest.ShareContactRequest;
import org.madbit.sharecontacts.rest.ShareContactResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShareContactController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/shareContact", method = RequestMethod.POST)
    @ResponseBody
	public ShareContactResponse shareContact(@RequestBody ShareContactRequest request) {
		
		logger.debug(request.getUser().phoneNumber);
		for(PhoneNumberData pnd: request.getToContact().getPhoneNumbers().getPhoneNumber()) {			
			logger.debug(pnd.getValue());
		}
		
			
		return new ShareContactResponse();
	}
	
	@RequestMapping(value = "/echo", method = RequestMethod.GET)   
	public String echo() {		
		return "ciao";
	}

}
