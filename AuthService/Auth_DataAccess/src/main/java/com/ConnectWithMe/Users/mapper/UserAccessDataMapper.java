package com.ConnectWithMe.Users.mapper;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Users.JpaRepository.*;
import com.ConnectWithMe.Users.entity.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAccessDataMapper {

    private final CountryJpaRepository countryjparepo;
    private final StateJpaRepository statejparepo;
    private final CityJpaRepository cityjparepo;

    public UserAccessDataMapper(CountryJpaRepository countryjparepo ,
                                StateJpaRepository statejparepo,
                                CityJpaRepository cityjparepo){
        this.countryjparepo = countryjparepo;
        this.statejparepo = statejparepo;
        this.cityjparepo = cityjparepo;
    }

    public static CountryEntity convertToCountryEntity(createCountry country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCountryName(country.getCountryName()); // Assuming CountryEntity has setCountryName method
        // Set other properties of CountryEntity if needed
        System.out.println(countryEntity);
        System.out.println(countryEntity.getCountryName());
        return countryEntity;
    }

    public  StateEntity convertToStateEntity(createState state) {
        StateEntity stateentity = new StateEntity();
        System.out.println("state "+state.getCountryID());
        Integer countryID = state.getCountryID();
        Optional<CountryEntity> countryOptional = countryjparepo.findById(countryID);
        System.out.println("countryOptional "+countryOptional.isEmpty());
        CountryEntity countryEntity = countryOptional.orElse(null); // or handle gracefully based on your requirements
        stateentity.setCountry(countryEntity);
        stateentity.setStateName(state.getStateName());
        // Set other properties of CountryEntity if needed
        System.out.println(stateentity);
        System.out.println(stateentity.getCountry());
        return stateentity;
    }


    public CityEntity convertToCityEntity(createCity city) {
        CityEntity cityEntity = new CityEntity();
        System.out.println("city "+city.getStateID());
        Integer stateID = city.getStateID();
        Optional<StateEntity> stateOptional = statejparepo.findById(stateID);
        System.out.println("stateOptional "+stateOptional.isEmpty());
        StateEntity stateentity = stateOptional.orElse(null); // or handle gracefully based on your requirements
        cityEntity.setState(stateentity);
        cityEntity.setCityName(city.getCityName());
        // Set other properties of CountryEntity if needed
        System.out.println(cityEntity);
        System.out.println(cityEntity.getState());
        return cityEntity;
    }

    public CollegesInfoEntity convertToCollegeInfoEntity(createCollegeInfo createcollegeinfo) {
        CollegesInfoEntity collegeinfoEntity = new CollegesInfoEntity();

        System.out.println("city "+createcollegeinfo.getCityID());
        Integer cityID = createcollegeinfo.getCityID();
        Optional<CityEntity> cityOptional = cityjparepo.findById(cityID);
        System.out.println("cityOptional "+cityOptional.isEmpty());
        CityEntity cityEntity = cityOptional.orElse(null); // or handle gracefully based on your requirements
        collegeinfoEntity.setCity(cityEntity);

        System.out.println("state "+createcollegeinfo.getStateID());
        Integer stateID = createcollegeinfo.getStateID();
        Optional<StateEntity> stateOptional = statejparepo.findById(stateID);
        System.out.println("stateOptional "+stateOptional.isEmpty());
        StateEntity stateEntity = stateOptional.orElse(null); // or handle gracefully based on your requirements
        collegeinfoEntity.setState(stateEntity);

        System.out.println("country "+createcollegeinfo.getCountryID());
        Integer countryID = createcollegeinfo.getCountryID();
        Optional<CountryEntity> countryOptional = countryjparepo.findById(countryID);
        System.out.println("countryOptional "+countryOptional.isEmpty());
        CountryEntity countryEntity = countryOptional.orElse(null); // or handle gracefully based on your requirements
        collegeinfoEntity.setCountry(countryEntity);

        collegeinfoEntity.setCollegeName(createcollegeinfo.getCollegeName());
        System.out.println(collegeinfoEntity);
        System.out.println(collegeinfoEntity.getState());
        return collegeinfoEntity;
    }

    public SkillsEntity convertToSkillEntity(createSkill createskill) {
        SkillsEntity skillsEntity = new SkillsEntity();
        System.out.println("createskill "+createskill.getSkillName());

        skillsEntity.setSkillName(createskill.getSkillName());
        System.out.println(skillsEntity.getSkillName());
        return skillsEntity;
    }
}
