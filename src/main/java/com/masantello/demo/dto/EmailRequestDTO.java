package com.masantello.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDTO {
	
	private String to;
	private String subject;
	private String body;

	public EmailRequestDTO() {
		
	}
	
	public EmailRequestDTO(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
}
