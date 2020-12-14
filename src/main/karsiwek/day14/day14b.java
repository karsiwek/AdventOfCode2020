package day14;


import java.util.*;
import java.util.stream.Collectors;

public class day14b {


    static String testInput = "mask = 000000000000000000000000000000X1001X\n" +
            "mem[42] = 100\n" +
            "mask = 00000000000000000000000000000000X0XX\n" +
            "mem[26] = 1";
    static Long parseInput(final String input) {
        List<String> program = Arrays.asList(input.split("\n"));
        Map<Long, Long> memory = new HashMap<>();
        String mask = "";
        for(String line : program) {
            if(line.split(" = ")[0].equals("mask")){
                mask = line.split(" = ")[1];
            } else {
                long addr = Long.parseLong(line.substring(line.indexOf("[")+1, line.indexOf("]")));
                long value = Long.parseLong(line.substring(line.indexOf("=")+2));



                List<Long> addressesAfterMask = getAllValues(getAddressAfterMask(addr, mask)).stream()
                        .map(elem -> Long.parseLong(elem, 2))
                        .collect(Collectors.toList());

                addressesAfterMask.forEach(elem -> memory.put(elem, value));
            }
        }

        return  memory.values().stream().reduce(0l, (a,b) -> a+b);


    }

    private static List<String> getAllValues(String mask) {
        List<String> results = new ArrayList<>();
        for(int i=0;i<mask.length();i++){
            if(mask.substring(i, i+1).equals("X")) {
                results.addAll(getAllValues(mask.substring(0, i) + "0" + ((i>mask.length()-1)? "" : mask.substring(i+1))));
                results.addAll(getAllValues(mask.substring(0, i) + "1" + ((i>mask.length()-1)? "" : mask.substring(i+1))));
                return results;

            }
        }

        return Arrays.asList(mask);
    }

    private static String getAddressAfterMask(long address, String mask) {

        String addressString = Long.toBinaryString(address);


        while(mask.length() > addressString.length()) {
            addressString = "0" + addressString;
        }

        for(int i=mask.length()-1;i>=0;i--) {
            if(mask.substring(i, i+1).equals("1") || mask.substring(i, i+1).equals("X")) {
                addressString = addressString.substring(0, i) + mask.substring(i, i+1) + addressString.substring(i+1);
            }
        }

        return addressString;
    }

    public static void main(final String[] args) {
//        System.out.println(getAllMasksOfType("01XXXX0X"));
//        System.out.println(getValueAfterMask(0l, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"));
//        System.out.println(getValueAfterMask(101l, "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"));

        System.out.println(parseInput(testInput));
        System.out.println(parseInput(day14a.input));
    }


}

//404529744648 to low
