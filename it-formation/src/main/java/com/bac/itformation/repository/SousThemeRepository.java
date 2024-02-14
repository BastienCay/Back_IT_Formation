package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.SousTheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SousThemeRepository extends JpaRepository<SousTheme, Long> {
    @Query("SELECT sousTheme FROM SousTheme sousTheme " +
            "WHERE sousTheme.id = :id")
    SousTheme getSousThemeById (@Param("id") Long id);
}
