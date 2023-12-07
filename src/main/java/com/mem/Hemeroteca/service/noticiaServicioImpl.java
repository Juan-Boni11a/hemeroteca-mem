package com.mem.Hemeroteca.service;


import com.mem.Hemeroteca.model.Noticia;
import com.mem.Hemeroteca.repository.noticiaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class noticiaServicioImpl implements noticiaServicio {
    @Autowired
    noticiaRepositorio noticiaRepositorio;

    @Override
    public List<Noticia> obtenerNoticias() {
        return noticiaRepositorio.findAll();
    }


    @Override
    public Noticia guardarNoticia(Noticia noticia){return noticiaRepositorio.save(noticia);}



    @Override
    public Noticia obtenerNoticiaPorId(String id) {
        return noticiaRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminarNoticiaPorId(String id) {
        noticiaRepositorio.deleteById(id);
    }

    @Override
    public Noticia actualizarNoticia(String id, Noticia noticia) {
        Noticia noticiaExistente = noticiaRepositorio.findById(id).orElse(null);

        if (noticiaExistente != null) {
            // Actualiza los campos de la noticia existente con los valores de la noticia proporcionada

            noticiaExistente.setImagen(noticia.getImagen());

            noticiaExistente.setFechaRegistro(noticia.getFechaRegistro());
            noticiaExistente.setNombreUsuario(noticia.getNombreUsuario());
            noticiaExistente.setFechaNoticia(noticia.getFechaNoticia());
            noticiaExistente.setSeccion(noticia.getSeccion());
            noticiaExistente.setNoPagina(noticia.getNoPagina());
            noticiaExistente.setSector(noticia.getSector());
            noticiaExistente.setSubsector(noticia.getSubsector());
            noticiaExistente.setInformacion(noticia.getInformacion());
            noticiaExistente.setMedio(noticia.getMedio());
            noticiaExistente.setFuente(noticia.getFuente());
            noticiaExistente.setTendencia(noticia.getTendencia());
            noticiaExistente.setResumen(noticia.getResumen());
            noticiaExistente.setOpinion(noticia.getOpinion());
            noticiaExistente.setComentario(noticia.getComentario());
            // Añadir más campos según sea necesario...

            // Guarda la noticia actualizada
            return noticiaRepositorio.save(noticiaExistente);
        } else {
            return null; // O puedes lanzar una excepción indicando que la noticia no existe
        }
    }

}

