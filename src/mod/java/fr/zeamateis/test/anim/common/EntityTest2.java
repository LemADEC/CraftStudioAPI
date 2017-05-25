package fr.zeamateis.test.anim.common;

import com.leviathanstudio.craftstudio.common.IAnimated;

import fr.zeamateis.test.anim.common.animations.AnimationHandlerTest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityTest2 extends EntityCreature implements IAnimated
{
    protected AnimationHandlerTest animHandler;
    protected boolean              fanOpen = true;

    public EntityTest2(World par1World) {
        super(par1World);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    // Getter for animation handler
    @Override
    public AnimationHandlerTest getAnimationHandler() {
        if (this.animHandler == null)
            this.animHandler = new AnimationHandlerTest(this);
        return this.animHandler;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        if (!this.getAnimationHandler().isAnimationActive(Mod_Test.MODID, "close_fan")
                && !this.getAnimationHandler().isAnimationActive(Mod_Test.MODID, "open_fan"))
            if (this.fanOpen) {
                this.getAnimationHandler().executeAnimation(Mod_Test.MODID, "close_fan", 0);
                this.fanOpen = false;
            }
            else {
                this.getAnimationHandler().executeAnimation(Mod_Test.MODID, "open_fan", 0);
                this.fanOpen = true;
            }

        return true;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        // Activate the animation in ticking method
        // if (!this.getAnimationHandler().isAnimationActive("close_fan"))
        // this.getAnimationHandler().executeAnimation("close_fan", 0);
    }
}
