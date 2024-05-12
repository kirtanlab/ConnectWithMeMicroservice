package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createState {
    @JsonProperty("countryID")
    private Integer countryID;
    @JsonProperty("StateName")
    private String StateName;
}