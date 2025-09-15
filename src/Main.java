import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>(List.of("qwerty", "asdfghjkl", "zxcvbnm"));
        lst = lst.stream().filter(s -> !"zxcvbnm".equals(s)).collect(Collectors.toList());
        System.out.println(lst);

        Map<String, String> map = new HashMap<>(Map.of("a", "b", "c", "d", "e", "f"));
        map = map.entrySet()
                .stream()
                .filter(entry -> !"a".equals(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(map);

        List<Integer> intList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        intList.add(1, 66);
        intList.addAll(2, List.of(8, 9, 10));
        System.out.println(intList);

        Map<String, Integer> newMap = new HashMap<>(Map.of("a", 1, "b", 2, "c", 3));
        int val = newMap.put("a", 4);
        System.out.println(val);
        Set<String> newMapKeySet = newMap.keySet();
        Collection<Integer> newMapValues = newMap.values();
        System.out.println(newMapValues);


        System.out.println();
        System.out.println();

        Map<String, Integer> holops = new HashMap<>(
                Map.of("Холоп 1", 101, "Холоп 2", 20, "Холоп 3", 200)
        );

        holops = holops.entrySet().stream()
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue() > 100 ?
                                        entry.getValue() - 20 :
                                        entry.getValue()
                        ));
        System.out.println(holops);
    }
}
