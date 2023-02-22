package com.avbook.app.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto {
        private UUID id;
        private String role;
        private String name;
        private String username;
        private String email;
        private String avatar;
        private int age;
}
