import java.io.*;
import java.nio.file.*;
import java.time.LocalTime;
import java.util.*;

public class City {
    private String name;
    private int summerTimezone;
    private double latitude;
    private double longitude;

    public City(String name, int summerTimezone, double latitude, double longitude) {
        this.name = name;
        this.summerTimezone = summerTimezone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Gettery
    public String getName() {
        return name;
    }

    public int getSummerTimezone() {
        return summerTimezone;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    // Parsowanie pojedynczej linii
    private static City parseLine(String line) {
        String[] parts = line.split(",", -1);
        if (parts.length < 4) {
            throw new IllegalArgumentException("Nieprawidłowa linia: " + line);
        }

        String name = parts[0].trim();
        int timezone = Integer.parseInt(parts[1].trim());

        double lat = parseCoordinate(parts[2].trim());
        double lon = parseCoordinate(parts[3].trim());

        return new City(name, timezone, lat, lon);
    }

    // Konwersja współrzędnych np. "24.4539 N" → 24.4539; "54.3773 E" → 54.3773
    private static double parseCoordinate(String coord) {
        String[] split = coord.split(" ");
        double value = Double.parseDouble(split[0]);
        String direction = split[1].toUpperCase();

        if (direction.equals("S") || direction.equals("W")) {
            value *= -1;
        }
        return value;
    }

    // Wczytanie całego pliku do mapy
    public static Map<String, City> parseFile(String filePath) throws IOException {
        Map<String, City> cityMap = new HashMap<>();

        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (int i = 1; i < lines.size(); i++) { // Pomijamy nagłówek
            City city = parseLine(lines.get(i));
            cityMap.put(city.getName(), city);
        }

        return cityMap;
    }

    public LocalTime localMeanTime(LocalTime strefowyCzas) {
        int miejscowyOffsetSekundy = (int)(longitude * 240);

        int strefowyOffsetSekundy = summerTimezone * 3600;

        int zmianaSekundy = miejscowyOffsetSekundy - strefowyOffsetSekundy;

        return strefowyCzas.plusSeconds(zmianaSekundy);
    }

    @Override
    public String toString() {
        return String.format("%s: UTC+%d, Lat: %.4f, Lon: %.4f", name, summerTimezone, latitude, longitude);
    }
}
