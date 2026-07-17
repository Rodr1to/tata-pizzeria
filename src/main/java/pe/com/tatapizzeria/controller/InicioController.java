package pe.com.tatapizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String MostrarInicio() {
        return "index";
    }

    @GetMapping("/menuprincipal")
    public String MostrarMenuPrincipal() {
        return "menuprincipal";
    }
    
    @GetMapping("/login")
    public String MostrarLogin() {
        return "login";
    }
}
