package br.com.stoica.estudy.cep;

public record Endereco 
(
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String uf
)
{
    
}
