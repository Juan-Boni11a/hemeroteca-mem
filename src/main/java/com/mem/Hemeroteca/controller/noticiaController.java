package com.mem.Hemeroteca.controller;

import com.mem.Hemeroteca.dto.NoticiaDTO;
import com.mem.Hemeroteca.model.Noticia;
import com.mem.Hemeroteca.service.noticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/noticia")
@CrossOrigin
public class noticiaController {
    @Autowired
    private noticiaServicio noticiaServicio;

    @PostMapping("/agregar")
    public String agregar(@RequestParam("imagen") MultipartFile imagen,
                          @RequestParam("nombreUsuario") String nombreUsuario,
                          @RequestParam("fechaNoticia") String fechaNoticia,
            @               RequestParam("fechaRegistro") String fechaRegistro,
                          @RequestParam("seccion") String seccion,
                          @RequestParam("noPagina") int noPagina,
                          @RequestParam("sector") String sector,
                          @RequestParam("subsector") String subsector,
                          @RequestParam("informacion") String informacion,
                          @RequestParam("medio") String medio,
                          @RequestParam("fuente") String fuente,
                          @RequestParam("tendencia") String tendencia,
                          @RequestParam("resumen") String resumen,
                          @RequestParam("opinion") String opinion,
                          @RequestParam("comentario") String comentario) {
        try {
            byte[] imagenBytes = imagen.getBytes();

            Noticia noticia = new Noticia();
            noticia.setImagen(imagenBytes);
            noticia.setNombreUsuario(nombreUsuario);
            noticia.setFechaNoticia(fechaNoticia);
            noticia.setFechaRegistro(fechaRegistro);
            noticia.setSeccion(seccion);
            noticia.setNoPagina(noPagina);
            noticia.setSector(sector);
            noticia.setSubsector(subsector);
            noticia.setInformacion(informacion);
            noticia.setMedio(medio);
            noticia.setFuente(fuente);
            noticia.setTendencia(tendencia);
            noticia.setResumen(resumen);
            noticia.setOpinion(opinion);
            noticia.setComentario(comentario);

            noticiaServicio.guardarNoticia(noticia);

            return "Noticia agregada correctamente";
        } catch (IOException e) {
            return "Error al procesar la imagen: " + e.getMessage();
        }
    }

    @GetMapping("/obtenerNoticias")
    public List<Noticia> obtenerNoticias() {
        return noticiaServicio.obtenerNoticias();
    }

    @GetMapping("/obtenerNoticia/{id}")
    public ResponseEntity<NoticiaDTO> obtenerNoticiaPorId(@PathVariable String id) {
        Noticia noticia = noticiaServicio.obtenerNoticiaPorId(id);

        if (noticia != null) {
            // Crear un DTO que contenga la URL de la imagen y otros campos
            NoticiaDTO noticiaDTO = new NoticiaDTO(noticia, construirUrlImagen(noticia));
            return ResponseEntity.ok(noticiaDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String construirUrlImagen(Noticia noticia) {
        // Construir la URL completa para la imagen
        if (noticia.getImagen() != null) {
            // Convierte los bytes de la imagen a una URL base64
            return "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(noticia.getImagen());
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarNoticia(@PathVariable String id) {
        noticiaServicio.eliminarNoticiaPorId(id);
        return ResponseEntity.ok("Noticia eliminada correctamente");
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Noticia> actualizarNoticia(@PathVariable String id,
                                                     @RequestParam("imagen") MultipartFile imagen,
                                                     @RequestParam("nombreUsuario") String nombreUsuario,
                                                     @RequestParam("fechaNoticia") String fechaNoticia,
                                                     @RequestParam("fechaRegistro") String fechaRegistro,
                                                     @RequestParam("seccion") String seccion,
                                                     @RequestParam("noPagina") int noPagina,
                                                     @RequestParam("sector") String sector,
                                                     @RequestParam("subsector") String subsector,
                                                     @RequestParam("informacion") String informacion,
                                                     @RequestParam("medio") String medio,
                                                     @RequestParam("fuente") String fuente,
                                                     @RequestParam("tendencia") String tendencia,
                                                     @RequestParam("resumen") String resumen,
                                                     @RequestParam("opinion") String opinion,
                                                     @RequestParam("comentario") String comentario) {
        try {
            byte[] imagenBytes = imagen.getBytes();


            Noticia noticia = new Noticia();
            noticia.setImagen(imagenBytes);
            noticia.setNombreUsuario(nombreUsuario);
            noticia.setFechaNoticia(fechaNoticia);
            noticia.setFechaRegistro(fechaRegistro);
            noticia.setSeccion(seccion);
            noticia.setNoPagina(noPagina);
            noticia.setSector(sector);
            noticia.setSubsector(subsector);
            noticia.setInformacion(informacion);
            noticia.setMedio(medio);
            noticia.setFuente(fuente);
            noticia.setTendencia(tendencia);
            noticia.setResumen(resumen);
            noticia.setOpinion(opinion);
            noticia.setComentario(comentario);

            Noticia noticiaActualizada = noticiaServicio.actualizarNoticia(id, noticia);

            if (noticiaActualizada != null) {
                return ResponseEntity.ok(noticiaActualizada);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException e) {
            return ResponseEntity.notFound().build();
        }
    }




}

