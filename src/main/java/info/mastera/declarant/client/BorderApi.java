package info.mastera.declarant.client;

import info.mastera.declarant.client.model.CheckpointsResponse;
import info.mastera.declarant.client.model.StateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;

@FeignClient(name = "BorderApi", url = "https://belarusborder.by/info")
public interface BorderApi {

    String CONSTANT_BORDER_TOKEN = "bts47d5f-6420-4f74-8f78-42e8e4370cc4";
    String CONSTANT_NEW_TEST_TOKEN = "test";

    @GetMapping(
            value = "checkpoint?token=" + CONSTANT_BORDER_TOKEN,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    CheckpointsResponse getCheckpoints();

    @GetMapping(
            value = "/monitoring-new?token=" + CONSTANT_NEW_TEST_TOKEN,
            produces = MediaType.APPLICATION_JSON_VALUE,
            headers = {"Origin=https://mon.declarant.by", "Accept-Encoding='gzip, deflate, br'"}
    )
    StateResponse getStateNew(@NotBlank @RequestParam("checkpointId") String checkpointId);
}
