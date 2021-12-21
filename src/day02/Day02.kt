package day02

import readInput

enum class Direction { UP, DOWN, FORWARD }
data class Step(val direction: Direction, val value: Int)

fun String.toStep() = Step(
    Direction.valueOf(substringBefore(" ").uppercase()),
    substringAfter(" ").toInt()
)

class Position(var horizontal: Int = 0, var depth: Int = 0) {

    fun forward(value: Int) {
        this.horizontal += value
    }

    fun up(value: Int) {
        this.depth -= value
    }

    fun down(value: Int) {
        this.depth += value
    }

    fun result(): Int {
        return this.horizontal * this.depth
    }
}

fun main() {
//    val directions = readInput("day02/Day02_test")
    val directions = readInput("day02/Day02_input")

    val position = Position()
    directions.map { it.toStep() }
        .forEach { dir ->
            when (dir.direction) {
                Direction.FORWARD -> position.forward(dir.value)
                Direction.UP -> position.up(dir.value)
                Direction.DOWN -> position.down(dir.value)
            }
        }

    println("Position : ${position.result()}")
}
