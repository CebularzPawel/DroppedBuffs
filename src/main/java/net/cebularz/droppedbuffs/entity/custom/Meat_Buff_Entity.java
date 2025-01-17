package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.List;
import java.util.Random;

public class Meat_Buff_Entity extends Basic_Buff_Entity {


    public Meat_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color=0xD87C3F;
    }

    @Override
    public void buffOnPickUpEffect(Player player) {
        player.getFoodData().eat(8,6);
    }

    public static boolean canSpawn(LivingDeathEvent event) {
        return configactive;
    }

    public static void spawnBuff(Player player, LivingDeathEvent event) {
        if(canSpawn(event)) {
            Entity killedEntity = event.getEntity();
            Meat_Buff_Entity buffentity = new Meat_Buff_Entity(ModEntities.MEAT_BUFF_ENTITY.get(), killedEntity.level());
            buffentity.owner = player;
            buffentity.setPos(killedEntity.getX(), killedEntity.getY(), killedEntity.getZ());
            killedEntity.level().addFreshEntity(buffentity);
        }
    }
}
