package br.com.stoica.estudy.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    
    @Autowired
    private ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public EnderecoDTO getEndereco(@PathVariable String cep) {
        return viaCepClient.getEndereco(cep); 
    }
}
