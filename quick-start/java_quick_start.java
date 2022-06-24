import java.util.HashMap;

class QuickStart {
    public static void main (String[] args) {
        var map1 = new HashMap<String, Integer>();
        map1.put("a", 1);

        var map2 = new HashMap<String, Integer>();
        map2.put("b", 1);

        map2.forEach((k, v) -> map1.merge(k, v, (v1, v2) -> v1));

        System.out.println(map1.size());
    }

    public boolean canDivide(int a, int b) {
        return a % b == 0;
    }
}
