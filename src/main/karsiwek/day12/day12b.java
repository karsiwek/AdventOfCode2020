package day12;

import kotlin.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static day11.day11a.*;


public class day12b {
    static int parseInput(final String input) {
        List<String> instructions = Arrays.asList(input.split("\n"))
                .stream()
                .filter(line -> !line.isBlank())
                .map(line -> line.trim())
                .collect(Collectors.toList());

       WaypontShip ship = new WaypontShip();

        for(String instruction : instructions) {
            String command = instruction.substring(0,1);
            Integer value = Integer.parseInt(instruction.substring(1));

            switch (command) {
                case "F" :
                    ship.forward(value);
                    break;
                case "L" :
                    ship.turnLeft(value/90);
                    break;
                case  "R" :
                    ship.turnRight(value/90);
                    break;
                default:
                    ship.move(day12a.Direction.valueOf(command), value);
            }
        }
        return ship.getDistance();
    }

    public static void main(final String[] args) {
        System.out.println(parseInput(day12a.input));
    }


    public static class WaypontShip {
        int x,y;
        int wx, wy;

        public WaypontShip() {
            x = 0;
            y=0;
            wx = 10;
            wy =1;
        }

        public void turnLeft(int times) {
            for(int i=0;i<times;i++){
                turnLeft();
            }
        }

        public void turnRight(int times) {
            turnLeft(4-times);
        }

        public int getDistance() {
            return Math.abs(x)+Math.abs(y);
        }

        public void move(day12a.Direction direction, int dist) {
            switch (direction) {
                case N:
                    wy+=dist;
                    return;
                case W:
                    wx-=dist;
                    return;
                case S:
                    wy-=dist;
                    return;
                case E:
                    wx+=dist;
            }
        }

        public void forward(int dist) {
            x=x+wx*dist;
            y = y+wy *dist;
        }

        private void turnLeft() {
            int tmp = wy;
            wy = wx;
            wx = -tmp;
        }
    }
}
