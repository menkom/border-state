package info.mastera.service;

import feign.RetryableException;
import info.mastera.bot.client.BorderStateBotClient;
import info.mastera.mapper.ChangedVehicleStateMapper;
import info.mastera.model.ChangedVehicleState;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final BorderStateBotClient borderStateBotClient;
    private final ChangedVehicleStateMapper changedVehicleStateMapper;

    public void notify(ChangedVehicleState changedVehicleState) {
        switch (changedVehicleState.changeType()) {
            case ORDER_ID -> log.debug(
                    "For registration number %s order changed from %s to %s. %s : %s".formatted(
                            changedVehicleState.actual().getRegNum(),
                            changedVehicleState.saved().getOrderId(),
                            changedVehicleState.actual().getOrderId(),
                            changedVehicleState.actual().getCheckpoint().getName(),
                            changedVehicleState.actual().getQueueType()
                    )
            );
            case STATUS -> log.debug(
                    "For registration number %s status changed from %s to %s. %s : %s".formatted(
                            changedVehicleState.actual().getRegNum(),
                            changedVehicleState.saved().getStatus(),
                            changedVehicleState.actual().getStatus(),
                            changedVehicleState.actual().getCheckpoint().getName(),
                            changedVehicleState.actual().getQueueType()
                    )
            );
        }
        try {
            borderStateBotClient.sendInfo(changedVehicleStateMapper.convert(changedVehicleState));
        } catch (RetryableException e) {
            log.error("Error sending states");
        }
    }
}
