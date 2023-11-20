//package study.kopring
//
//import io.kotest.core.spec.style.FunSpec
//import io.kotest.matchers.shouldBe
//import io.kotest.matchers.shouldNotBe
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
//import study.kopring.domain.user.entity.User
//import study.kopring.domain.user.enums.Gender
//import study.kopring.domain.user.repository.UserRepository
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//class BaseTimeEntityTest(
//    @Autowired
//    private val userRepository: UserRepository
//) : FunSpec({
//
//    test("User 생성 시 createdAt과 lastModifiedAt이 생성된 시각으로 저장되어야 한다.") {
//        val user = User(
//            email = "test@test.com",
//            name = "홍길동",
//            gender = Gender.MAN
//        )
//
//        val savedUser = userRepository.save(user)
//
//        savedUser.createdAt shouldBe savedUser.lastModifiedAt
//    }
//
//    test("User를 수정하면 lastModifiedAt이 변경된 시각으로 수정되어야 한다.") {
//        val user = User(
//            email = "test2@test.com",
//            name = "홍길동",
//            gender = Gender.MAN
//        )
//        val savedUser = userRepository.save(user)
//
//        Thread.sleep(1000)
//        savedUser.update("임꺽정", Gender.MAN)
//        val updatedUser = userRepository.save(savedUser)
//
//        updatedUser.createdAt shouldNotBe updatedUser.lastModifiedAt
//    }
//})