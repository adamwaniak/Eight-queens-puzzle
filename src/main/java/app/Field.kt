package app

class Field(val row: Int, val column: Int, var isOccupied: Boolean = false) {

    fun toPrintBoard(): String {
        return if (isOccupied) {
            "[X]"
        } else "[ ]"
    }

    override fun toString(): String {
        return "Field(row=$row, column=$column, isOccupied=$isOccupied)"
    }
}