package br.com.stoica.estudy.cep;

public record EnderecoDTO
(
    String cep,
    String logradouro,
    String bairro,
    String localidade,
    String uf,
    String ddd
)
{
    
}
