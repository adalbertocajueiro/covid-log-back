package br.edu.ufcg.covidlog.config;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;

import br.edu.ufcg.covidlog.service.UserService;
import br.edu.ufcg.covidlog.util.GoogleIdVerifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class TokenFilter extends GenericFilterBean {

    @Autowired
    UserService userService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        if(userService == null){
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            userService = webApplicationContext.getBean(UserService.class);
        }

        HttpServletRequest req = (HttpServletRequest) request;

        String header = req.getHeader("Authorization");

        if(header == null || !header.startsWith("Bearer ")) {
            ((HttpServletResponse) response).sendError(HttpStatus.BAD_REQUEST.value(), "Token inválido ou expirado!");
            return;
        }

        // Extraindo apenas o token do cabecalho.
        String token = header.substring(7);
        GoogleIdToken.Payload payload;

        try {
            payload = GoogleIdVerifier.getPayload(token);
            System.out.println(new Date(payload.getExpirationTimeSeconds()*1000));
            System.out.println(payload.getExpirationTimeSeconds());
            if (new Date().getTime() > payload.getExpirationTimeSeconds()*1000) {
                throw new Exception();
            }
        } catch (Exception e) {
            ((HttpServletResponse) response).sendError(HttpStatus.BAD_REQUEST.value(), "Token inválido ou expirado!");
            return;
        }
        
        String email = payload.getEmail();
        try {
            userService.getById(email);
        }catch(Exception e) {
            ((HttpServletResponse) response).sendError(HttpStatus.NOT_FOUND.value(), "Usuário ainda não registrado no sistema!");
            return;
        }
        request.setAttribute("usuario", userService.getById(email));

        chain.doFilter(request, response);
    }

}