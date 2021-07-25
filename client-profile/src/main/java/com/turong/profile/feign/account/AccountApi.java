package com.turong.profile.feign.account;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "client-account", url = "http://host.docker.internal:8580/client-account")
// if we do not use ribbon for load balancer, then we use url instead of name.
// otherwise, we use instanceId as name of the service
public interface AccountApi {

    @GetMapping("/accounts/email")
    ResponseEntity<AccountResponse> getAccountByEmail(@RequestParam final String email);

}
