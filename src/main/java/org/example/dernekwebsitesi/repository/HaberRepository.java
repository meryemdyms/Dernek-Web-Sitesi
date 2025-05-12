package org.example.dernekwebsitesi.repository;

import org.example.dernekwebsitesi.model.Haber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HaberRepository extends JpaRepository<Haber,Long> {
}
