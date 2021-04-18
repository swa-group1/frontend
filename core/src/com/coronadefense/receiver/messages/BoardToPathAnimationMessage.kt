package com.coronadefense.receiver.messages

data class BoardToPathAnimationMessage(
    val spriteNumber: UByte,
    val startX: UByte,
    val startY: UByte,
    val endPosition: UShort,
    val startTime: UShort,
    val endTime: UShort,
    val resultAnimation: UByte
): IMessage
