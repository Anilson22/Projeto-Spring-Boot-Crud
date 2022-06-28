package com.fai.springboot.dao;


import com.fai.springboot.model.Musica;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicaDaoImpl implements CrudDao<Musica> {

    private static List<Musica> Musicas = new ArrayList<Musica>();
    private static int ID = 0;

    private int getNextID() {
        ID += 1;
        return ID;
    }

    public MusicaDaoImpl() {
        Musica primeiraMusia = new Musica();
        primeiraMusia.setId(getNextID());
        primeiraMusia.setNome("Loyal");
        primeiraMusia.setGenero("Hip Hop");
        primeiraMusia.setAno("2015");

        //Inserindo as musicas criadas na lista chamada MUSICAS
        Musicas.add(primeiraMusia);

        Musica segundaMusica = new Musica();
        segundaMusica.setId(getNextID());
        segundaMusica.setNome("Santinha");
        segundaMusica.setGenero("Axe");
        segundaMusica.setAno("2018");

        Musicas.add(segundaMusica);

        Musica terceiraMusica = new Musica();
        terceiraMusica.setId(getNextID());
        terceiraMusica.setNome("Falling in Love");
        terceiraMusica.setGenero("Rock Classico");
        terceiraMusica.setAno("1961");

        Musicas.add(terceiraMusica);

        Musica quartaMusica = new Musica();
        quartaMusica.setId(getNextID());
        quartaMusica.setNome("Malvada");
        quartaMusica.setGenero("Funk");
        quartaMusica.setAno("2021");

        Musicas.add(quartaMusica);
    }


    @Override
    public List<Musica> list() {
        return Musicas;
    }

    @Override
    public int save(Musica entity) {
        return 0;
    }

    @Override
    public Musica listById(int id) {
        return null;
    }

    @Override
    public boolean update(Musica entity) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
