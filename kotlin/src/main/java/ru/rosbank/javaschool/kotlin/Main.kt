package ru.rosbank.javaschool.kotlin

// extends very bad
open class Person(var name: String, var age: Int)
// all args constructor, val - read only property

class RichPerson(name: String, age: Int, val balance: Int) : Person(name, age)

// @Data
data class Dto(val id: Int, val value: String)
// val - lombok

// extension function - к существующему типу добавляем функцию-расширение
fun <T> List<T>.last(): T = this[this.lastIndex]

fun main() {
    // immutability
    val dto = Dto(1, "Value")
    val copy = dto.copy(id = 2) // named args

    // List.of
    // Map.of
    listOf(1, 2, 3, 4).forEach {
        println(it)
    }

    // можно переопределять операторы в том числе
    val vasya = Person("Vasya", 20).apply {
        this.name = "VASUA"
    }

    // destructuring
    val (name) = dto
    // val name = dto.name

    println(listOf(1, 2, 3).last())
}