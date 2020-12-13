package day13;

import java.util.*;
import java.util.stream.Collectors;

public class day13a {

    static String testInput = "939\n" +
            "7,13,x,x,59,x,31,19";
    static String testInput1 = "939\n" +
            "17,x,13,19";
    static String testInput2 = "939\n" +
            "67,7,59,61";
    static String testInput3 = "939\n" +
            "67,x,7,59,61";
    static String testInput4 = "939\n" +
            "67,7,x,59,61";
    static String testInput5 = "939\n" +
            "1789,37,47,1889";

    static String input = "1002632\n" +
            "23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,829,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,677,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19";

    static Long parseInput(final String input) {
        List<String> bussesString = Arrays.asList(input.split("\n")[1].split(","));

        Map<Integer, Integer> busses = new HashMap<>();

        for(int i=0;i<bussesString.size();i++){
            if(bussesString.get(i).equals("x")) {
                continue;
            }
            busses.put(Integer.parseInt(bussesString.get(i)), i);
        }

        List<Integer> sortedBusNumbers = busses.keySet().stream().collect(Collectors.toList());
        sortedBusNumbers.sort(Integer::compareTo);

        Long jmp = sortedBusNumbers.get(0).longValue();
        Long pos = 0l;
        int okNb = 0;
        int maxNb = sortedBusNumbers.get(sortedBusNumbers.size()-1);


        while (okNb<maxNb){
            pos+=jmp;
            jmp=1l;
            for(Integer busNb: sortedBusNumbers){
                if((pos+busses.get(busNb))%busNb == 0) {
                    okNb = busNb;
                    jmp*=busNb.longValue();
                } else {
                    break;
                }
            }
        System.out.println(pos);
        }

        return pos;




    }

    public static void main(final String[] args) {
        System.out.println(parseInput(input));
    }


}
//237155040905 // to low
//600689120448303 ok