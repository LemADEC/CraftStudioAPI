package fr.zeamateis.test.anim.client;

import com.leviathanstudio.craftstudio.client.ModelCraftStudio;

import fr.zeamateis.test.anim.common.EntityTest;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;

public class RenderTest<T extends EntityTest> extends RenderLiving<T>
{
    public RenderTest() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelCraftStudio("CraftStudioAPITest", 64, 32), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return new ResourceLocation("testmod", "textures/entity/CraftStudioAPITest.png");
    }
}