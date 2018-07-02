package com.greenjavadude.Poker.test.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.greenjavadude.Poker.test.Common.Data;

public class Person implements Runnable{
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream ous;
	
	private Server server;
	
	private boolean running;
	
	public Person(Socket s, Server v) throws IOException{
		running = false;
		server = v;
		socket = s;
		ois = new ObjectInputStream(socket.getInputStream());
		ous = new ObjectOutputStream(socket.getOutputStream());
		ous.flush();
	}
	
	public void run() {
		//while running wait for incoming objects and deal with them
		while(running) {
			try {
				Data d = (Data) ois.readObject();
				//now object successfully read
				
				//do something with it
				if(d.getType() == "M") {
					server.display(d.getText());
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	public void start() {
		running = true;
		new Thread(this).start();
	}
	
	public void stop() {
		running = false;
		try {
			ois.close();
			ous.close();
			socket.close();
		}catch(Exception e) {
			
		}
	}
	
	public void sendMessage(String s) {
		try {
			ous.writeObject(s);
		}catch(Exception e) {
			
		}
	}
	
	public void sendTurn(Data t) {
		//do properly
		try {
			ous.writeObject(t);
		}catch(Exception e) {
			
		}
	}
}