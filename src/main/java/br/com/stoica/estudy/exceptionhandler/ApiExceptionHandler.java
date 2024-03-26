package br.com.stoica.estudy.exceptionhandler;

import java.net.URI;
import java.net.http.HttpRequest;

import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.stoica.estudy.pessoa.PessoaNaoEncontradaException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler({PessoaNaoEncontradaException.class})
    public ResponseEntity<?> handlePessoaNaoEncontradaException (WebRequest request, PessoaNaoEncontradaException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(404);
        problemDetail.setTitle("Pessoa não encontrada");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("recurso-nao-encontrado"));
        return ResponseEntity.of(problemDetail).build();
        }



}
