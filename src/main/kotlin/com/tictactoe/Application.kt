package com.tictactoe

import com.tictactoe.models.TicTacToeGame
import com.tictactoe.plugins.configureMonitoring
import com.tictactoe.plugins.configureRouting
import com.tictactoe.plugins.configureSerialization
import com.tictactoe.plugins.configureSockets
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

// ref: https://www.youtube.com/watch?v=sKCCwl5lNBk&t=1s
fun Application.module() {
    val game = TicTacToeGame()
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureRouting(game)
}
