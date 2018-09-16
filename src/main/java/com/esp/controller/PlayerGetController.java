package com.esp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.esp.entity.Players;
import com.esp.exception.PlayerNotFoundException;
import com.esp.repository.PlayerDao;

@RestController("PlayerGetController")
public class PlayerGetController {

	@Autowired
	private PlayerDao playerDao;
	
	@GetMapping(path = "/players")
	public ArrayList<Players> displayAllPlayers() {
		return playerDao.findAll();
	}
	
	@GetMapping(path = "/players/{id}") 
	public Players findOnePlayer(@PathVariable int id) {
		Players player = playerDao.findOne(id);
		if(player == null) {
			throw new PlayerNotFoundException("id-"+id);
		}
		return player;
	}
}
