package day11;

import kotlin.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static day11.day11a.*;


public class day11b {

    static Map<Pair<Integer, Integer>, String> gameTick2(Map<Pair<Integer, Integer>, String> board) {
        Map<Pair<Integer, Integer>, String> result = new HashMap<>();

        for(Pair<Integer, Integer> key : board.keySet()) {

            int occupied=checkVisibleSeats(board, key);

            if(board.get(key).equals("L") && occupied==0) {
                result.put(key, "#");
            } else if (board.get(key).equals("#") && occupied>=5){
                result.put(key, "L");
            } else {
                result.put(key, board.get(key));
            }
        }

        return result;
    }


    private static int checkVisibleSeats(Map<Pair<Integer, Integer>, String> board, Pair<Integer, Integer> key) {
        int occupied = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                occupied += checkSeatsInDirection(board, key, dx, dy);
            }
        }
        return occupied;
    }

        private static int checkSeatsInDirection(Map<Pair<Integer, Integer>, String> board, Pair<Integer, Integer> key, int dx, int dy) {
            Pair<Integer, Integer> consideredPlace = new Pair<>(key.getFirst() + dx, key.getSecond() + dy);

            while (board.containsKey(consideredPlace) && board.get(consideredPlace).equals(".")) {
                consideredPlace = new Pair<>(consideredPlace.getFirst()+dx, consideredPlace.getSecond()+dy);
            }

            return board.getOrDefault(consideredPlace, ".").equals("#")? 1:0;
        }

    public static void main(final String[] args) {
        Map<Pair<Integer, Integer>, String> board = new HashMap<>();
        Map<Pair<Integer, Integer>, String> newBoard = parseInput(input);

        while (!areBoardsSame(board, newBoard)) {
            board = newBoard;
            newBoard = gameTick2(board);

            printBoard(newBoard);
        }

        System.out.println(newBoard.values().stream().filter(seat -> seat.equals("#")).count());
    }



}
