package com.greenjavadude.Poker.Client;

import java.awt.BorderLayout;

import javax.swing.*;

public class Client extends JFrame {
	
	private static final long serialVersionUID = -4432581809458106520L;
	
	private JTextArea text;
	
	public Client() {
		super("Poker - Made by Maxwell");
		
		text = new JTextArea();
		text.setEditable(false);
		
		add(new JScrollPane(text), BorderLayout.EAST);
		
		setSize(500, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	            stop();
	        }
	    }, "Shutdown Thread"));
	}
	
	public void start() {
		try {
			//try to connect
			
			//play game with server
			
			//when server disconnects stop, on own stop also stop
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	public void stop() {
		//disconnect
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		c.start();
	}
}