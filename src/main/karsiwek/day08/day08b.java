package day08;

import day08.day08a.Instruction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

import static day08.day08a.parseInput;

public class day08b {

    static String testInput = "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";

    static String input = "acc +0\n" +
            "acc -11\n" +
            "acc -19\n" +
            "acc -18\n" +
            "jmp +356\n" +
            "nop +29\n" +
            "acc +22\n" +
            "jmp +619\n" +
            "jmp +97\n" +
            "acc -14\n" +
            "jmp +71\n" +
            "nop +54\n" +
            "nop +348\n" +
            "jmp +144\n" +
            "jmp +123\n" +
            "nop +27\n" +
            "acc +48\n" +
            "acc +3\n" +
            "acc +2\n" +
            "jmp +79\n" +
            "jmp +576\n" +
            "acc -7\n" +
            "acc +37\n" +
            "acc +37\n" +
            "jmp +478\n" +
            "acc +49\n" +
            "nop +600\n" +
            "acc +28\n" +
            "jmp +388\n" +
            "acc +6\n" +
            "jmp +232\n" +
            "acc -2\n" +
            "jmp +1\n" +
            "jmp +140\n" +
            "acc +36\n" +
            "acc -15\n" +
            "acc +21\n" +
            "acc +29\n" +
            "jmp +361\n" +
            "acc +4\n" +
            "acc -2\n" +
            "jmp +585\n" +
            "acc +44\n" +
            "acc -16\n" +
            "acc +42\n" +
            "acc -12\n" +
            "jmp +252\n" +
            "acc +0\n" +
            "acc +19\n" +
            "acc +7\n" +
            "acc +38\n" +
            "jmp +232\n" +
            "acc +14\n" +
            "acc +26\n" +
            "jmp +132\n" +
            "acc +46\n" +
            "acc -19\n" +
            "jmp +219\n" +
            "acc +45\n" +
            "acc -1\n" +
            "acc +23\n" +
            "jmp +376\n" +
            "acc +41\n" +
            "nop +2\n" +
            "jmp +55\n" +
            "acc +24\n" +
            "acc +43\n" +
            "acc -3\n" +
            "jmp -53\n" +
            "acc +2\n" +
            "acc +19\n" +
            "jmp +520\n" +
            "jmp +1\n" +
            "acc +9\n" +
            "acc -2\n" +
            "acc +40\n" +
            "jmp +284\n" +
            "acc +0\n" +
            "jmp +250\n" +
            "jmp +454\n" +
            "jmp +559\n" +
            "acc +22\n" +
            "nop +561\n" +
            "jmp +425\n" +
            "jmp +146\n" +
            "jmp +236\n" +
            "jmp +1\n" +
            "jmp +222\n" +
            "acc -19\n" +
            "acc -10\n" +
            "acc -8\n" +
            "jmp +399\n" +
            "nop +410\n" +
            "acc +49\n" +
            "acc -1\n" +
            "jmp +209\n" +
            "jmp -88\n" +
            "jmp +263\n" +
            "acc +0\n" +
            "acc -5\n" +
            "acc +31\n" +
            "jmp +438\n" +
            "acc -10\n" +
            "acc +37\n" +
            "jmp +404\n" +
            "acc +34\n" +
            "acc +49\n" +
            "acc +0\n" +
            "jmp -79\n" +
            "acc +23\n" +
            "acc +0\n" +
            "nop -23\n" +
            "acc +47\n" +
            "jmp -71\n" +
            "jmp +277\n" +
            "acc +37\n" +
            "nop +144\n" +
            "acc +16\n" +
            "jmp +248\n" +
            "nop +179\n" +
            "jmp +413\n" +
            "jmp +177\n" +
            "acc +18\n" +
            "acc +1\n" +
            "acc +36\n" +
            "acc -19\n" +
            "jmp +145\n" +
            "acc -8\n" +
            "acc +34\n" +
            "jmp +154\n" +
            "nop +174\n" +
            "acc +14\n" +
            "acc +17\n" +
            "jmp +272\n" +
            "acc +46\n" +
            "acc +17\n" +
            "jmp +219\n" +
            "acc -3\n" +
            "acc +1\n" +
            "nop -81\n" +
            "jmp +335\n" +
            "acc -4\n" +
            "acc -18\n" +
            "acc +11\n" +
            "jmp +139\n" +
            "nop +221\n" +
            "jmp +1\n" +
            "acc +1\n" +
            "jmp +295\n" +
            "acc -4\n" +
            "jmp +205\n" +
            "jmp +270\n" +
            "nop +87\n" +
            "acc +11\n" +
            "acc +37\n" +
            "nop +61\n" +
            "jmp +319\n" +
            "acc +39\n" +
            "acc -16\n" +
            "jmp +327\n" +
            "acc +34\n" +
            "acc -14\n" +
            "acc -5\n" +
            "nop -142\n" +
            "jmp +417\n" +
            "jmp +1\n" +
            "nop +467\n" +
            "acc +7\n" +
            "jmp -87\n" +
            "nop +186\n" +
            "nop +158\n" +
            "acc +44\n" +
            "jmp -157\n" +
            "jmp +281\n" +
            "acc +14\n" +
            "acc +29\n" +
            "acc +40\n" +
            "jmp +132\n" +
            "jmp +1\n" +
            "jmp +1\n" +
            "acc -18\n" +
            "jmp +345\n" +
            "jmp +1\n" +
            "acc +0\n" +
            "acc +49\n" +
            "jmp +9\n" +
            "acc +30\n" +
            "jmp +1\n" +
            "jmp +261\n" +
            "acc +38\n" +
            "acc +42\n" +
            "acc -6\n" +
            "nop +369\n" +
            "jmp +256\n" +
            "nop -173\n" +
            "jmp +6\n" +
            "acc +44\n" +
            "acc -4\n" +
            "acc +46\n" +
            "acc -2\n" +
            "jmp +229\n" +
            "jmp +1\n" +
            "acc +44\n" +
            "acc +26\n" +
            "jmp -74\n" +
            "acc +25\n" +
            "nop -55\n" +
            "acc -15\n" +
            "acc +24\n" +
            "jmp -90\n" +
            "acc +15\n" +
            "jmp +214\n" +
            "acc +48\n" +
            "nop -35\n" +
            "acc -1\n" +
            "jmp +287\n" +
            "jmp +249\n" +
            "acc -11\n" +
            "acc +36\n" +
            "nop +407\n" +
            "nop -75\n" +
            "jmp +405\n" +
            "acc -14\n" +
            "acc +9\n" +
            "acc -14\n" +
            "jmp -204\n" +
            "acc +34\n" +
            "acc +31\n" +
            "nop +171\n" +
            "jmp +63\n" +
            "acc +7\n" +
            "acc +1\n" +
            "acc +23\n" +
            "jmp -222\n" +
            "acc +17\n" +
            "acc -13\n" +
            "acc +13\n" +
            "acc -6\n" +
            "jmp +401\n" +
            "acc +15\n" +
            "acc -10\n" +
            "acc +38\n" +
            "jmp -146\n" +
            "acc +9\n" +
            "nop +155\n" +
            "jmp -211\n" +
            "acc -14\n" +
            "acc +41\n" +
            "nop +163\n" +
            "acc -16\n" +
            "jmp +54\n" +
            "acc +3\n" +
            "acc +1\n" +
            "jmp -108\n" +
            "acc +42\n" +
            "nop -77\n" +
            "acc -6\n" +
            "jmp -27\n" +
            "acc +12\n" +
            "jmp +231\n" +
            "jmp +321\n" +
            "jmp -39\n" +
            "acc +16\n" +
            "acc +41\n" +
            "acc +1\n" +
            "jmp -114\n" +
            "acc +10\n" +
            "acc -2\n" +
            "acc -18\n" +
            "acc +7\n" +
            "jmp +220\n" +
            "jmp +103\n" +
            "nop +144\n" +
            "acc +39\n" +
            "nop -186\n" +
            "jmp +85\n" +
            "acc -17\n" +
            "acc +5\n" +
            "acc +36\n" +
            "acc -14\n" +
            "jmp +369\n" +
            "acc +3\n" +
            "jmp +101\n" +
            "jmp +38\n" +
            "acc +16\n" +
            "acc +16\n" +
            "acc +49\n" +
            "acc +35\n" +
            "jmp +169\n" +
            "jmp +190\n" +
            "jmp +1\n" +
            "jmp -226\n" +
            "acc +15\n" +
            "jmp -83\n" +
            "acc -2\n" +
            "acc -1\n" +
            "acc +11\n" +
            "jmp -175\n" +
            "nop +305\n" +
            "acc +12\n" +
            "acc +34\n" +
            "nop +153\n" +
            "jmp +294\n" +
            "jmp -189\n" +
            "acc +8\n" +
            "jmp +334\n" +
            "acc +23\n" +
            "acc +48\n" +
            "jmp +146\n" +
            "jmp -63\n" +
            "nop +329\n" +
            "acc +25\n" +
            "nop -3\n" +
            "acc +4\n" +
            "jmp -209\n" +
            "acc +39\n" +
            "acc +30\n" +
            "acc +22\n" +
            "acc +35\n" +
            "jmp +292\n" +
            "jmp +29\n" +
            "acc +14\n" +
            "acc +48\n" +
            "acc -2\n" +
            "jmp +92\n" +
            "acc +25\n" +
            "acc +3\n" +
            "jmp +72\n" +
            "nop +180\n" +
            "acc +7\n" +
            "jmp +1\n" +
            "acc +18\n" +
            "jmp -159\n" +
            "jmp +181\n" +
            "acc +15\n" +
            "jmp -46\n" +
            "acc -7\n" +
            "acc +46\n" +
            "acc +25\n" +
            "jmp +252\n" +
            "acc -2\n" +
            "acc +50\n" +
            "acc +24\n" +
            "acc -2\n" +
            "jmp -272\n" +
            "acc +20\n" +
            "acc +38\n" +
            "acc -17\n" +
            "jmp +12\n" +
            "acc -2\n" +
            "jmp +136\n" +
            "acc +14\n" +
            "acc +32\n" +
            "acc +50\n" +
            "jmp -83\n" +
            "acc +35\n" +
            "acc -10\n" +
            "jmp -118\n" +
            "acc +4\n" +
            "jmp -325\n" +
            "jmp +136\n" +
            "acc -5\n" +
            "nop +164\n" +
            "acc -8\n" +
            "acc -8\n" +
            "jmp +174\n" +
            "jmp -38\n" +
            "jmp +108\n" +
            "nop -8\n" +
            "acc +8\n" +
            "jmp +196\n" +
            "nop -234\n" +
            "acc +47\n" +
            "jmp +260\n" +
            "acc +31\n" +
            "acc +26\n" +
            "acc -8\n" +
            "jmp +96\n" +
            "acc +0\n" +
            "nop -294\n" +
            "acc +3\n" +
            "acc +0\n" +
            "jmp -330\n" +
            "nop +1\n" +
            "acc +32\n" +
            "acc +36\n" +
            "jmp +160\n" +
            "nop -201\n" +
            "acc +24\n" +
            "acc +48\n" +
            "jmp -114\n" +
            "acc +32\n" +
            "nop +251\n" +
            "jmp +233\n" +
            "acc +22\n" +
            "nop -330\n" +
            "acc +8\n" +
            "jmp +1\n" +
            "jmp +67\n" +
            "nop +115\n" +
            "nop -304\n" +
            "jmp +171\n" +
            "acc +2\n" +
            "acc +7\n" +
            "jmp -55\n" +
            "nop +186\n" +
            "jmp +214\n" +
            "acc +12\n" +
            "nop -148\n" +
            "nop -388\n" +
            "jmp -232\n" +
            "acc -11\n" +
            "acc +1\n" +
            "jmp -98\n" +
            "acc +39\n" +
            "jmp -250\n" +
            "jmp -337\n" +
            "nop -388\n" +
            "acc +49\n" +
            "acc +45\n" +
            "jmp -54\n" +
            "acc +17\n" +
            "acc -8\n" +
            "jmp -57\n" +
            "jmp +209\n" +
            "jmp -231\n" +
            "jmp +1\n" +
            "jmp +1\n" +
            "jmp -124\n" +
            "acc +49\n" +
            "acc +17\n" +
            "jmp +1\n" +
            "acc +45\n" +
            "jmp -84\n" +
            "acc +3\n" +
            "acc -3\n" +
            "jmp -402\n" +
            "jmp +1\n" +
            "acc -8\n" +
            "acc -7\n" +
            "acc +17\n" +
            "jmp -30\n" +
            "jmp +54\n" +
            "acc +2\n" +
            "jmp +1\n" +
            "jmp +75\n" +
            "nop -224\n" +
            "acc +16\n" +
            "jmp -270\n" +
            "acc +43\n" +
            "acc +34\n" +
            "jmp -68\n" +
            "acc +45\n" +
            "jmp -4\n" +
            "acc +23\n" +
            "jmp -421\n" +
            "jmp -152\n" +
            "acc +47\n" +
            "acc -19\n" +
            "jmp -361\n" +
            "jmp -259\n" +
            "acc +20\n" +
            "acc +0\n" +
            "jmp -187\n" +
            "jmp -188\n" +
            "nop +10\n" +
            "nop -368\n" +
            "acc -5\n" +
            "jmp -403\n" +
            "acc +45\n" +
            "acc -12\n" +
            "nop -357\n" +
            "jmp -51\n" +
            "jmp -139\n" +
            "jmp -258\n" +
            "nop -464\n" +
            "acc +49\n" +
            "jmp +37\n" +
            "jmp -359\n" +
            "acc +30\n" +
            "jmp -315\n" +
            "acc -9\n" +
            "acc +5\n" +
            "acc +28\n" +
            "acc +5\n" +
            "jmp -187\n" +
            "acc -9\n" +
            "acc +47\n" +
            "jmp -133\n" +
            "jmp +50\n" +
            "acc +19\n" +
            "acc +8\n" +
            "jmp -81\n" +
            "acc -3\n" +
            "acc +18\n" +
            "jmp -265\n" +
            "nop -53\n" +
            "jmp +1\n" +
            "jmp -164\n" +
            "acc +44\n" +
            "nop -322\n" +
            "jmp -76\n" +
            "acc -17\n" +
            "acc +42\n" +
            "acc +8\n" +
            "acc +2\n" +
            "jmp -421\n" +
            "jmp -285\n" +
            "acc +41\n" +
            "acc -2\n" +
            "jmp +133\n" +
            "acc +13\n" +
            "nop -47\n" +
            "jmp -340\n" +
            "acc +40\n" +
            "acc -16\n" +
            "jmp +1\n" +
            "acc +13\n" +
            "jmp +115\n" +
            "jmp +77\n" +
            "acc -10\n" +
            "acc -9\n" +
            "acc -16\n" +
            "acc +17\n" +
            "jmp -264\n" +
            "jmp -126\n" +
            "acc +49\n" +
            "jmp -98\n" +
            "acc +26\n" +
            "acc -19\n" +
            "acc +24\n" +
            "acc +34\n" +
            "jmp -338\n" +
            "acc +13\n" +
            "jmp -242\n" +
            "acc +7\n" +
            "acc -5\n" +
            "nop -233\n" +
            "jmp -234\n" +
            "acc -12\n" +
            "acc +4\n" +
            "jmp +62\n" +
            "acc +9\n" +
            "nop -485\n" +
            "acc +9\n" +
            "jmp -236\n" +
            "jmp +1\n" +
            "acc -16\n" +
            "acc +20\n" +
            "nop -497\n" +
            "jmp +11\n" +
            "acc +41\n" +
            "acc +8\n" +
            "acc +0\n" +
            "acc +49\n" +
            "jmp -172\n" +
            "acc +0\n" +
            "acc +0\n" +
            "acc +23\n" +
            "jmp -501\n" +
            "jmp -495\n" +
            "nop -285\n" +
            "acc +22\n" +
            "acc +36\n" +
            "jmp -103\n" +
            "jmp -513\n" +
            "acc +0\n" +
            "acc +0\n" +
            "jmp -480\n" +
            "nop -254\n" +
            "acc +31\n" +
            "jmp -96\n" +
            "acc +9\n" +
            "acc +18\n" +
            "acc +27\n" +
            "acc +0\n" +
            "jmp -431\n" +
            "acc +34\n" +
            "acc +31\n" +
            "nop -104\n" +
            "jmp -66\n" +
            "acc -5\n" +
            "acc +30\n" +
            "acc +21\n" +
            "nop -362\n" +
            "jmp -471\n" +
            "acc +7\n" +
            "acc +14\n" +
            "acc +47\n" +
            "nop -184\n" +
            "jmp -561\n" +
            "acc -1\n" +
            "jmp -36\n" +
            "acc +42\n" +
            "acc +17\n" +
            "jmp -306\n" +
            "acc +3\n" +
            "acc -11\n" +
            "acc +15\n" +
            "acc +40\n" +
            "jmp -481\n" +
            "acc +30\n" +
            "jmp -537\n" +
            "acc +45\n" +
            "nop -358\n" +
            "jmp -322\n" +
            "nop -169\n" +
            "nop -298\n" +
            "acc +14\n" +
            "acc +0\n" +
            "jmp +23\n" +
            "acc -14\n" +
            "acc +43\n" +
            "nop -111\n" +
            "jmp -492\n" +
            "acc +43\n" +
            "acc +19\n" +
            "acc +44\n" +
            "acc +9\n" +
            "jmp -365\n" +
            "acc +25\n" +
            "acc +24\n" +
            "acc +5\n" +
            "acc +0\n" +
            "jmp -256\n" +
            "jmp -488\n" +
            "acc +17\n" +
            "jmp -170\n" +
            "nop -17\n" +
            "acc +50\n" +
            "acc +5\n" +
            "nop -494\n" +
            "jmp -292\n" +
            "jmp -234\n" +
            "acc +42\n" +
            "acc -1\n" +
            "nop -365\n" +
            "acc -15\n" +
            "jmp -47\n" +
            "jmp +1\n" +
            "acc -9\n" +
            "jmp -286\n" +
            "jmp -523\n" +
            "acc -13\n" +
            "acc +1\n" +
            "acc +27\n" +
            "acc +0\n" +
            "jmp -393\n" +
            "jmp -327\n" +
            "acc -4\n" +
            "acc +37\n" +
            "nop -375\n" +
            "acc +38\n" +
            "jmp +1";


    static int runProgram(final List<Instruction> code, int acc) {
       final Set<Integer> parsedLines = new HashSet<>();
       int i=0;
       int di = 0;

       while(true) {
           parsedLines.add(i);
            System.out.println(String.format("%s> %s", i, code.get(i)));
           switch (code.get(i).getOperation()) {
               case "nop":
                  di=1;
                  break;
               case "acc":
                   di=1;
                   acc+=code.get(i).getArgument();
                   break;
               case "jmp":
                   di=code.get(i).getArgument();
                   break;
           }
           if(parsedLines.contains(i+ di)){
               throw new IllegalStateException(String.valueOf(acc));
           }
           i+=di;

           if(di==1 && i==code.size()){
               return acc;
           }
       }
    }

    public static int fixProgram(List<Instruction> input) {

        for(int i=0;i<input.size();i++) {
            try {
                if (input.get(i).getOperation().equals("jmp")) {
                    System.out.println("FIXING CANDIDATE " + i);
                    List<Instruction> fixedCandidate = new ArrayList<>();
                    fixedCandidate.addAll(input);

                    fixedCandidate.remove(i);
                    fixedCandidate.add(i, new Instruction("nop", 0));
                    return runProgram(fixedCandidate, 0);
                } else if (input.get(i).getOperation().equals("nop")) {
                    System.out.println("FIXING CANDIDATE " + i);
                    List<Instruction> fixedCandidate = new ArrayList<>();
                    fixedCandidate.addAll(input);

                    fixedCandidate.remove(i);
                    fixedCandidate.add(i, new Instruction("jmp", input.get(i).getArgument()));
                    return runProgram(fixedCandidate, 0);
                }
            } catch (IllegalStateException ex){
                continue;
            }

        }
        return 0;
    }

    public static void main(final String[] args) {
        System.out.println(fixProgram(parseInput(input)));
    }

}
