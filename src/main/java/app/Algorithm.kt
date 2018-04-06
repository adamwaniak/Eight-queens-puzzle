package app

abstract class Algorithm(val board: Board) {

    abstract fun placeQueens(n: Int): Boolean

    fun getAllPossibleSolution(n: Int): Set<Board> {
        val result = mutableSetOf<Board>()
        for (field in board.fields) {
            field.isOccupied = true
            placeQueens(n - 1)
            if (board.numberOfQueens()==n){
                result.add(board.getCopy())
            }
            board.clearBoard()
        }
        return result
    }

    fun isCollisionExist(): Boolean {
        for (field in board.fields) {
            if (field.isOccupied) {
                val row = board.getRow(field.row)
                val column = board.getColumn(field.column)
                val diagonal = board.getDiagonals(field.row, field.column)

                if (row.isOccupied(field) or column.isOccupied(field) or diagonal.isOccupied(field)) {
                    return true
                }
            }
        }
        return false
    }


    internal fun isAttacked(row: Int, column: Int): Boolean {
        if (board.get(row, column).isOccupied) {
            return true
        }
        board.addQueen(row, column)
        return if (isCollisionExist()) {
            board.removeQueen(row, column)
            true
        } else {
            board.removeQueen(row, column)
            false
        }
    }

    internal fun isAttacked(field: Field): Boolean {
        return isAttacked(field.row, field.column)
    }

    private fun List<Field>.isOccupied(excludedField: Field): Boolean {
        for (field in this) {
            if ((field != excludedField) and field.isOccupied) {
                return true
            }
        }
        return false
    }

}