package lecture.chapter9;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer, String> myWordMap = new TreeMap<Integer, String>();

        Integer keyValue = new Integer(1000);
        int keyValueSimpleType = keyValue.intValue();

        myWordMap.put(new Integer(1000), "Blau");
        myWordMap.put(2000, "Rot");
        myWordMap.put(3000, "Grün");


        System.out.println(myWordMap.get(2000));

        Set<Integer> wordKeys = myWordMap.keySet();

        for(int key : wordKeys){
            System.out.println(key + ": " + myWordMap.get(key));
        }

    }
}
