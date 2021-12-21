package day01

import readInput

fun main() {
    val depths = readInput("Day01_part1")
    val depthIncreased = depths
        .map { it.toInt() }
        .windowed(2)
        .count { (first, second) -> first < second }
    println(depthIncreased)
}
