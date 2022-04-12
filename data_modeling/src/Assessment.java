import java.util.Date;

public class Assessment
{
    Date date;
    String title;

    public Assessment(Date date, String title) {
        this.date = date;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "date=" + date +
                ", title='" + title + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
