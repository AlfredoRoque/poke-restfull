package com.rest.pokemon.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.pokemon.models.AbilityModel;
import com.rest.pokemon.models.BaseExperienceModel;
import com.rest.pokemon.models.HeldItemsModel;
import com.rest.pokemon.models.IdModel;
import com.rest.pokemon.models.LocationAreaModel;
import com.rest.pokemon.models.NameModel;
import com.rest.pokemon.services.PokemonService;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,
		RequestMethod.PUT,RequestMethod.PATCH})
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonService cService;
	@GetMapping(path = "/abilities/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public AbilityModel getAbilities(@PathVariable("nombre") String nombre){
		return cService.getAbilities(nombre);
	}
	@GetMapping(path = "/base-experiences/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public BaseExperienceModel getBaseExperience(@PathVariable("nombre") String nombre){
		return cService.getBaseExperience(nombre);
	}
	@GetMapping(path = "/held-items/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public HeldItemsModel getHeldItems(@PathVariable("nombre") String nombre){
		return cService.getHeldItems(nombre);
	}
	@GetMapping(path = "/id/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public IdModel getId(@PathVariable("nombre") String nombre){
		return cService.getId(nombre);
	}
	@GetMapping(path = "/name/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public NameModel getname(@PathVariable("nombre") String nombre){
		return cService.getname(nombre);
	}
	@GetMapping(path = "/location-area-encounters/{nombre}")
	@ResponseStatus(HttpStatus.OK)
	public LocationAreaModel getLocationArea(@PathVariable("nombre") String nombre){
		return cService.getLocationArea(nombre);
	}
}
