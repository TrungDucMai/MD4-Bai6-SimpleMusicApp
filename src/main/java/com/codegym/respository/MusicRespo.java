package com.codegym.respository;

import com.codegym.model.Music;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class MusicRespo implements IMusicRespo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        String query = "select  m from Music as m";
        List<Music> musicList = entityManager.createQuery(query, Music.class).getResultList();
        return musicList;
    }

    @Override
    public Music findById(Long id) {
        String query = "select m from Music as m where m.id =:id";
        Music music = entityManager.createQuery(query, Music.class).setParameter("id", id).getSingleResult();
        return music;
    }

    @Override
    public void save(Music music) {
        if (music != null) {
            entityManager.merge(music);
        } else {
            entityManager.persist(music);
        }
    }

    @Override
    public void remove(Long id) {
        Music music = findById(id);
        if (music != null) {
            entityManager.remove(music);
        }
    }
}
