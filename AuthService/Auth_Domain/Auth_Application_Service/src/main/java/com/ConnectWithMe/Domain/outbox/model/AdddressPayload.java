package com.ConnectWithMe.Domain.outbox.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdddressPayload {
    private Integer cityID;
    private Integer stateID;
    private Integer countryID;
}
