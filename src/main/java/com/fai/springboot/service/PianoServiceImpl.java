package com.fai.springboot.service;

import com.fai.springboot.dao.PianoDaoImpl;
import com.fai.springboot.model.Piano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PianoServiceImpl implements CrudService<Piano> {

    @Autowired
    PianoDaoImpl pianoDao;
    @Override
    public List<Piano> list() {
        return pianoDao.list();
    }

    @Override
    public int save(Piano entity) {
        return pianoDao.save(entity);
    }

    @Override
    public Piano listById(int id) {
        return pianoDao.listById(id);
    }

    @Override
    public boolean update(Piano entity) {
        return pianoDao.update(entity);
    }

    @Override
    public boolean deleteById(int id) {
        return pianoDao.deleteById(id);
    }
}