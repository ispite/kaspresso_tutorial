package com.kaspersky.kaspresso.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object SimpleScreen : KScreen<SimpleScreen>() {

    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val simpleTitle: KTextView = KTextView { withId(R.id.simple_title) }
    val inputText: KEditText = KEditText { withId(R.id.input_text) }
    val changeTitleButton: KButton = KButton { withId(R.id.change_title_btn) }
}
