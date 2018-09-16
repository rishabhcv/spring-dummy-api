package com.esp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public Resource<Players> findOnePlayer(@PathVariable int id) {
		Players player = playerDao.findOne(id);
		if(player == null) {
			throw new PlayerNotFoundException("id-"+id);
		}
		Resource<Players> resource = new Resource<Players>(player);
		ControllerLinkBuilder uri = linkTo(methodOn(this.getClass()).displayAllPlayers());
		resource.add(uri.withRel("all-players"));
		return resource;
	}
}
