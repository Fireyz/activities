package br.com.activities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.activities.daos.UsuarioDAO;
import br.com.activities.models.Usuario;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioDAO usuarioDao;

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("usuarios/form");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView gravar(Usuario usuario, RedirectAttributes redirectAttributes) {
        usuarioDao.gravar(usuario);
        redirectAttributes.addFlashAttribute("sucesso", "Usuário Cadastrado com Sucesso!");
        return new ModelAndView("redirect:usuarios");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Usuario> usuarios = usuarioDao.listar();
        ModelAndView modelAndView = new ModelAndView("usuarios/lista");
        modelAndView.addObject("usuario", usuarios);
        return modelAndView;
    }

}
