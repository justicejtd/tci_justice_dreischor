//package tci.demo.week1.solutions;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import tci.demo.week1.buffer.BufferIsFullException;
//import tci.demo.week1.buffer.IntBuffer;
//
//import static org.assertj.core.api.Assertions.*;
//
//class IntBufferTest {
//    static int VALID_BUFFERSIZE = 4;
//

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//@Test
//    public void buffer_canBeCreatedWithCorrectBufferSize(){
//}
//
//@Test
//    public void buffer_ShouldThrowExceptionWhenSizeIsNegative() {
//    }
//
//
//    public void buffer_wrongInitialValuesThrowIllegalArgumentException(int initialSize) {
//    }

//        @Test
//    public void put_addingAValueInNonFullBufferIsPossible() {
//    }
//
//    @Test
//    public void put_overflowBufferShouldThrowException() throws BufferIsFullException {
//    }
//
//    @Test
//    public void addNrOfItemsEqualToBuffersizeLeadsToFullBuffer() throws BufferIsFullException {
//    }




///////////////////////////////////////////////////////////////////////////////////////////////////////////

//@Test
//    public void buffer_canBeCreatedWithCorrectBufferSize(){
//    // Arrange
//
//    // Act
//    IntBuffer sut = new IntBuffer(VALID_BUFFERSIZE);
//    // Assert
//    assertThat(sut.getBufferSize()).isEqualTo(VALID_BUFFERSIZE);
//}
//
//@Test
//    public void buffer_ShouldThrowExceptionWhenSizeIsNegative() {
//        // Arrange
//    int invalidsize = -4;
//        // Act & Assert
//    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
//    {
//        new IntBuffer(invalidsize);
//    });
//    }
//
//
//    @ParameterizedTest
//    @ValueSource(ints = {-1, -2, -10})
//    public void buffer_wrongInitialValuesThrowIllegalArgumentException(int initialSize) {
//        // Arrange & Act & Assert
//        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new IntBuffer(initialSize));
//    }
//
//
//
//
//        @Test
//    public void put_addingAValueInNonFullBufferIsPossible() {
//        // Arrange
//        IntBuffer sut = new IntBuffer(VALID_BUFFERSIZE);
//        int valueToPutInBuffer = 34;
//        // Act & Assert
//        assertThatNoException().isThrownBy(() -> sut.put(valueToPutInBuffer));
//        assertThat(sut.getNrOfItemsInBuffer()).isEqualTo(1);
//    }
//
//    @Test
//    public void put_overflowBufferShouldThrowException() throws BufferIsFullException {
//        // Arrange
//        IntBuffer sut = new IntBuffer(1);
//        sut.put(5);
//        // Act & Assert
//        assertThatExceptionOfType(BufferIsFullException.class).isThrownBy(() -> sut.put(3465));
//
//    }
//
//    @Test
//    public void addNrOfItemsEqualToBuffersizeLeadsToFullBuffer() throws BufferIsFullException {
//        // Arrange
//        final int BUFFERSIZE = 3;
//        IntBuffer buf = new IntBuffer(BUFFERSIZE);
//        // Act
//        buf.put(1);
//        buf.put(2);
//        buf.put(3);
//        // assert
//        assertThat(buf.bufferIsFull()).isTrue();
//    }
//
//
//}