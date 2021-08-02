package com.david.garcia.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.david.garcia.model.Perfil;
import com.david.garcia.model.Usuario;
import com.david.garcia.model.Vacante;
import com.david.garcia.service.IntUsuariosService;
import com.david.garcia.service.IntVacantesService;

@Controller
public class HomeController {
	@Autowired
	private IntUsuariosService usuariosService;
	@Autowired
	private IntVacantesService vacantesService;
	@GetMapping("/")
	public String mostrarHome(Model model) {
		List<Vacante> vacantes = vacantesService.todasDestacadas();
		model.addAttribute("vacantes", vacantes);
		return "home";
	}
	
	@GetMapping("/acerca")
	public String Acerca() {
		return "acerca";
	}
	@GetMapping("/crear")
	public String crearUsuario(Usuario usuario) {
		return "formRegistro";
	}
	
	@PostMapping("/guardar")
	public String guardarUsuario(Usuario usuario) {
		
		String modificar = "{noop}" + usuario.getPassword();
		usuario.setPassword(modificar);
		
		usuario.setEstatus(1);
		usuario.setFechaRegistro(LocalDate.now());
		
		Perfil perfil = new Perfil();
		perfil.setId(3);
		usuario.agregar(perfil);
		System.out.println(usuario);
		usuariosService.guardar(usuario);
		
		return "/formLogin";
	}
}
