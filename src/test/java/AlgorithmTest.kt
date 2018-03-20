import app.Algorithm
import app.Board
import org.junit.Assert
import org.junit.Test

class AlgorithmTest{

    @Test
    fun testIsCollisionExist(){
        val board = Board(4)
        board.addQueen(1,1)
        board.addQueen(3,3)
        println(board.toString())
        val algorithm = Algorithm(board)
        Assert.assertTrue(algorithm.isCollisionExist())
    }

    @Test
    fun testIsCollisionExist1(){
        val board = Board(4)
        board.addQueen(1,1)
        board.addQueen(2,3)
        println(board.toString())
        val algorithm = Algorithm(board)
        Assert.assertTrue(!algorithm.isCollisionExist())
    }
}