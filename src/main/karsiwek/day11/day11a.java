package day11;

import kotlin.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class day11a {

    static String testInput = "L.LL.LL.LL\n" +
            "LLLLLLL.LL\n" +
            "L.L.L..L..\n" +
            "LLLL.LL.LL\n" +
            "L.LL.LL.LL\n" +
            "L.LLLLL.LL\n" +
            "..L.L.....\n" +
            "LLLLLLLLLL\n" +
            "L.LLLLLL.L\n" +
            "L.LLLLL.LL";

    static String input = "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLL.LL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLL.L.LLLLLLLLLLLLLLL.LLLL.LLL\n" +
            ".LLLLLLLL.LL.L.LLLLLLLLL.LLLLLLL.L.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLL.L.LLLLL.L.LLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL...LL.LLLLLLLL..LLLLLLLLL.L..LLLLLLLLLLLLLLLLLLLLLLLL.LLL..LLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLL.LLLLLL.LLLLLLLLL.LL.LLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLL..LLLLL.LLLLLL...LLLLLLL.LLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LL\n" +
            "LLLLLLL.LLLLLL.LLLLLLLL..LLLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLL.LLLL.LLLLLL.L\n" +
            ".LLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLL.LLLL.LLLLLLLLL.LL.L.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLL.LL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLL.LLLLL\n" +
            "LLL.LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLL..L..LLLLLLL.LLLLLLL\n" +
            "L.....L..L....LLLL......L.L....LLLL..L...L..LL..........L...LL..LL.LLL..L.LL...LL.L...L.L....L..\n" +
            "LLLLLLLLL.LLLLLLLLLLL.LLLLLLLLLLLL.LLLLLL.L.LLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLL.LLLLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LL.LL.LL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLL.LLL.LLLL.LLLL.LLLLLL.L.LLL.LLLL.LLLLLL.LLLLLLL.LLLLLLLLL.LLLLL.L.L.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLL..LLLLLLLL.LLLLLLLLLLLLLL.LLL.LLL.L.LL.LLLLLL.LL.LLLLL\n" +
            ".L..L....LLL...LL.L.LL......L........LL...L..L..LL.......L....L.L.LLL......LL..L..L.....LLL.....\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLL.LLLL.LL.LLLLLLLLLLLLLLLL.LLLLL.LL\n" +
            "LLLLLL.LL.LLLLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "L.LLLLLLL..LLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL..LLLLLL.L.LLLLLLLL\n" +
            "LL.LLLLLL..LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLL.LLLLL.LLLL.L.LL.LLLL.LL.LLLLLL.LLLLLLLL\n" +
            "LL.LLLLLLLLLLL.LLLLL.LLL.LLLLLLLL..LLLLLLLL.LL..LLLL.LLLLLLLL..LLLLLLLLLLLLLLLLL.L.LLL..LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLL.LLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLL.LLLLLLLL\n" +
            "LLLLLLL.L.LLLL.LLLLLLLLLL.LLLLL.LL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLL.LLLLL.LLLL.LLLLLLLLLLLLL\n" +
            "LL.LLL....L....L.L....LL...L......L.....LL.LL.LLL....L.LL........L.LL..L.LLLL.LLL.LLLLLLL.L..L..\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLL.LLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLL.LLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLL.LL.LLLLLLLL\n" +
            "LLLLL.LLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLL.LLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.L.LLLLLLLLLL.LLL.L\n" +
            "LLLLLLLLL.LLLL.LLLLLL..L.LLLLLLLLLLL.LL.LLLLL.LLLLLL.LL.LLLLLL.LLLL.LLLLLLLLLLLL.LLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.L.LLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            "LLL.LLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLL.LLLL.LLLLLL.LL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLL.LLLL.LLLLLLLLL.LL.LLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            ".L.LL....L.....LL...L.....LL..LL.........L.L..L.......LL...L.L......L........L...L.....L.....LL.\n" +
            "LLLLLLLLLLLLLL.LLLLLLL.L.LLLLLLLLL.LLLLLLLL.LLLLLLL..LLLLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLL.LL.LLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL..LLLLLLL\n" +
            "LLL.LLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            ".LLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLL..LLL.LLLL.LLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLL.LLLLL.LLLLLLL.L.LLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLL.LLLLL.LLL.LLLLLLLLL..LLLLLLL\n" +
            "L....L..L...L....L.....L...L...L......L.LL.L....L.L.......L.LL.LL.LL....L...LLL...LL...LLL...L.L\n" +
            "LLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.L.LLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL..LLLLLLLLLLLLLLLL.LLLLLLLLL.L.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LL.LLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLL.LLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLL.LLLLLLLLLLL.LLLLLLLL\n" +
            ".LLLLLLLL.LL.L.LLLLLLLLL.LLLLLLL...LLLLLLLLLLL.LLLLLLLLLLLLLLL.LLLL.LLLLLLLLL..LLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLL.LL.LLLLLLLLL.LLLLLLLLLLLLL.LLLL.LLLL.LLLLLLLLLLL.LLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLL.LLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLL.LLLL.L.LLLLLLL.LLLLLLLLL.LLLL.LLL\n" +
            "LL.LLLLLL.LL.L.L.LLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL..LLLLLLL.\n" +
            "LLLLLLL.L.LLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            "LL......LLL.L......LL.LLL.....L..L.........L....L..L....L.L....L...L..L...L...L..L..L....L......\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLL.L.L.LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLL..LLLLLLLLLLLLLLL.LLL.LLLLLLLL.LLLLLLLL.LLLLLLL.L.LLLL.LLLLLLL.L.LLLLLLL.L.LLLLLLLL\n" +
            "LL.LL.LLLLLLLLLLLLLLLLLL.LLLLLLLLL..LLLLLLL.LLLLLLLL.LLLLLLLL..L.LLLLLLLLL.LLLLLLLLLLLL.LLLLLLL.\n" +
            "LLLL.LLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.L.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLL.LLLL.LLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            ".LLLLLL.L.L...L.L.....L..L......LLL..L..L.L..LLL....LLL......L........LL..L.L....LL.L..L.L......\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLL.LLLLLLLLLL.LLLL.LL.L.L.LLLLLL..LLLLLLL.\n" +
            "LLLLLLLLLLLLLL.LLL.LLLLL.LLLLLLLLL.LLLLLLLL.LL.LLLL..LLLLLLLLL.LLLL.LLLLLLLLLLLLL.LLLLLLLLLLLLLL\n" +
            "LLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL..LLLLL.LL.LLLLLLLLLLL.LLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL..LLLLLLLL.L.LLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLL..LLLLLLL\n" +
            "LLLLLLLLL.LL.L.LLLLL.LLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LL.LLLLL\n" +
            "....L.LLLLL......L.LL....L.L...L..LL...LLL.LLLL...LL.L.L....L.LL...L.......L...L.L..LL.........L\n" +
            "LLLLLL.LL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLL.LLLLLLLLLLLLLLL.L.LLLLLLLL.LLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLL.LL.LLLLLLLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLL..LLLLLLLL.LLLLLLLLLL.LLL.LLL.LLLL.LLLLL.L.L.LLLLLLL.L.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLL.L.LLLLLLLLL..LL.LLLL.LLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LL........L.....L....L..L...L.LLL........L.....L...L.......L.....L..L.L........L.L..L....LL.L.L.\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLL.LLLL\n" +
            "LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL..LLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLL.L.LL.LLLLLLLL.L.LLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLL.LL.L.LLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLL.LLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLL.LLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.L.LL.LLLLLLLLLLLLLL.LLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLL..LLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLL...LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LL.LLLLLLLL.LLLLL.LLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.\n" +
            "...........LL.L.L.LLL..LL.L..L...LL.L.L........LL.L..L.....L..L...L.L....L.LL..LL..L.L.LL..LL..L\n" +
            "LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLL.LL.LLLLLLLL.LLLLL.LLLLLLLLL.LLLLL.LL.LLLLLLLL.LLLLLLLLL.LLLL.LLLLLLL.L.L.LLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.L.LLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLLLLLLL.LLL..LLLLLLLLL..LLLLLLLL.LLL.LLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLL.LLLLLL.LL.LLLLLLLL.LLLL.LLL.LLLLLLLLL.L.LLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL\n" +
            "LLLLLLLLLLLLLLL.LLLLLLLL.LLL.LLLLLLLLLLLLLL.L.LLLLLL.LLLLLLLLL.LLLL.LLLLLLLLLLLLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLL.LLLLLLLLLLL\n" +
            "LLLLLLLLL.LLLLL.LLLLLLLL.LLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLL.L.LL..LLLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLL.LLLL..LLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLLLLLL\n" +
            "LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLL.LLLLLLLL.LLLLLLLLLLLLLL.L.LLLLLLL..LLLLLLLLL.L.LL.LL\n" +
            "LLLLLLLLL.LLLLLLLLLLLLLL.LLLLLLLLLLLLLLLLLLLLLLLLLLL.LLLLLLLLL.LLLL.LLLLLLLLL.LLLLLLLLL.LLLL.L.L\n" +
            "LLLLLLLLL.LL.L.LLLLLLLLL.LLLLLL.LL.LLLLLLLL.LLLLLLLLLLLLLLLLLL.LLL.LLLLLLLLLLLLLLLLLLLL.LL..LLLL";


    static Map<Pair<Integer, Integer>, String> parseInput(final String input) {
        List<List<String>> board = Arrays.asList(input.split("\n"))
                .stream()
                .map(line -> Arrays.stream(line.split("")).collect(Collectors.toList()))
                .collect(Collectors.toList());

        Map<Pair<Integer, Integer>, String> result = new HashMap<>();
        for(int i=0;i<board.size();i++){
            for(int j=0;j<board.get(i).size();j++){
                result.put(new Pair<>(i,j), board.get(i).get(j));
            }
        }
        return result;
    }

    static Map<Pair<Integer, Integer>, String> gameTick(Map<Pair<Integer, Integer>, String> board) {
        Map<Pair<Integer, Integer>, String> result = new HashMap<>();

        for(Pair<Integer, Integer> key : board.keySet()) {
            int occupied = 0;
            for(int i=key.getFirst()-1;i<=key.getFirst()+1; i++){
                for(int j=key.getSecond()-1;j<=key.getSecond()+1;j++){
                    if(i==key.getFirst() && j==key.getSecond()) {
                        continue;
                    }

                    if(board.get(new Pair<>(i,j))=="#") {
                        occupied++;
                    }
                }
            }

            if(board.get(key).equals("L") && occupied==0) {
                result.put(key, "#");
            } else if (board.get(key).equals("#") && occupied>=4){
                result.put(key, "L");
            } else {
                result.put(key, board.get(key));
            }
        }

        return result;
    }

    static  void printBoard(Map<Pair<Integer, Integer>, String> board) {
        int i=0,j=0;

        while(true){
            if(!board.containsKey(new Pair<>(i,j))){
                if(j==0) {
                    return;
                } else {
                    System.out.println("");
                    j=0;
                    i++;
                    continue;
                }

            }
            System.out.print(board.get(new Pair<>(i,j)));
            j++;
        }
    }

    static Boolean areBoardsSame(Map<Pair<Integer, Integer>, String> board1, Map<Pair<Integer, Integer>, String> board2) {
        if(!board1.keySet().containsAll(board2.keySet()) || board1.keySet().size() != board2.keySet().size()){
            return false;
        }

        for(Pair<Integer, Integer> key : board1.keySet()) {
            if(!board1.get(key).equals(board2.get(key))){
                return false;
            }
        }
        return true;
    }

    public static void main(final String[] args) {
        Map<Pair<Integer, Integer>, String> board = new HashMap<>();
        Map<Pair<Integer, Integer>, String> newBoard = parseInput(input);

        while (!areBoardsSame(board, newBoard)) {
            board = newBoard;
            newBoard = gameTick(board);

            printBoard(newBoard);
        }

        System.out.println(newBoard.values().stream().filter(seat -> seat.equals("#")).count());
    }

}