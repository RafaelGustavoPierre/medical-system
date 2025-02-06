package com.hospital.medicalsystem.infrastructure.service.email;

import com.hospital.medicalsystem.core.email.EmailProperties;
import com.hospital.medicalsystem.domain.exception.EmailException;
import com.hospital.medicalsystem.domain.service.SendEmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Service
@RequiredArgsConstructor
public class SmtpSendEmailService implements SendEmailService {

    private final JavaMailSender mailSender;

    private final EmailProperties emailProperties;

    private final Configuration freemarkerConfig;

    @Override
    public void send(Message message) {
        try {
            String body = generateTemplate(message);
            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
            helper.setFrom(emailProperties.getSender());
            helper.setTo(message.getRecipients().toArray(new String[0]));
            helper.setSubject(message.getTitle());
            helper.setText(body, true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new EmailException("Não foi possível enviar e-mail", e);
        }
    }

    private String generateTemplate(Message message) {
        try {
            Template template = freemarkerConfig.getTemplate(message.getBody());

            return FreeMarkerTemplateUtils.processTemplateIntoString(template, message.getVars());
        } catch (Exception e) {
            throw new EmailException("Não foi possível montar template do e-mail", e);
        }
    }

}
