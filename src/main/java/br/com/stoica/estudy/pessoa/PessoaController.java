package br.com.stoica.estudy.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @GetMapping
    public String getMethodName() {
        return "Sucesso";
    }
    
}
