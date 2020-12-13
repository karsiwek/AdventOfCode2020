package day06

var testInput: String ="""
    abc

a
b
c

ab
ac

a
a
a
a

b
"""
fun getUnionOfAnswers(input: String): Set<Char> {
    return input.trim().split("\n")
        .map { it.trim() }
        .map { it.toList() }
        .reduceRight { left, acc -> acc.intersect(left).toList() }
        .toSet()
}

fun solve2(input: String): Int {
    return input.trim().split("\n\n")
        .map { it.trim() }
        .filter { it.isNotBlank() }
        .map { getUnionOfAnswers(it) }
        .sumBy { it.size }
}

fun main(args: Array<String>) {
    println(solve2(input));
}

