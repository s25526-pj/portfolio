package com.kalinowski.exchange.service;

import com.kalinowski.exchange.model.ExchangeApiResponse;
import com.kalinowski.exchange.model.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderService {

    private static final String SUBJECT = "Exchange Confirmation";

    private final JavaMailSender mailSender;

    public void sendEmail(String reciverEmail , ExchangeApiResponse response) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("testmail@gmail.com");
        message.setSubject(SUBJECT);
        message.setTo(reciverEmail);
        Query query = response.getQuery();
        message.setText("Successful exchange \n" +
                "Changed " + query.getAmount() + query.getFrom() + " to "
                + response.getResult() + query.getTo() + " at:" + response.getDate()
                + " with rate:" + response.getInfo().getRate());
        mailSender.send(message);
        System.out.println("Mail sent successfully!");
    }

}
