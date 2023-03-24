package info.mastera.service;

import feign.RetryableException;
import info.mastera.declarant.client.BorderApi;
import info.mastera.model.Checkpoint;
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
    VehicleService vehicleService;

    @Scheduled(fixedDelayString = "${border-waiting-area.scheduler.data-collection.checkpoints-update}")
    public void retrieveCheckpointsData() {
        var actualCheckpoints = borderApi.getCheckpoints();
        checkpointService.update(actualCheckpoints);
        log.info("Checkpoints updated");
    }

    @Scheduled(fixedDelayString = "${border-waiting-area.scheduler.data-collection.states-update}")
    public void retrieveStatesData() {
        for (Checkpoint checkpoint : checkpointService.getAll()) {
            try {
                var state = borderApi.getStateNew(checkpoint.getId());
                vehicleService.processData(state);
            } catch (RetryableException exc) {
                log.error("Error on getting states. {}", exc.getMessage());
            }
        }
        log.info("States updated");
    }
}
