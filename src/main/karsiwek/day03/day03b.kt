package day03


fun main(args: Array<String>) {
    System.out.println(
        solve(input, 1, 1)
                * solve(input, 3, 1)
                * solve(input, 5, 1)
                * solve(input, 7, 1)
                * solve(input, 1, 2)
    );

}
