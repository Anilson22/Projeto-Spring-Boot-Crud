package com.fai.springboot.service;


import com.fai.springboot.dao.MusicaDaoImpl;
import com.fai.springboot.model.Musica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaServiceImpl implements CrudService<Musica> {

    @Autowired
    MusicaDaoImpl musicaDao;

    @Override
    public List<Musica> list() {
        return musicaDao.list();
    }

    @Override
    public int save(Musica entity) {

        return musicaDao.save(entity);
    }

    @Override
    public Musica listById(int id) {
        return musicaDao.listById(id);
    }

    @Override
    public boolean update(Musica entity) {
        return musicaDao.update(entity);
    }

    @Override
    public boolean deleteById(int id)
    {
        return musicaDao.deleteById(id);
    }
}
