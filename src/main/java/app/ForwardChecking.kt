package app

import kotlin.math.absoluteValue

class ForwardChecking(board: Board) : Algorithm(board) {


    override fun placeQueens(n: Int, allSolution: Boolean): Boolean {
        val availableFields = getAvailableFields()
        when {
            n == 0 -> return if (allSolution) {
                allPossibleSolution.add(board.getCopy())
                false
            } else {
                true
            }
            availableFields.isEmpty() -> return false
            else -> for (field in availableFields
//                    .filter { !it.isOccupied }
//                    .sortedBy { o1 ->
//                val center = board.size / 2
//                val diff1 = (center - o1.column).absoluteValue + (center - o1.row).absoluteValue
//                diff1
//            }.toMutableList()
            )
            {
                board.addQueen(field)
                if (placeQueens(n - 1, allSolution)) return true
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