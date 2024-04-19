package br.com.stoica.estudy.cep;

import org.springframework.stereotype.Service;

import br.com.stoica.estudy.pessoa.PessoaService;

@Service
public class EnderecoService {
    
    // @Autowired
    private EnderecoRepository enderecoRepository;
    
    // @Autowired
    private PessoaService pessoaService;

    // private v


    public void salvarEndereco () {

        enderecoRepository.save(null);
    }

}
