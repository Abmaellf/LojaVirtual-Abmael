package com.lojavirtualabmael.resouces;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtualabmael.security.JWTUtil;
import com.lojavirtualabmael.security.UserSS;
import com.lojavirtualabmael.service.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {
	
	@Autowired
	private JWTUtil jwtUtil;

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity refreshToken(HttpServletResponse response) {
		
		UserSS user = UserService.authenticated();
		
		String token = jwtUtil.generateToken(user.getUsername());
		
		response.addHeader("Authorization", "Bearer " + token);
		
		return ResponseEntity.noContent().build();
	}

}
