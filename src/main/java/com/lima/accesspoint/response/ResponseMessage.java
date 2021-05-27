package com.lima.accesspoint.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ResponseMessage {
	
	public ResponseMessage createMessage(String message, Long id) {
		return ResponseMessage.builder()
				.message(message + id)
				.build();
	}
	
	private String message;
	
}

