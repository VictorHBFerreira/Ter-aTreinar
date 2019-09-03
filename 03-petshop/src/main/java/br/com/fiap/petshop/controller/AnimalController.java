package br.com.fiap.petshop.controller;

import br.com.fiap.petshop.model.Animal;
import br.com.fiap.petshop.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    private AnimalRepository rep;


    //deletar

        @PostMapping("excluir")
        public String deletar(int codigo, RedirectAttributes redirect){
            rep.deleteById(codigo);
            redirect.addFlashAttribute("msg", "Apagado!");
            return "redirect:/animal/listar";
        }
    //URL - animal/editar
    @PostMapping("/editar")
    public String editar(Animal animal, RedirectAttributes redirectAttributes){
        rep.save(animal);
        redirectAttributes.addFlashAttribute("msg","Editado!");
        return "redirect:/animal/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("animal", rep.findById(codigo));
        return "/animal/editar";
    }

    //URL - animal/listar
    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("pets", rep.findAll());
        return "animal/lista";
    }

    //URL - animal/cadastrar
    @GetMapping("/cadastrar")
    public String cadastrar(Animal animal){
        return "/animal/form";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Animal animal, RedirectAttributes redirectAttributes){
        rep.save(animal);
        redirectAttributes.addFlashAttribute("msg","Cadastrado!");
        return "redirect:/animal/listar";
    }

}
