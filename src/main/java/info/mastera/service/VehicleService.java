package info.mastera.service;

import info.mastera.declarant.client.model.StateResponse;
import info.mastera.mapper.VehicleMapper;
import info.mastera.model.Checkpoint;
import info.mastera.model.QueueType;
import info.mastera.model.Vehicle;
import info.mastera.repository.CheckpointRepository;
import info.mastera.repository.VehicleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class VehicleService {

    VehicleMapper vehicleMapper;
    CheckpointRepository checkpointRepository;
    VehicleRepository vehicleRepository;

    public void update(StateResponse response) {
        var checkpoint = checkpointRepository.findById(response.getInfo().getName())
                .orElseThrow();
        vehicleRepository.saveAll(collectVehiclesData(response, checkpoint));
    }

    private Stream<Vehicle> prepareVehicles(List<Vehicle> vehicles, QueueType queueType, Checkpoint checkpoint) {
        return vehicles.stream()
                .map(vehicle -> vehicle.setQueueType(queueType)
                        .setCheckpoint(checkpoint));
    }

    private List<Vehicle> collectVehiclesData(StateResponse response, Checkpoint checkpoint) {
        return Stream.of(
                        prepareVehicles(vehicleMapper.convert(response.getTruckLiveQueue()), QueueType.TRUCK_LIVE_QUEUE, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getTruckPriority()), QueueType.TRUCK_PRIORITY, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getTruckGpk()), QueueType.TRUCK_GPK, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getBusLiveQueue()), QueueType.BUS_LIVE_QUEUE, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getBusPriority()), QueueType.BUS_PRIORITY, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getCarLiveQueue()), QueueType.CAR_LIVE_QUEUE, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getCarPriority()), QueueType.CAR_PRIORITY, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getMotorcycleLiveQueue()), QueueType.MOTORCYCLE_LIVE_QUEUE, checkpoint),
                        prepareVehicles(vehicleMapper.convert(response.getMotorcyclePriority()), QueueType.MOTORCYCLE_PRIORITY, checkpoint)
                )
                .flatMap(i -> i)
                .toList();
    }
}
