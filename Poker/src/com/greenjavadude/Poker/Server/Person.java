package com.greenjavadude.Poker.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.greenjavadude.Poker.Common.TurnReq;

public class Person implements Runnable{
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream ous;
	
	private Server server;
	
	public Person(Socket s, Server v) throws IOException{
		server = v;
		socket = s;
		ois = new ObjectInputStream(socket.getInputStream());
		ous = new ObjectOutputStream(socket.getOutputStream());
		ous.flush();
	}
	
	public void run() {
		//while running wait for incoming objects and deal with them
	}
	
	public void start() {
		
	}
	
	public void stop() {
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
	
	public void sendTurn(TurnReq t) {
		//do properly
		try {
			ous.writeObject(t);
		}catch(Exception e) {
			
		}
	}
}