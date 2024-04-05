package br.com.stoica.estudy.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;


@RequestMapping("/email")
@RestController
public class EmailController {
    
    @Autowired
    private EmailService emailService;

    
    @GetMapping(path="/send")
    public void getMethodName(@RequestBody @Valid EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
    }
    
}
