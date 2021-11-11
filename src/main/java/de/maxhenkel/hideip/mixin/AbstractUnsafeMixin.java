package de.maxhenkel.hideip.mixin;

import io.netty.channel.nio.AbstractNioByteChannel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.net.SocketAddress;

//@Mixin(targets = {"io/netty/channel/socket/nio/NioSocketChannel$NioSocketChannelUnsafe"}, remap = false)
@Mixin(targets = {"io/netty/channel/AbstractChannel$AbstractUnsafe"}, remap = false)
public abstract class AbstractUnsafeMixin {

    /*@Inject(method = "annotateConnectException", at = @At("HEAD"), remap = false)
    protected void annotateConnectException(Throwable cause, SocketAddress remoteAddress, CallbackInfoReturnable<Throwable> ci) {
        System.out.println("-----------!!!!!!!!!!!");

    }*/

}
