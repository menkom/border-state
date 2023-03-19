package info.mastera.mapper;

import info.mastera.declarant.client.model.CheckpointsResponse;
import info.mastera.model.Checkpoint;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CheckpointMapper {

    @Mapping(target = "active", constant = "true")
    Checkpoint convert(CheckpointsResponse.Checkpoint response);

    List<Checkpoint> convert(List<CheckpointsResponse.Checkpoint> checkpointList);
}
