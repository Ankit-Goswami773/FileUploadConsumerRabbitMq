package com.example.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Files;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageConsumer {

    @NonNull
    private final ObjectMapper mapper;
    
    @Autowired
    private HomeService homeService;
    
	@RabbitListener(queues = "fileDataqueue")
	public void getMessage(Message message) throws JsonParseException, JsonMappingException, IOException {

		String str = new String(message.getBody(), StandardCharsets.UTF_8);
        Files file = mapper.readValue(message.getBody(), Files.class);
   
		System.out.println("str " + str);
        
		  homeService.matchData(file.getId());
	}

	   
	
	
}