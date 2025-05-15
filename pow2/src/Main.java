public class Main {
    public static void main(String[] args) {

        DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33");
        System.out.println(stat);
        System.out.println();

    }
}