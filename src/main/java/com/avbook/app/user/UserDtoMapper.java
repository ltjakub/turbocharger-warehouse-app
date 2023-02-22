package com.avbook.app.user;

public class UserDtoMapper {
    public static UserDto map(User user) {
        UserDto dto = new UserDto();
        dto.setName(user.getFirstname());
        dto.setId(user.getId());
        dto.setAge(20);
        dto.setRole("user");
        dto.setAvatar("/assets/images/face-6.jpg");
        dto.setEmail(user.getEmail());
        dto.setUsername(user.getEmail());
        return dto;
    }
}
