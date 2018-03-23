package app

class Algorithm(val board: Board) {

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

    fun isAttacked(row: Int, column: Int): Boolean {
        if (board.get(row, column).isOccupied){
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

    private fun List<Field>.isOccupied(excludedField: Field): Boolean {
        for (field in this) {
            if ((field != excludedField) and field.isOccupied) {
                return true
            }
        }
        return false
    }
}