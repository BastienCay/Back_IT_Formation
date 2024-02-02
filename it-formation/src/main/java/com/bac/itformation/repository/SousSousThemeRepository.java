package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.SousSousTheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousSousThemeRepository extends JpaRepository<SousSousTheme, Long> {
}
