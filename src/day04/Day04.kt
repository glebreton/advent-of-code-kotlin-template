package day04

import readInput

data class Case(val number: Int, var check: Boolean = false)

fun String.toCases() = split(" ").filter { it.isNotBlank() }.map { Case(it.toInt()) }.toTypedArray()

class Board(private val board: Array<Array<Case>>) {

    fun drawn(number: Int) {
        board.forEach {
            it.forEach { case ->
                if (case.number == number) {
                    case.check = true
                }
            }
        }
    }

    fun isComplete(): Boolean {
        board.forEach {
            if (it.all { case -> case.check }) return true
        }

        for (row in board.indices) {
            var allChecked = true
            for (column in board[row].indices) {
                if (!board[column][row].check) {
                    allChecked = false
                }
            }

            if (allChecked)     return true
        }

        return false
    }

    fun score(): Int {
        var score = 0
        board.forEach {
            it.forEach { case -> if (!case.check) score += case.number }
        }
        return score
    }
}

fun main() {
//    val input = readInput("day04/Day04_test")
    val input = readInput("day04/Day04_input")

    val drawnNumbers = input[0].split(",")

    val boards = mutableListOf<Board>()
    val currentBoard = mutableListOf<Array<Case>>()
    for (index in 2 until input.size) {
        if (input[index].isBlank()) {
            boards.add(Board(currentBoard.toTypedArray()))
            currentBoard.clear()
        } else {
            currentBoard.add(input[index].toCases())
        }
    }
    if (currentBoard.isNotEmpty()) {
        boards.add(Board(currentBoard.toTypedArray()))
        currentBoard.clear()
    }

    for (drawn in drawnNumbers.map { it.toInt() }) {
        boards.forEach { it.drawn(drawn) }
        
        val winningBoard = boards.find { it.isComplete() }
        if (winningBoard != null) {
            println("Winning board score : " + winningBoard.score() * drawn)
            return
        }
    }
}
