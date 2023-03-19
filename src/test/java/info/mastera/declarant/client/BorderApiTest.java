package info.mastera.declarant.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@EnableFeignClients
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@TestPropertySource(
        properties = {
                "logging.level.info.mastera.declarant.client.BorderApi=DEBUG",
                "feign.client.config.default.loggerLevel=full"
        }
)
@ExtendWith(SpringExtension.class)
@Disabled
public class BorderApiTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private BorderApi borderApi;

    @Test
    public void getCheckpointsTest() {
        var resultToTest = borderApi.getCheckpoints();
        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getResult());
        Assertions.assertNotEquals(0, resultToTest.getResult().size());
    }

    @Test
    public void getStateTest() {
        var resultToTest = borderApi.getStateNew("53d94097-2b34-11ec-8467-ac1f6bf889c0");
        Assertions.assertNotNull(resultToTest);
        Assertions.assertNotNull(resultToTest.getTruckPriority());
        Assertions.assertNotEquals(0, resultToTest.getTruckLiveQueue().size());
        Assertions.assertNotNull(resultToTest.getTruckGpk());
        Assertions.assertNotNull(resultToTest.getBusLiveQueue());
        Assertions.assertNotNull(resultToTest.getBusPriority());
        Assertions.assertNotNull(resultToTest.getCarLiveQueue());
        Assertions.assertNotNull(resultToTest.getCarPriority());
        Assertions.assertNotNull(resultToTest.getMotorcycleLiveQueue());
        Assertions.assertNotNull(resultToTest.getMotorcyclePriority());
    }
}