package com.chassot.vote.to.eat.api.model.dto;

import java.time.LocalDateTime;

public class ExceptionHandlerDto {

	private LocalDateTime timestamp;
	private String message;
	private String details;

	public ExceptionHandlerDto(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
