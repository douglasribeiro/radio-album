package com.douglas.developer.album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.developer.album.service.AlbumService;
import com.douglas.developer.core.crud.CrudController;
import com.douglas.developer.core.crud.CrudService;
import com.douglas.developer.core.model.Album;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/album")
@Slf4j
@CrossOrigin
@AllArgsConstructor
public class AlbumController extends CrudController<Album, Long> {

    private final AlbumService albumService;

    @Override
    public CrudService<Album, Long> getService() {
        return albumService;
    }
    
    @GetMapping("status")
    public String status() {
    	log.info("Serviço album esta ok!");
    	return "Serviço album esta ok!";
    }
    
    @GetMapping("/name/{name}")
    public List<Album> findByName(@PathVariable String  name) {
    	log.info("Pesquisa por nome de Album.");
    	return albumService.findByName(name);
    }
    
    @PatchMapping("{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Album album){
    	albumService.update(id, album);
    	return ResponseEntity.noContent().build();
    }
}
