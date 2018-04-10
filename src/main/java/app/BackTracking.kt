package app

class BackTracking(board: Board) : Algorithm(board) {
    override fun placeQueens(n: Int, allSolution: Boolean): Boolean {
        if (n == 0) {
            return if (allSolution){
                allPossibleSolution.add(board.getCopy())
                false
            }else{
                true
            }
        } else {
            for (field in board.fields) {
                if (!isAttacked(field)) {
                    board.addQueen(field)
                        if (placeQueens(n - 1, allSolution)) {
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