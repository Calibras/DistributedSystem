package com.company;

import com.company.Server.TCPServer;
import com.company.Teams.PlayerPosition;
import com.company.Teams.Team;

public class Main {

    public static void main(String[] args) {
        TCPServer.team1 = new Team("Die Furiosen vier");
        TCPServer.team2 = new Team("Die fantastichen 5");
        TCPServer.team3 = new Team("Mamas liebling !");

        TCPServer.RunServer();;
    }
}
