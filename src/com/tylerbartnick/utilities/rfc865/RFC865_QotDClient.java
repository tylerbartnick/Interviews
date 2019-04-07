package com.tylerbartnick.utilities.rfc865;

public class RFC865_QotDClient {

	public static void main(String[] args) {
		
		String host = "djxmmx.net";
		int port = 17;

		TCPClient client = new TCPClient(host, port);
		String response = client.sendMessage("Hello!");
		System.out.println(response);
		client.disconnect();
	}

}
