package com.ryanbester.keepcommandhistory.mixin;

import net.minecraft.client.gui.components.ChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChatComponent.class)
public abstract class MixinNewChatGui {

    @Inject(at = @At("HEAD"), method = "clearMessages(Z)V", cancellable = true)
    private void onClearChatHistory(boolean variable, CallbackInfo callback) {
        if (variable) {
            callback.cancel();
        }
    }

}
