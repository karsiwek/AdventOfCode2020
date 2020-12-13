package day12;

import kotlin.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class day12a {

    static String testInput = "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";

    static String input = "F29\n" +
            "E5\n" +
            "L90\n" +
            "W1\n" +
            "R90\n" +
            "E1\n" +
            "R90\n" +
            "W5\n" +
            "F32\n" +
            "E2\n" +
            "S3\n" +
            "R270\n" +
            "F61\n" +
            "R180\n" +
            "R180\n" +
            "E2\n" +
            "F13\n" +
            "R180\n" +
            "F18\n" +
            "L180\n" +
            "F15\n" +
            "N2\n" +
            "S2\n" +
            "R270\n" +
            "N2\n" +
            "F81\n" +
            "W4\n" +
            "N2\n" +
            "E1\n" +
            "N5\n" +
            "F5\n" +
            "N3\n" +
            "R90\n" +
            "W5\n" +
            "S1\n" +
            "F20\n" +
            "L90\n" +
            "S2\n" +
            "R90\n" +
            "F81\n" +
            "S2\n" +
            "E1\n" +
            "F59\n" +
            "N1\n" +
            "L180\n" +
            "W3\n" +
            "R90\n" +
            "E5\n" +
            "F2\n" +
            "R90\n" +
            "F28\n" +
            "R90\n" +
            "F70\n" +
            "L180\n" +
            "S4\n" +
            "L90\n" +
            "F97\n" +
            "W2\n" +
            "R180\n" +
            "S5\n" +
            "F12\n" +
            "N4\n" +
            "L90\n" +
            "F47\n" +
            "R90\n" +
            "F20\n" +
            "W3\n" +
            "S2\n" +
            "E2\n" +
            "F29\n" +
            "S2\n" +
            "L90\n" +
            "S1\n" +
            "L180\n" +
            "F92\n" +
            "L90\n" +
            "S4\n" +
            "W3\n" +
            "L90\n" +
            "W5\n" +
            "F56\n" +
            "N3\n" +
            "L90\n" +
            "S4\n" +
            "F83\n" +
            "S2\n" +
            "F82\n" +
            "W4\n" +
            "F34\n" +
            "R90\n" +
            "N5\n" +
            "F85\n" +
            "R90\n" +
            "F17\n" +
            "R90\n" +
            "F15\n" +
            "W1\n" +
            "L90\n" +
            "F55\n" +
            "S3\n" +
            "F38\n" +
            "W1\n" +
            "F38\n" +
            "S3\n" +
            "W1\n" +
            "N1\n" +
            "F77\n" +
            "R180\n" +
            "S5\n" +
            "F89\n" +
            "L90\n" +
            "F62\n" +
            "N4\n" +
            "R90\n" +
            "E3\n" +
            "L180\n" +
            "E2\n" +
            "F44\n" +
            "S4\n" +
            "R90\n" +
            "W2\n" +
            "L180\n" +
            "S4\n" +
            "R90\n" +
            "N5\n" +
            "F30\n" +
            "S5\n" +
            "R90\n" +
            "F88\n" +
            "R90\n" +
            "F10\n" +
            "L90\n" +
            "N5\n" +
            "F45\n" +
            "E5\n" +
            "F51\n" +
            "W5\n" +
            "N3\n" +
            "E3\n" +
            "F93\n" +
            "E5\n" +
            "F85\n" +
            "N5\n" +
            "L90\n" +
            "F6\n" +
            "W4\n" +
            "N3\n" +
            "F25\n" +
            "L90\n" +
            "E2\n" +
            "S4\n" +
            "W1\n" +
            "R180\n" +
            "E4\n" +
            "S3\n" +
            "E2\n" +
            "F26\n" +
            "N3\n" +
            "E3\n" +
            "F32\n" +
            "N3\n" +
            "L90\n" +
            "F25\n" +
            "L180\n" +
            "E3\n" +
            "F46\n" +
            "F12\n" +
            "N3\n" +
            "W4\n" +
            "L90\n" +
            "S2\n" +
            "L90\n" +
            "F31\n" +
            "W4\n" +
            "F75\n" +
            "L180\n" +
            "E3\n" +
            "F79\n" +
            "R90\n" +
            "N5\n" +
            "L270\n" +
            "W5\n" +
            "L180\n" +
            "S5\n" +
            "F19\n" +
            "N2\n" +
            "F90\n" +
            "L180\n" +
            "W3\n" +
            "S4\n" +
            "E2\n" +
            "F85\n" +
            "N1\n" +
            "F62\n" +
            "W4\n" +
            "F77\n" +
            "L180\n" +
            "W1\n" +
            "N2\n" +
            "L90\n" +
            "F86\n" +
            "R90\n" +
            "W5\n" +
            "F34\n" +
            "E1\n" +
            "F72\n" +
            "R90\n" +
            "E3\n" +
            "F5\n" +
            "N2\n" +
            "R90\n" +
            "S2\n" +
            "R270\n" +
            "W4\n" +
            "F58\n" +
            "F19\n" +
            "R180\n" +
            "R90\n" +
            "W4\n" +
            "F60\n" +
            "N1\n" +
            "E1\n" +
            "R90\n" +
            "F27\n" +
            "W4\n" +
            "L90\n" +
            "F35\n" +
            "E1\n" +
            "F11\n" +
            "E4\n" +
            "R90\n" +
            "W5\n" +
            "F68\n" +
            "L90\n" +
            "S2\n" +
            "W3\n" +
            "F2\n" +
            "L90\n" +
            "F24\n" +
            "W4\n" +
            "N4\n" +
            "R90\n" +
            "F32\n" +
            "L90\n" +
            "L90\n" +
            "F22\n" +
            "F91\n" +
            "R90\n" +
            "W1\n" +
            "F23\n" +
            "W2\n" +
            "S1\n" +
            "W3\n" +
            "S2\n" +
            "F97\n" +
            "W4\n" +
            "L90\n" +
            "W1\n" +
            "F16\n" +
            "S4\n" +
            "L180\n" +
            "W4\n" +
            "F48\n" +
            "E5\n" +
            "F21\n" +
            "N3\n" +
            "F2\n" +
            "E2\n" +
            "F75\n" +
            "N5\n" +
            "E2\n" +
            "L90\n" +
            "E3\n" +
            "F76\n" +
            "L90\n" +
            "N1\n" +
            "L90\n" +
            "N5\n" +
            "E1\n" +
            "L90\n" +
            "E2\n" +
            "R90\n" +
            "F40\n" +
            "L90\n" +
            "S5\n" +
            "E1\n" +
            "F8\n" +
            "S1\n" +
            "L90\n" +
            "E4\n" +
            "N3\n" +
            "F10\n" +
            "L180\n" +
            "F68\n" +
            "R90\n" +
            "F89\n" +
            "R90\n" +
            "W1\n" +
            "L180\n" +
            "E2\n" +
            "F48\n" +
            "S2\n" +
            "L90\n" +
            "F61\n" +
            "N3\n" +
            "L90\n" +
            "L180\n" +
            "W2\n" +
            "N2\n" +
            "F32\n" +
            "R90\n" +
            "E2\n" +
            "F74\n" +
            "W4\n" +
            "N5\n" +
            "F78\n" +
            "N2\n" +
            "F62\n" +
            "S1\n" +
            "R180\n" +
            "S2\n" +
            "E1\n" +
            "L90\n" +
            "N4\n" +
            "F85\n" +
            "R90\n" +
            "W4\n" +
            "R90\n" +
            "E1\n" +
            "R180\n" +
            "W3\n" +
            "S5\n" +
            "E1\n" +
            "R270\n" +
            "N4\n" +
            "F89\n" +
            "N4\n" +
            "R90\n" +
            "N1\n" +
            "E2\n" +
            "N3\n" +
            "F89\n" +
            "N5\n" +
            "E1\n" +
            "F17\n" +
            "R270\n" +
            "F58\n" +
            "E1\n" +
            "L90\n" +
            "F38\n" +
            "W4\n" +
            "S1\n" +
            "E2\n" +
            "R90\n" +
            "E2\n" +
            "W2\n" +
            "L90\n" +
            "W5\n" +
            "L90\n" +
            "E2\n" +
            "F1\n" +
            "E1\n" +
            "F34\n" +
            "S4\n" +
            "F16\n" +
            "W5\n" +
            "L180\n" +
            "F31\n" +
            "L90\n" +
            "E2\n" +
            "F46\n" +
            "L180\n" +
            "N5\n" +
            "F64\n" +
            "R90\n" +
            "F58\n" +
            "L90\n" +
            "F15\n" +
            "L90\n" +
            "S4\n" +
            "E3\n" +
            "F74\n" +
            "F26\n" +
            "S2\n" +
            "W2\n" +
            "S4\n" +
            "F81\n" +
            "S4\n" +
            "L180\n" +
            "E1\n" +
            "F21\n" +
            "F53\n" +
            "E5\n" +
            "F55\n" +
            "L270\n" +
            "W2\n" +
            "S2\n" +
            "E1\n" +
            "S2\n" +
            "E3\n" +
            "N2\n" +
            "F24\n" +
            "L180\n" +
            "N1\n" +
            "E5\n" +
            "F60\n" +
            "S1\n" +
            "F54\n" +
            "N1\n" +
            "F9\n" +
            "N3\n" +
            "L90\n" +
            "E3\n" +
            "L90\n" +
            "E3\n" +
            "L90\n" +
            "N1\n" +
            "F28\n" +
            "N4\n" +
            "R180\n" +
            "N5\n" +
            "F44\n" +
            "N2\n" +
            "E3\n" +
            "R90\n" +
            "W4\n" +
            "R180\n" +
            "F69\n" +
            "W3\n" +
            "S2\n" +
            "R180\n" +
            "E3\n" +
            "R270\n" +
            "S4\n" +
            "W2\n" +
            "R90\n" +
            "F69\n" +
            "E3\n" +
            "F44\n" +
            "L90\n" +
            "F87\n" +
            "E4\n" +
            "F21\n" +
            "E1\n" +
            "S2\n" +
            "R90\n" +
            "E5\n" +
            "L90\n" +
            "W5\n" +
            "R90\n" +
            "E1\n" +
            "F66\n" +
            "W4\n" +
            "F51\n" +
            "S3\n" +
            "S4\n" +
            "W3\n" +
            "L90\n" +
            "E1\n" +
            "R90\n" +
            "W1\n" +
            "R180\n" +
            "W1\n" +
            "N1\n" +
            "L180\n" +
            "N3\n" +
            "L180\n" +
            "E2\n" +
            "F14\n" +
            "N2\n" +
            "E5\n" +
            "F95\n" +
            "L270\n" +
            "N4\n" +
            "R90\n" +
            "N1\n" +
            "R90\n" +
            "N1\n" +
            "E4\n" +
            "F90\n" +
            "N3\n" +
            "F35\n" +
            "N5\n" +
            "F74\n" +
            "R90\n" +
            "N3\n" +
            "F64\n" +
            "N1\n" +
            "F28\n" +
            "N2\n" +
            "W2\n" +
            "F7\n" +
            "W4\n" +
            "N2\n" +
            "F37\n" +
            "E3\n" +
            "F100\n" +
            "R90\n" +
            "F36\n" +
            "L90\n" +
            "F41\n" +
            "E1\n" +
            "L90\n" +
            "L90\n" +
            "W1\n" +
            "N3\n" +
            "W2\n" +
            "W3\n" +
            "L90\n" +
            "W5\n" +
            "F100\n" +
            "R90\n" +
            "N2\n" +
            "L180\n" +
            "F7\n" +
            "W2\n" +
            "E2\n" +
            "F77\n" +
            "L180\n" +
            "N2\n" +
            "R180\n" +
            "F60\n" +
            "L90\n" +
            "N5\n" +
            "L90\n" +
            "F72\n" +
            "L270\n" +
            "W1\n" +
            "L180\n" +
            "N5\n" +
            "R90\n" +
            "F54\n" +
            "S3\n" +
            "F70\n" +
            "N1\n" +
            "F72\n" +
            "E4\n" +
            "N5\n" +
            "R90\n" +
            "S1\n" +
            "W1\n" +
            "N3\n" +
            "R90\n" +
            "F45\n" +
            "E4\n" +
            "F32\n" +
            "W5\n" +
            "F78\n" +
            "W3\n" +
            "R90\n" +
            "W4\n" +
            "F58\n" +
            "R90\n" +
            "E5\n" +
            "L90\n" +
            "F3\n" +
            "R90\n" +
            "N1\n" +
            "R90\n" +
            "W1\n" +
            "N4\n" +
            "E1\n" +
            "W3\n" +
            "N5\n" +
            "R90\n" +
            "W5\n" +
            "S3\n" +
            "F25\n" +
            "W4\n" +
            "N3\n" +
            "F55\n" +
            "W2\n" +
            "R90\n" +
            "N1\n" +
            "F98\n" +
            "L90\n" +
            "W3\n" +
            "L270\n" +
            "E1\n" +
            "N3\n" +
            "N2\n" +
            "R90\n" +
            "S1\n" +
            "F39\n" +
            "L90\n" +
            "W2\n" +
            "L90\n" +
            "N3\n" +
            "E3\n" +
            "F80\n" +
            "W1\n" +
            "N1\n" +
            "W4\n" +
            "F25\n" +
            "R90\n" +
            "E3\n" +
            "L180\n" +
            "F21\n" +
            "S4\n" +
            "F75\n" +
            "L90\n" +
            "F76\n" +
            "W5\n" +
            "N4\n" +
            "E2\n" +
            "R90\n" +
            "F44\n" +
            "E3\n" +
            "N1\n" +
            "W3\n" +
            "F49\n" +
            "N2\n" +
            "L180\n" +
            "S4\n" +
            "L90\n" +
            "F55\n" +
            "S4\n" +
            "R90\n" +
            "F14\n" +
            "R90\n" +
            "W5\n" +
            "L90\n" +
            "F85\n" +
            "N2\n" +
            "L90\n" +
            "L90\n" +
            "E3\n" +
            "R90\n" +
            "N3\n" +
            "E4\n" +
            "S5\n" +
            "F75\n" +
            "L90\n" +
            "F60\n" +
            "N2\n" +
            "R180\n" +
            "E2\n" +
            "L90\n" +
            "E2\n" +
            "L180\n" +
            "F27\n" +
            "E4\n" +
            "N4\n" +
            "L90\n" +
            "N2\n" +
            "L180\n" +
            "F91\n" +
            "N4\n" +
            "F47\n" +
            "W2\n" +
            "N2\n" +
            "F63\n" +
            "F63\n" +
            "W4\n" +
            "F28\n" +
            "L90\n" +
            "N1\n" +
            "F57\n" +
            "S1\n" +
            "E2\n" +
            "L90\n" +
            "E5\n" +
            "L180\n" +
            "N3\n" +
            "E4\n" +
            "F70\n" +
            "R90\n" +
            "W5\n" +
            "L90\n" +
            "W1\n" +
            "E3\n" +
            "F18\n" +
            "E3\n" +
            "F15\n" +
            "N1\n" +
            "E4\n" +
            "L90\n" +
            "W1\n" +
            "F49\n" +
            "E3\n" +
            "R90\n" +
            "F61\n" +
            "N3\n" +
            "E2\n" +
            "F69\n" +
            "E1\n" +
            "F7\n" +
            "L90\n" +
            "S1\n" +
            "F73\n" +
            "R90\n" +
            "S5\n" +
            "E2\n" +
            "L90\n" +
            "N1\n" +
            "S4\n" +
            "R180\n" +
            "F8\n" +
            "S1\n" +
            "E5\n" +
            "F44\n" +
            "N1\n" +
            "F39\n" +
            "L90\n" +
            "S1\n" +
            "F83\n" +
            "L90\n" +
            "E4\n" +
            "F59\n" +
            "N4\n" +
            "W2\n" +
            "S3\n" +
            "W2\n" +
            "R90\n" +
            "L270\n" +
            "E4\n" +
            "R90\n" +
            "N5\n" +
            "E4\n" +
            "F22\n" +
            "E1\n" +
            "S3\n" +
            "R90\n" +
            "W5\n" +
            "R270\n" +
            "N1\n" +
            "S4\n" +
            "F39\n" +
            "N4\n" +
            "F78\n" +
            "N4\n" +
            "W3\n" +
            "F34\n" +
            "E5\n" +
            "F31\n" +
            "L90\n" +
            "N3\n" +
            "R180\n" +
            "F75\n" +
            "S2\n" +
            "E1\n" +
            "R180\n" +
            "F89\n" +
            "E5\n" +
            "R180\n" +
            "S1\n" +
            "W3\n" +
            "F97\n" +
            "R180\n" +
            "F54\n" +
            "W2\n" +
            "F6\n" +
            "W5\n" +
            "N3\n" +
            "F58\n" +
            "R90\n" +
            "N2\n" +
            "L180\n" +
            "F2\n" +
            "W3\n" +
            "E3\n" +
            "N3\n" +
            "R180\n" +
            "W1\n" +
            "E3\n" +
            "S3\n" +
            "E2\n" +
            "F87\n" +
            "W5\n" +
            "E3\n" +
            "R90\n" +
            "F63\n" +
            "F30\n" +
            "R90\n" +
            "S3\n" +
            "F69\n" +
            "E2\n" +
            "F87\n" +
            "N1\n" +
            "F95\n" +
            "S4\n" +
            "L90\n" +
            "F52";

    static int parseInput(final String input) {
        List<String> instructions = Arrays.asList(input.split("\n"))
                .stream()
                .filter(line -> !line.isBlank())
                .map(line -> line.trim())
                .collect(Collectors.toList());

        Ship ship = new Ship();

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
                    ship.move(Direction.valueOf(command), value);
            }
        }
        return ship.getDistance();
    }

    public static void main(final String[] args) {
        System.out.println(parseInput(input));
    }

    public static class Ship {
        int x,y;
        Direction direction;

        public Ship() {
            x = 0;
            y=0;
            direction = Direction.E;
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

        public void move(Direction direction, int dist) {
            switch (direction) {
                case N:
                    x+=dist;
                    return;
                case W:
                    y-=dist;
                    return;
                case S:
                    x-=dist;
                    return;
                case E:
                    y+=dist;
            }
        }

        public void forward(int dist) {
            move(direction, dist);
        }

        private void turnLeft() {
            switch (direction) {
                case N:
                    direction = Direction.W;
                    return;
                case W:
                    direction= Direction.S;
                    return;
                case S:
                    direction = Direction.E;
                    return;
                case E:
                    direction = Direction.N;
            }
        }
    }

    public static enum Direction {
        N, S, E, W;
    }
}
