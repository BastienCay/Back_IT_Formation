package com.bac.itformation.service.serviceImpl;

import com.bac.itformation.dto.FormateurDTO;
import com.bac.itformation.exception.NotFoundException;
import com.bac.itformation.model.Formateur;
import com.bac.itformation.repository.FormateurRepository;
import com.bac.itformation.service.FormateurService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FormateurServiceImpl implements FormateurService {

    private final FormateurRepository formateurRepository;
    private final JdbcTemplate jdbcTemplate;

    public FormateurServiceImpl(FormateurRepository formateurRepository, JdbcTemplate jdbcTemplate) {
        this.formateurRepository = formateurRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Formateur> findAll() {
        return formateurRepository.findAll();
    }

    @Override
    public List<FormateurDTO> getAllFormateurs() {
        List<Formateur> listFormateurs = formateurRepository.findAll();

        List<FormateurDTO> listFormateurDTO = new ArrayList<>();

        if (!listFormateurs.isEmpty()){
            for (Formateur formateur : listFormateurs){

                FormateurDTO formateurDto = new FormateurDTO();

                formateurDto.setId(formateur.getId());
                formateurDto.setIdUtilisateur(formateur.getUtilisateur().getId());
                formateurDto.setNom(formateur.getUtilisateur().getNom());
                formateurDto.setPrenom(formateur.getUtilisateur().getPrenom());

                listFormateurDTO.add(formateurDto);
            }
        }

        return listFormateurDTO;
    }


    public Formateur findById(Long id) {
        return formateurRepository.findById(id).orElseThrow( () -> new NotFoundException("Formateur inconnue !"));
    }

    public Formateur save(Formateur formateur) {
        return formateurRepository.save(formateur);
    }


    public Formateur update(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    public void deleteById(Long id) {
        formateurRepository.deleteById(id);
    }

    public void deleteAll() {
        formateurRepository.deleteAll();
    }
}
