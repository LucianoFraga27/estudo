package br.com.stoica.estudy.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.stoica.estudy.jasper.PessoaJasper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaJasper jasper;


    @Operation(summary = "Liste as pessoas")
    @ApiResponses(value = { 
    @ApiResponse(responseCode = "200", description = "Sucesso")})
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    public Page<?> findAll (@ParameterObject Pageable pageable) {
        return pessoaService.findAll(pageable);
    }

    @GetMapping(path="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    public Pessoa findById (@PathVariable(value = "id") Long id) {
        return pessoaService.findById(id);
    }

    @GetMapping(path="/basico/gerar-csv")
    public void gerarCsvBasico() {
        pessoaService.gerarCsvBasico();
    }

    @GetMapping(path="/basico/ler-csv")
    public void lerCsvBasico() {
        pessoaService.lerCsvBasico("path");
    }
    
    @GetMapping(path= "/basico/gerar-jasper", produces= MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> gerarRelatorioJasper(Pageable pageable) {
        byte[] pessoasPdf = jasper.gerarRelatorioPessoas(pageable);
        
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=pessoas.pdf"); 
        // filename = nome sugerido do arquivo baixado
        // attachment: isso significa que a resposta deve ser baixado pelo cliente.

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(pessoasPdf);
    }


    
}
