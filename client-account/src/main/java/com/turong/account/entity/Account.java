package com.turong.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "accounts")
public class Account {

    @Id
    private Long id;
    private String fullname;
    private String email;
    private Date dob;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate modifiedAt;

}
