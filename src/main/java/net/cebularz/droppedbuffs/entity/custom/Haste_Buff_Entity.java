package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;

public class Haste_Buff_Entity extends Basic_Buff_Entity {

    public Haste_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = 0xe38305;
    }

    @Override
    public void buffOnPickUpEffect(Player player) {
        MobEffectInstance effect = new MobEffectInstance(MobEffects.DIG_SPEED,30*20,0);
        player.addEffect(effect);
    }

    public static boolean canSpawn(LivingDeathEvent event) {
        return configactive;
    }

    public static void spawnBuff(Player player, LivingDeathEvent event) {
        if(canSpawn(event)) {
            Entity killedEntity = event.getEntity();
            Haste_Buff_Entity buffentity = new Haste_Buff_Entity(ModEntities.HASTE_BUFF_ENTITY.get(), killedEntity.level());
            buffentity.owner = player;
            buffentity.setPos(killedEntity.getX(), killedEntity.getY(), killedEntity.getZ());
            killedEntity.level().addFreshEntity(buffentity);
        }
    }
}
