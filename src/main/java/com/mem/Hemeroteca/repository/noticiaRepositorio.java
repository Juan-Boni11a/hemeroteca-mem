package com.mem.Hemeroteca.repository;

import com.mem.Hemeroteca.model.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface noticiaRepositorio extends JpaRepository<Noticia, String> {
}