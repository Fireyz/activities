package br.com.activities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.activities.daos.TarefaDAO;
import br.com.activities.models.Tarefa;
import br.com.activities.validation.TarefaValidation;
import java.util.List;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
//Mapeia todo o controler para iniciar de /tarefas
@RequestMapping(name = "TarefaController", value = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaDAO tarefaDao;

    //Faz as ligações do Controller com Validation
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new TarefaValidation());
    }

    @RequestMapping("/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("tarefas/form");
        return modelAndView;
    }

    //Como existem dois mapeamentos para /tarefas, há duas formas de tratar baseado no método, nesse caso POST
    @RequestMapping(name = "gravar", method = RequestMethod.POST)
    //@Valid = Efetua a validação automaticamente utilizando o TarefaValidation | result = Resultado da Validação
    public ModelAndView gravar(@Valid @ModelAttribute("tarefa") Tarefa tarefa, BindingResult result,
            RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return form();
        }

        tarefaDao.gravar(tarefa);
        //Redireciona um atributo para próxima requisição (bem utilizado para mensagens de sucesso/erro) > Post > Redirect > Get
        redirectAttributes.addFlashAttribute("sucesso", "Tarefa Cadastrada com Sucesso!");
        return new ModelAndView("redirect:tarefas");
    }

    //Como existem dois mapeamentos para /tarefas, há duas formas de tratar baseado no método, nesse caso GET
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Tarefa> tarefas = tarefaDao.listar();
        ModelAndView modelAndView = new ModelAndView("tarefas/lista");
        modelAndView.addObject("tarefas", tarefas);
        return modelAndView;
    }

}
