package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Visit;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final VisitService visitService;

    private final EmailService emailService;

    @Scheduled(fixedRate = 60_000)
    private void sendConfirmationEmail() {
        List<Visit> notNotifiedVisits = visitService.findAllNotNotifiedInNextTwentyFourHours();
        for (Visit visit : notNotifiedVisits) {
                emailService.sendEmail(visit);
                visitService.confirmSendingNotification(visit.getId());
        }

    }

}
