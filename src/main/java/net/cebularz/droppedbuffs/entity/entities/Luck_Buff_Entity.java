package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.buffs.LuckBuff;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

public class Luck_Buff_Entity extends Basic_Buff_Entity {
    public Luck_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color = new LuckBuff().getColor();
        this.setBuffId(Identifier.fromNamespaceAndPath(DroppedBuffs.MOD_ID,"luck"));

    }

}
