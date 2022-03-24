package br.com.cineclube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


import br.com.cineclube.model.Person;
import br.com.cineclube.dao.PersonRepository;

import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController{
    @Autowired
    private PersonRepository dao;

    @PostMapping("/save")
    public String Save(@Valid Person person, BindingResult result, Model model){
        if(result.hasErrors()){
            return"persons/manter";
        }
        dao.save(person);
        return"redirect:/persons/list";
    }

    @RequestMapping("/new") // cadastro do person
    public String newForm(Model model){
        // objeto person sera mapeado ao ${person} da view
        Person person=new Person();
        model.addAttribute("persons",person);

        // criar um lista de categorias
        System.out.println("chegouaqui");
        return"persons/manter";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable Long id){
        dao.deleteById(id);
        return"redirect:/persons/list";
    }
    @RequestMapping("/list")
    public String list(Model model){
        List<Person> personList=dao.findAll();
        model.addAttribute("persons",personList);
        return"/persons/list";
    }
}
