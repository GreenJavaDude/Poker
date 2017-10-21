package com.greenjavadude.Poker.Server;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.*;

public class Server extends JFrame implements Runnable{
	private static final long serialVersionUID = -6598726644206368068L;
	
	public Stack<Person> people;
	public Game game;
	public Connector connector;
	private boolean started;
	private boolean running;
	private boolean stopped;
	
	public JTextArea text;
	private JButton startButton;
	private JButton stopButton;
	private JPanel panel;
	
	private Thread hook;
	
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
					text.append("The game has started.\n");
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
		
		hook = new Thread(new Runnable() {
			public void run() {
				stopped = true;
				stop();
			}
		});
		
		Runtime.getRuntime().addShutdownHook(hook);
	}
	
	public void run() {
		try {
			connector.start();
			text.append("Now open for connections.\n");
			
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
		
		System.out.println("T1");
		
		if(!stopped) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}