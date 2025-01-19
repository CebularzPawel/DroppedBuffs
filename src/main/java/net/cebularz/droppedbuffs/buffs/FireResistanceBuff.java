package net.cebularz.droppedbuffs.buffs;

import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.api.AbstractBuff;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.entities.Basic_Buff_Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class FireResistanceBuff extends AbstractBuff {
    private static final int color = 0xeb6410;
    public static boolean configactive = true;
    @Override
    public void onPickup(Player player) {
        player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, DroppedBuffsConfig.buff_effect_duration*20,0));
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public EntityType<? extends Basic_Buff_Entity> getEntityType() {
        return ModEntities.FIRE_RESISTANCE_BUFF_ENTITY.get();
    }

    @Override
    public boolean canSpawn(LivingDeathEvent event) {
        Entity entity = event.getSource().getEntity();
        if (entity instanceof Player player) {
            boolean KillerOnFire = player.isOnFire();
            boolean InNether = player.level().dimension().equals(Level.NETHER);
            if(!(KillerOnFire||InNether)){
                return false;
            }
        }

        return configactive;
    }
}
