import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


public class cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length!=1){
			System.out.println("argumentos: <id del fichero>");
			System.exit(1);
		}
		
		try{
			String id_fichero = args[0];
			Socket clientSocket = new Socket();
			
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			clientSocket.connect(addr);
			
			InputStream is = clientSocket.getInputStream();
			OutputStream os = clientSocket.getOutputStream();
			
			PrintWriter pw = new PrintWriter(os,true);
			
			System.out.println("Descargando fichero "+id_fichero);
			
			pw.println(id_fichero);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			char buffer[] = new char[1];
			br.read(buffer);
			while(br.read(buffer) != -1){
				System.out.println(buffer[0]);
			}
		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
