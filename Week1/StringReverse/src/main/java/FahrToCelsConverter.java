public class FahrToCelsConverter {

    public static int toFahrenheit(int celsius) {
        return (celsius * 9/5) + 32;
    }

    public static int toCelsius(int fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
