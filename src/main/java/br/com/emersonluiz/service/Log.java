package br.com.emersonluiz.service;

import javax.enterprise.event.Observes;

public class Log {

	public void write(@Observes Message message) {
		System.out.println("Log.class: " + message.getMessage());
	}

}
