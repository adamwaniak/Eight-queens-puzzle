import app.Board
import org.junit.Assert
import org.junit.Test


class BoardTest {

    @Test
    fun testGetDiagonal() {
        val board = Board(3)
        val diagonal = board.getDiagonals(1,1)
        Assert.assertTrue(diagonal.contains(board.get(2,2)))
    }

}
