package com.turong.mail.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailRequest {

    private String from;
    private String to;
    private String body;

    public boolean isValid() {
        return !StringUtils.isAnyBlank(from, to, body);
    }

}
