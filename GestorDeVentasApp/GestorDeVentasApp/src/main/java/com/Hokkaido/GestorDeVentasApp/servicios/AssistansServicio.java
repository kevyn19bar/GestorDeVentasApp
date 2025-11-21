package com.Hokkaido.GestorDeVentasApp.servicios;

import java.util.List;
import com.Hokkaido.GestorDeVentasApp.entidades.Assistants;

public interface AssistansServicio {
    
    List<Assistants> GetAllAssistants();
    
    Assistants getAssistantById(Long id);    
    
    void saveOrUpdateAssistant(Assistants assistant);
    
    void deleteAssistant(Long id);
}