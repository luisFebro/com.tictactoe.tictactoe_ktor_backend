package com.tictactoe.models

import kotlinx.serialization.Serializable

// exp: https://youtu.be/sKCCwl5lNBk?t=729s
@Serializable
data class GameState(
    val playerAtTurn: Char? = 'X',
    val field: Array<Array<Char?>> = emptyField(),
    val winningPlayer: Char? = null,
    val isBoardFull: Boolean = false,
    val connectedPlayers: List<Char> = emptyList()
) {
    companion object {
        fun emptyField(): Array<Array<Char?>> {
            return arrayOf(
                arrayOf(null, null, null),
                arrayOf(null, null, null),
                arrayOf(null, null, null),
            )
        }
    }

    // exp: https://youtu.be/sKCCwl5lNBk?t=915s
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameState

        if (playerAtTurn != other.playerAtTurn) return false
        if (!field.contentDeepEquals(other.field)) return false
        if (winningPlayer != other.winningPlayer) return false
        if (isBoardFull != other.isBoardFull) return false

        return true
    }

    override fun hashCode(): Int {
        var result = playerAtTurn?.hashCode() ?: 0
        result = 31 * result + field.contentDeepHashCode()
        result = 31 * result + (winningPlayer?.hashCode() ?: 0)
        result = 31 * result + isBoardFull.hashCode()
        result = 31 * result + connectedPlayers.hashCode()
        return result
    }
}
