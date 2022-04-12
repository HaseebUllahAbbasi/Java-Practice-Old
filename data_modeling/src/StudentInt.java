import java.net.URL;
import java.util.List;

public interface StudentInt
{

    Submission submit(String sid, String module, String assessment, URL url);
    String getFeedback(String sNr);
    List<Submission> getMySubmission(String sid);

}
