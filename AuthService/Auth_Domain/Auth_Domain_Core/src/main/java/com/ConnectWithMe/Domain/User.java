package com.ConnectWithMe.Domain;

import lombok.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String ProfilePicture; //
    private String password; //
    private String Name; //

    private String email; //

    private Date createdAt;
    private Date updatedAt;
    private boolean active;
    private boolean status;
    private String bio;
    private String headline; //
    private Integer visits;
}
