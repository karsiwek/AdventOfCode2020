package day10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class day10a {

    static String testInput = "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";

    static String input = "86\n" +
            "149\n" +
            "4\n" +
            "75\n" +
            "87\n" +
            "132\n" +
            "12\n" +
            "115\n" +
            "62\n" +
            "61\n" +
            "153\n" +
            "78\n" +
            "138\n" +
            "43\n" +
            "88\n" +
            "108\n" +
            "59\n" +
            "152\n" +
            "109\n" +
            "63\n" +
            "42\n" +
            "60\n" +
            "7\n" +
            "104\n" +
            "49\n" +
            "156\n" +
            "35\n" +
            "2\n" +
            "52\n" +
            "72\n" +
            "125\n" +
            "94\n" +
            "46\n" +
            "136\n" +
            "26\n" +
            "16\n" +
            "76\n" +
            "117\n" +
            "116\n" +
            "150\n" +
            "20\n" +
            "13\n" +
            "141\n" +
            "131\n" +
            "127\n" +
            "67\n" +
            "3\n" +
            "40\n" +
            "54\n" +
            "82\n" +
            "36\n" +
            "100\n" +
            "41\n" +
            "56\n" +
            "146\n" +
            "157\n" +
            "89\n" +
            "23\n" +
            "8\n" +
            "55\n" +
            "111\n" +
            "135\n" +
            "144\n" +
            "77\n" +
            "124\n" +
            "18\n" +
            "53\n" +
            "92\n" +
            "126\n" +
            "101\n" +
            "69\n" +
            "27\n" +
            "145\n" +
            "11\n" +
            "151\n" +
            "31\n" +
            "19\n" +
            "34\n" +
            "17\n" +
            "130\n" +
            "118\n" +
            "28\n" +
            "107\n" +
            "137\n" +
            "68\n" +
            "93\n" +
            "85\n" +
            "66\n" +
            "97\n" +
            "110\n" +
            "37\n" +
            "114\n" +
            "79\n" +
            "121\n" +
            "1";


    static List<Long> parseInput(final String input) {
        return Arrays.asList(input.split("\n"))
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    static Map<Long, Integer> checkRule(final List<Long> input) {
        input.sort(Long::compareTo);
        Map<Long, Integer> differences = new HashMap<>();
        differences.put(1l, 1);
        differences.put(2l, 0);
        differences.put(3l, 1);

        for(int i=1;i<input.size();i++){
            Long diff = input.get(i)-input.get(i-1);
            differences.put(diff, differences.get(diff)+1);
            if(diff>3){
                return differences;
            }
        }
        return differences;
    }


    public static void main(final String[] args) {
        System.out.println(checkRule(parseInput(testInput)));
        System.out.println(checkRule(parseInput(input)));
    }

}
