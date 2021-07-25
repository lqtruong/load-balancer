package com.turong.mail.repository;

import com.turong.mail.entity.MailLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MailLogRepository extends MongoRepository<MailLog, Long> {

}
