package com.turong.mail.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(value = "mail_logs")
public class MailLog {

    @Id
    private String id;
    private String from;
    private String to;
    private String body;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate modifiedAt;

}
