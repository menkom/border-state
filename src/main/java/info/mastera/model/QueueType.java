package info.mastera.model;

import info.mastera.util.StringItems;

import java.util.stream.Stream;

public enum QueueType {
    TRUCK_LIVE_QUEUE("truckLiveQueue"),
    TRUCK_PRIORITY("truckPriority"),
    TRUCK_GPK("truckGpk"),
    BUS_LIVE_QUEUE("busLiveQueue"),
    BUS_PRIORITY("busPriority"),
    CAR_LIVE_QUEUE("carLiveQueue"),
    CAR_PRIORITY("carPriority"),
    MOTORCYCLE_LIVE_QUEUE("motorcycleLiveQueue"),
    MOTORCYCLE_PRIORITY("motorcyclePriority"),
    ;

    private final String code;

    QueueType(String code) {
        this.code = code;
    }

    public static QueueType parse(String valueCode) {
        return Stream.of(QueueType.class.getEnumConstants())
                .filter(item -> item.code.equals(valueCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        StringItems.ERROR_ENUM_CODE_PARSE
                                .formatted(QueueType.class.getSimpleName(), valueCode)
                ));
    }
}
