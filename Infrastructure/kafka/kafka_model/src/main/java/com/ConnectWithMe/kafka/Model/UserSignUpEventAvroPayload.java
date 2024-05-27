package com.ConnectWithMe.kafka.Model;

import lombok.*;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.specific.SpecificRecordBase;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpEventAvroPayload extends SpecificRecordBase {
    private Integer userID;
    private List<Integer> skillIDs;
    //    private Map<Integer, List<Integer>> projectSkillMapping;
    private List<Integer> collegeInfoID;
//    private AdddressPayload address;

    private static final SpecificData MODEL$ = new SpecificData();

    @Override
    public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
    public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"UserSignUpEventPayload\",\"namespace\":\"com.ConnectWithMe.kafka.Model\",\"fields\":[{\"name\":\"userID\",\"type\":\"int\"},{\"name\":\"skillIDs\",\"type\":{\"type\":\"array\",\"items\":\"int\"}},{\"name\":\"collegeInfoID\",\"type\":{\"type\":\"array\",\"items\":\"int\"}}]}");


    @Override
    public org.apache.avro.Schema getSchema() { return SCHEMA$; }

    @Override
    public Object get(int field$) {
        switch (field$) {
            case 0: return userID;
            case 1: return skillIDs;
            case 2: return collegeInfoID;
            default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public void put(int field$, Object value$) {
        switch (field$) {
            case 0: userID = (Integer) value$; break;
            case 1: skillIDs = (List<Integer>) value$; break;
            case 2: collegeInfoID = (List<Integer>) value$; break;
            default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
        }
    }
}
