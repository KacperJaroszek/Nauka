import java.time.LocalTime;

public class Clock {
    protected int hour;
    protected int minute;
    protected int second;
    private City city;

    public Clock(City city) {
        this.city = city;
        setCurrentTime();
    }

    // Metoda ustawia czas na aktualny czas systemowy
    public void setCurrentTime() {
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
    }

    // Metoda ustawia czas ręcznie, sprawdzając poprawność danych
    public void setTime(int hour, int minute, int second) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Nieprawidłowa godzina: " + hour + " (dozwolony zakres: 0–23)");
        }
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Nieprawidłowa minuta: " + minute + " (dozwolony zakres: 0–59)");
        }
        if (second < 0 || second > 59) {
            throw new IllegalArgumentException("Nieprawidłowa sekunda: " + second + " (dozwolony zakres: 0–59)");
        }

        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setCity(City newCity){
        int oldOffSet = (city!=null) ? city.getSummerTimezone() : 0;
        int newOffSet = newCity.getSummerTimezone();
        int offSetDiff = newOffSet - oldOffSet;

        this.hour = (this.hour + offSetDiff + 24) % 24;

        this.city=newCity;
    }

    // Metoda zwraca czas w formacie hh:mm:ss
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public City getCity() {
        return city;
    }
}