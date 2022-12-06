package shmulik.klein.day04

import readInput

fun main() {


    val input = readInput("shmulik/klein/day04/Day04_test")
    val result1 = part1(input)
    println(result1)
    val result2 = part2(input)
    println(result2)
}

fun part2(input: List<String>): Int {
    var count = 0
    for (line in input) {
        val ranges = line.split(",", "-")
        if ((ranges[0].toInt() >= ranges[2].toInt()) && (ranges[0].toInt() <= ranges[3].toInt())
            || ((ranges[1].toInt() >= ranges[2].toInt()) && (ranges[1].toInt() <= ranges[3].toInt()) || (ranges[0].toInt() <= ranges[2].toInt() && ranges[1].toInt() >= ranges[3].toInt()))
        ) {
            count++
            println("${ranges[0]}, ${ranges[1]}, ${ranges[2]}, ${ranges[3]}")
        }
    }
    return count
}

fun part1(input: List<String>): Int {
    var count = 0
    for (line in input) {
        val ranges = line.split(",", "-")
        if ((ranges[2].toInt() <= ranges[0].toInt() && (ranges[1].toInt() <= ranges[3].toInt())) || (ranges[0].toInt() <= ranges[2].toInt() && ranges[1].toInt() >= ranges[3].toInt())) {
            count++
//            println("${ranges[0]}, ${ranges[1]}, ${ranges[2]}, ${ranges[3]}")
        }
    }
    return count
}