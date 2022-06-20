package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author UserPc
 */
public class udpClient {

    public static void main(String[] args) throws SocketException, IOException {
//        DatagramSocket clientSocket = new DatagramSocket();
//        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
//        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];
//        System.out.println("Enviar un dato al servidor");
//        String sentence = inFromUser.readLine();
//        sendData = sentence.getBytes();
//        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
//        clientSocket.send(sendPacket);        
//        System.out.println("MESSAGE SENT");
//        
//        //*
//        //*
        DatagramSocket clietSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Inet4Address IPAddress = (Inet4Address) Inet4Address.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println("Envía un dato al servidor");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clietSocket.send(sendPacket);
        System.out.println("El puerto de envio es -> "+sendPacket.getPort());
        clietSocket = new DatagramSocket(9877);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clietSocket.receive(receivePacket);
        String recieveSentence = new String(receivePacket.getData());

        System.out.println("Mensajes -> " + recieveSentence);

        System.out.println("Client");
//        DatagramSocket clietSocket = new DatagramSocket(9876);
    }

}
