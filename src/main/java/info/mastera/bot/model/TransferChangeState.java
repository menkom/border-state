package info.mastera.bot.model;

import info.mastera.model.StateChangeType;
import info.mastera.model.Status;

public record TransferChangeState(
        String regNum,
        StateChangeType changeType,
        Status previousStatus,
        Status actualStatus,
        Integer previousOrderId,
        Integer actualOrderId
) {
}
