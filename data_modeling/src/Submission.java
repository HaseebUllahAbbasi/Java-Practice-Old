public class Submission
{
    public Submission(String subNr, String url) {
        this.subNr = subNr;
        this.url = url;
    }


    @Override
    public String toString() {
        return "Submission{" +
                "subNr='" + subNr + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getSubNr() {
        return subNr;
    }

    public void setSubNr(String subNr) {
        this.subNr = subNr;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String subNr;
    String url;
}
