package br.com.stoica.estudy.csv;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.stoica.estudy.pessoa.Pessoa;

@Service
public interface CsvService {
    void gerarCsvBasico(List<Pessoa> lista);
    List<Pessoa> lerCsvBasico(String path);
}
