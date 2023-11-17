package study.kopring.domain.common

import org.slf4j.Logger
import org.springframework.stereotype.Controller
import study.kopring.utils.logger.logger

@Controller
class BaseController() {
    val log: Logger = logger()
}