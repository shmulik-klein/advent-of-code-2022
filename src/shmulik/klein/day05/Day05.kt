package shmulik.klein.day05

import readInput

/*
[V]         [T]         [J]
[Q]         [M] [P]     [Q]     [J]
[W] [B]     [N] [Q]     [C]     [T]
[M] [C]     [F] [N]     [G] [W] [G]
[B] [W] [J] [H] [L]     [R] [B] [C]
[N] [R] [R] [W] [W] [W] [D] [N] [F]
[Z] [Z] [Q] [S] [F] [P] [B] [Q] [L]
[C] [H] [F] [Z] [G] [L] [V] [Z] [H]
1   2   3   4   5   6   7   8   9
*/

fun part1(input: List<String>): MutableList<Char>? {
    val stacks =
        mutableListOf("CZNBMWQV", "HZRWCB", "FQRJ", "ZSWHFNMT", "GFWLNQP", "LPW", "VBDRGCQJ", "ZQNBW", "HLFCGTJ")
//    val stacks = mutableListOf("ZN", "MCD", "P")
    for (line in input) {
        val move = line.split(" ").filter { it.toIntOrNull() != null }.map { it.toInt() }.toList()
        println(move)
        for (i in 1..move[0]) {
            println(stacks)
            val crateToMove = stacks[move[1] - 1].last()
            stacks[move[2] - 1] = stacks[move[2] - 1] + crateToMove
            stacks[move[1] - 1] = stacks[move[1] - 1].removeSuffix(crateToMove.toString())
        }
    }
    return stacks.stream().map { it.last() }.toList()
}

fun main() {
    val input = readInput("shmulik/klein/day05/Day05_test")
    val result1 = part1(input)
    println(result1)
    val result2 = part2(input)
    println(result2)
}

fun part2(input: List<String>): MutableList<Char>? {
    val stacks =
        mutableListOf("CZNBMWQV", "HZRWCB", "FQRJ", "ZSWHFNMT", "GFWLNQP", "LPW", "VBDRGCQJ", "ZQNBW", "HLFCGTJ")
//    val stacks = mutableListOf("ZN", "MCD", "P")
    for (line in input) {
        val move = line.split(" ").filter { it.toIntOrNull() != null }.map { it.toInt() }.toList()
        println(move)
        println(stacks)
        val crateToMove = stacks[move[1] - 1].takeLast(move[0])
        stacks[move[2] - 1] = stacks[move[2] - 1] + crateToMove
        stacks[move[1] - 1] = stacks[move[1] - 1].removeSuffix(crateToMove)
    }
    return stacks.stream().map { it.last() }.toList()
}
