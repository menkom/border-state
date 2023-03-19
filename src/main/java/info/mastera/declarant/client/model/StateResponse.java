package info.mastera.declarant.client.model;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class StateResponse {
    private List<Transport> truckLiveQueue;
    private List<Transport> truckPriority;
    private List<Transport> truckGpk;
    private List<Transport> busLiveQueue;
    private List<Transport> busPriority;
    private List<Transport> carLiveQueue;
    private List<Transport> carPriority;
    private List<Transport> motorcycleLiveQueue;
    private List<Transport> motorcyclePriority;

    @Getter
    @Setter
    @JsonbPropertyOrder(value = {"regNum", "status", "order_id", "type_queue", "registration_date", "changed_date"})
    public static class Transport {
        @JsonbProperty(value = "regnum")
        private String regNum;
        private int status;
        @JsonbProperty(value = "order_id")
        private Integer orderId;
        @JsonbProperty(value = "type_queue")
        private int typeQueue;
        @JsonbProperty(value = "registration_date")
        @JsonbDateFormat(value = "HH:mm:ss' 'dd.MM.yyyy")
        private LocalDateTime registrationDate;
        @JsonbProperty(value = "changed_date")
        @JsonbDateFormat(value = "HH:mm:ss' 'dd.MM.yyyy")
        private LocalDateTime changedDate;
    }
}
