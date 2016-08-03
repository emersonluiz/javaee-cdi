package br.com.emersonluiz.service;

import javax.enterprise.event.Observes;

public class Logger {

	public void write(@Observes Message message) {
		System.out.println("Logger.class: " + message.getMessage());
	}
	
}
