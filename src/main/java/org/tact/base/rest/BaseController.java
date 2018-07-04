package org.tact.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tact.base.handler.AgeException;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");        
        
        return (T) map;
    }
    
    /**
     * 
     * @param age
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/check/age
     */
    @RequestMapping(value = "/check/age", method = RequestMethod.GET)
    public <T> T checkAge(
    	@RequestParam(value = "age", defaultValue = "14") Integer age
    		) throws AgeException {
    	
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        
        if(age < 14){
        	throw new AgeException("Not Allowed under 14");
        }
        
        return (T) map;
    }
    
    /*
     * Tests:
     * 		http://localhost:1878/base/check/age?age=12
     * 			should return 
     * 				{
					  "result": 202,
					  "message": "Age violation : Not Allowed under 14"
					}
     * 		
     * 		
     */
}
