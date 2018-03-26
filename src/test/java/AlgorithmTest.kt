import app.*
import org.junit.Assert
import org.junit.Test

class AlgorithmTest{

    @Test
    fun testIsCollisionExist(){
        val board = Board(4)
        board.addQueen(1,1)
        board.addQueen(3,3)
        val algorithm = BackTracking(board)
        Assert.assertTrue(algorithm.isCollisionExist())
    }

    @Test
    fun testIsCollisionExist1(){
        val board = Board(4)
        board.addQueen(1,1)
        board.addQueen(2,3)
        val algorithm = BackTracking(board)
        Assert.assertTrue(!algorithm.isCollisionExist())
    }

    @Test
    fun testIsAttacked() {
        val board = Board(4)
        val algorithm = BackTracking(board)
        board.addQueen(1,1)
        Assert.assertTrue(algorithm.isAttacked(3,3))
        Assert.assertFalse(algorithm.isAttacked(2,3))
        Assert.assertTrue(board.numberOfQueens()==1)
    }


    @Test
    fun testBackTracking(){
        val board = Board(4)
        val algorithm = BackTracking(board)
        algorithm.placeQueens(4)
        println(board.printBoard())
        Assert.assertTrue(board.numberOfQueens()==4)
    }

    @Test
    fun testGetAvailableFields() {
        val board = Board(3)
        val algorithm = ForwardChecking(board)
        board.addQueen(0,0)
        val availableFields = setOf(board.get(2,1),board.get(1,2))
        Assert.assertTrue(availableFields==(algorithm.getAvailableFields()))
    }

    @Test
    fun testForwardChecking() {
        val board = Board(4)
        val algorithm = ForwardChecking(board)
        algorithm.placeQueens(4)
        println(board.printBoard())
        Assert.assertTrue(board.numberOfQueens()==4)
    }
}