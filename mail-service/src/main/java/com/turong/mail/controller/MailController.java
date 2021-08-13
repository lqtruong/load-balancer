package com.turong.mail.controller;

import com.turong.mail.mapstruct.MailingMapper;
import com.turong.mail.service.MailingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("mails")
@Log4j2
public class MailController {

    @Autowired
    private MailingService mailingService;

    @Autowired
    private MailingMapper mailingMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MailLogResponse> mail(@RequestBody final MailRequest mailRequest) {
        if (!mailRequest.isValid()) {
            throw new IllegalArgumentException("Mail request is invalid.");
        }
        return ResponseEntity.ok(mailingMapper.toResponse(
                mailingService.insert(mailRequest.getFrom(), mailRequest.getTo(), mailRequest.getBody())));
    }

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello!");
    }

}
