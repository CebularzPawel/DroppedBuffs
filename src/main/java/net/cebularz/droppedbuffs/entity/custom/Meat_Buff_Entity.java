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

import java.util.List;
import java.util.Random;

public class Meat_Buff_Entity extends Basic_Buff_Entity {


    public Meat_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color=0xD87C3F;
    }

    @Override
    protected void effect(Player player) {
        player.getFoodData().eat(8,6);
    }
}
