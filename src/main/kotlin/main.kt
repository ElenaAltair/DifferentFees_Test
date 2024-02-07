/*
Cумма комиссии будет зависеть ещё и от типа карты, с которой мы переводим средства.

За переводы с карты Mastercard комиссия не взимается,
пока не превышен месячный лимит в 75 000 руб. Если лимит превышен,
комиссия составит 0,6% + 20 руб.
За переводы с карты Visa комиссия составит 0,75%, минимальная сумма комиссии 35 руб.
За переводы с карты Мир комиссия не взимается.
Кроме того, введём лимиты на суммы перевода за сутки и за месяц. Максимальная сумма перевода с одной карты:

150 000 руб. в сутки
600 000 руб. в месяц
Комиссия в лимитах не учитывается.

Т. е. если пользователь решит перевести матери 150 000 руб.
с карты Mastercard впервые за месяц, то его мать получит всю сумму,
а комиссия будет удержана сверх этого.
Сумма комиссии составит 75 000 * 0,006 + 20 = 470 руб.
(т. к. с первых 75 000 руб. комиссия не взимается).
 */

/*
Напишите алгоритм расчёта в виде функции, передавая в функцию:

тип карты (по умолчанию Мир);
сумму предыдущих переводов в этом месяце (по умолчанию 0 рублей);
сумму совершаемого перевода.
В случае превышения какого-либо из лимитов операция должна блокироваться.
 */

val cardType = "Mastercard" // тип карты
var amountPreviousTransfers = 200000  //сумма предыдущих переводов в этом месяце (по умолчанию 0 рублей)
val amountTransferBeingMade = 110000    //сумма совершаемого перевода
val transferLimitPerDay = 150000 //Максимальная сумма перевода с одной карты руб. в сутки
val transferLimitPerMonth = 600000 // Максимальная сумма перевода с одной карты руб. в месяц
val visaMinTransfer = 35.0
val mastercardLimitMonth = 75000


fun main() {
    if (amountTransferBeingMade > transferLimitPerDay) {
        println("Операция заблокирована. Превышен суточный лимит.")
    } else if ((amountPreviousTransfers + amountTransferBeingMade) > transferLimitPerMonth) {
        println("Операция заблокирована. Превышен месячный лимит.")
    } else {
        println(
            "Комиссия составит " + calculatingCommission(
                cardType,
                amountPreviousTransfers,
                amountTransferBeingMade
            )
        )
    }

}

fun calculatingCommission(
    cardType: String = "Мир",
    amountPreviousTransfers: Int = 0,
    amountTransferBeingMade: Int
): Double {
    var transfer: Double = 0.0
    when (cardType) {
        "Mastercard" -> {
            if (amountPreviousTransfers == 0 && amountTransferBeingMade > mastercardLimitMonth) {
                transfer = (amountTransferBeingMade - mastercardLimitMonth) * 0.006 + 20
            } else if (amountPreviousTransfers <= mastercardLimitMonth && (amountPreviousTransfers + amountTransferBeingMade) > mastercardLimitMonth) {
                transfer = (amountPreviousTransfers + amountTransferBeingMade - mastercardLimitMonth) * 0.006 + 20
            } else if (amountPreviousTransfers > mastercardLimitMonth) {
                transfer = amountTransferBeingMade * 0.006 + 20
            }
        }

        "Visa" -> {
            transfer = amountTransferBeingMade * 0.0075
            if (transfer < visaMinTransfer) transfer = visaMinTransfer
        }
    }
    return transfer
}