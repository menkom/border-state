package info.mastera.model;

public record ChangedVehicleState(
        Vehicle actual,
        Vehicle saved,
        StateChangeType changeType
) {
}
