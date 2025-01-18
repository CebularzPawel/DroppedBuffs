package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.buffs.InvisibilityBuff;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Invisibility_Buff_Entity extends Basic_Buff_Entity {
    public Invisibility_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new InvisibilityBuff().getColor();
    }

}
