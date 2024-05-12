package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Otp")
@Entity
public class OTPEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID" , referencedColumnName = "id")
    private UsersEntity userID;

    private String otp;
}
