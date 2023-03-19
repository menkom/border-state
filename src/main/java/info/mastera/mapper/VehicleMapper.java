package info.mastera.mapper;

import info.mastera.declarant.client.model.StateResponse;
import info.mastera.model.Status;
import info.mastera.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface VehicleMapper {

    default Status convert(int code) {
        return Status.parse(code);
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "checkpoint", ignore = true)
    @Mapping(target = "queueType", ignore = true)
    @Mapping(target = "status", source = "status")
    Vehicle convert(StateResponse.Transport transport);

    List<Vehicle> convert(List<StateResponse.Transport> transportList);
}
