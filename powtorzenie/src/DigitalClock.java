public class DigitalClock extends Clock{
    public enum ClockMode{
        H24,
        H12
    }

    private ClockMode mode;

    public DigitalClock(City city, ClockMode mode) {
        super(city);
        this.mode = mode;
    }

    @Override
    public String toString(){
        if(mode == ClockMode.H24){
            return super.toString();
        }
        else{
            String period = (hour <12) ? "AM" : "PM";

            int hour12 = hour%12;
            if(hour12 ==0) hour12 = 12;
            return String.format("%d:%02d:%02d %s", hour12, minute, second, period);
        }
    }

    public void setMode(ClockMode mode) {
        this.mode = mode;
    }

    public ClockMode getMode() {
        return mode;
    }
}
