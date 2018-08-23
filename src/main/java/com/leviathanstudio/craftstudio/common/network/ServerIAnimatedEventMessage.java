package com.leviathanstudio.craftstudio.common.network;

import com.leviathanstudio.craftstudio.common.animation.AnimationHandler;
import com.leviathanstudio.craftstudio.common.animation.IAnimated;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Message to send an IAnimated event to the server.
 * 
 * @since 0.3.0
 * 
 * @author Timmypote
 */
public class ServerIAnimatedEventMessage extends IAnimatedEventMessage
{
    /** Constructor */
    public ServerIAnimatedEventMessage() {}

    /** Constructor */
    public ServerIAnimatedEventMessage(EnumIAnimatedEvent event, IAnimated animated, short animId) {
        super(event, animated, animId);
    }

    /** Constructor */
    public ServerIAnimatedEventMessage(EnumIAnimatedEvent event, IAnimated animated, short animId, float keyframeInfo) {
        super(event, animated, animId, keyframeInfo);
    }

    /** Constructor */
    public ServerIAnimatedEventMessage(EnumIAnimatedEvent event, IAnimated animated, short animId, float keyframeInfo, short optAnimId) {
        super(event, animated, animId, keyframeInfo, optAnimId);
    }

    /** Constructor */
    public ServerIAnimatedEventMessage(IAnimatedEventMessage eventObj) {
        super(eventObj);
    }

    /**
     * Handler for IAnimated event messages send to the server.
     * 
     * @since 0.3.0
     * 
     * @author Timmypote
     */
    public static class ServerIAnimatedEventHandler extends IAnimatedEventHandler
            implements IMessageHandler<ServerIAnimatedEventMessage, ClientIAnimatedEventMessage>
    {
        @Override
        public ClientIAnimatedEventMessage onMessage(ServerIAnimatedEventMessage message, MessageContext ctx) {
            if (!super.onMessage(message, ctx))
                return null;

            message.animated.getAnimationHandler();
            boolean success = AnimationHandler.onServerIAnimatedEvent(message);
            if (success && message.event != EnumIAnimatedEvent.ANSWER_START_ANIM.getId())
                return new ClientIAnimatedEventMessage(message);
            return null;
        }

        @Override
        public Entity getEntityById(MessageContext ctx, int entityId) {
            return ctx.getServerHandler().player.world.getEntityByID(entityId);
        }

        @Override
        public TileEntity getTileEntityByPos(MessageContext ctx, int x, int y, int z) {
            BlockPos pos = new BlockPos(x, y, z);
            return ctx.getServerHandler().player.world.getTileEntity(pos);
        }
    }
}
