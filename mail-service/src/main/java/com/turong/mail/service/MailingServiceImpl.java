package com.turong.mail.service;

import com.turong.mail.entity.MailLog;
import com.turong.mail.repository.MailLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MailingServiceImpl implements MailingService {

    private final MailLogRepository mailLogRepository;

    public MailingServiceImpl(@Autowired final MailLogRepository mailLogRepository) {
        this.mailLogRepository = mailLogRepository;
    }

    @Override
    public MailLog insert(String from, String to, String body) {
        MailLog mailLog = new MailLog();
        mailLog.setFrom(from);
        mailLog.setTo(to);
        mailLog.setBody(body);
        mailLog.setCreatedAt(LocalDate.now());
        mailLog.setModifiedAt(LocalDate.now());
        return this.mailLogRepository.save(mailLog);
    }
}
