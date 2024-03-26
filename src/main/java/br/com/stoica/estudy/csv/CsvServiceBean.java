package br.com.stoica.estudy.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.stoica.estudy.pessoa.Pessoa;

@Service
class CsvServiceBean implements CsvService{
    
    @Override
    public void gerarCsvBasico(List<Pessoa> pessoas)  {
        String fileName = "C://desenvolvimento//estudy//src//main//resources//relatorios//csv//pessoas.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("ID;Nome;Email");
            for (Pessoa pessoa : pessoas) {
                writer.println(pessoa.getId() + ";" + pessoa.getNome() + ";" + pessoa.getCpf());
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerar csv");
        }
    }

}
