package fr.rockbell.gestion.groupe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.rockbell.gestion.groupe.dto.ConcertDTO;
import fr.rockbell.gestion.groupe.mapper.MapperDTO;
import fr.rockbell.gestion.groupe.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConcertServiceImp implements ConcertService {
	
	private final ConcertRepository concertRepository;
	private final MapperDTO groupeMapper;

	@Override
	public List<ConcertDTO> recupererTousLesConcerts() {
		return groupeMapper.fromConcertToConcertDTO(concertRepository.findAll());
	}

	@Override
	public List<ConcertDTO> recupererTousLesConcertsDunGroupe(long idGroupe) {
		return groupeMapper.fromConcertToConcertDTO(concertRepository.findByIdGroupe(idGroupe));
	}

	@Override
	public ConcertDTO recupererUnConcertViaSonId(long idConcert) {
		return groupeMapper.fromConcertToConcertDTO(concertRepository.findById(idConcert).orElseThrow());
	}

}
