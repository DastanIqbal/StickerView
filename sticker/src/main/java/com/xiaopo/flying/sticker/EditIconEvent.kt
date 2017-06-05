package com.xiaopo.flying.sticker

import android.view.MotionEvent

/**
 * @author wupanjie
 */

class EditIconEvent : StickerIconEvent {
    interface IEditIconEvent {
        fun performEditAction(sticker: Sticker?)
    }

    var editIconEvent: IEditIconEvent? = null

    override fun onActionDown(stickerView: StickerView, event: MotionEvent) {}

    override fun onActionMove(stickerView: StickerView, event: MotionEvent) {}

    override fun onActionUp(stickerView: StickerView, event: MotionEvent) {
        editIconEvent?.performEditAction(stickerView.currentSticker)
    }
}
