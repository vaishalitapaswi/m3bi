import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.function.Executable

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun whenAdding1and3_thenAnswerIs4() {
        Assertions.assertEquals(4, calculator.add(1, 3))
    }
    fun whenSquaringNumbers_thenCorrectAnswerGiven() {
        Assertions.assertAll(
            Executable { Assertions.assertEquals(1, calculator.square(1)) },
            Executable { Assertions.assertEquals(4, calculator.square(2)) },
            Executable { Assertions.assertEquals(9, calculator.square(3)) }
        )
    }
    @Test
    fun whenEmptyList_thenListIsEmpty() {
        val list = listOf<String>()
        Assertions.assertTrue(list::isEmpty)
    }
    @Test
    fun when3equals4_thenTestFails() {
        val actual = 4
        Assertions.assertEquals(3, actual) {
            "3 does not equal $actual"
        }

        @TestFactory
        fun testSquares() = listOf(
            DynamicTest.dynamicTest("when I calculate 1^2 then I get 1") { Assertions.assertEquals(1,calculator.square(1))},
            DynamicTest.dynamicTest("when I calculate 2^2 then I get 4") { Assertions.assertEquals(4,calculator.square(2))},
            DynamicTest.dynamicTest("when I calculate 3^2 then I get 9") { Assertions.assertEquals(9,calculator.square(3))}
        )
        @TestFactory
        fun testSquares1() = listOf(
            1 to 1,
            2 to 4,
            3 to 9,
            4 to 16,
            5 to 25)
            .map { (input, expected) ->
                DynamicTest.dynamicTest("when I calculate $input^2 then I get $expected") {
                    Assertions.assertEquals(expected, calculator.square(input))
                }
            }

    }
}