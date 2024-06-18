package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class Invisibility_Buff_Entity extends Basic_Buff_Entity {


    public Invisibility_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color=0xffc400;
    }

    @Override
    protected void effect(Player player) {
        MobEffectInstance effect = new MobEffectInstance(MobEffects.INVISIBILITY,30*20,0);
        player.addEffect(effect);
    }
}
