package app

class ForwardChecking(board: Board) : Algorithm(board) {


    override fun placeQueens(n: Int): Boolean {
        val availableFields = getAvailableFields()
        when {
            n == 0 -> return true
            availableFields.isEmpty() -> return false
            else -> for (field in availableFields) {
                board.addQueen(field)
                if (placeQueens(n - 1)) return true
                else board.removeQueen(field)
            }
        }
        return false
    }

    internal fun getAvailableFields(): Set<Field> {
        val availableFields = mutableSetOf<Field>()
        board.fields.forEach { if (!isAttacked(it)) availableFields.add(it) }
        return availableFields
    }
}