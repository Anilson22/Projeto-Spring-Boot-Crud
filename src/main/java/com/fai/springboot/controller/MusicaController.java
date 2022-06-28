package com.fai.springboot.controller;

import com.fai.springboot.dao.MusicaDaoImpl;
import com.fai.springboot.model.Musica;
import com.fai.springboot.service.MusicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/musica")
public class MusicaController {

    @Autowired
    MusicaServiceImpl musicaService;

    @GetMapping("/list")
    public String getListPage(Model model) {

        List<Musica> list = musicaService.list();
        model.addAttribute("musica", list);
        return "/musica/listar-musica";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model) {
        Musica musicaModel = new Musica();
        model.addAttribute("musica", musicaModel);
        return "piano/criar-musica";
    }
    @GetMapping("/detail/{id}")
    public String getdetailPage(@PathVariable int id, Model model) {
        model.addAttribute("musica", musicaService.listById(id));

        return "musica/detalhes-musica";
    }

    @GetMapping("/update")
    public String getUpdatePage (Model model, Musica musica) {
        musicaService.update(musica);
        return getListPage(model);
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable int id, Model model){
        model.addAttribute("musica", musicaService.listById(id));

        return "/musica/editar-musica";
    }


}
