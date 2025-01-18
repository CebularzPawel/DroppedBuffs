package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.buffs.WaterBreathingBuff;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Water_Breathing_Buff_Entity extends Basic_Buff_Entity {
    public Water_Breathing_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new WaterBreathingBuff().getColor();
    }

    public static boolean canSpawn(LivingDeathEvent event) {
        if(!event.getEntity().level().getFluidState(event.getEntity().blockPosition()).is(Fluids.WATER)){
            return false;
        }
        return configactive;
    }
}
