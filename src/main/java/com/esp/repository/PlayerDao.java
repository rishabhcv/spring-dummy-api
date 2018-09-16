package com.esp.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.esp.entity.Players;

@Component
public class PlayerDao {
	
	public static ArrayList<Players> playerRecord = new ArrayList<Players>();
	
	static {
		playerRecord.add(new Players(1,"Rocky Ponting" ,"Australia"));
		playerRecord.add(new Players(2,"Steve Waugh" ,"England"));
		playerRecord.add(new Players(3,"Virat Kohli" ,"India"));
	}
	
	public ArrayList<Players> findAll(){
		return playerRecord;
	}
	
	public Players findOne(int id){
		for(Players player : playerRecord) {
			if(player.getId() == id) {
				return player;
			}
		}
		return null;
	}
	
	public void save(Players player) {
	   playerRecord.add(player);
	}
	
	//To be enhanced using iterator
	public void delete(int id) {
		   playerRecord.remove(id);
		}

}
