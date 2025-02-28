package org.example.springauthsample.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
public class ErrorResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String errorCode;

	private final String message;

	public ErrorResponse(String message) {
		this.message = message;
	}
}