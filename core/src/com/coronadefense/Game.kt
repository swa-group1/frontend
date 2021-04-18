package com.coronadefense

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.InputMultiplexer
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.coronadefense.api.ApiClient
import com.coronadefense.api.HighScore
import kotlinx.coroutines.*

class Game : ApplicationAdapter() {
  companion object {
    const val WIDTH = 800F
    const val HEIGHT = 480F
    const val TITLE = "Game"
    var batch: SpriteBatch? = null
  }
  var batch: SpriteBatch? = null
  var img: Texture? = null
  var highScores: List<HighScore>? = null
  var lobbyId: Long? = null
  var font: BitmapFont? = null
  override fun create() {
    batch = SpriteBatch()
    font = BitmapFont()
    GlobalScope.launch {
      lobbyId = ApiClient.createLobbyRequest("Hermanns", "test")
      highScores = ApiClient.highScoreListRequest()
    }
  }
  override fun render() {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch?.begin()
    if (lobbyId != null) {
      font!!.draw(batch, "$lobbyId", 10f, 30f)
    }
    if (highScores != null) {
      for (i in highScores!!.indices) {
        font!!.draw(
          batch, "${highScores!![i].name}: ${highScores!![i].value}", 10f, 60f + 30f * (i)
        )
      }
    }
    batch?.end()
  }
  override fun dispose() {
    batch?.dispose()
  }
}