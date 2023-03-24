package info.mastera.bot.client;

import info.mastera.bot.model.TransferChangeState;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BorderStateBotApi", url = "http://localhost:8088")
public interface BorderStateBotClient {


    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    void sendInfo(@RequestBody TransferChangeState state);
}
