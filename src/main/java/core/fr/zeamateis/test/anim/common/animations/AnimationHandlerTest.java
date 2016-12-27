package fr.zeamateis.test.anim.common.animations;

import java.util.HashMap;

import lib.craftstudio.common.IAnimated;
import lib.craftstudio.common.animation.AnimationHandler;
import lib.craftstudio.common.animation.Channel;

/**
 * The Animation handler class to register all animations you want in static
 * method
 */
public class AnimationHandlerTest extends AnimationHandler
{
    public AnimationHandlerTest(IAnimated entity) {
        super(entity);
    }

    /** Map with all the animations. */
    public static HashMap<String, Channel> animChannels = new HashMap<>();

    /** Register the animation(s) */
    static {
        AnimationHandlerTest.animChannels.put("block", new ChannelBlockAnimation("block", 30.0F));
        AnimationHandlerTest.animChannels.put("idle", new ChannelIdleAnimation("idle", 30.0F));
    }

    @Override
    public void executeAnimation(String name, float startingFrame) {
        super.executeAnimation(AnimationHandlerTest.animChannels, name, startingFrame);
    }

    @Override
    public void stopAnimation(String name) {
        super.stopAnimation(AnimationHandlerTest.animChannels, name);
    }

}