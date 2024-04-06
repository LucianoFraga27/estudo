package br.com.stoica.estudy.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendEmail(EmailDTO emailDTO) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailDTO.getEmailFrom());
            message.setTo(emailDTO.getEmailTo());
            message.setSubject(emailDTO.getSubject());
            message.setText(emailDTO.getText());
            javaMailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException (e);
        } 
    }
    
}
