package br.com.stoica.estudy.pessoa;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException(Long id){
        super(String.format("A pessoa com id igual a %d, não foi localizada.", id));
    }
    
}
