package co.simplon.dao;

import co.simplon.entities.Tache;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TacheRepository extends JpaRepository<Tache,Long> {
}
