	package br.edu.ufcg.covidlog.util;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;


import br.edu.ufcg.covidlog.exception.InvalidTokenException;
import br.edu.ufcg.covidlog.model.User;
import br.edu.ufcg.covidlog.service.UserService;

public class GoogleIdVerifier {

    static final String CLIENT_ID = "20548046020-ela8re78lc4aick7se96nih2om2krfmi.apps.googleusercontent.com";

    static final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
            .setAudience(Collections.singletonList(CLIENT_ID)).build();

    public static GoogleIdToken.Payload getPayload(String tokenString) {
        try {
            GoogleIdToken idToken = verifier.verify(tokenString);
            if(idToken != null) {
            	System.out.println(idToken.getPayload().getEmail());
                return idToken.getPayload();
            } else {
                throw new InvalidTokenException();
            }
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

    public static User getUsuario(String tokenString, UserService service) {
        try {
            GoogleIdToken idToken = verifier.verify(tokenString);
            if(idToken != null) {
                User user = service.getById(idToken.getPayload().getEmail());
                if(user != null) {
                    return user;
                } else {
                    throw new InvalidTokenException();
                }
            } else {
                throw new InvalidTokenException();
            }
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }
}
