package study.kopring.domain.common

import org.slf4j.Logger
import study.kopring.utils.logger.logger

open class BaseController {
    val log: Logger = logger()
}