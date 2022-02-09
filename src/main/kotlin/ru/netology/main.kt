package ru.netology

import kotlin.math.roundToInt
const val VISA = "Visa"
const val MAESTRO = "Maestro"
const val MASTERCARD = "Mastercard"
const val VK = "VkPay"
const val MIR = "Mir"

fun main() {
    val result = checkCommission(currentSum =  90)
    val message = formattedMessage(result)

    println(message)
}

fun checkCommission(type: String = VK, previousSum: Int = 0, currentSum: Int): Int{
    return when (type){
        MAESTRO, MASTERCARD -> checkPreviousTransactions(previousSum,currentSum)
        VISA, MIR -> checkMinCommission(currentSum)
        VK -> 0
        else -> error("Unsupported payment system")
    }
}

fun checkPreviousTransactions(previousSum: Int, currentSum: Int): Int{
    return if (previousSum / 100 > 75000) (currentSum * 0.006 + 2000).roundToInt() else 0
}

fun checkMinCommission(sum: Int): Int {
    val amount = (sum * 0.0075).roundToInt()
    val minCommission = 3500
    return if (amount > minCommission) amount else minCommission

}
    fun formattedMessage(sum: Int): String{
       val roubles = sum / 100
        val cents = sum % 100
        return "Комиссия составит $roubles р. $cents к."
    }
