package ru.netology

import org.junit.Assert.*
import org.junit.Test
import java.lang.IllegalStateException


class MainKtTest {


    @Test
    fun checkCommission_VK() {
        val type = VK
        val previousSum = 0
        val currentSum = 1000
        val expected = 0

        val result = checkCommission(type = type, previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkCommission_MAESTRO(){
        val type = MAESTRO
        val previousSum = 0
        val currentSum = 1000
        val expected = 0

        val result = checkCommission(type = type, previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkCommission_VISA(){
        val type = VISA
        val previousSum = 0
        val currentSum = 1000
        val expected = MIN_COMMISSION

        val result = checkCommission(type = type, previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkCommission_MIR(){
        val type = MIR
        val previousSum = 0
        val currentSum = 1000
        val expected = MIN_COMMISSION

        val result = checkCommission(type = type, previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkCommission_MASTERCARD(){
        val type = MASTERCARD
        val previousSum = 0
        val currentSum = 1000
        val expected = 0

        val result = checkCommission(type = type, previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkCommission_ELSE_EXCEPTION(){
        val type = "Tjsd"
        val previousSum = 0
        val currentSum = 1000

        val thrown = assertThrows(
            IllegalStateException::class.java
        ) {  checkCommission(type = type, previousSum = previousSum, currentSum = currentSum) }

        assertEquals("Unsupported payment system", thrown.message)

    }

    @Test
    fun checkPreviousTransactions() {
        val previousSum = 0
        val currentSum = 1000
        val expected = 0

        val result = checkPreviousTransactions(previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }
    @Test
    fun checkPreviousTransactions_SHOULD_HAVE_COMMISSION(){
        val previousSum = LIMIT + 1000 * 100
        val currentSum = 1000
        val expected = 2006

        val result = checkPreviousTransactions(previousSum = previousSum, currentSum = currentSum)

        assertEquals(expected, result)
    }

    @Test
    fun checkMinCommission() {
        val sum = 1000
        val expected = MIN_COMMISSION

        val result = checkMinCommission(sum = sum)

        assertEquals(expected, result)
    }
    @Test
    fun checkMinCommission_SHOUD_NOT_USE_MIN_COMMISSION(){
        val sum = 500_000
        val expected = 3750

        val result = checkMinCommission(sum = sum)

        assertEquals(expected, result)
    }
}