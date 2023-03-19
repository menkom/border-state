package info.mastera.repository;

import info.mastera.model.Checkpoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckpointRepository extends JpaRepository<Checkpoint, String> {

}
