package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import com.example.demo.Dao.Email;
import com.example.demo.Services.emailService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class mainController {
@Autowired
	private emailService emailservice;
	@GetMapping("/")
	public String home()
	{
		return "Wellcome";
	}
	
	@PostMapping("/sendemail")
	public ResponseEntity<String> sendEmail(@RequestBody Email email) {
	  
     boolean f=emailservice.sendmails(email.getTo(),email.getSubject(), email.getMessage());
     
     if(f)
     {
    	 
    	 return ResponseEntity.ok("Done...");
     }
     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not sent .....");
	}
	
}
