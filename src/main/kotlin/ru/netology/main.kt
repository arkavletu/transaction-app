package ru.netology

import kotlin.math.roundToInt

fun main() {
    val typeOfAccount = "Visa"
    val previousTransactions = 0
    val currentTransaction = 10000

    val result = checkCommission(type = "Maestro", previousSum = previousTransactions, currentSum =  currentTransaction).roundToInt()
    val message = formattedMessage(result)

    println(message)

}
fun checkCommission(type: String = "VkPay", previousSum: Int = 0, currentSum: Int): Double{
    return when (type){
        "Maestro", "Mastercard" -> checkPreviousTransactions(previousSum,currentSum)
        "Visa", "Mir" -> checkMinCommission(currentSum)
        else -> 0.0
    }
}
fun checkPreviousTransactions(previousSum: Int, currentSum: Int): Double{
    return when (previousSum){
        in 0..75000*100 -> currentSum * 0.006 + 20 * 100
        else -> 0.0
    }
}

fun checkMinCommission(sum: Int): Double {
    return when (sum * 0.0075) {
        in 0.0..3500.0 -> 3500.0
        else -> sum * 0.0075
    }
}
    fun formattedMessage(sum: Int): String{
       val roubles = sum / 100
        val cents = sum % 100
        return "Комиссия составит $roubles р. $cents к."
    }
