package com.greenjavadude.Poker.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.util.Stack;

import javax.swing.*;

public class Server extends JFrame implements Runnable{
	private static final long serialVersionUID = -6598726644206368068L;
	
	public Stack<Person> people;
	public Game game;
	
	private boolean started;
	private boolean running;
	private boolean stopped;
	
	public JTextArea text;
	private JButton startButton;
	private JButton stopButton;
	private JPanel panel;
	
	private ServerSocket socket;
	public Connector connector;
	
	public Server() {
		super("Server Side Poker - Made by Maxwell");
		
		people = new Stack<Person>();
		game = new Game();
		connector = new Connector(this);
		started = false;
		running = true;
		stopped = false;
		
		text = new JTextArea();
		text.setEditable(false);
		
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				if(!started) {
					display("The game has started.");
					started = true;
				}
			}
		});
		
		stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.exit(0);
			}
		});
		
		panel = new JPanel();
		panel.add(startButton, BorderLayout.WEST);
		panel.add(stopButton, BorderLayout.EAST);
		
		add(new JScrollPane(text), BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setSize(500, 300);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			public void run() {
				stopped = true;
				stop();
			}
		}, "Shutdown Thread"));
	}
	
	public void run() {
		try {
			socket = new ServerSocket(7777, 20);
			connector.start();
			display("Now open for connections.");
			
			while(!started) {
				Thread.sleep(100);
			}
			
			while(running) {
				//play the game with the connected people
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void stop() {
		//disconnect
		for(Person p : people) {
			p.stop();
		}
		
		if(!stopped) {
			System.exit(0);
		}
	}
	
	public void display(String s) {
		text.append(s + "\n");
	}
	
	public ServerSocket getServerSocket() {
		return socket;
	}
	
	public Stack<Person> getPeople(){
		return people;
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}