package com.ConnectWithMe.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FeedGenerationData")
@Entity
public class FeedGenerationDataEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer userID;
    private Integer projectIDs;
    private Integer skillIDs;
    private Integer locationID;
    private Integer educationIDs;
}
