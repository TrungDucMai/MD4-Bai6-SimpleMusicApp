package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String name;
    private String artist;
    private MultipartFile music;

    public MusicForm() {
    }

    public MusicForm(Long id, String name, String artist, MultipartFile music) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.music = music;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public MultipartFile getMusic() {
        return music;
    }

    public void setMusic(MultipartFile music) {
        this.music = music;
    }
}
