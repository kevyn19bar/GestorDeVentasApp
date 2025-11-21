package com.Hokkaido.GestorDeVentasApp.servicios;

import com.Hokkaido.GestorDeVentasApp.entidades.Assistants;
import com.Hokkaido.GestorDeVentasApp.repositorios.AssistansRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class AssistansServicioImpl implements AssistansServicio {

	@Autowired
	private AssistansRepositorio assistantsRepository;

    @Override
	public List<Assistants> GetAllAssistants() {
		return assistantsRepository.findAll();
	}
	
    @Override
	public Assistants getAssistantById(Long id) {
		Optional<Assistants> optionalAssistant = assistantsRepository.findById(id);
		if (optionalAssistant.isPresent()) {
			return optionalAssistant.get();
		} else {
			throw new RuntimeException("Wizard not found with ID: " + id);
		}
	}

    @Override
	public void saveOrUpdateAssistant(Assistants assistant) {
		assistantsRepository.save(assistant);
	}

    @Override
	public void deleteAssistant(Long id) {
		assistantsRepository.deleteById(id);
	}
}