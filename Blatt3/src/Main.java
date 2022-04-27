package com.company;

import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Team team = new Team("Die Furiosen Falken!");
        team.addPlayer("Hardmud", PlayerPosition.OUTSIDE_LINEBRACKER, 20);
        team.addPlayer("Gurdrund", PlayerPosition.SAFETY, 42);
        team.addPlayer("Chutlu höst selbst", PlayerPosition.COMBACK, 100);

        System.out.println(calculateAverageTeamAge(team));
        System.out.println("DAs allter von gurdun durhc das Team gefunden " + team.getPlayer("Gurdrund").getAge());
        team.getPlayer("Gurdrund").setAge(200);
        System.out.println("Gurddun ist gealtert ! " + team.getPlayer("Gurdrund").getAge());
    }
    public static double calculateAverageTeamAge(Team team){
        int cumulatedAge = 0;
        ArrayList<Player> players = team.getPlayers();
        for(int i = 0; i < players.size(); i++){
            cumulatedAge += players.get(i).getAge();
        }
        return  cumulatedAge / players.size();
    }
}
