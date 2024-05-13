package com.ConnectWithMe.Domain.dto.create;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createUser {

    @JsonProperty("ProfilePicture")
    private String ProfilePicture;

    @JsonProperty("password")
    private String password;

    @JsonProperty("Name")
    private String Name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("headline")
    private String headline;

//    @JsonProperty("country")
//    private Integer country; // id
//
//    @JsonProperty("state")
//    private Integer state; //id
//
//    @JsonProperty("city")
//    private Integer city; //id

    @JsonProperty("collegesInfo")
    private Integer collegesInfo;

    @JsonProperty("StartDate")
    private String StartDate;

    @JsonProperty("EndDate")
    private String EndDate;

    @JsonProperty("Degreetitlee")
    private String Degreetitlee;

    @JsonProperty("DegreeName")
    private String DegreeName;

    @JsonProperty("Skills")
    private List<Integer> Skills;
}
