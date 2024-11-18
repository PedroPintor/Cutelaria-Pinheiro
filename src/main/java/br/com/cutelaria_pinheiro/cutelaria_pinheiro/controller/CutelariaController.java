package br.com.cutelaria_pinheiro.cutelaria_pinheiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping({"/cutelaria-pinheiro","/teste"})
public class CutelariaController {

    // pagina de teste para os DEVs
    @GetMapping("/dev")
    public String indexDev() {
        return "index/index-dev";
    }

    // pagina principal
    @GetMapping({"","/"})
    public String index(){
        return "index/pagina-principal";
    }

    // pagina de cutelos
    @GetMapping("/cutelos")
    public String pag_cutelos(){
        return "index/cutelos";
    }

    // pagina de tabuas
    @GetMapping("/tabuas")
    public String pag_tabuas(){
        return "index/tabuas";
    }

    // página de comentários
    @GetMapping("/comentarios")
    public String pag_comentarios(){
        return "index/comentarios-OutroGrupo";
    }

    // página de vitrine
    @GetMapping("/vitrine")
    public String pag_vitrine(){
        return "index/vitrine-OutroGrupo";
    }


     // página de index-OG
     @GetMapping("/index-OG")
     public String pag_indexOG(){
         return "index/index-outroGrupo";
     }
}
