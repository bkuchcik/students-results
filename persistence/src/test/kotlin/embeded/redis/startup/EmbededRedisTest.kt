package embeded.redis.startup

import com.students.results.redis.configuration.RedisConfiguration
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import redis.embedded.RedisServer

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [RedisConfiguration::class, RedisEmbededConfiguration::class])
@TestInstance(Lifecycle.PER_CLASS)
abstract class RedisTestConfiguration protected constructor() {
    @Autowired
    private lateinit var redisServer: RedisServer

    @BeforeAll
    fun beforeStart() {
        redisServer.start()
    }

    @AfterAll
    fun afterStart() {
        redisServer.stop()
    }
}

class EmbededRedisTest : RedisTestConfiguration() {


    @Test
    fun runATEst() {
        println("I am running")
    }

}