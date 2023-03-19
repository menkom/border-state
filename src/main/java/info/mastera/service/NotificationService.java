package info.mastera.service;

import info.mastera.model.ChangedVehicleState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public void notify(ChangedVehicleState changedVehicleState) {
        switch (changedVehicleState.changeType()) {
            case ORDER_ID -> log.info(
                    "For registration number %s order changed from %s to %s. %s : %s".formatted(
                            changedVehicleState.actual().getRegNum(),
                            changedVehicleState.saved().getOrderId(),
                            changedVehicleState.actual().getOrderId(),
                            changedVehicleState.actual().getCheckpoint().getName(),
                            changedVehicleState.actual().getQueueType()
                    )
            );
            case STATUS -> log.info(
                    "For registration number %s status changed from %s to %s. %s : %s".formatted(
                            changedVehicleState.actual().getRegNum(),
                            changedVehicleState.saved().getStatus(),
                            changedVehicleState.actual().getStatus(),
                            changedVehicleState.actual().getCheckpoint().getName(),
                            changedVehicleState.actual().getQueueType()
                    )
            );
        }
    }
}
