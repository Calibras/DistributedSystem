package com.company.Teams;

import java.util.ArrayList;
import java.util.Iterator;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name){
        this.name = name;
        this.players = new ArrayList<Player>();
    }

    public Player getPlayer(String name){
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext()){
            Player player = playerIterator.next();
            if(player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }
    public void addPlayer(String name,  PlayerPosition position, int age){
        Player player = new Player(name, position, age);
        this.players.add(player);
    }
    public void addPlayer(Player player){
        this.players.add(player);
    }
    public String returnAllPlayerAsString(){
        String returnString = "";
        for(int i = 0; i < this.players.size(); i++){
            returnString += this.players.get(i).getName() + " ";
        }
        return returnString;
    }
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    public String getName(){
        return this.name;
    }
}
