package com.nasa.NasaDemo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONParser {
	
	public static apodImage parseJSON (String jsonString)  throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		apodImage apodImageData = objectMapper.readValue(jsonString, apodImage.class);
		
		return apodImageData;
		
	}
	
public static List<apodImage> parseArrayJSON (String jsonString)  throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<apodImage> apodImageDataList = Arrays.asList(objectMapper.readValue(jsonString, apodImage[].class));
		
		return apodImageDataList;
		
	}

public static List<marsRoverImage> parseMarsJSON (String jsonString)  throws IOException{
	
	ObjectMapper objectMapper = new ObjectMapper();
	List<marsRoverImage> marsRoverImageList = Arrays.asList(objectMapper.readValue(jsonString, marsRoverImage.class));
	
	return marsRoverImageList;
	
}
}
