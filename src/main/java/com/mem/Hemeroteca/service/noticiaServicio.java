package com.mem.Hemeroteca.service;

import com.mem.Hemeroteca.model.Noticia;

import java.util.List;

public interface noticiaServicio {
    public Noticia guardarNoticia(Noticia noticia);
    public List<Noticia> obtenerNoticias();

    Noticia obtenerNoticiaPorId(String id);
    void eliminarNoticiaPorId(String id);

    Noticia actualizarNoticia(String id, Noticia noticia);
}
