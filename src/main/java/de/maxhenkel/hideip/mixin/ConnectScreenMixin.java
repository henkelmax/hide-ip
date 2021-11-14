package de.maxhenkel.hideip.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net/minecraft/client/gui/screens/ConnectScreen$1")
public class ConnectScreenMixin {

    @Redirect(method = "run", at = @At(value = "INVOKE", target = "Ljava/lang/Exception;toString()Ljava/lang/String;"))
    private String injected(Exception exception) {
        return exception.getCause().getMessage();
    }

}
