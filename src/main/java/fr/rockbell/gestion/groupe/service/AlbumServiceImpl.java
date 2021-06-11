package fr.rockbell.gestion.groupe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.rockbell.gestion.groupe.dto.AlbumDTO;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
	
	private final AlbumRepository albumRepository;
	private final MapperDTO groupeMapper;

	@Override
	public List<AlbumDTO> recupererTousLesAlbums() {
		return groupeMapper.fromAlbumToAlbumDTO(albumRepository.findAll());
	}

	@Override
	public List<AlbumDTO> recupererTousLesAlbumsDunGroupe(long idGroupe) {
		return groupeMapper.fromAlbumToAlbumDTO(albumRepository.findByIdGroupe(idGroupe));
	}

	@Override
	public AlbumDTO recupererUnAlbumViaSonId(long idAlbum) {
		return groupeMapper.fromAlbumToAlbumDTO(albumRepository.findById(idAlbum).orElseThrow());
	}

}
