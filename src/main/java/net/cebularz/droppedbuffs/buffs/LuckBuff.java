package net.cebularz.droppedbuffs.buffs;

import net.cebularz.droppedbuffs.api.AbstractBuff;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;

public class LuckBuff extends AbstractBuff {
    private static final int color = 0x54e62c;

    @Override
    public void onPickup(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.LUCK, 30 * 20, 0));
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public EntityType<? extends Basic_Buff_Entity> getEntityType() {
        return ModEntities.LUCK_BUFF_ENTITY.get();
    }
}
