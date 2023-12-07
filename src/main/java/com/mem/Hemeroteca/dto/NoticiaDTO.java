package com.mem.Hemeroteca.dto;

import com.mem.Hemeroteca.model.Noticia;

public class NoticiaDTO {
    private Noticia noticia;
    private String imagenUrl;

    public NoticiaDTO(Noticia noticia, String imagenUrl) {
        this.noticia = noticia;
        this.imagenUrl = imagenUrl;
    }

    public Noticia getNoticia() {
        return noticia;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}

