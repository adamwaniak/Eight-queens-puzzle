import app.BackTracking
import app.Board
import app.ForwardChecking
import org.junit.Test

class AlgorithmsTimeTest{
    @Test
    fun forwardCheckingAllSolution() {
        val n = 6
        val board = Board(n)
        val forwardChecking = ForwardChecking(board)

        val solutions = forwardChecking.getAllPossibleSolution(n)

        println("Forward checking, possible solution: ${solutions.size}")
    }

    @Test
    fun backTrackingAllSolution() {
        val n = 6
        val board = Board(n)
        val backTracking = BackTracking(board)

        val solutions = backTracking.getAllPossibleSolution(n)

        println("Forward checking, possible solution: ${solutions.size}")
    }
}