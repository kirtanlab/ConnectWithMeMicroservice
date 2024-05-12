package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createCountry {
    @JsonProperty("CountryName")
    private String CountryName;
}
