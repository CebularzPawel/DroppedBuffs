package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.buffs.SpeedBuff;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Speed_Buff_Entity extends Basic_Buff_Entity {
    public Speed_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new SpeedBuff().getColor();
        this.setBuffId(new ResourceLocation(DroppedBuffs.MOD_ID,"speed"));

    }

}
