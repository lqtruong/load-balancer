package com.turong.mail.service;

import com.turong.mail.entity.MailLog;

public interface MailingService {

    MailLog insert(final String from, String to, String body);

}
