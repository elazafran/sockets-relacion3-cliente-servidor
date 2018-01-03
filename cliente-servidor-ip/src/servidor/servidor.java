package servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			DatagramSocket datagramSocket = new DatagramSocket(addr);
			
			while(true){
				byte[] buffer = new byte[25];
				DatagramPacket datagrama1 = new DatagramPacket(buffer,buffer.length);
				datagramSocket.receive(datagrama1);
				
				String respuesta = datagrama1.getAddress().toString();
				DatagramPacket datagrama2 = new DatagramPacket(respuesta.getBytes(),respuesta.getBytes().length,datagrama1.getAddress(),datagrama1.getPort());
				datagramSocket.send(datagrama2);
				
			}

		}catch(IOException e){
			e.printStackTrace();
		}


	}

}
