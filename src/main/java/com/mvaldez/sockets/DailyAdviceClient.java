package com.mvaldez.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author mvaldez
 */
public class DailyAdviceClient {
    public void go() {
        try {
            Socket a = new Socket("127.0.0.1", 4242);

            InputStreamReader inputStreamReader = new InputStreamReader(a.getInputStream());
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String advice = reader.readLine();
            System.out.println("Client: Server says " + advice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        while (true) {
            client.go();
        }
    }
}
