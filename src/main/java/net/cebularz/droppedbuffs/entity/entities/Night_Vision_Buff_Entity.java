package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.buffs.NightVisionBuff;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Night_Vision_Buff_Entity extends Basic_Buff_Entity {
    public Night_Vision_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new NightVisionBuff().getColor();
    }


}
