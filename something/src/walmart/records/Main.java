package walmart.records;

import java.util.List;
import java.util.Arrays;

record Pair<K,V>(K key, V value) {}

public class Main {

    public static void main(String[] args)
    {
        Pair<String, Integer> p1 = new Pair("Aman Dubey",293);
        System.out.println(p1);
        System.out.println(p1.key());
        System.out.println(p1.value());


        Pair<List<String>,List<Integer>> p2 = new Pair(Arrays.asList("Aman","Dubey","is","already","a","goat"), Arrays.asList(
                112,32,123,345,234,234,4234,123,234,234234,234234
        ));

        System.out.println(p2.key());
        System.out.println(p2.value());
    }
}
