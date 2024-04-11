package br.com.stoica.estudy.email;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@RequestMapping("/email")
@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private EmailConfig emailCONFIG;
    
    @PostMapping(path="/send")
    public void getMethodName(@RequestBody @Valid EmailDTO emailDTO) {
        System.out.println(emailCONFIG.getUsername());
        System.out.println(emailCONFIG.getPassword());
        emailService.sendEmail(emailDTO);
    }
    
    @PostMapping(path="/send/relatorio")
    public void enviarRelatorio(@RequestBody @Valid EmailDTO emailDTO ,Pageable pageable) {
        emailService.sendRelatorio(emailDTO,pageable);
    }
    
}
