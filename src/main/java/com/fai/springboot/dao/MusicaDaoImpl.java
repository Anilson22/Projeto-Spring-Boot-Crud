package com.fai.springboot.dao;


import com.fai.springboot.model.Musica;
import com.fai.springboot.model.Piano;
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
        entity.setId(getNextID());
        Musicas.add(entity);
        return 0;
    }

    @Override
    public Musica listById(int id) {
        for (Musica musica: Musicas) {
            if (musica.getId() == id) {
                return musica;
            }
        }
        return null;
    }

    @Override
    public boolean update(Musica entity) {

        for (Musica musica: Musicas){
            if (musica.getId() == entity.getId()){
                musica.setNome(entity.getNome());
                musica.setGenero(entity.getGenero());
                musica.setAno(entity.getAno());
            }
        }

        return true;
    }

    @Override
    public boolean deleteById(int id) {
        int ItemIndex = -1;
        for (int i = 0; i < Musicas.size(); i++) {
            Musica musica = Musicas.get(i);
            if (musica.getId() == id) {
                ItemIndex = i;
                break;
            }
        }

        if (ItemIndex == -1) return false;
        Musicas.remove(ItemIndex);
        return true;
    }
}
