import java.util.Arrays;
import java.util.Objects;

public class DeathCauseStatistic {
    private String ICD_10;
    private int[] numberOfDeaths;

    public DeathCauseStatistic(String ICD_10, int[] numberOfDeaths) {
        this.ICD_10 = ICD_10;
        this.numberOfDeaths = numberOfDeaths;
    }

    public String getICD_10() {
        return ICD_10;
    }

    public static DeathCauseStatistic fromCsvLine(String csvLine){
        String[] elements = csvLine.split(",", -1);
        String code = elements[0].trim();
        int[] deaths = new int[20];
        for(int i=0;i<20;++i){
            if(Objects.equals(elements[i + 2], "-")){
                deaths[i]=0;
            }else {
                deaths[i] = Integer.parseInt(elements[i + 2]);
            }
        }

        return new DeathCauseStatistic(code, deaths);
    }

    public class AgeBracketDeaths{
        public final int young, old, deathcount;

        public AgeBracketDeaths(int young, int old, int deathcount) {
            this.young = young;
            this.old = old;
            this.deathcount = deathcount;
        }
    }

    public AgeBracketDeaths getDeathCount(int age){
        int index= age/5;
        if(index>=20){
            index=19;
        }

        return new AgeBracketDeaths(index*5,index*5+4,index);
    }

    @Override
    public String toString() {
        return "DeathCauseStatistic{" +
                "ICD_10='" + ICD_10 + '\'' +
                ", numberOfDeaths=" + Arrays.toString(numberOfDeaths) +
                '}';
    }

}
