package app

class Field(val row: Int, val column: Int, var isOccupied: Boolean = false) {

    override fun toString(): String {
        return if (isOccupied) {
            "[X]"
        } else "[ ]"
    }
}