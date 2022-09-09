package com.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class App {

	static String key = "mukesh";

	public static void main(String[] args) {
		String token = Jwts.builder().setId("101").setAudience("Developer").setIssuer("Testing Engineer")
				.setSubject("Application not working").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(key.getBytes())).compact();

		System.out.println(token);
		
		//--------reading token/parsing token-----
		
		Claims c=Jwts.parser()
		.setSigningKey(Base64.getEncoder().encode(key.getBytes()))
.parseClaimsJws(token)
.getBody();
		
		System.out.println(c.getId());
		System.out.println(c.getAudience());
		System.out.println(c.getIssuer());
		System.out.println(c.getSubject());
		System.out.println(c.getIssuedAt());
		System.out.println(c.getExpiration());
	}
}
