package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adress */
    private String LocationOn;

    /** Phone number */
    private String PhoneNumber;

    /** www */
    private String Www;

    /** Datas Aboutme */
    private String tDatasAboutMe;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param LocationOn
     * @param PhoneNumber
     * @param Www
     * @param tDatasAboutMe
     *
     *
     */
    public Neighbour(Integer id, String name, String avatarUrl, String LocationOn, String PhoneNumber, String Www, String tDatasAboutMe) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.LocationOn = LocationOn;
        this.PhoneNumber = PhoneNumber;
        this.Www = Www;
        this.tDatasAboutMe = tDatasAboutMe;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getLocationOn() {
        return LocationOn;
    }

    public void setLocationOn(String LocationOn) {
        this.LocationOn = LocationOn;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getWww() {
        return Www;
    }

    public void setWww(String Www) {
        this.Www = Www;
    }

    public String gettDatasAboutMe() {
        return tDatasAboutMe;
    }

    public void settDatasAboutMe(String tDatasAboutMe) {
        this.tDatasAboutMe = tDatasAboutMe;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}