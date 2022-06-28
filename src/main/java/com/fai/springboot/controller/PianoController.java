package com.fai.springboot.controller;


import com.fai.springboot.model.Piano;
import com.fai.springboot.service.PianoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/piano")
public class PianoController {

    @Autowired
    PianoServiceImpl pianoService;

    @GetMapping("/list")
    public String getListPage(Model model){

        List<Piano> list = pianoService.list();
        model.addAttribute("piano", list);
        return "/piano/listar-piano";
    }

    @GetMapping("/create")
    public String getCreatePage(Model model){
        Piano pianoModel = new Piano();
        model.addAttribute("piano", pianoModel);
        return "piano/criar-piano";
    }

    @GetMapping("/detail/{id}")
    public String getDetailPage(@PathVariable int id, Model model){
        model.addAttribute("piano", pianoService.listById(id));
        return "/piano/detalhes-piano";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable int id, Model model){
        model.addAttribute("piano", pianoService.listById(id));
        return "/piano/editar-piano";

    }

    @PostMapping("/update")
    public String update(Model model, Piano piano){
        pianoService.update(piano);
        return getListPage(model);
    }

    @PostMapping("/save")
    public String save(Model model, Piano piano){
        pianoService.save(piano);
        return getListPage(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable int id, Model model){
        pianoService.deleteById(id);
        return getListPage(model);
    }


}