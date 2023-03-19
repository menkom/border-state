package info.mastera.mapper;

import info.mastera.declarant.client.model.StateResponse;
import info.mastera.model.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class VehicleMapperTest {

    private final VehicleMapper mapper = Mappers.getMapper(VehicleMapper.class);

    @Test
    public void mapperWorksTest() {
        StateResponse.Transport response = new StateResponse.Transport()
                .setStatus(2)
                .setRegNum("REG_NUM");

        var resultToTest = mapper.convert(response);

        Assertions.assertNotNull(resultToTest);
        Assertions.assertNull(resultToTest.getId());
        Assertions.assertEquals(Status.ARRIVED, resultToTest.getStatus());
        Assertions.assertEquals("REG_NUM", resultToTest.getRegNum());
    }
}