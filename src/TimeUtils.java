import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeUtils {

    private String time;

    public TimeUtils() {
        this.setNowDate();
    }

    public String getTime() {
        return this.time;
    }

    private void setNowDate() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        this.time = formatter.format(calendar.getTime());
        System.out.println("Logged time create: " + this.time);
    }

    public String getActionTime() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat formatter= new SimpleDateFormat(" '|' HH:mm:ss z");
        return formatter.format(calendar.getTime());
    }
}