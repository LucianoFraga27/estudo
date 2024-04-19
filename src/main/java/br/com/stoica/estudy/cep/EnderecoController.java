package br.com.stoica.estudy.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private ViaCepClient viaCepClient;

    @Autowired
    private PessoaEnderecoRepository rRepository;

    @Autowired
    private EnderecoRepository eRepository;

    @GetMapping("/{cep}")
    public Endereco getEndereco(@PathVariable String cep) {
        return viaCepClient.getEndereco(cep); 
    }

    @GetMapping("/relacionamentos")
    public List<?> getRelacionamentos() {
        return rRepository.findAll();
    }
    
    @GetMapping("/enderecos")
    public List<?> getEnderecos() {
        return eRepository.findAll();
    }

    @PostMapping("/pessoa/{pessoaID}/{cep}")
    public PessoaEndereco salvarEnderecoPessoa (@PathVariable Long pessoaID, @PathVariable String cep ) {
        return null;
    }
 
}
