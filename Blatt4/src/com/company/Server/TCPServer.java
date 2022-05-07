package com.company.Server;

import com.company.Teams.Player;
import com.company.Teams.PlayerPosition;
import com.company.Teams.Team;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TCPServer {
  public static Team team1;
  public static Team team2;
  public static Team team3;
  public static void RunServer () {
    try{
      System.out.println("The Server is running");
	  int serverPort = 7896;
	  ServerSocket listenSocket = new ServerSocket (serverPort);
	  while(true) {
	    Socket clientSocket = listenSocket.accept();
	    System. out.println("New Connection");
	    Connection c = new Connection(clientSocket);
	  }
    } catch( IOException e) {System.out.println(" Listen :"+ e.getMessage());}
  }// main
}//class


class Connection extends Thread {
  DataInputStream in;
  DataOutputStream out;
  Socket clientSocket;

  public Connection (Socket aClientSocket) {
    try {
      clientSocket = aClientSocket;
      out = new DataOutputStream ( clientSocket.getOutputStream() );
      in = new DataInputStream ( clientSocket.getInputStream() );     
      this.start();
    } catch( IOException e) {System. out. println(" Connection:"+ e.getMessage());}
  }

  public void run(){
    try {
      String data = in.readUTF();
	  //out.writeUTF(data);

	  System.out.println("Sent data: " + data);
	  //entscheiden auf basis der Daten trennen mit | 1 Spieler hinzufügen oder abfragen
      String [] dataSet = data.split("\\|", -1);

      System.out.println("Was in Dataset drin ist " +  Arrays.toString(dataSet));

        if(dataSet[0].equals("1")){
          //"1|Fabian|FOO|42|1" fügt
          System.out.println("Neuer Spiler!");
          //neuer spieler
          //String name, PlayerPosition position, int age
          int playerPositionInt = Integer.parseInt(dataSet[2]);
          Player newPlayer = new Player(dataSet[1], PlayerPosition.values()[playerPositionInt],Integer.parseInt(dataSet[3]));
          //welches team
          String teamId = dataSet[4];
          if(teamId.equals("1")){
              TCPServer.team1.addPlayer(newPlayer);
          }else if(teamId.equals("2")){
              TCPServer.team2.addPlayer(newPlayer);
          }else  if(teamId.equals("3")){
              TCPServer.team3.addPlayer(newPlayer);
          }
          out.writeUTF("Neuer Spieler !");
        }else if(dataSet[0].equals("2")){
          System.out.println("Alle Spieler namen bidde!");
          //alle Namen bidde
          String allPlayersString = "";
          String teamId = dataSet[1];
          if(teamId.equals("1")){
              allPlayersString = TCPServer.team1.returnAllPlayerAsString();
          }else if(teamId.equals("2")){
              allPlayersString = TCPServer.team2.returnAllPlayerAsString();
          }else  if(teamId.equals("3")){
              allPlayersString = TCPServer.team3.returnAllPlayerAsString();
          }
          System.out.println("Was wir senden wollen " + allPlayersString);
          //und senden
          out.writeUTF(allPlayersString);
      }else{
          System.out.println("Irgendeine andere angabe");
      }
    } catch( EOFException e) {System.out.println(" EOF:"+ e.getMessage());
    } catch( IOException e) {System.out.println(" IO:"+ e.getMessage());}
  }
}