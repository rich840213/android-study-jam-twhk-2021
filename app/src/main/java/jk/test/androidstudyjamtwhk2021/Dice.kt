package jk.test.androidstudyjamtwhk2021

class Dice(
    val numSides: Int = 6
) {
    fun roll(current: Int = 1): Int {
        var newVal: Int

        do {
            newVal = (1..numSides).random()
        } while (current == newVal)

        return newVal
    }
}