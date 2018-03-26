package com.mvaldez.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author mvaldez
 */
public class SimpleChatClient {
    private Socket sock;
    private PrintWriter writer;
    private BufferedReader reader;

    public void go() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Send Message: " );
            String message = br.readLine();
            writer.println(message);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        setupNetworking();
        setupListener();

        // start message listener
        Thread readerThread = new Thread(new InputReaderRunner());
        readerThread.run();
    }

    private void setupListener() {
        // setup reader
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setupNetworking() {
        try {
            sock = new Socket("127.0.0.1", 4242);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Network Established");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class InputReaderRunner implements Runnable {

        @Override
        public void run() {

            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Server Response: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.init();
        while (true) {
            client.go();
        }
    }
}
