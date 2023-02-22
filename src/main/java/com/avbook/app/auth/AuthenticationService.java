package com.avbook.app.auth;


import com.avbook.app.config.JwtService;
import com.avbook.app.entity.Company;
import com.avbook.app.exception.CompanyException;
import com.avbook.app.exception.ErrorMessage;
import com.avbook.app.service.CompanyService;
import com.avbook.app.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CompanyService companyService;


    public AuthenticationResponse register(RegisterRequest request) {
        Company company = null;
        if (request.getCompanyId() != null) {
        company = companyService.getCompanyById(request.getCompanyId());
        }
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .company(company)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .companyId(user.getCompany().getId())
                .role(user.getRole())
                .email(user.getEmail())
                .user(new UserDto())
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        UserDto userDto = UserDtoMapper.map(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .companyId(user.getCompany().getId())
                .role(user.getRole())
                .email(user.getEmail())
                .user(userDto)
                .build();
    }

    public ValidateAuthenticationDto validate(String token) {
        String email = jwtService.extractUsername(token);
        User user = repository.findByEmail(email).orElseThrow(() -> new CompanyException(ErrorMessage.ENTITY_NOT_FOUND));
        UserDto userDto = UserDtoMapper.map(user);
        ValidateAuthenticationDto dto = new ValidateAuthenticationDto();
        dto.setAuthenticated(true);
        dto.setUser(userDto);
        return dto;
    }
}
