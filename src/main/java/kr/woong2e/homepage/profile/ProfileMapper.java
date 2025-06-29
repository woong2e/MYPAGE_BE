package kr.woong2e.homepage.profile;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProfileMapper {

    Profile selectProfile(Long id);
    int updateProfile(Profile profile);
}
