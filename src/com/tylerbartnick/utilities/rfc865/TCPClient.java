package com.tylerbartnick.utilities.rfc865;

import java.io.*;
import java.net.*;

public class TCPClient {

	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;

	public TCPClient(String ip, int port) {
		try {
			this.socket = new Socket(ip, port);
			this.out = new PrintWriter(this.socket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		} catch (IOException ex) {
			System.err.println("Unable to create TCP connection to server.");
		}
	}

	public void disconnect() {
		try {
			this.in.close();
			this.out.close();
			this.socket.close();
		} catch (IOException ex) {
			System.err.println("Error while closing connection to server.");
			System.exit(-1);
		}
	}

	public String sendMessage(String msg) {
		String response = "";
		String line;
		out.println(msg);

		try {
			while ((line = in.readLine()) != null) {
				response += line;
			}
		} catch (IOException ex) {
			System.err.println("Unable to ping TCP server.");
			System.exit(-1);
		}

		return response;
	}

}
