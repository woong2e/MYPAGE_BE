package kr.woong2e.homepage.profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private Long id;
    private String name;
    private String age;
    private String school;
    private String major;
    private String email;

    private String bio;
    private String company;
    private String location;
    private String website;
    private String githubUrl;
    private String velogUrl;
    private String instagramUrl;
    private String linkedinUrl;

    private String profileImageUrl;

    private String project1Name;
    private String project1Url;
    private String project2Name;
    private String project2Url;
    private String project3Name;
    private String project3Url;
    private String project4Name;
    private String project4Url;

    private String customReadme;
}