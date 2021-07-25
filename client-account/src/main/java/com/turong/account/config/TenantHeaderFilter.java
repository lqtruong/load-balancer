package com.turong.account.config;

import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log4j2
public class TenantHeaderFilter extends OncePerRequestFilter {

    public static final String X_TENANT_ID = "x-tenant-id";

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {
        AppContextHolder.printAllContextProperties();
        final String tenant = httpServletRequest.getHeader(X_TENANT_ID);
        log.info("Request tenant = {}", tenant);
        /*if (StringUtils.isBlank(tenant)) {
            throw new IllegalArgumentException("Header " + X_TENANT_ID + " must be present!");
        }*/
        AppContextHolder.setTenant(tenant);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
