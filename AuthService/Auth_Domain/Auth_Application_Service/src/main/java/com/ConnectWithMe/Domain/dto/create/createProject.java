package com.ConnectWithMe.Domain.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class createProject {

    @JsonProperty("ProjectTitle")
    private String ProjectTitle;

    @JsonProperty("ProjectDescription")
    private String ProjectDescription;

    @JsonProperty("ProjectSkills")
    private List<Integer> ProjectSkills;

    @JsonProperty("ProjectLink")
    private String ProjectLink;
}
