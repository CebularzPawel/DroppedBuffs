package net.cebularz.droppedbuffs.event;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.client.Speed_Buff.Speed_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Water_Breathing_Buff.Water_Breathing_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.custom.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.WaterFluid;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
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
                if(player.hasEffect(MobEffects.LUCK)){
                    chance+=Config.luck_extra_chance;
                }

                int chance2 = Config.log_buff_chance;
                if (chance < chance2 + lootingLevel * lootingboost) {
                    int number = random.nextInt(10);
                    List<Boolean> Checklist = new ArrayList<>(Config.activelist);
                    if(!event.getEntity().level().getFluidState(event.getEntity().blockPosition()).is(Fluids.WATER)){
                        Checklist.set(9,false);
                    }
                    boolean havetrue = Checklist.contains(true);

                    while ((!Checklist.get(number)&&havetrue)) {
                        number = random.nextInt(10);
                    }
                    if(!havetrue){
                        number=-1;
                    }



                    if (number == 5) {
                        Meat_Buff_Entity buffentity = new Meat_Buff_Entity(ModEntities.MEAT_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 3) {
                        Invisibility_Buff_Entity buffentity = new Invisibility_Buff_Entity(ModEntities.INVISIBILITY_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 6) {
                        Resistance_Buff_Entity buffentity = new Resistance_Buff_Entity(ModEntities.RESISTANCE_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 8) {
                        Strength_Buff_Entity buffentity = new Strength_Buff_Entity(ModEntities.STRENGTH_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 1) {
                        Haste_Buff_Entity buffentity = new Haste_Buff_Entity(ModEntities.HASTE_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 2) {
                        Heal_Buff_Entity buffentity = new Heal_Buff_Entity(ModEntities.HEAL_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 4) {
                        Luck_Buff_Entity buffentity = new Luck_Buff_Entity(ModEntities.LUCK_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 7) {
                        Speed_Buff_Entity buffentity = new Speed_Buff_Entity(ModEntities.SPEED_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 0) {
                        Absorption_Buff_Entity buffentity = new Absorption_Buff_Entity(ModEntities.ABSORPTION_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);
                    }
                    if (number == 9) {
                        Water_Breathing_Buff_Entity buffentity = new Water_Breathing_Buff_Entity(ModEntities.WATER_BREATHING_BUFF_ENTITY.get(), event.getEntity().level());
                        buffentity.owner = player;
                        buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());
                        event.getEntity().level().addFreshEntity(buffentity);

                    }
                }
            }
        }
    }
}
