package br.com.stoica.estudy.cep;

import br.com.stoica.estudy.pessoa.Pessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PessoaEndereco {
    
    @Id
    @EqualsAndHashCode.Include
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private int numero;
    private String complemento;
    
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "cep")
    private Endereco endereco;
    
    private boolean principal;

}
