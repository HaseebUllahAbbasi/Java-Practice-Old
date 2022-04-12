public class Feedback
{
    String text;
    int mark;

    public Feedback(String text, int mark) {
        this.text = text;
        this.mark = mark;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "text='" + text + '\'' +
                ", mark=" + mark +
                '}';
    }
}
