package net.cebularz.droppedbuffs.buffs;

import net.cebularz.droppedbuffs.api.AbstractBuff;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;

public class AbsorptionBuff extends AbstractBuff {
    private static final int color = 0xffc919;

    @Override
    public void onPickup(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 30 * 20, 1));
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public EntityType<? extends Basic_Buff_Entity> getEntityType() {
        return ModEntities.ABSORPTION_BUFF_ENTITY.get();
    }
}
