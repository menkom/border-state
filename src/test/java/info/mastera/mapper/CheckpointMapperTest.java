package info.mastera.mapper;

import info.mastera.declarant.client.model.CheckpointsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CheckpointMapperTest {

    private final CheckpointMapper mapper = Mappers.getMapper(CheckpointMapper.class);

    @Test
    public void mapperWorksTest() {
        CheckpointsResponse.Checkpoint response = new CheckpointsResponse.Checkpoint()
                .setId("id-1")
                .setName("town");

        var resultToTest = mapper.convert(response);

        Assertions.assertNotNull(resultToTest);
        Assertions.assertEquals("id-1", resultToTest.getId());
        Assertions.assertEquals("town", resultToTest.getName());
        Assertions.assertTrue(resultToTest.isActive());
    }

    @Test
    public void mapperWorksWithNullsTest() {
        CheckpointsResponse.Checkpoint response = new CheckpointsResponse.Checkpoint()
                .setId(null)
                .setName(null);

        var resultToTest = mapper.convert(response);

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNull(resultToTest.getId());
        Assertions.assertNull(resultToTest.getName());
        Assertions.assertTrue(resultToTest.isActive());
    }
}