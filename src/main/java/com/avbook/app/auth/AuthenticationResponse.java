package com.avbook.app.auth;


import com.avbook.app.user.Role;
import com.avbook.app.user.User;
import com.avbook.app.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private UUID companyId;
    private String email;
    private Role role;
    private String accessToken;
    private UserDto user;
}
