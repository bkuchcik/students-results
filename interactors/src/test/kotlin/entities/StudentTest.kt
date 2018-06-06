package entities

import com.students.results.entities.Exam
import com.students.results.entities.Student
import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it

class StudentTest : Spek({

    given("a student") {
        val student = Student(id = 40L)
        val exam = Exam(id = 50L)

        it("getNot without note should returns NotEvaluatedException") {
            student.getNotation(exam).isLeft() shouldBe true
        }
        it("notate an exam with 20 and get notation should return 20") {
            student.notate(exam, "20".toBigDecimal()).apply {
                isRight() shouldBe true
                map {
                    it.getNotation(exam).apply {
                        isRight() shouldBe true
                        map { it shouldEqual "20".toBigDecimal() }
                    }
                }
            }
        }
        it("notate less than zero should fail to register note") {
            student.notate(exam, "-1".toBigDecimal()).isLeft() shouldBe true
        }
    }
})