package com.adobe.aem.guides.wknd.core.models;

public interface EmailService {

    void sendEmail(
            String toEmail,
            String ccEmail,
            String fromEmail,
            String subject,
            String content);
}