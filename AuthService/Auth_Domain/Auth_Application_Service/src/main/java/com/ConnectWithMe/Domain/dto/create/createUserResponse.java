package com.ConnectWithMe.Domain.dto.create;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class createUserResponse {

    UserDetails user;
    private String token;
    private String message;
}
