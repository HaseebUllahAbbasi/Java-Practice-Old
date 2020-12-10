package Main_Pakcage;

public class ImageData {
    private String path;
    private int num;

    public ImageData(String path, int num) {
        this.path = path;
        this.num = num;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
