import com.tamas.gyorkis.FlightBookingSystem;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FlightBookingSystemTest {

    @Test
    public void testCreatingFlight() {
        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();

        flightBookingSystem.createFlight("F001", 100);

        int actual = flightBookingSystem.getAvailableSeats("F001");
        int expected = 100;

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAvailableSeats() {
        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();

        flightBookingSystem.createFlight("F001", 100);
        flightBookingSystem.bookSeats("F001", 2);

        int expected = 98;
        int actual = flightBookingSystem.getAvailableSeats("F001");

        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @MethodSource("paramsForTestBoundry")
    public void testBoundry(int numSeats, boolean expectedResult) {
        String flightId = "F001";
        int totalSeats = 100;
        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();

        flightBookingSystem.createFlight(flightId, totalSeats);

        boolean actual = flightBookingSystem.bookSeats(flightId, numSeats);

        assertEquals(expectedResult, actual);
    }

    private static Stream<Arguments> paramsForTestBoundry() {
        return Stream.of(
                Arguments.of(0, false), // Alsó határ alatt
                Arguments.of(1, true), //Alsó határon belül
                Arguments.of(10, true), //Felső határon belül
                Arguments.of(11, false) //Felső határon kívül
        );
    }

    @RepeatedTest(2)
    public void testRepeatedFlight(RepetitionInfo repetitionInfo) {
        System.out.println(repetitionInfo);

        FlightBookingSystem flightBookingSystem = new FlightBookingSystem();

        flightBookingSystem.createFlight("RepeatedFlight", 100);
        assertThrows(IllegalArgumentException.class, () -> flightBookingSystem.createFlight("RepeatedFlight", 100));
    }
}
