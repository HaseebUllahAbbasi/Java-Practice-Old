import java.net.URL;
import java.util.List;

public class StudentClass implements StudentInt
{

    @Override
    public Submission submit(String sid, String module, String assessment, URL url) {
        return null;
    }

    @Override
    public String getFeedback(String sNr) {
        return null;
    }

    @Override
    public List<Submission> getMySubmission(String sid) {
        return null;
    }
}
