package br.com.stoica.estudy.cep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository <PessoaEndereco, Long> {
    
}
