package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class NeighbourFavorites {

    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Adress */
    private String locationOn;

    /** Phone number */
    private String phoneNumber;

    /** www */
    private String www;

    /** Datas Aboutme */
    private String tAboutMe;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param locationOn
     * @param phoneNumber
     * @param www
     * @param tAboutMe
     *
     *
     */
    public NeighbourFavorites(Integer id, String name, String avatarUrl, String locationOn, String phoneNumber, String www, String tAboutMe) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.locationOn = locationOn;
        this.phoneNumber = phoneNumber;
        this.www = www;
        this.tAboutMe = tAboutMe;


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

    public String getlocationOn() {
        return locationOn;
    }

    public void setLocationOn(String tAboutMe) {
        this.locationOn = locationOn;
    }

    public String getphoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer id) {
        this.phoneNumber = phoneNumber;
    }

    public String getwww() {
        return www;
    }

    public void setwww(String tAboutMe) {
        this.www = www;
    }

    public String gettAboutMe() {
        return tAboutMe;
    }

    public void settAboutMe(String tAboutMe) {
        this.tAboutMe = tAboutMe;
    }











    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NeighbourFavorites neighbour = (NeighbourFavorites) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
