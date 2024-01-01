package com.tictactoe.plugins

import com.tictactoe.models.TicTacToeGame
import com.tictactoe.socket
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting(game: TicTacToeGame) {
    routing {
        socket(game)
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
