package day01

import readInput

fun main() {
    val depths = readInput("day01/Day01_input").map { it.toInt() }

    val depthIncreasedPart1 = depths
        .windowed(2)
        .count { (first, second) -> first < second }
    println("Part 1 : $depthIncreasedPart1")

    val depthIncreasedPart2 = depths
        .windowed( 3 )
        .map { it.sum() }
        .windowed(2)
        .count { (first, second) -> first < second }
    print("Part 2 : $depthIncreasedPart2")
}
