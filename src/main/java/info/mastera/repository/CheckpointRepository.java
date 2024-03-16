package info.mastera.repository;

import info.mastera.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CheckpointRepository extends JpaRepository<Checkpoint, String> {

    List<Checkpoint> findAllByActive(boolean active);
}
