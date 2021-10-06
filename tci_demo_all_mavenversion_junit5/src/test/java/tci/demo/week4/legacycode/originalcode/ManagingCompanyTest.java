package tci.demo.week4.legacycode.originalcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class ManagingCompanyTest {
    private final int VALID_STRIPES_NUMBER = 25;

    /**
     * while running: error.
     * Argument(s) are different! Wanted:
     * zoo.addAnimal(
     *     tci.demo.week4.legacycode.Zebra@77df7272
     * );
     * -> at tci.demo.week4.legacycode.ManagingCompanyTest.shouldAddNewZebraToZoo(ManagingCompanyTest.java:22)
     * Actual invocations have different arguments:
     * zoo.addAnimal(
     *     tci.demo.week4.legacycode.Zebra@7bb76866
     *
     *     how to solve this?
     *
     *     1. adding equals+hashcode (minor change. adding code)
     *     2. making code loosely coupled (rather big change. changing code)
     */


    @Test
    public void shouldAddNewZebraToZoo() {
        // arrange
        Zoo mockZoo = mock(Zoo.class);
        ManagingCompany managingCompanySUT = new ManagingCompany(mockZoo);
        Zebra expectedZebra = new Zebra(VALID_STRIPES_NUMBER);
        // act
        managingCompanySUT.addZebra(VALID_STRIPES_NUMBER);
        // assert that zebra with correct nr of stripes was added
        verify(mockZoo).addAnimal(expectedZebra);

    }
}