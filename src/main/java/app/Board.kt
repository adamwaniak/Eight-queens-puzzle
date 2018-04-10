package app

import java.lang.StringBuilder
import kotlin.math.absoluteValue

class Board(val size: Int) {
    var fields: MutableList<Field> = mutableListOf()

    init {
        for (i in 0 until size) {
            for (j in 0 until size) {
                fields.add(Field(i, j))
            }
        }
//        fields = fields.sortedBy {o1->
//
//            val center = size / 2
//            val diff1 = (center - o1.column).absoluteValue + (center - o1.row).absoluteValue
//            diff1
//        }.toMutableList()
    }


    fun getCopy(): Board {
        val copyBoard = Board(size)
        for (i in 0 until size) {
            for (j in 0 until size) {
                copyBoard.get(i, j).isOccupied = get(i, j).isOccupied
            }
        }
        return copyBoard
    }

    fun numberOfQueens(): Int {
        var result = 0
        fields.forEach { if (it.isOccupied) result += 1 }
        return result
    }

    fun addQueen(field: Field) = addQueen(field.row, field.column)


    fun addQueen(row: Int, column: Int) {
        get(row, column).isOccupied = true
    }

    fun removeQueen(field: Field) = removeQueen(field.row, field.column)

    fun removeQueen(row: Int, column: Int) {
        get(row, column).isOccupied = false
    }

    fun get(row: Int, column: Int): Field {
        for (field in fields) {
            if ((field.row == row) and (field.column == column)) {
                return field
            }
        }
        throw IndexOutOfBoundsException()
    }

    fun getRow(row: Int): List<Field> {
        val rowsField: MutableList<Field> = mutableListOf()
        for (field in fields) {
            if (field.row == row)
                rowsField.add(field)
        }
        return rowsField
    }

    fun getColumn(column: Int): List<Field> {
        val columnsField: MutableList<Field> = mutableListOf()
        for (field in fields) {
            if (field.column == column)
                columnsField.add(field)
        }
        return columnsField
    }

    fun getDiagonals(row: Int, column: Int): List<Field> {
        val diagonal: MutableList<Field> = mutableListOf()
        var i = row
        var j = column
        while (i >= 0 && j < size) {
            diagonal.add(get(i, j))
            i--
            j++
        }
        i = row
        j = column
        while (i < size && j >= 0) {
            diagonal.add(get(i, j))
            i++
            j--
        }
        i = row
        j = column
        while (i < size && j < size) {
            diagonal.add(get(i, j))
            i++
            j++
        }

        i = row
        j = column
        while (i >= 0 && j >= 0) {
            diagonal.add(get(i, j))
            i--
            j--
        }
        return diagonal
    }

    fun printBoard() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Board(size=$size,")
        for (i in 0 until size) {
            stringBuilder.append("\n")
            for (j in 0 until size) {
                stringBuilder.append(get(i, j).toPrintBoard())
            }
        }
        stringBuilder.append("\n)")
        println(stringBuilder.toString())
    }

    override fun toString(): String {
        return "Board(size=$size, fields=$fields)"
    }

    fun clearBoard() {
        for (field in fields) {
            field.isOccupied = false
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        if (size != other.size) return false
        if (fields != other.fields) return false

        return true
    }

    override fun hashCode(): Int {
        var result = size
        result = 31 * result + fields.hashCode()
        return result
    }


}