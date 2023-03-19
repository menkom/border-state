package info.mastera.declarant.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
public class CheckpointsResponse {

    private List<Checkpoint> result;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class Checkpoint {
        private String id;
        private String name;
    }
}
