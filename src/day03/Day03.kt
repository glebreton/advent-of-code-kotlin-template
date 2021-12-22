package day03

import readInput
import kotlin.math.pow

fun buildDiagnosticReport(file: String, inputSize: Int): Array<Int> {
    val input = readInput("day03/$file")

    val report = Array(inputSize) { it }
    for (index in 0 until inputSize) {
        report[index] = input.map { it.elementAt(index) }.count { it == '1' } / (inputSize / 2)
    }

    return report
}

fun main() {
//    val report = buildDiagnosticReport("Day03_test", 5)
    val report = buildDiagnosticReport("Day03_input", 12)

    val gammaRate = report.joinToString("") { it.toString() }.toInt(2)
    val epsilonRate = 2.0.pow(12).toInt() -1 - gammaRate
    println(gammaRate * epsilonRate)
}
