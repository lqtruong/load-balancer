package com.turong.mail.mapstruct;

import com.turong.mail.controller.MailLogResponse;
import com.turong.mail.entity.MailLog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailingMapper {

    MailLogResponse toResponse(final MailLog mailLog);

}
