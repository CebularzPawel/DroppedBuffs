package net.cebularz.droppedbuffs.event;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.custom.Invisibility_Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Meat_Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Resistance_Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Strength_Buff_Entity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = DroppedBuffs.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingDeath(LivingDeathEvent event) {
            Random random = new Random();
            Entity entity = event.getSource().getEntity();
            if (entity instanceof Player player) {
                int chance = random.nextInt(100);
                int lootingLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.MOB_LOOTING, player.getMainHandItem());
                int lootingboost = Config.looting_extra_chance;
                int chance2 = Config.log_buff_chance;
                if (chance < chance2 + lootingLevel * lootingboost) {
                    int number = random.nextInt(4); //I know this isn't the most pretty code but it works.
                    if (number == 0) {
                        Meat_Buff_Entity buffentity = new Meat_Buff_Entity(ModEntities.MEAT_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 1) {
                        Invisibility_Buff_Entity buffentity = new Invisibility_Buff_Entity(ModEntities.INVISIBILITY_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 2) {
                        Resistance_Buff_Entity buffentity = new Resistance_Buff_Entity(ModEntities.RESISTANCE_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 3) {
                        Strength_Buff_Entity buffentity = new Strength_Buff_Entity(ModEntities.STRENGTH_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }

                }
            }
        }
    }
}
