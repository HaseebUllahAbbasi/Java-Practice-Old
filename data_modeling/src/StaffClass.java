import java.util.List;

public class StaffClass implements  StaffInt
{
    List<Submission> submissions;
    @Override
    public List<Submission> getSubmissions(String module)
    {
        return null;
    }
    @Override
    public Feedback submitFeedback(String sNr, String text, int mark)
    {
        return null;
    }

    @Override
    public List<Submission> getAllSubmission(String term) {
        return null;
    }
}
