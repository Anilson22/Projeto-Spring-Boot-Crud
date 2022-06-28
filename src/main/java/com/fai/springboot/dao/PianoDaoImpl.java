package com.fai.springboot.dao;

import com.fai.springboot.model.Piano;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PianoDaoImpl implements CrudDao<Piano> {

    private static List<Piano> PIANOS = new ArrayList<Piano>();
    private static int ID = 0;

    private int getNextId() {
        ID += 1;
        return ID;
    }

    public PianoDaoImpl() {

        Piano primeiroPiano = new Piano();
        primeiroPiano.setId(getNextId());
        primeiroPiano.setMarca("Steinway");
        primeiroPiano.setModelo("L");
        primeiroPiano.setAno("1986");

        PIANOS.add(primeiroPiano);

        // ----------
        Piano segundoPiano = new Piano();
        segundoPiano.setId(getNextId());
        segundoPiano.setMarca("Yamaha");
        segundoPiano.setModelo("CLP-765GP");
        segundoPiano.setAno("2021");

        PIANOS.add(segundoPiano);

        // ----------
        Piano terceiroPiano = new Piano();
        terceiroPiano.setId(getNextId());
        terceiroPiano.setMarca("Casio");
        terceiroPiano.setModelo("px-870");
        terceiroPiano.setAno("2022");

        PIANOS.add(terceiroPiano);

        // ----------
        Piano quartoPiano = new Piano();
        quartoPiano.setId(getNextId());
        quartoPiano.setMarca("Ronisch");
        quartoPiano.setModelo("Acústico Armário");
        quartoPiano.setAno("1912");

        PIANOS.add(quartoPiano);

        // ----------
        Piano quintoPiano = new Piano();
        quintoPiano.setId(getNextId());
        quintoPiano.setMarca("Collard & Collard");
        quintoPiano.setModelo("London Acústico Vertical");
        quintoPiano.setAno("1967");

        PIANOS.add(quintoPiano);
    }

    @Override
    public Piano listById(int id) {
        for (Piano piano : PIANOS) {
            if (piano.getId() == id) {
                return piano;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        int itemIndex = -1;
        for (int i = 0; i < PIANOS.size(); i++) {
            Piano piano = PIANOS.get(i);
            if (piano.getId() == id) {
                itemIndex = i;
                break;
            }
        }
        if (itemIndex == -1) return false;
        PIANOS.remove(itemIndex);
        return true;
    }

    @Override
    public List<Piano> list() {
        // Implemente este metodo - questao numero 4

        return PIANOS;
    }

    @Override
    public boolean update(Piano entity) {
        // Implemente este metodo - questao numero 9

        for (Piano piano: PIANOS){
            if (piano.getId() == entity.getId()){
                piano.setModelo(entity.getModelo());
                piano.setMarca(entity.getMarca());
                piano.setAno(entity.getAno());
            }
        }
        return true;
    }

    @Override
    public int save(Piano entity) {
        // Implemente este metodo - questao numero 13

        entity.setId(getNextId());
        PIANOS.add(entity);
        return 0;
    }
}