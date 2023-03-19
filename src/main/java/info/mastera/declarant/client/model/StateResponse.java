package info.mastera.declarant.client.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StateResponse {

    Info info;

    List<Transport> truckLiveQueue;
    List<Transport> truckPriority;
    List<Transport> truckGpk;
    List<Transport> busLiveQueue;
    List<Transport> busPriority;
    List<Transport> carLiveQueue;
    List<Transport> carPriority;
    List<Transport> motorcycleLiveQueue;
    List<Transport> motorcyclePriority;

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Accessors(chain = true)
    @Getter
    @Setter
    @JsonbPropertyOrder(value = {"regNum", "status", "order_id", "type_queue", "registration_date", "changed_date"})
    public static class Transport {
        @JsonProperty(value = "regnum")
        String regNum;
        int status;
        @JsonProperty(value = "order_id")
        Integer orderId;
        @JsonProperty(value = "type_queue")
        int typeQueue;
        @JsonProperty(value = "registration_date")
        @JsonFormat(pattern =  "HH:mm:ss' 'dd.MM.yyyy")
        LocalDateTime registrationDate;
        @JsonProperty(value = "changed_date")
        @JsonFormat(pattern =  "HH:mm:ss' 'dd.MM.yyyy")
        LocalDateTime changedDate;
    }

    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Accessors(chain = true)
    @Getter
    @Setter
    @JsonbPropertyOrder(value = {"id", "nameEn", "name"})
    public static class Info {

        String id;
        String nameEn;
        String name;
    }
}
