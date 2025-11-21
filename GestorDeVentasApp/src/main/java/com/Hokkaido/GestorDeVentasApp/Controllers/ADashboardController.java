package com.Hokkaido.GestorDeVentasApp.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ADashboardController {
	
	@GetMapping("")
	public String getAllAssistants(Model model) {		
		return "/entities/index";
	}
	
}
