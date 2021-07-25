package com.turong.mail.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailLogResponse {

    private String id;
    private String from;
    private String to;
    private String body;

    private LocalDate createdAt;

    private LocalDate modifiedAt;

}
