package com.esp.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esp.entity.Players;
import com.esp.exception.PlayerNotFoundException;
import com.esp.repository.PlayerDao;

@RestController("PlayerController")
public class PlayerController {
	
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
	
	@SuppressWarnings("rawtypes")
	@PostMapping(path = "/players")
	public ResponseEntity createPlayer(@RequestBody Players player) {
		playerDao.save(player);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(player.getId())
		.toUri();
		return ResponseEntity.created(location).build();
	}
	
}
