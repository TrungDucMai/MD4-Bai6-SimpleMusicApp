package com.codegym.service;

import com.codegym.model.Music;
import com.codegym.respository.IMusicRespo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MusicService  implements IMusicService{
@Autowired
    private IMusicRespo musicRespo;
@Override
    public List<Music> findAll() {
        return musicRespo.findAll();
    }

    @Override
    public void save(Music music) {
        musicRespo.save(music);
    }

    @Override
    public void remove(Long id) {
        musicRespo.remove(id);
    }

    @Override
    public Music findById(Long id) {
        return musicRespo.findById(id);
    }
}
