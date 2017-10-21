package com.greenjavadude.Poker.Server;

import java.net.Socket;

public class Connector implements Runnable{
	private boolean running;
	private Server server;
	
	public Connector(Server s) {
		running = false;
		server = s;
	}
	
	public void run() {
		try {
			while(running) {
				try {
					Socket socket = server.getServerSocket().accept();
					//now connected
					Person p = new Person(socket, server);
					server.getPeople().push(p);
					server.display("Someone Successfully Connected.");
				}catch(Exception e) {
					
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
	}
}