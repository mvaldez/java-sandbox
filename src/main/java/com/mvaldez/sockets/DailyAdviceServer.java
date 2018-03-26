package com.mvaldez.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author mvaldez
 */
public class DailyAdviceServer {
    private final String[] adviceList = {"Hello", "Hi", "Hola", "Aribaderchi"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4242);
            System.out.println("Starting Server");
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }
}
