import java.util.*;

public class Main {

    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        char[] e = text.toLowerCase().toCharArray();

        for (char value : e) {
            if (Character.isLetter(value)) {
                Integer c = map.get(value);
                if (c == null) {
                    map.put(value, 1);
                } else {
                    map.put(value, ++c);
                }
            }
        }


        Integer max = getMax(map);
        Integer min = getMin(map);

        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (Objects.equals(s.getValue(), max)) {
                System.out.println(s.getKey() + " = " + s.getValue() + " - это чаще всего встречающаяся буква.");
            }
        }

        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (Objects.equals(s.getValue(), min)) {
                System.out.println(s.getKey() + " = " + s.getValue() + " - это реже всего встречающаяся буква.");
            }
        }
    }

    private static Integer getMax(Map<Character, Integer> map) {
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (s.getValue() > max) {
                max = s.getValue();
            }
        }
        return max;
    }

    private static Integer getMin(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> s : map.entrySet()) {
            if (s.getValue() < min) {
                min = s.getValue();
            }
        }
        return min;
    }

}