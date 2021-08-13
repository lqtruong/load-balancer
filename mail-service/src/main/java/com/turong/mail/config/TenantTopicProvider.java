package com.turong.mail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class TenantTopicProvider {

    @Autowired
    private Environment env;

    public String getSendMailListeningTopic() {
        return MessageFormat.format("cloudufo-{0}-message-sendmail", "tr");
    }

}
