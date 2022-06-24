import java.util.HashMap;

public class App {
    public static void main(String[] args) throws Exception {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);

        var map2 = new HashMap<String, Integer>();
        map2.put("a", 2);

        map2.forEach((k, v) -> map1.merge(k, v, (v1, v2) -> v2));

        System.out.println(map1.get("a"));
    }
}
