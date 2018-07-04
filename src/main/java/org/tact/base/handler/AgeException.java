package org.tact.base.handler;

import java.io.IOException;

@SuppressWarnings("serial")
public class AgeException extends IOException {

	public AgeException(String message){
		super(message);
	}
}
