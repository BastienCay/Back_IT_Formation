package com.bac.itformation.service.serviceImpl;

import com.bac.itformation.dto.AdresseDTO;
import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Adresse;
import com.bac.itformation.repository.AdresseRepository;
import com.bac.itformation.service.AdresseService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;
    private final JdbcTemplate jdbcTemplate;

    public AdresseServiceImpl(AdresseRepository adresseRepository, JdbcTemplate jdbcTemplate) {
        this.adresseRepository = adresseRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Adresse> findAll() {
        return adresseRepository.findAll();
    }

    @Override
    public Adresse findById(Long id) {
        return adresseRepository.findById(id).orElseThrow( () -> new NotFoundException("Adresse inconnue !"));
    }

    @Override
    public void addAdresse(AdresseDTO adresseDto) {
        Adresse adresse = new Adresse();

        try {
            adresse.setCodePostal(adresseDto.getCodePostal());
            adresse.setVille(adresseDto.getVille());
            adresse.setRue(adresseDto.getRue());
            adresse.setPays(adresseDto.getPays());

            adresseRepository.save(adresse);
        }catch (Exception e){

        }
    }

    @Override
    public Adresse save(Adresse adresse) {
        System.out.println(adresse);
        return adresseRepository.save(adresse);
    }

    @Override
    public Adresse update(Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @Override
    public void deleteById(Long id) {
        adresseRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        adresseRepository.deleteAll();
    }
}
