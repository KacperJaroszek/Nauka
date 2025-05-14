import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
// 1
//        Clock clock = new Clock();
//        clock.setCurrentTime();
//        System.out.println("Aktualny czas: "+clock);
//
//        clock.setTime(18, 30, 30);
//        System.out.println("Nowy czas: " + clock);
//
////        clock.setTime(25,0,0);

//2
//        DigitalClock clock24 = new DigitalClock(DigitalClock.ClockMode.H24);
//        clock24.setTime(9, 5, 7);
//        System.out.println("Tryb 24h: " + clock24);
//
//        DigitalClock clock12 = new DigitalClock(DigitalClock.ClockMode.H12);
//        clock12.setTime(9, 5, 7);
//        System.out.println("Tryb 12h: " + clock12);
//
//        clock12.setTime(15, 45, 0);
//        System.out.println("Tryb 12h (PM): " + clock12);
//
//        clock12.setTime(0, 15, 0);
//        System.out.println("Tryb 12h (AM, północ): " + clock12);

        //3
//        try {
//            String filePath = "strefy.csv"; // Ścieżka względna lub bezwzględna
//            Map<String, City> cities = City.parseFile(filePath);
//
//            // Przykład: wypisz wszystkie miasta
//            for (String cityName : cities.keySet()) {
//                System.out.println(cities.get(cityName));
//            }
//
//        } catch (IOException e) {
//            System.err.println("Błąd podczas wczytywania pliku: " + e.getMessage());
//        }

        //4
        City london = new City("Londyn", 1, 51.5074, -0.1278);
        City tokyo = new City("Tokio", 9, 35.6895, 139.6917);

        DigitalClock clock = new DigitalClock(london, DigitalClock.ClockMode.H12);
        clock.setTime(14, 45, 30);
        System.out.println("Londyn (12h): " + clock);

        clock.setCity(tokyo); // przestawi czas o +8 godzin
        System.out.println("Tokio (12h): " + clock);

        clock.setMode(DigitalClock.ClockMode.H24);
        System.out.println("Tokio (24h): " + clock);

        City lublin = new City("Lublin", 2, 51.25, 22.5667);

        LocalTime czasStrefowy = LocalTime.of(12, 0, 0);
        LocalTime czasMiejscowy = lublin.localMeanTime(czasStrefowy);

        System.out.println("Czas strefowy w Lublinie: " + czasStrefowy);
        System.out.println("Czas miejscowy w Lublinie: " + czasMiejscowy);
    }
}