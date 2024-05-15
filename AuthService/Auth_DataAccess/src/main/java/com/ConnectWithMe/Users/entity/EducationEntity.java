package com.ConnectWithMe.Users.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Education")
@Entity
public class EducationEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CollegeInfoID" , referencedColumnName = "id")
    private CollegesInfoEntity collegesInfo;

    @ManyToOne
    @JoinColumn(name = "userID" , referencedColumnName = "id")
    private UsersEntity user;

    private String StartDate;
    private String EndDate;
    private String Degreetitlee;
    private String DegreeName;
}
