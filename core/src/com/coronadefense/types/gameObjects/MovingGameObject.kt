package com.coronadefense.types.gameObjects

import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

interface MovingGameObject {
  val texture: Texture
  fun draw(sprites: SpriteBatch)
  fun update(deltaTime: Float)
}