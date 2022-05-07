package com.company.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
  public static String eingabe(){
  	String returnString = "";
  	Scanner scanner = new Scanner(System.in);
  	String option;
  	System.out.println("Welche Option: 1 für Neuen Spieler, 2 Für alle Spieler vom Team");
  	option = scanner.nextLine();
  	if(option.equals("1")){
  		String name;
		String position;
		String age;
		String team;
  		System.out.println("Bitte geben sie den Namen des neuen Spielers ein : ");
  		name = scanner.nextLine();
  		System.out.println("Bitte geben sie den Int wert zur zugehörigen Position ein : ");
  		position = scanner.nextLine();
  		System.out.println("Bitte geben sie das Alter Des Spielers ein ! :");
  		age = scanner.nextLine();
  		System.out.println("Bitte geben sie das Team des Speilers ein : ");
  		team = scanner.nextLine();
  		returnString = option + "|" + name + "|" + position + "|" + age + "|" + team;
	}else if(option.equals("2")){
  		String team;
  		System.out.println("bitte geben sie an welcehs Team ausgelesen werden soll");
  		team = scanner.nextLine();
  		returnString = option + "|" + team;
	}
  	return returnString;
  }
  public static void main (String args[]) {
  // args[0]: Message
  // args[1]: Server
  String message = "Test";
  String ip = "localhost";
    try{
	  int serverPort = 7896;
	  Socket s = new Socket (ip, serverPort);
	  DataOutputStream out = new DataOutputStream ( s.getOutputStream());
	  DataInputStream in = new DataInputStream ( s.getInputStream());

	  /*
	  message = "1|Sebastian|1|42|1";
	  message = "2|2"; //erstes Team alle Spiele
	  //message = "1|Fabian|1|42|2"; //Neuer spieler
	   */
	  message = eingabe();
	  out.writeUTF (message);
	  String data = in.readUTF ();
	  System. out.println("Received: "+ data) ;
	  s.close();
    }catch (UnknownHostException e){
	  System.out.println(" Sock:"+ e.getMessage());
    }catch (EOFException e){ System.out.println(" EOF:"+ e.getMessage());
    }catch (IOException e){ System.out.println(" IO:"+ e.getMessage());}
  }// main
}// class