package com.avbook.app.auth;

import com.avbook.app.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateAuthenticationDto {
    private boolean isAuthenticated;
    private UserDto user;
}
