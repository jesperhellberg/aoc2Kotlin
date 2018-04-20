import kotlin.test.assertEquals
import org.junit.jupiter.api.Test as test


class Test {
    val TESTINPUT = "5\t1\t9\t5\n" +
    "7\t5\t3\n" +
    "2\t4\t6\t8"

    val TESTINPUT2 = "5\t9\t2\t8\n" +
    "9\t4\t7\t3\n" +
    "3\t8\t6\t5"

    private val logic = Logic()

    @test
    fun testFirstInput() {
        val input = logic.transformInput(TESTINPUT)
        assertEquals(18, logic.version1(input))
    }

    @test
    fun testSecondInput() {
        val input = logic.transformInput(TESTINPUT2)
        assertEquals(9, logic.version2(input))
    }
}