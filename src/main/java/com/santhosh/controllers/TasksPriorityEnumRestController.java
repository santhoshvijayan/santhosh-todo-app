package com.santhosh.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.santhosh.models.Priority;

@RestController
public class TasksPriorityEnumRestController {
	
	@RequestMapping(value = "/populateTasksPriorities", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public @ResponseBody
	Collection<Priority> populateTasksPriorities(){
		return new ArrayList<Priority>(Arrays.asList(Priority.values()));
	}

}
