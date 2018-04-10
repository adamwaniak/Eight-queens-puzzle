import app.BackTracking
import app.Board
import app.ForwardChecking
import org.junit.Test

class AlgorithmsTimeTest{
    @Test
    fun forwardCheckingAllSolution() {
        val n = 7
        val board = Board(n)
        val forwardChecking = ForwardChecking(board)

        val solutions = forwardChecking.getAllPossibleSolutions()

        println("Forward checking, possible solution: ${solutions.size}")
    }

    @Test
    fun backTrackingAllSolution() {
        val n = 8
        val board = Board(n)
        val backTracking = BackTracking(board)

        val solutions = backTracking.getAllPossibleSolutions()

        println("Back tracking, possible solution: ${solutions.size}")
    }
}