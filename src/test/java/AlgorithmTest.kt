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

    @Test
    fun testPlaceQueens(){
        val board = Board(8)
        val algorithm = Algorithm(board)
        algorithm.placeQueens(8)
        println(board.toString())
        Assert.assertTrue(board.numberOfQueens()==8)
    }

    @Test
    fun testIsAttacked() {
        val board = Board(4)
        val algorithm = Algorithm(board)
        board.addQueen(1,1)
        Assert.assertTrue(algorithm.isAttacked(3,3))
        Assert.assertFalse(algorithm.isAttacked(2,3))
        Assert.assertTrue(board.numberOfQueens()==1)
    }
}