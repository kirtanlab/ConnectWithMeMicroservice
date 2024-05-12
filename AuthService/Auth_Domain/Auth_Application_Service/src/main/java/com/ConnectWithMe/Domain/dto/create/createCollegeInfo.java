package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createCollegeInfo {

    @JsonProperty("CollegeName")
    private String CollegeName;

    @JsonProperty("countryID")
    private Integer countryID;

    @JsonProperty("stateID")
    private Integer stateID;

    @JsonProperty("cityID")
    private Integer cityID;
}
