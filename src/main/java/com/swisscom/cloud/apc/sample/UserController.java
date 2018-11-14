package com.swisscom.cloud.apc.sample;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
    public Principal user(Principal principal) {
        //Principal holds the logged in user information.
        // Spring automatically populates this principal object after login.
        return principal;
    }

    @RequestMapping("/userInfo")
    public String userInfo(Principal principal){
        final OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        final Authentication authentication = oAuth2Authentication.getUserAuthentication();
        //Manually getting the details from the authentication, and returning them as String.
        return authentication.getDetails().toString();
    }
}
