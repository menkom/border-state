package info.mastera.bot.client;

import info.mastera.bot.model.TransferChangeState;
import info.mastera.model.StateChangeType;
import info.mastera.model.Status;
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
public class BorderStateBotClientTest {

    @Autowired
    private BorderStateBotClient borderStateBotClient;

    @Test
    public void sendInfoTest() {
        borderStateBotClient.sendInfo(new TransferChangeState(
                "RegNum",
                StateChangeType.ORDER_ID,
                Status.ARRIVED,
                Status.ARRIVED,
                5,
                3
        ));
    }
}