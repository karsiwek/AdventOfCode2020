package day02

fun isValid2(input: List<String>): Boolean {
    val min = input[0].toInt();
    val max = input[1].toInt();
    val letter = input[2][0];
    val password = input[3];

    return (password.get(min - 1).equals(letter) || password.get(max - 1).equals(letter)) && !password.get(min - 1)
        .equals(password.get(max - 1));
}

fun solve2(input: String): Int {
    var rows = input
        .split("\n")
        .filter { !it.trim().equals("") }
        .map { e -> e.split("[- :]+".toRegex()) }

    var valid = 0;
    for (row in rows) {
        if (isValid2(row)) {
            valid++;
        }
    }
    return valid;
}

fun main(args: Array<String>) {
    System.out.println(solve2(input));

}
