package com.codegym.model;

import javax.persistence.*;


@Entity
@Table(name = "music")
public class Music {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String artist;
    private String songFile;



    public Music() {
    }

    public Music(String name, String artist, String songFile) {
        this.name = name;
        this.artist = artist;
        this.songFile = songFile;
    }

    public Music(Long id, String name, String artist, String songFile) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.songFile = songFile;
    }

    public Music(Long id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
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

    public String getSongFile() {
        return songFile;
    }

    public void setSongFile(String songFile) {
        this.songFile = songFile;
    }
}
