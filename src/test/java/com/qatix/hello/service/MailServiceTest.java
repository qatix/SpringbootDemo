package com.qatix.hello.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception{
        String to = "hawk418@qq.com";
        String subject = "test mail from java";
        String content = "springboot mail test";
        mailService.sendSimpleMail(to,subject,content);
    }

    @Test
    public void sendhtmlMail(){
        String to = "hawk418@qq.com";
        String subject = "test html from java";
        String content = "<html>\n"+
                "<body>\n" +
                "<h3>This is a test email</h3>\n" +
                "</body>\n"+
                "</html>";
        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    public void sendAttachmentMail(){
        String to = "hawk418@qq.com";
        String subject = "test attachment from java";
        String content = "email with attachment";
        String filePath = "/Users/tang/Downloads/conversation.jpg";
        mailService.sendAttachmentsMail(to,subject,content,filePath);
    }

    @Test
    public void sendInlineResourceMail(){
        String to = "hawk418@qq.com";
        String subject = "test inline email from java";
        String content = "email with attachment";
        String filePath = "/Users/tang/Downloads/conversation.jpg";
        String rscId = "tang002";
        mailService.sendInlineResourceMail(to,subject,content,filePath,rscId);
    }


    @Test
    public void sendTemplateMail(){
        String to = "hawk418@qq.com";
        String subject = "test template from java";

        Context context = new Context();
        context.setVariable("id","002");
        String content = templateEngine.process("email_template",context);

        mailService.sendHtmlMail(to,subject,content);
    }

}
