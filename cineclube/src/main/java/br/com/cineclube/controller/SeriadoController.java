package br.com.cineclube.controller;

// import java.math.BigDecimal;
// import java.time.LocalDate;
// import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cineclube.dao.SeriadoRepository;
import br.com.cineclube.model.Category;
import br.com.cineclube.model.Seriado;

@Controller
@RequestMapping("/seriados")
public class SeriadoController {
    
    @Autowired
    private SeriadoRepository dao;

    @PostMapping("/save")
    public String Save(@Valid Seriado seriado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categories", Category.values());
            return "/seriados/manter";
        }
        dao.save(seriado);
        return "redirect:/seriados/list";
    }

    @RequestMapping("/new") // cadastro do seriado
	public String newForm(Model model) {
		// objeto seriado sera mapeado ao ${seriado} da view
		Seriado seriado = new Seriado(); 
		model.addAttribute("seriado", seriado);
		
		// criar um lista de categorias
		model.addAttribute("categories",Category.values());
		System.out.println("chegouaqui");
		return "/seriados/manter";
	}

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        dao.deleteById(id);
        return "redirect:/seriados/list";
    }
    @RequestMapping("/list")
    public String list(Model model) {
        List<Seriado> seriadoList = dao.findAll();
        model.addAttribute("seriados", seriadoList);
        return "/seriados/list";
    }
}
