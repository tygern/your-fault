package org.gern.yourfault

private val statuses = UserErrorCodes.values()

val clientErrors = generateSequence(0){ (it + 1).rem(statuses.size) }
    .map { statuses[it] }
    .iterator()

enum class UserErrorCodes(val code: Int, val description: String) {
    BadRequest(400, "Bad Request"),
    Unauthorized(401, "Unauthorized"),
    PaymentRequired(402, "Payment Required"),
    Forbidden(403, "Forbidden"),
    NotFound(404, "Not Found"),
    MethodNotAllowed(405, "Method Not Allowed"),
    NotAcceptable(406, "Not Acceptable"),
    ProxyAuthenticationRequired(407, "Proxy Authentication Required"),
    RequestTimeout(408, "Request Timeout"),
    Conflict(409, "Conflict"),
    Gone(410, "Gone"),
    LengthRequired(411, "Length Required"),
    PreconditionFailed(412, "Precondition Failed"),
    PayloadTooLarge(413, "Payload Too Large"),
    URITooLong(414, "URI Too Long"),
    UnsupportedMediaType(415, "Unsupported Media Type"),
    RangeNotSatisfiable(416, "Range Not Satisfiable"),
    ExpectationFailed(417, "Expectation Failed"),
    ImATeapot(418, "I'm a teapot"),
    MisdirectedRequest(421, "Misdirected Request"),
    UnprocessableEntity(422, "Unprocessable Entity"),
    Locked(423, "Locked"),
    FailedDependency(424, "Failed Dependency"),
    UpgradeRequired(426, "Upgrade Required"),
    PreconditionRequired(428, "Precondition Required"),
    TooManyRequests(429, "Too Many Requests"),
    RequestHeaderFieldsTooLarge(431, "Request Header Fields Too Large"),
    UnavailableForLegalReasons(451, "Unavailable For Legal Reasons")
}
