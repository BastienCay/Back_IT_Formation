package com.bac.itformation.repository;

import com.bac.itformation.model.Adresse;
import com.bac.itformation.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
