package app

import kotlin.math.absoluteValue

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
            for (field in board.fields
                    .filter { !it.isOccupied }
                    .sortedBy { o1->
            val center = board.size / 2
            val diff1 = (center - o1.column).absoluteValue + (center - o1.row).absoluteValue
            diff1
        }.toMutableList()
            )
 {
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