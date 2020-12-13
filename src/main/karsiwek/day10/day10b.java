package day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static day10.day10a.parseInput;


public class day10b {

    static Map<String, Long> cache = new HashMap<>();

    public static Long findNumberOfPossibilities(List<Long> input) {
        Long possibilities = 0l;
        if(input.size()==1) {
            return 1l;
        }
        for(int i=1;i<4 && i<input.size();i++){

            if(input.get(i)-input.get(0)<=3) {
                String key = input.subList(i, input.size()).stream().map(elem -> elem.toString()).reduce((a,b)->a+","+b).get();
                if(cache.get(key)==null) {
                    cache.put(key, findNumberOfPossibilities(input.subList(i, input.size())));
                }
                possibilities+=cache.get(key);
            }
        }
        return possibilities;
    }

    public static void main(final String[] args) {
        List<Long> input = parseInput(day10a.input);
        input.add(0l);
        input.add(input.stream().max(Long::compareTo).get()+3);
        input.sort(Long::compareTo);
        System.out.println(findNumberOfPossibilities(input));
//        System.out.println(findConsecutiveNumbersToProduce(parseInput(testInput)));
    }
}
