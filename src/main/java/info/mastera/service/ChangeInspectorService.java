package info.mastera.service;

import info.mastera.model.ChangedVehicleState;
import info.mastera.model.StateChangeType;
import info.mastera.model.Vehicle;
import info.mastera.repository.VehicleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ChangeInspectorService {

    VehicleRepository vehicleRepository;

    public ChangedVehicleState inspect(Vehicle actual) {
        // Transport was never saved in the system or has saved info from previous journey
        var saved = vehicleRepository.findByRegNumAndRegistrationDate(actual.getRegNum(), actual.getRegistrationDate());
        if (saved == null) {
            return new ChangedVehicleState(actual, saved, StateChangeType.NEW);
        } else {
            StateChangeType changeType = StateChangeType.NONE;
            if (hasOrderChanged(actual, saved)) {
                changeType = StateChangeType.ORDER_ID;
            } else if (hasStatusChanged(actual, saved)) {
                changeType = StateChangeType.STATUS;
            }
            return new ChangedVehicleState(actual, saved, changeType);
        }
    }

    public Vehicle prepareVehicleToSave(ChangedVehicleState state) {
        return switch (state.changeType()) {
            case NEW -> state.actual();
            case STATUS, ORDER_ID -> state.saved()
                    .setStatus(state.actual().getStatus())
                    .setOrderId(state.actual().getOrderId())
                    .setChangedDate(state.actual().getChangedDate());
            default -> throw new IllegalArgumentException("Incorrect state " + state.changeType());
        };
    }

    private boolean hasOrderChanged(Vehicle actual, Vehicle saved) {
        return actual.getOrderId() != null && !Objects.equals(saved.getOrderId(), actual.getOrderId());
    }

    private boolean hasStatusChanged(Vehicle actual, Vehicle saved) {
        return !Objects.equals(saved.getStatus(), actual.getStatus());
    }
}
