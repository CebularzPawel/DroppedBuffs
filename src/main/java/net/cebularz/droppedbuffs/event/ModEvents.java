package net.cebularz.droppedbuffs.event;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.client.Speed_Buff.Speed_Buff_Model;
import net.cebularz.droppedbuffs.entity.client.Water_Breathing_Buff.Water_Breathing_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.custom.*;
import net.cebularz.droppedbuffs.init.BuffsList;
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
                    int number = random.nextInt(BuffsList.classes.length);

                    Basic_Buff_Entity selectedbuff=BuffsList.getBuffByIndex()






                }
            }
        }
    }
}