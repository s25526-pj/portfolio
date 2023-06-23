package com.lekarze.visit_api.service;

import com.lekarze.visit_api.model.Visit;

public interface EmailService {

    void sendEmail(Visit visit);

}
