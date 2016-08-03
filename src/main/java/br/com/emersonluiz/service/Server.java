package br.com.emersonluiz.service;

import java.io.IOException;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/hello")
public class Server extends HttpServlet {
	
	@Inject
	Hello hello;
	
	@Inject
	@Any
	Event<Message> eventMessage;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("Came in Server...");
			Message message = new Message("Log on classe Server!!!");
			eventMessage.fire(message);
			resp.setContentType("text/html");
			resp.getWriter().append("<h1>" + hello.get() + "</h1>");
	}

}
