package shmulik.klein.day03

import readInput

fun main() {
    fun getPriorityMap(): MutableMap<Char, Int> {
        val lowerIntRange = 1..26
        val upperIntRange = 27..52
        val lowerRange = 'a'..'z'
        val upperRange = 'A'..'Z'
        val mutableMapOf = mutableMapOf<Char, Int>()
        for ((j, i) in lowerIntRange zip lowerRange) {
            mutableMapOf[i] = j
        }
        for ((j, i) in upperIntRange zip upperRange) {
            mutableMapOf[i] = j
        }
        return mutableMapOf
    }

    fun part1(input: List<String>): Int {
        val mutableMapOf = getPriorityMap()
        println(mutableMapOf)
        val exists = mutableSetOf<Char>()
        var sum = 0
        for (line in input) {
            for (char in line.substring(0 until (line.length / 2))) {
                exists.add(char)
            }
            sum += (line.substring((line.length / 2) until (line.length))
                .filter { exists.contains(it) }).map { mutableMapOf[it] }.first()!!
            exists.clear()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var index = 0
        var sum = 0
        val priorityMap = getPriorityMap()
        while (input.getOrNull(index) != null) {
            val set1 = input[index].toSet()
            val set2 = input[index + 1].toSet()
            val set3 = input[index + 2].toSet()
            index += 3
            val value = set1.intersect(set2).intersect(set3).first()
            sum += priorityMap[value]!!
        }
        return sum
    }

    val input = readInput("shmulik/klein/day03/Day03_test")
    val result1 = part1(input)
    println(result1)
    val result2 = part2(input)
    println(result2)
}