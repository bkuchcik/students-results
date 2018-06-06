package embeded.redis.startup

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import redis.embedded.RedisServer

@Configuration
class RedisEmbededConfiguration {

    @Bean
    fun redisServer(): RedisServer = RedisServer(6379)
}