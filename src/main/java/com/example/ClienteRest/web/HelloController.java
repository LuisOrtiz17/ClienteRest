package com.example.ClienteRest.web;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.ClienteRest.model.Persona;

@Controller
public class HelloController {
	private static final String URL = "http://localhost:8181/ClientesWS/rest/";
	
	@RequestMapping(value = "/hello")
	public String showMessage(Model model){
		int n1 = 23;
		int n2 = 10;
		int suma = n1 + n2;
		model.addAttribute("saludo", "Mi primer aplicacion web SPRING BOOT");
		model.addAttribute("resultado", suma);
		return "hello";
	}
	
	@RequestMapping(value = "sumar", method = RequestMethod.POST)
	public @ResponseBody int sumar(@RequestParam int num1,
			@RequestParam int num2, Model mod){
		int res = num1 + num2;
//		mod.addAttribute("resultado", res);
		return res;
	}
	
	@RequestMapping(value="/mensaje", method = RequestMethod.GET)
	public @ResponseBody String saludo(){
		String saludo ="Welcome";
		return saludo;
	}
	
	@ModelAttribute("personas")
	public List<Persona> getPersona(){
		RestTemplate clien = new RestTemplate();
		ResponseEntity<Persona[]> response = clien.getForEntity(URL + "obtenPersona", Persona[].class);
		List<Persona> all = new ArrayList<Persona>(Arrays.asList(response.getBody()));
		return all;
	}
	
	@RequestMapping(value = "eliminaPer", method = RequestMethod.POST)
	public @ResponseBody String eliminaPer(@RequestParam int id){
		RestTemplate cli = new RestTemplate();
		cli.delete(URL + "eliminaPersona/" + id, 12L);
//		model.addAttribute("message", "EXITO");
		return "EXITO";
	}
	
	@RequestMapping(value = "agregaPer", method = RequestMethod.POST)
	public @ResponseBody String agregaPer(@RequestBody Persona per){
		RestTemplate cliente = new RestTemplate();
		cliente.postForEntity(URL + "agregaPersona", per, Persona.class);
		return "EXITO";
	}
	
	@RequestMapping(value = "updatePer", method = RequestMethod.POST)
	public @ResponseBody String updatePer(@RequestBody Persona per){
		RestTemplate cliente = new RestTemplate();
		cliente.postForEntity(URL + "updatePersona", per, Persona.class);
		return "EXITO";
	}

}
