package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Address")
@Entity
public class AddressEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId" , referencedColumnName = "id")
    private UsersEntity user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryID" , referencedColumnName = "id")
    private CountryEntity country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name =  "StateID", referencedColumnName = "id")
    private StateEntity state;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CityID" , referencedColumnName = "id")
    private CityEntity city;
}
