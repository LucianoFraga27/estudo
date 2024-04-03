package br.com.stoica.estudy.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.stoica.estudy.pessoa.Pessoa;

@Service
class CsvServiceBean implements CsvService{
    
    @Override
    public void gerarCsvBasico(List<Pessoa> pessoas)  {
        String fileName = "C://desenvolvimento//estudy//src//main//resources//relatorios//csv//pessoas.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("ID;Nome;Cpf");
            for (Pessoa pessoa : pessoas) {
                writer.println(pessoa.getId() + ";" + pessoa.getNome() + ";" + pessoa.getCpf());
            }
        } catch (Exception e) {
            System.err.println("Erro ao gerar csv");
        }
    }

    @Override
    public List<Pessoa> lerCsvBasico(String path) {
        // deixa para lá o path, depois fica melhor
        path = "C://desenvolvimento//estudy//src//main//resources//relatorios//csv//leitura.csv";
        String line = "";
        int count = 0;
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                System.out.println("Linha: "+count);
                String[] campos = line.split(";");
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(campos[1]);
                pessoa.setCpf(campos[2]);
                pessoas.add(pessoa);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        pessoas.forEach(System.out::println);
        return pessoas;
    }
        
    

}
