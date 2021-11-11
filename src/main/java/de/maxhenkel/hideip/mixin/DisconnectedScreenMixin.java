package de.maxhenkel.hideip.mixin;

import net.minecraft.client.gui.screens.DisconnectedScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(DisconnectedScreen.class)
public abstract class DisconnectedScreenMixin {

    @Shadow
    @Final
    @Mutable
    private Component reason;

    @Inject(method = "init", at = @At("HEAD"))
    protected void injected(CallbackInfo ci) {
        if (reason instanceof TranslatableComponent tc) {
            reason = new TranslatableComponent(tc.getKey(), Arrays.stream(tc.getArgs()).map(Object::toString).map(this::censorString).toArray());
            System.out.println(Arrays.toString(tc.getArgs()));
        } else if (reason instanceof TextComponent tc) {
            reason = new TextComponent(censorString(tc.getText()));
        }
    }

    private String censorString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (s.equals(" ")) {
                sb.append(" ");
            } else {
                sb.append("\u2588");
            }
        }
        return sb.toString();
    }

}
