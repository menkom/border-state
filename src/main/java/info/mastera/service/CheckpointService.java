package info.mastera.service;

import info.mastera.declarant.client.model.CheckpointsResponse;
import info.mastera.mapper.CheckpointMapper;
import info.mastera.repository.CheckpointRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CheckpointService {

    CheckpointRepository checkpointRepository;
    CheckpointMapper checkpointMapper;

    public void update(CheckpointsResponse response) {
        var actualCheckpoints = checkpointMapper.convert(response.getResult());
        var saved = checkpointRepository.findAll();
        actualCheckpoints.removeAll(saved);
        checkpointRepository.saveAll(actualCheckpoints);
    }
}
