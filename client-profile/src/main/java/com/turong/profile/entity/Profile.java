package com.turong.profile.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "profiles")
public class Profile {

    @Id
    private Long id;
    private String username;
    private String email;
    private String app;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate modifiedAt;

}
