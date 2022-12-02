fun main() {
    fun getCaloriesList(input: List<String>): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        var current = 0
        for (row in input) {
            if (row.isEmpty()) {
                result.add(current)
                current = 0
                continue
            }
            current += Integer.valueOf(row)
        }
        result.add(current)
        return result.toList()
    }

    fun part1(input: List<String>): Int {
        val max: List<Int> = getCaloriesList(input)
        return max.max()
    }

    fun part2(input: List<String>): Int {
        val descendCaloriesList: List<Int> = getCaloriesList(input).sortedDescending()
        var sum = 0
        for (i in 0..2) {
            sum += descendCaloriesList[i]
        }
        return sum
    }

    val input = readInput("shmulik/klein/day01/Day01_test")
    val result1 = part1(input)
    println(result1)
    val result2 = part2(input)
    println(result2)
}
