package info.mastera.declarant.client.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CheckpointsResponse {

    private List<Checkpoint> result;

    @Getter
    @Setter
    public static class Checkpoint {
        private String id;
        private String name;
    }
}
