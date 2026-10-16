package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.buffs.AbsorptionBuff;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class Absorption_Buff_Entity extends Basic_Buff_Entity {
    public Absorption_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color= new AbsorptionBuff().getColor();
        this.setBuffId(Identifier.fromNamespaceAndPath(DroppedBuffs.MOD_ID,"absorption"));

    }

}
