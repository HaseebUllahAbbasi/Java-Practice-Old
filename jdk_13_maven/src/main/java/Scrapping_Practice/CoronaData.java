package Scrapping_Practice;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class CoronaData {
    public String getData(String name) throws IOException {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<html>" +
                "<body style='text-align:center;color:red;'>");
        buffer.append(name.toUpperCase() + "<br>");
        String url = "https://www.worldometers.info/coronavirus/country/" + name + "/";
        Document doc = Jsoup.connect(url).get();
        // #maincounter-number
        Elements elements = doc.select("#maincounter-wrap");
        elements.forEach((e) -> {
            String text = e.select("h1").text();
            String counter = e.select(".maincounter-number>span").text();
            buffer.append(text).append(counter).append("<br>");
        });
        buffer.append("</html>" +
                "</body>");
        return buffer.toString();
    }

    public static void main(String[] args) {
        CoronaData scrap = new CoronaData();
//        System.out.println("Enter country name.");
//        Scanner input = new Scanner(System.in);
//        String countryName = input.nextLine();
//        System.out.println(scrap.getData(countryName));

        JFrame frame = new JFrame("Corona Details");
        JTextField textField;
        JLabel label;
        JButton button;

        frame.setSize(500, 500);

        Font font = new Font("Poppins", Font.BOLD, 30);
        textField = new JTextField();
        label = new JLabel();
        button = new JButton("Fetch");
        button.addActionListener((event -> {
            try {
                String data = textField.getText();
                String result = scrap.getData(data);
                label.setText(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
        textField.setFont(font);
        label.setFont(font);
        button.setFont(font);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.setLayout(new BorderLayout());
        frame.add(textField, BorderLayout.NORTH);
        frame.add(label, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setVisible(true);

    }
}
