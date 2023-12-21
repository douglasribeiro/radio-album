package com.douglas.developer.album.service;

import java.util.List;

import com.douglas.developer.core.crud.CrudService;
import com.douglas.developer.core.model.Album;

public interface AlbumService extends CrudService<Album, Long> {
	
	List<Album> findByName(String name);
	
	void update(Long id, Album album);

}
