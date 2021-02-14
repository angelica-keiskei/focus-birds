package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v2.user

import chalkboard.me.twitter_api_client.infrastructure.transfer.api.v1.timeline.UserTimeLineTransfer
import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRepository
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.lang.RuntimeException

@Repository
class UserLookupTransfer(
    private val userConfig: UserConfig
) : UserLookupRepository {

    companion object {
        private val log = LoggerFactory.getLogger(UserTimeLineTransfer::class.java)
    }

    override fun userLookup(request: UserLookupRequest, screenName: String): Mono<LookUpResponse> {
        return userConfig.userLookupClient().get()
            .uri { builder ->
                builder.queryParams(request.queryParameter()).build(screenName)
            }
            .retrieve()
            .onStatus(HttpStatus::isError) { clientResponse ->
                clientResponse.bodyToMono(String::class.java).map { response ->
                    log.error(response)
                    RuntimeException()
                }
            }
            .bodyToMono(LookUpResponse::class.java)
    }
}