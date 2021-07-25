package com.turong.account.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class AccountSaveRequest implements WebRequest {


    @Override
    public String getRequestId() {
        return UUID.randomUUID().toString();
    }

    private Long id;
    private String fullname;
    private String email;
    private Date dob;

    @JsonIgnore
    public boolean hasFullname() {
        return !StringUtils.isBlank(fullname);
    }

    @JsonIgnore
    public boolean hasEmail() {
        return !StringUtils.isBlank(email);
    }

    @JsonIgnore
    public boolean hasDob() {
        return !Objects.isNull(dob);
    }

    @JsonIgnore
    public boolean valid() {
        return hasFullname() && hasDob() && hasEmail();
    }

}
