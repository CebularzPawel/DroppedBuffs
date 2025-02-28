package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.buffs.WaterBreathingBuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Water_Breathing_Buff_Entity extends Basic_Buff_Entity {
    public Water_Breathing_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new WaterBreathingBuff().getColor();
        this.setBuffId(new ResourceLocation(DroppedBuffs.MOD_ID,"waterbreathing"));

    }

}
