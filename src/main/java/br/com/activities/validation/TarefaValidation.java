package br.com.activities.validation;

import br.com.activities.models.Tarefa;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TarefaValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Tarefa.class.isAssignableFrom(clazz);
    }

    @Override
    //Validação do Formulário
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "empresa", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "tipo", "field.required");
        ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");

        Tarefa tarefa = (Tarefa) target;
        
        if (tarefa.getMinutos() <= 0) {
            errors.rejectValue("minutos", "field.required");
        }
    }
}
