package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CollegesInfo")
@Entity
public class CollegesInfoEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String CollegeName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryID" , referencedColumnName = "id")
    private CountryEntity country;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "StateID" , referencedColumnName = "id")
    private StateEntity state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CityID" , referencedColumnName = "id")
    private CityEntity city;
}
