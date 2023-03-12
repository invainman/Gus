package test.webApp.Gus.jwt;

import lombok.Data;

@Data
public class JwtAuthenticationRequest {
    private String username;
    private String password;
}