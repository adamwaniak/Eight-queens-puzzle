package app

class BackTracking(board: Board) : Algorithm(board) {
    fun placeQueens(n: Int): Boolean {
        if (n == 0) {
            return true
        } else {
            for (field in board.fields) {
                if (!isAttacked(field)) {
                    board.addQueen(field)
                        if (placeQueens(n - 1)) {
                            return true
                        } else {
                            board.removeQueen(field)
                        }
                    }
            }
            return false
        }
    }
}