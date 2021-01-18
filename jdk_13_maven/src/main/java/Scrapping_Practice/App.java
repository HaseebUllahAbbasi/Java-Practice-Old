package Scrapping_Practice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        Scrapping scrap = new Scrapping();
        for(int i=0;i<10;i++) {
            if(i==0)
                scrap.getData("https://www.bbc.com/urdu/topics/cjgn7n9zzq7t","pakistan");
            else
                scrap.getData("https://www.bbc.com/urdu/topics/cjgn7n9zzq7t/page/"+i,"pakistan");
        }
        System.out.println("\nWorld....\n");
        for(int i=0;i<10;i++)
        {
            if(i==0)
                scrap.getData("https://www.bbc.com/urdu/topics/cw57v2pmll9t","World");
            else
                scrap.getData("https://www.bbc.com/urdu/topics/cw57v2pmll9t/page/"+i,"World");
        }

        System.out.println("\nKhel....\n");
        for(int i=0;i<10;i++)
        {
            if(i==0)
                scrap.getData("https://www.bbc.com/urdu/topics/c340q0p2585t","Khel");
            else
                scrap.getData("https://www.bbc.com/urdu/topics/c340q0p2585t/page/"+i,"Khel");
        }
        System.out.println("\nFun Funkar....\n");
        for(int i=0;i<10;i++)
        {
            if(i==0)
                scrap.getData("https://www.bbc.com/urdu/topics/ckdxnx900n5t","Fun Funkar");
            else
                scrap.getData("https://www.bbc.com/urdu/topics/ckdxnx900n5t/page/"+i,"Fun Funkar");
        }

        System.out.println("\nScience....\n");
        for(int i=0;i<10;i++)
        {
            if(i==0)
                scrap.getData("https://www.bbc.com/urdu/topics/c40379e2ymxt","Science");
            else
                scrap.getData("https://www.bbc.com/urdu/topics/c40379e2ymxt/page/"+i,"Science");
        }
        scrap.dataInFile();
    }
}

class Scrapping{
    StringBuffer text = new StringBuffer();
    public void getData(String url,String label) throws IOException{
        Document doc1 = Jsoup.connect(url).get();
        System.out.println(doc1.title());
        Elements elements1 = doc1.getElementsByClass("qa-heading-link");

        for (Element para : elements1) {
            text.append(para.text()+", "+label+"\n");
        }
    }
    public void dataInFile() throws IOException {
        FileWriter filewriter = new FileWriter("web-scaping.csv");
        filewriter.write(String.valueOf(text));
        filewriter.close();
    }
}
