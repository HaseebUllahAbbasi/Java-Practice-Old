import java.util.List;

public interface StaffInt
{
    List<Submission> getSubmissions(String module);
    Feedback submitFeedback(String sNr, String text, int mark);
    List<Submission> getAllSubmission(String term);
}
