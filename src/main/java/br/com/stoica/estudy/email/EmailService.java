package br.com.stoica.estudy.email;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import br.com.stoica.estudy.jasper.PessoaJasper;
import br.com.stoica.estudy.pessoa.PessoaService;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private PessoaJasper pessoaJasper;

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

    public void sendRelatorio(EmailDTO emailDTO,Pageable pageable) {
        byte[] relatorio = pessoaJasper.gerarRelatorioPessoas(pageable);
        MimeMessagePreparator message = mimeMessage -> {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(emailDTO.getEmailFrom());
            helper.setTo(emailDTO.getEmailTo());
            helper.setSubject(emailDTO.getSubject());
            helper.setText(emailDTO.getText());
            helper.addAttachment("relatorio-pessoas.pdf", new ByteArrayResource(relatorio));
        };
        try {
            javaMailSender.send(message);
        } catch (MailException e) {
            throw new RuntimeException (e);
        }
    }

    
}
