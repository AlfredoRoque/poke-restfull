package com.rest.pokemon.services;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.rest.pokemon.models.AbilityModel;
import com.rest.pokemon.models.BaseExperienceModel;
import com.rest.pokemon.models.HeldItemsModel;
import com.rest.pokemon.models.IdModel;
import com.rest.pokemon.models.LocationAreaModel;
import com.rest.pokemon.models.NameModel;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PokemonService {
	private HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
	private final String URL = "https://pokeapi.co/api/v2/pokemon/";
	
	public AbilityModel getAbilities(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			AbilityModel endPoint = new Gson().fromJson(response.body(), AbilityModel.class);
			endPoint.setAbilities(endPoint.getAbilities());
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	public BaseExperienceModel getBaseExperience(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			BaseExperienceModel endPoint = new Gson().fromJson(response.body(), BaseExperienceModel.class);
			endPoint.setBase_experience(endPoint.getBase_experience());
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public HeldItemsModel getHeldItems(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			HeldItemsModel endPoint = new Gson().fromJson(response.body(), HeldItemsModel.class);
			endPoint.setHeld_items(endPoint.getHeld_items());
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public IdModel getId(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			IdModel endPoint = new Gson().fromJson(response.body(), IdModel.class);
			endPoint.setId(endPoint.getId());
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public NameModel getname(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			NameModel endPoint = new Gson().fromJson(response.body(), NameModel.class);
			endPoint.setName(endPoint.getName());
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public LocationAreaModel getLocationArea(String nombre){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(this.URL+nombre)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			LocationAreaModel res = new Gson().fromJson(response.body(), LocationAreaModel.class);
			String respuesta = getURLLocation(res.getLocation_area_encounters());
			LocationAreaModel endPoint = new LocationAreaModel();
			endPoint.setLocation_area_encounters(respuesta);
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getURLLocation(String url){
		HttpRequest requestPost = HttpRequest.newBuilder().GET()
				.uri(URI.create(url)).build();
		try {
			HttpResponse<String> response = httpClient.send(requestPost, HttpResponse.BodyHandlers.ofString());
			String endPoint = response.body();
			return endPoint;
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
