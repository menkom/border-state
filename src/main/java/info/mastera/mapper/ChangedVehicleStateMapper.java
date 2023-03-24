package info.mastera.mapper;

import info.mastera.bot.model.TransferChangeState;
import info.mastera.model.ChangedVehicleState;
import org.springframework.stereotype.Service;

@Service
public class ChangedVehicleStateMapper {

    public TransferChangeState convert(ChangedVehicleState state) {
        return new TransferChangeState(
                state.actual().getRegNum(),
                state.changeType(),
                state.saved() == null ? null : state.saved().getStatus(),
                state.actual().getStatus(),
                state.saved() == null ? null : state.saved().getOrderId(),
                state.actual().getOrderId()
        );
    }
}
