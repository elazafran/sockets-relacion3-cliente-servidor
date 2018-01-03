package cliente;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			DatagramSocket datagramSocket = new DatagramSocket();
			
			String token = "id";
			InetAddress addr1 = InetAddress.getByName("localhost");
			DatagramPacket datagrama1 = new DatagramPacket(token.getBytes(),token.getBytes().length,addr1,5555);
			datagramSocket.send(datagrama1);
			
			byte[] buffer = new byte[128];
			DatagramPacket datagrama2 = new DatagramPacket(buffer,buffer.length);
			datagramSocket.receive(datagrama2);
			
			String respuesta = new String(buffer);
			
			System.out.println("Mi dirección es "+respuesta);
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
