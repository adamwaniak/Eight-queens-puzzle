package app

class BackTracking(board: Board) : Algorithm(board) {
    fun placeQueens(n: Int): Boolean {
        if (n == 0) {
            return true
        } else {
            for (i in 0 until board.size) {
                for (j in 0 until board.size) {
                    if (!isAttacked(i, j)) {
                        board.addQueen(i, j)
                        if (placeQueens(n - 1)) {
                            return true
                        } else {
                            board.removeQueen(i, j)
                        }
                    }
                }
            }
            return false
        }
    }
}