package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class createSkill {
    @JsonProperty("skillName")
    private String skillName;
}