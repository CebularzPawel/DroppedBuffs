package net.cebularz.droppedbuffs.buffs;

import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.api.AbstractBuff;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class NightVisionBuff extends AbstractBuff {
    private static final int color = 0x9115c2;
    public static boolean configactive = true;
    @Override
    public void onPickup(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, DroppedBuffsConfig.buff_effect_duration * 20, 0));
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public EntityType<? extends Basic_Buff_Entity> getEntityType() {
        return ModEntities.NIGHT_VISION_BUFF_ENTITY.get();
    }

    @Override
    public boolean canSpawn(LivingDeathEvent event) {
        int lightlevel = event.getEntity().level().getBrightness(LightLayer.BLOCK,event.getEntity().blockPosition())+event.getEntity().level().getBrightness(LightLayer.SKY,event.getEntity().blockPosition());
        if (lightlevel>5){
            return false;
        }
        return configactive;
    }
}
