package br.com.stoica.estudy.cep;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EnderecoDTO {
    public String cep;
    public String logradouro;
    public String bairro;
    public String localidade;
    public String uf;
    public String ddd;
}