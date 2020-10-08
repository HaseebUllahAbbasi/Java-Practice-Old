package com.Hashmap;

import java.util.HashMap;

public class Main
{
    public static void main(String[] args)
    {
        //stores the data in (Key, Value) pairs
        HashMap<String, Integer> hashMap = new HashMap<>();

        // Add elements to the hashMap
        hashMap.put("vishal", 10);
        hashMap.put("sachin", 30);
        hashMap.put("vaibhav", 20);

        // Print size and content
        System.out.println("Size of hashMap is:- "+ hashMap.size());
        System.out.println(hashMap);
        // Check if a key is present and if
        // present, print value
        System.out.println(hashMap.get(20));
        if (hashMap.containsKey("vishal"))
        {

            Integer a = hashMap.get("vishal");
            System.out.println("value for key"
                    + " \"vishal\" is:- "
                    + a);
        }
        System.out.println(hashMap.keySet().toString());
    }

    /*
    clear()
Removes all of the mappings from this map.

get(Object key)
Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.

    remove(Object key)
Removes the mapping for the specified key from this map if present.

values()
Returns a Collection view of the values contained in this map.

	keySet()
Returns a Set view of the keys contained in this map.
     */




    /*
    Points to remember
Java HashMap contains values based on the key.
Java HashMap contains only unique keys.
Java HashMap may have one null key and multiple null values.
Java HashMap is non synchronized.
Java HashMap maintains no order.
The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.
     */
}

/*
    Advantages of HashSet
HashSet allows null value and contains only unique values.

    Disadvantages
    Potential of collision when 2 distinct keys generate the same hashCode() value worse the performance of the hashMap.

    Occasionally HashMaprequires resizing when the original size of HashMap buckets are full. Resizing takes O(n) time as the elements from the previous hashtable/HashMap are transferred to a new bigger HashMap



    ///
    Advantages of LinkedHashMap


    Manintains insertion order.

    Faster iteration with LinkedHashMap.

    ///
    Disadvantages of LinkedHashMap


    Slower than HashMap for adding and removing elements.


 */