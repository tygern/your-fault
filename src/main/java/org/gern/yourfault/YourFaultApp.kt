package org.gern.yourfault

import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.server.handler.AbstractHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


fun main(args: Array<String>) = YourFault().start()

class YourFault {
    private val server = Server(8080).apply {
        stopAtShutdown = true
    }

    init {
        server.handler = object : AbstractHandler() {
            override fun handle(s: String, request: Request, servletRequest: HttpServletRequest, servletResponse: HttpServletResponse) {
                val error = clientErrors.next()

                servletResponse.status = error.code
                servletResponse.outputStream.write("${error.code}: ${error.description}".toByteArray())
                request.isHandled = true
            }
        }
    }

    fun start() = server.start()
}
