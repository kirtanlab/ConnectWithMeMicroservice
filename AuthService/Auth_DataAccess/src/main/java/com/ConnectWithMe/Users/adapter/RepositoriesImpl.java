package com.ConnectWithMe.Users.adapter;

import com.ConnectWithMe.Domain.dto.create.*;
import com.ConnectWithMe.Domain.ports.output.Repository.UserRepository;
import com.ConnectWithMe.Users.JpaRepository.*;
import com.ConnectWithMe.Users.entity.*;
import com.ConnectWithMe.Users.mapper.UserAccessDataMapper;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.ConnectWithMe.Users.mapper.UserAccessDataMapper.convertToCountryEntity;

@Component
public class RepositoriesImpl implements UserRepository {

    private final CountryJpaRepository countryjparepo;
    private final StateJpaRepository statejparepo;
    private final CityJpaRepository cityjparepo;
    private final UserAccessDataMapper usermapper;
    private final CollegeInfoJpaRepository collegeinfojparepo;
    private final SkillJpaRepository skilljparepo;
    private final AuthJpaRepository authjparepo;

    public RepositoriesImpl(CountryJpaRepository countryjparepo ,
                            StateJpaRepository statejparepo ,
                            UserAccessDataMapper usermapper,
                            CityJpaRepository cityjparepo,
                            CollegeInfoJpaRepository collegeinfojparepo,
                            SkillJpaRepository skilljparepo,
                            AuthJpaRepository authjparepo){
        this.countryjparepo = countryjparepo;
        this.statejparepo = statejparepo;
        this.usermapper = usermapper;
        this.cityjparepo = cityjparepo;
        this.collegeinfojparepo = collegeinfojparepo;
        this.skilljparepo = skilljparepo;
        this.authjparepo = authjparepo;
    }

    public void saveCountry(createCountry country){
        CountryEntity countryEntity = convertToCountryEntity(country);
        System.out.println(countryEntity);
        countryjparepo.save(countryEntity);
    }

    public void saveState(createState state){
        System.out.println("in repo impl "+state.getStateName());
        System.out.println("in repo impl "+state.getCountryID());
        StateEntity stateEntity = usermapper.convertToStateEntity(state);
        System.out.println("stateEntity "+stateEntity);
        statejparepo.save(stateEntity);
    }

    public void saveCity(createCity city){
        System.out.println("in repo impl "+city.getCityName());
        System.out.println("in repo impl "+city.getCityName());
        CityEntity cityEntity = usermapper.convertToCityEntity(city);
        System.out.println("cityEntity "+cityEntity);
        cityjparepo.save(cityEntity);
    }

    public void saveCollegeInfo(createCollegeInfo createcollegeinfo){
        System.out.println("in repo impl "+createcollegeinfo.getCollegeName());
        System.out.println("in repo impl "+createcollegeinfo.getCountryID());
        CollegesInfoEntity collegeInfoEntity = usermapper.convertToCollegeInfoEntity(createcollegeinfo);
        System.out.println("collegeInfoEntity "+collegeInfoEntity);
        collegeinfojparepo.save(collegeInfoEntity);
    }

    public void saveSkill(createSkill createskill){
        System.out.println("in repo impl "+createskill.getSkillName());
        SkillsEntity skillEntity = usermapper.convertToSkillEntity(createskill);
        System.out.println("skillEntity "+skillEntity);
        skilljparepo.save(skillEntity);
    }

    public Integer saveUser(createUser createuser){
        System.out.println("createuser "+createuser.getHeadline());
        UsersEntity userEntity = UsersEntity.builder()
                .ProfilePicture(createuser.getProfilePicture())
                .password(createuser.getPassword())
                .Name(createuser.getName())
                .email(createuser.getEmail())
                .headline(createuser.getHeadline())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        authjparepo.save(userEntity);
        System.out.println("id "+userEntity.getId());
        return userEntity.getId();
    }
}