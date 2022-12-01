package com.portfolio.MAAP.Controller;

import com.portfolio.MAAP.Entity.Persona;
import com.portfolio.MAAP.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona() {
        return iPersonaService.getPersona();
    }
    
    @PostMapping("/personas/crear")
        public String createPersona(@RequestBody Persona persona){
        iPersonaService.savePersona(persona);
        return("Persona guardada.");
    }

    @DeleteMapping("/personas/borrar/{id}")
        public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return("Persona eliminada.");
        }
        
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                                @RequestParam("Nombre") String NuevoNombre,
                                @RequestParam("Apellido") String NuevoApellido,
                                @RequestParam("Img") String NuevoImg){
        Persona persona = iPersonaService.findPersona(id);
        persona.setNombre(NuevoNombre);
        persona.setApellido(NuevoApellido);
        persona.setImg(NuevoImg);
        iPersonaService.savePersona(persona);
        return persona;
        }
}
