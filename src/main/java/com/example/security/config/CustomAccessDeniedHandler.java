package com.example.security.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException{
        String requestURI = request.getRequestURI();
        String errorMessage;
        if (requestURI.equals("/api/")) {
            errorMessage = "Only Admin and Manager can save data.";
//        } else if (requestURI.equals("/users/manager")) {
//            errorMessage = "Only Admin can access /manager.";
//        } else if (requestURI.equals("/users/Normaldata")) {
//            errorMessage = "Only Manager and Admin can access";
//        } else if (requestURI.equals("/users/update/**")) {
//            errorMessage = "Only Manager and Admin Can Update Data";
        }else{
            errorMessage = "Only Manager and Admin Can Update Data";
        }
        ResponseEntity<Object> responseBody = ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorMessage);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.getWriter().write(responseBody.getBody().toString());
    }

}
