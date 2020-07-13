package br.com.activities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.activities.daos.EmpresaDAO;
import br.com.activities.models.Empresa;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/empresas")
public class EmpresasController {

    @Autowired
    private EmpresaDAO empresaDao;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("empresas/form");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(Empresa empresa, RedirectAttributes redirectAttributes) {
        empresaDao.gravar(empresa);
        redirectAttributes.addFlashAttribute("sucesso", "Empresa Cadastrada com Sucesso!");
        return new ModelAndView("redirect:empresas");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Empresa> empresas = empresaDao.listar();
        ModelAndView modelAndView = new ModelAndView("empresas/lista");
        modelAndView.addObject("empresas", empresas);
        return modelAndView;
    }

}
