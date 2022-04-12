public class Module
{
    String code;
    String term;

    public Module(String code, String term) {

        this.code = code;
        this.term = term;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Module{" +
                "code='" + code + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
