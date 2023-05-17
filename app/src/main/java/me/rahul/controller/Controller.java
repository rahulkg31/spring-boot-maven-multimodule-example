package me.rahul.controller;

import me.rahul.commons.RandomNumberGenerator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class Controller {	
	
	private static final Logger logger = LogManager.getLogger(RandomNumberGenerator.class);

	@Value("#{new Long('${range.random.num}')}")
	private Long range;

	@GetMapping(value = "/generate-num/{num}")
	public int[] generateNumber1(@PathVariable int num){
		logger.info("Request received with num count: " + num);
		RandomNumberGenerator ran = new RandomNumberGenerator();
		return ran.generateRandomNumber(num, range);
	}
	
	@PostMapping(value = "/generate-num")
	public int[] generateNumber2(@RequestBody String message) throws ParseException{
		logger.info("Request received with body: " + message);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(message);
		long num = (long) obj.get("num");
		RandomNumberGenerator ran = new RandomNumberGenerator();
		return ran.generateRandomNumber((int) num, range);
	}
	
}