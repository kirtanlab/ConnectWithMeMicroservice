package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createCity {
    @JsonProperty("stateID")
    private Integer stateID;
    @JsonProperty("CityName")
    private String CityName;
}