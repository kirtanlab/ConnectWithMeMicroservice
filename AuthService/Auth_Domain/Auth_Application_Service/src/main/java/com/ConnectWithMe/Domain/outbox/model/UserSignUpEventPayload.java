package com.ConnectWithMe.Domain.outbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpEventPayload {
    private Integer userID;
    private List<Integer> skillIDs;
//    private Map<Integer, List<Integer>> projectSkillMapping;
    private Integer collegeInfoID;
//    private AdddressPayload address;
}
