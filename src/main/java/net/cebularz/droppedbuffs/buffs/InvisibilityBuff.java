package net.cebularz.droppedbuffs.buffs;

import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.api.AbstractBuff;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class InvisibilityBuff extends AbstractBuff {
    private static final int color = 0xffc400;
    public static boolean configactive = true;
    @Override
    public void onPickup(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, DroppedBuffsConfig.buff_effect_duration * 20, 0));
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public EntityType<? extends Basic_Buff_Entity> getEntityType() {
        return ModEntities.INVISIBILITY_BUFF_ENTITY.get();
    }

    @Override
    public boolean canSpawn(LivingDeathEvent event) {
        return configactive;
    }
}
