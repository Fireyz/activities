package br.com.activities.controllers;

import br.com.activities.daos.DepartamentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.activities.daos.TipoDAO;
import br.com.activities.models.Departamento;
import br.com.activities.models.Tipo;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tipos")
public class TiposController {

    @Autowired
    private TipoDAO tipoDao;
    @Autowired
    private DepartamentoDAO departamentoDao;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("tipos/form");
        List<Departamento> departamento = departamentoDao.listar();
        modelAndView.addObject("departamento", departamento);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(Tipo tipo, RedirectAttributes redirectAttributes) {
        tipoDao.gravar(tipo);
        redirectAttributes.addFlashAttribute("sucesso", "Tipo Cadastrado com Sucesso!");
        return new ModelAndView("redirect:tipos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Tipo> tipos = tipoDao.listar();
        ModelAndView modelAndView = new ModelAndView("tipos/lista");
        modelAndView.addObject("tipo", tipos);
        return modelAndView;
    }

}
