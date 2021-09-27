import raceResultsService.interfaces.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class CarTest {

    @Test
    public void Car_shouldReturnDefaultValuesOnTestDoubles() {
        Car car = mock(Car.class);
        assertThat(car.getEngineTemperature()).isEqualTo(0);
        assertThat(car.needsFuel()).isEqualTo(false);
        assertThat(car.getName()).isNull();
    }

}