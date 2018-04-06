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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Field

        if (row != other.row) return false
        if (column != other.column) return false
        if (isOccupied != other.isOccupied) return false

        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        result = 31 * result + isOccupied.hashCode()
        return result
    }


}