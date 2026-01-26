package com.Hokkaido.GestorDeVentasApp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Hokkaido.GestorDeVentasApp.entidades.Locations;
import com.Hokkaido.GestorDeVentasApp.servicios.LocationsServicio;

@Controller
public class LocationsController {
	
	@Autowired
	private LocationsServicio locationsServicio;
	
	@GetMapping("/listLocation")
	public String getAllAssistants(Model model) {
		try {
			List<Locations> listLocations = locationsServicio.getAllLocations();
			model.addAttribute("Locations", listLocations);
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
		return "/entities/location/Locations";
	}
	
	@GetMapping("/addLocation")
	public String showAddForn(Model model) {
		try {
			model.addAttribute("location", new Locations());
		} catch (Exception e) {
			System.out.println("Error preparing add form: " + e.getMessage());
		}
		return "/entities/location/AddLocation";
	}
    @GetMapping("/editLocation/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        try {       
            Locations locations = locationsServicio.getLocationById(id);            
            model.addAttribute("location", locations);
        } catch (Exception e) {
            System.out.println("Error getting editing location: " + e.getMessage());
            return "redirect:/listLocation";
        }
        return "/entities/location/EditLocation";
    }
    @PostMapping("/savelocation")
    public String saveLocation(@ModelAttribute("location") Locations locations, RedirectAttributes redirectAttributes) {
 
        boolean isNew = (locations.getLocation_id() == null); 
        try {
        	locationsServicio.saveOrUpdateLocation(locations);
            if (isNew) {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully added location.");
            } else {
                redirectAttributes.addFlashAttribute("successMessage", "Successfully updated location.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error saving location: " + e.getMessage());
        }
        
        return "redirect:/listLocation";
    }
    @GetMapping("/delLocation/{id}")
    public String deleteInvetori(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
        	locationsServicio.deleteLocation(id);
            redirectAttributes.addFlashAttribute("successMessage", "locations ID " + id + " successfully removed.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error deleting location ID " + id + ": " + e.getMessage());
        }
        
        return "redirect:/listLocation";
    }
}
