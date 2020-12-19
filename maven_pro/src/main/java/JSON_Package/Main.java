package JSON_Package;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        demo_json_writer();
        try {
            demo_json_reader();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public static void demo_json_reader() throws IOException, ParseException
    {
        Object obj = new JSONParser().parse(new FileReader("src/main/resources/Json_Practice/JSONExample.json"));
        // typecasting obj to JSONObject
        JSONObject jsonObject = (JSONObject) obj;

        // getting firstName and lastName
        String firstName = (String) jsonObject.get("firstName");
        String lastName = (String) jsonObject.get("lastName");

        System.out.println(firstName);
        System.out.println(lastName);

        // getting age
        long age = (long) jsonObject.get("age");
        System.out.println(age);

        // getting address
        Map address = ((Map)jsonObject.get("address"));

        // iterating address Map
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }

        // getting phoneNumbers
        JSONArray jsonArray = (JSONArray) jsonObject.get("phoneNumbers");

        // iterating phoneNumbers
        Iterator itr2 = jsonArray.iterator();

        while (itr2.hasNext())
        {
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }
        }
    }
    public static void demo_json_writer()
    {
        // creating JSONObject
        JSONObject jsonObject = new JSONObject();

        // putting data to JSONObject
        jsonObject.put("firstName", "John");
        jsonObject.put("lastName", "Smith");
        jsonObject.put("age", 25);

        // for address data, first create LinkedHashMap
        Map map = new LinkedHashMap(4);
        map.put("streetAddress", "21 2nd Street");
        map.put("city", "New York");
        map.put("state", "NY");
        map.put("postalCode", 10021);

        // putting address to JSONObject
        jsonObject.put("address", map);

        // for phone numbers, first create JSONArray
        JSONArray jsonArray = new JSONArray();

        map = new LinkedHashMap(2);
        map.put("type", "home");
        map.put("number", "212 555-1234");

        // adding map to list
        jsonArray.add(map);

        map = new LinkedHashMap(2);
        map.put("type", "fax");
        map.put("number", "212 555-1234");

        // adding map to list
        jsonArray.add(map);

        // putting phoneNumbers to JSONObject
        jsonObject.put("phoneNumbers", jsonArray);

        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter print_writer = null;
        try
        {
            print_writer = new PrintWriter("src/main/resources/Json_Practice/JSONExample.json");
            print_writer.write(jsonObject.toJSONString());

            System.out.println(jsonObject.toJSONString());
            print_writer.flush();
            print_writer.close();

        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}

