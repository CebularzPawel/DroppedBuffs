package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.buffs.FireResistanceBuff;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Fire_Resistance_Buff_Entity extends Basic_Buff_Entity {
    public Fire_Resistance_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new FireResistanceBuff().getColor();
    }

    public static boolean canSpawn(LivingDeathEvent event) {
        return configactive;
    }
}
