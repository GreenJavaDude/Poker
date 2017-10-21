package com.greenjavadude.Poker.Server;

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
				//tries to connect people to Person and the server's people stack
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