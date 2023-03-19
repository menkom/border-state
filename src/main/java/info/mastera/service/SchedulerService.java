package info.mastera.service;

import info.mastera.declarant.client.BorderApi;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class SchedulerService {

    BorderApi borderApi;
    CheckpointService checkpointService;

    @Scheduled(fixedDelayString = "${border-waiting-area.scheduler.data-collection.checkpoints-update}")
    public void retrieveCheckpointsData() {
        var actualCheckpoints = borderApi.getCheckpoints();
        checkpointService.update(actualCheckpoints);
        log.info("Checkpoints updated");
    }
}
