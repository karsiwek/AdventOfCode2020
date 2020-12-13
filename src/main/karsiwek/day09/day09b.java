package day09;

import java.util.List;

import static day09.day09a.*;

public class day09b {

    public static Long findConsecutiveNumbersToProduce(List<Long> input, Long targetSum) {
        for(int i=0;i<input.size();i++){
            Long sum = input.get(i);
            for(int j=i+1; j<input.size() && sum<targetSum;j++){
                sum+=input.get(j);
                if(sum.equals(targetSum)){
                    return input.subList(i, j).stream().min(Long::compareTo).get()
                            +                    input.subList(i, j).stream().max(Long::compareTo).get();
                }
            }
        }
        return 0l;
    }

    public static void main(final String[] args) {
        System.out.println(findConsecutiveNumbersToProduce(parseInput(input), 248131121l));
        System.out.println(findConsecutiveNumbersToProduce(parseInput(testInput), 127l));
    }
}
