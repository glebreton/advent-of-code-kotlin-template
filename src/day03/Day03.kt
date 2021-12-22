package day03

import readInput

fun buildDiagnosticReport(input: List<String>, inputLength: Int, oxygen: Boolean): Int {
    val report = Array(inputLength) { 0 }
    var inputList = input;
    for (index in 0 until inputLength) {
        if (inputList.size == 1) {
            report[index] = inputList[0][index].digitToInt()
        } else {
            val countByElements = inputList.map { it.elementAt(index) }.groupingBy { it }.eachCount()
            if (oxygen) {
                report[index] = if ((countByElements['1'] ?: 0) >= (countByElements['0'] ?: Int.MIN_VALUE)) {
                    1
                } else {
                    0
                }
            } else {
                report[index] = if ((countByElements['0'] ?: Int.MAX_VALUE) <= (countByElements['1'] ?: 0)) {
                    0
                } else {
                    1
                }
            }

            inputList = inputList.filter { it.elementAt(index).digitToInt() == report[index] }
        }
    }

    return report.joinToString("") { it.toString() }.toInt(2)
}

fun main() {
//    val input = readInput("day03/Day03_test")
//    val inputLength = 5

    val input = readInput("day03/Day03_input")
    val inputLength = 12

    val oxygenGeneratorRating = buildDiagnosticReport(input, inputLength, true)
    val co2ScrubberRating = buildDiagnosticReport(input, inputLength, false)

    println("Life support rating = " + (oxygenGeneratorRating * co2ScrubberRating))
}
