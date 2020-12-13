package karsiwek.day01

import day01.input


fun getProductOfThree(input: String): Int {
    var array = input
        .split("\n")
        .filter { !it.trim().equals("") }
        .map { e -> e.toInt() }

    for (i in 0..array.size - 3) {
        for (j in i..array.size - 2) {
            for (k in j..array.size - 1)
                if (array.get(i) + array.get(j) + array.get(k) == 2020) {
                    return array.get(i) * array.get(j) * array.get(k)
                }
        }
    }

    return 0;
}

fun main(args: Array<String>) {
    System.out.println(getProductOfThree(input));

}
