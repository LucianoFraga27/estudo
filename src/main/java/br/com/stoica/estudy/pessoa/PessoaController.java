package br.com.stoica.estudy.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public Page<?> findAll (Pageable pageable) {
        return pessoaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Pessoa findById (@PathVariable(value = "id") Long id) {
        return pessoaService.findById(id);
    }

    @GetMapping("/gerar-csv")
    public void gerarCsvBasico() {
        pessoaService.gerarCsvBasico();
    }
    
    
}
