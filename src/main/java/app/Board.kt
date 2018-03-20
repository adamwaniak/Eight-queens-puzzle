package app

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class Board(val size: Int) {
    val fields: MutableList<Field> = mutableListOf()

    init {
        for (i in 0 until size) {
            for (j in 0 until size) {
                fields.add(Field(i, j))
            }
        }
    }

    fun addQueen(row: Int, column: Int) {
        get(row, column).isOccupied = true
    }

    fun get(row: Int, column: Int): Field {
        for (field in fields) {
            if ((field.row == row) and (field.column == column)) {
                return field
            }
        }
        throw IllegalArgumentException()
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

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("Board(size=$size,")
        for (i in 0 until size){
            stringBuilder.append("\n")
            for (j in 0 until size){
                stringBuilder.append(get(i,j).toString())
            }
        }
        stringBuilder.append("\n)")
        return stringBuilder.toString()
    }
}