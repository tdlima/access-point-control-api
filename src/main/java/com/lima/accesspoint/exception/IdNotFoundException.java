package com.lima.accesspoint.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception{
	
	public IdNotFoundException(Long id) {
		super("The id "+id+" does not exist for that entity!");
	}
}
