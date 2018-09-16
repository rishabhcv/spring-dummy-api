package com.esp.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.esp.entity.Players;
import com.esp.exception.PlayerNotFoundException;
import com.esp.repository.PlayerDao;

@RestController("PlayerPostController")
public class PlayerPostController {
	
	@Autowired
	private PlayerDao playerDao;
	
	@PostMapping(path = "/players")
	public ResponseEntity<Players> createPlayer(@Valid @RequestBody Players player) {
		playerDao.save(player);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(player.getId())
		.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/players/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deletePlayer(@PathVariable int id){
		Players player = playerDao.findOne(id);
		if(player == null) {
			throw new PlayerNotFoundException("id: "+id);
		}
		playerDao.delete(id);
		return "Success";
	}
	
}
