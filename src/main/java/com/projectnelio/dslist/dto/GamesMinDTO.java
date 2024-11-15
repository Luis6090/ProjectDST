package com.projectnelio.dslist.dto;

import com.projectnelio.dslist.entities.Game;
import jakarta.persistence.Column;

public class GamesMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GamesMinDTO() {
    }

    public GamesMinDTO(Game entities){
        id = entities.getId();
        title = entities.getTitle();
        year = entities.getYear();
        imgUrl = entities.getImgUrl();
        shortDescription = entities.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
