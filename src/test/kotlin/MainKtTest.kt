import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun calculatingCommissionMastercard1() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 200000
        val amountTransferBeingMade = 110000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(680.0, result)
    }

    @Test
    fun calculatingCommissionMastercard11() {
        val typeCard = "Maestro"
        val amountPreviousTransfers = 200000
        val amountTransferBeingMade = 110000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(680.0, result)
    }

    @Test
    fun calculatingCommissionMastercard2() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 200000
        val amountTransferBeingMade = 160000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionMastercard3() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 10000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(0.0, result)
    }

    @Test
    fun calculatingCommissionMastercard4() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 100000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(170.0, result)
    }

    @Test
    fun calculatingCommissionMastercard5() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 60000
        val amountTransferBeingMade = 100000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(530.0, result)
    }

    @Test
    fun calculatingCommissionMastercard6() {
        val typeCard = "Mastercard"
        val amountPreviousTransfers = 580000
        val amountTransferBeingMade = 60000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionVisa1() {
        val typeCard = "Visa"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 10000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(75.0, result)
    }

    @Test
    fun calculatingCommissionVisa11() {
        val typeCard = "Мир"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 10000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(75.0, result)
    }

    @Test
    fun calculatingCommissionVisa2() {
        val typeCard = "Visa"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 1000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(35.0, result)
    }

    @Test
    fun calculatingCommissionVisa3() {
        val typeCard = "Visa"
        val amountPreviousTransfers = 550000
        val amountTransferBeingMade = 70000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionVisa4() {
        val typeCard = "Visa"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 160000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionVK1() {
        val typeCard = "VK Pay"
        val amountPreviousTransfers = 35000
        val amountTransferBeingMade = 7000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionVK2() {
        val typeCard = "VK Pay"
        val amountPreviousTransfers = 12000
        val amountTransferBeingMade = 7000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(0.0, result)
    }

    @Test
    fun calculatingCommissionVK3() {
        val typeCard = "VK Pay"
        val amountPreviousTransfers = 0
        val amountTransferBeingMade = 16000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-2.0, result)
    }

    @Test
    fun calculatingCommissionErrorCard() {
        val typeCard = "VK"
        val amountPreviousTransfers = 12000
        val amountTransferBeingMade = 7000

        val result = calculatingCommission(typeCard, amountPreviousTransfers,amountTransferBeingMade)

        assertEquals(-1.0, result)
    }

}