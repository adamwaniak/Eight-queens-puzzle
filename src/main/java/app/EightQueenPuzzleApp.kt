package app

import kotlin.system.measureTimeMillis

fun printSolutions(solutions: Iterable<Board>) {
    solutions.forEach { it.printBoard() }
}


fun main(args: Array<String>) {
    var n : Int
    var board : Board
    var time: Long



    n = 8
    board = Board(n)
    val backTracking = BackTracking(board)
    time = measureTimeMillis {
        val solutions = backTracking.getAllPossibleSolution(n)
    }
    println("Back tracking execution time for n=$n: $time")

//    n = 8
//    board = Board(n)
//    val forwardChecking = ForwardChecking(board)
//    time = measureTimeMillis {
//        val solutions = forwardChecking.getAllPossibleSolution(n)
//    }
//    println("Forward checking execution time for n=$n: $time")

}
