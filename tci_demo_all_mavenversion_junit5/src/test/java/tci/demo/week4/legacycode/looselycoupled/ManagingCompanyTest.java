package tci.demo.week4.legacycode.looselycoupled;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ManagingCompanyTest {
    private final int VALID_STRIPES_NUMBER = 25;

    /**
     *
     */


    @Test
    public void shouldAddNewZebraToZoo() {
        // arrange
        Zoo mockZoo = mock(Zoo.class);
        ManagingCompany managingCompanySUT = new ManagingCompany(mockZoo);
        Zebra expectedZebra = mock(Zebra.class);
        // act
        managingCompanySUT.addZebra(expectedZebra);
        // assert that zebra with correct nr of stripes was added to the zoo
        verify(mockZoo).addAnimal(expectedZebra);


    }
}