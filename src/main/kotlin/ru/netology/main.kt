package ru.netology

import kotlin.math.roundToInt
const val VISA = "Visa"
const val MAESTRO = "Maestro"
const val MASTERCARD = "Mastercard"
const val VK = "VkPay"
const val MIR = "Mir"
const val MIN_COMMISSION = 3500 // for visa, mir
const val PERCENT_V_M = 0.75 // % for visa, mir
const val LIMIT = 75000 * 100 // limit for maestro, mastercard for zero commission
const val PERCENT_M_M = 0.6 // % for maestro, mastercard
const val ADDITIONAL_PAY = 2000 // add to commission for maestro, mastercard

fun main() {
    val result = checkCommission(currentSum =  90)
    println(formattedMessage(result))
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
    return if (previousSum > LIMIT) (currentSum * (PERCENT_M_M / 100) + ADDITIONAL_PAY).roundToInt() else 0
}

fun checkMinCommission(sum: Int): Int {
    val amount = (sum * (PERCENT_V_M / 100)).roundToInt()
    return if (amount > MIN_COMMISSION) amount else MIN_COMMISSION

}
    fun formattedMessage(sum: Int): String{
       val roubles = sum / 100
        val cents = sum % 100
        return "Комиссия составит $roubles р. $cents к."
    }
