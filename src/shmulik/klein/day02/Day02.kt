package shmulik.klein.day02

import readInput

fun main() {
    fun getGame(input: List<String>): List<Pair<String, String>> {
        val result: MutableList<Pair<String, String>> = mutableListOf()
        for (row in input) {
            val pair = row.split(" ")
            result.add(Pair(pair[0], pair[1]))
        }
        return result.toList()
    }

    fun part1(input: List<String>): Int {
        val list: List<Pair<String, String>> = getGame(input)
        return list.stream().map { Pair(Choice.convert(it.first), Choice.convert(it.second)) }
            .mapToInt { p -> Choice.result(p.first, p.second) + p.second.value }.sum()
    }

    fun part2(input: List<String>): Int {
        val list: List<Pair<String, String>> = getGame(input)
        return list.stream().map { Pair(Choice.convert(it.first), Outcome.valueOf(it.second)) }
            .mapToInt { p -> p.second.result(p.first) }.sum()
    }

    val input = readInput("shmulik/klein/day02/Day02_test")
    val result1 = part1(input)
    println(result1)
    val result2 = part2(input)
    println(result2)
}

enum class Outcome {
    X, // lose
    Y, // draw
    Z; // win

    fun result(c: Choice): Int {
        when (this.toString()) {
            "X" -> {
                return when (c) {
                    Choice.Paper -> Choice.Rock.value + 0
                    Choice.Rock -> Choice.Scissors.value + 0
                    Choice.Scissors -> Choice.Paper.value + 0
                }
            }

            "Y" -> {
                return c.value + 3
            }

            "Z" -> {
                return when (c) {
                    Choice.Paper -> Choice.Scissors.value + 6
                    Choice.Rock -> Choice.Paper.value + 6
                    Choice.Scissors -> Choice.Rock.value + 6
                }
            }

            else -> throw IllegalArgumentException()
        }
    }
}

enum class Choice(val value: Int) {
    Rock(1),
    Paper(2),
    Scissors(3);

    companion object {
        fun convert(input: String): Choice {
            when (input) {
                "A", "X" -> return Rock
                "B", "Y" -> return Paper
                "C", "Z" -> return Scissors
            }
            throw IllegalArgumentException("Argument was$input")
        }

        fun result(c1: Choice, c2: Choice): Int {
            if (c1 == c2) {
                return 3
            }
            if ((c2 == Rock && c1 == Scissors) || (c2 == Scissors && c1 == Paper) || (c2 == Paper && c1 == Rock)) {
                return 6
            }
            return 0
        }
    }
}
