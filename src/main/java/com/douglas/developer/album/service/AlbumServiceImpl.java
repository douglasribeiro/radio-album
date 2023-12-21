package com.douglas.developer.album.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.douglas.developer.core.crud.CrudServiceImpl;
import com.douglas.developer.core.model.Album;
import com.douglas.developer.core.repository.AlbumRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class AlbumServiceImpl extends CrudServiceImpl<Album, Long> implements AlbumService {

    private final AlbumRepository albumRepository;

    @Override
    protected JpaRepository<Album, Long> getRepository() {
        return albumRepository;
    }

    @Transactional(readOnly = true)
	@Override
	public List<Album> findByName(String name) {
		return albumRepository.findByNome(name);
	}
    
	@Transactional(readOnly = false)
	@Override
	public void update(Long id, Album album) {
		log.info("alteração em service.");
		Album obj = findById(id);
		obj.setGravadora(album.getGravadora());
		obj.setInterprete(album.getInterprete());
		obj.setLancamento(album.getLancamento());
		obj.setNome(album.getNome());
		obj.setSobre(album.getSobre());
		albumRepository.save(obj);
	}
	
	
}
