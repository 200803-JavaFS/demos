package com.revature.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.models.Flashcard;

@FeignClient(name = "flashcard")
public interface FlashcardClient {
	
	@GetMapping //Goes to a service called flashcard with a get request at the base URI
	public List<Flashcard> findAll();
	
	@GetMapping("/port") // Sends a GET request to a service named flashcard at the base URI + /port
	public String retrievePort();

}
