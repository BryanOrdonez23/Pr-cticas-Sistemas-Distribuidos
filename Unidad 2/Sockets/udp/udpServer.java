package udp;
import java.net.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author UserPc
 */
public class udpServer {

    public static void main(String[] args) throws SocketException, IOException {

//        DatagramSocket clientSocket = new DatagramSocket();
//        byte[] receiveData = new byte[1024];
//        byte[] sendData = new byte[1024];
//        DatagramSocket serverSocket = new DatagramSocket(9876);
//        while (true) {
//            System.out.println("SERVER ACTIVE");
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            serverSocket.receive(receivePacket);
//            String sentence = new String(receivePacket.getData());
//
//            ////**
//            InetAddress IPAddress = receivePacket.getAddress();
//            int port = receivePacket.getPort();
//            String caapitalizedSentence = sentence.toUpperCase();
//            sendData= caapitalizedSentence.getBytes();
//            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
//            clientSocket.send(sendPacket);
//
//            System.out.println("MESSAGE:" + sentence);
//            System.out.println("SERVER OUT");
//        DatagramSocket clientSocket = new DatagramSocket();
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramSocket serverSocket = new DatagramSocket(9876);
        while(true){
            System.out.println("Server Active");
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            
            System.out.println("Mensajes -> "+sentence);
            
            Inet4Address IPAddress = (Inet4Address) receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            String capitalizedSentence = "Mensaje Recivido";
//            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9877);
            System.out.println("el puerto es -> "+port);
            serverSocket.send(sendPacket);
            
            System.out.println("Server OUT");
        }
    }
}
