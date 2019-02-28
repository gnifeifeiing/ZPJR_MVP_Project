package com.zpjr.cunguan.entity.module;

import java.util.List;

/**
 * Description:      描述
 * Autour：          LF
 * Date：            2017/7/7 14:32
 */

public class MovieModule {

    public String id;
    public String title;
    public String share_url;
    public String casts;
    public List<String> getGenres() {
        return genres;
    }

    public String getCasts() {
        return casts;
    }

    public void setCasts(String casts) {
        this.casts = casts;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }



}
