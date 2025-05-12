public class Main {
    public static void main(String[] args) {
        Clock clock = new Clock();

        clock.setCurrentTime();
        System.out.println("Aktualny czas: "+clock);

        clock.setTime(18, 30, 30);
        System.out.println("Nowy czas: " + clock);

//        clock.setTime(25,0,0);


        DigitalClock clock24 = new DigitalClock(DigitalClock.ClockMode.H24);
        clock24.setTime(9, 5, 7);
        System.out.println("Tryb 24h: " + clock24);

        DigitalClock clock12 = new DigitalClock(DigitalClock.ClockMode.H12);
        clock12.setTime(9, 5, 7);
        System.out.println("Tryb 12h: " + clock12);

        clock12.setTime(15, 45, 0);
        System.out.println("Tryb 12h (PM): " + clock12);

        clock12.setTime(0, 15, 0);
        System.out.println("Tryb 12h (AM, północ): " + clock12);
    }
}