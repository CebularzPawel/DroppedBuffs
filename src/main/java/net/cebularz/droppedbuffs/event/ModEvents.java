package net.cebularz.droppedbuffs.event;

import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.api.Buff;
import net.cebularz.droppedbuffs.api.BuffRegistry;
import net.cebularz.droppedbuffs.entity.entities.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public class ModEvents {
    @EventBusSubscriber(modid = DroppedBuffs.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingDeath(LivingDeathEvent event) {
            Random random = new Random();
            Entity entity = event.getSource().getEntity();
            if (entity instanceof Player player) {
                int chance = random.nextInt(100);
                int lootingLevel = player.getMainHandItem().getEnchantmentLevel(player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING));
                int lootingboost = DroppedBuffsConfig.looting_extra_chance;
                if(player.hasEffect(MobEffects.LUCK)){
                    chance+= DroppedBuffsConfig.luck_extra_chance;
                }

                int chance2 = DroppedBuffsConfig.log_buff_chance;
                if (chance < chance2 + lootingLevel * lootingboost) {
                    Buff randomBuff = getRandomBuff(event);
                    if (randomBuff != null) {
                        dropBuff(player, event, randomBuff);
                    }
                }
            }
        }

        public static Buff getRandomBuff(LivingDeathEvent event) {
            Collection<Buff> allBuffs = BuffRegistry.getAllBuffs();
            if (allBuffs.isEmpty()) {
                return null;
            }
            List<Buff> validBuffs = allBuffs.stream()
                    .filter(buff -> buff.canSpawn(event))
                    .toList();

            if (validBuffs.isEmpty()) {
                return null;
            }

            Random random = new Random();

            Buff buff = validBuffs.get(random.nextInt(validBuffs.size()));

            return buff;
        }


        public static void dropBuff(Player killer, LivingDeathEvent event, Buff buff) {
            Entity killedEntity = event.getEntity();
            if (buff != null) {
                Basic_Buff_Entity buffEntity = buff.getEntityType().create(killedEntity.level(), EntitySpawnReason.EVENT);
                if (buffEntity != null) {
                    buffEntity.owner = killer;
                    buffEntity.setPos(killedEntity.getX(), killedEntity.getY(), killedEntity.getZ());
                    killedEntity.level().addFreshEntity(buffEntity);
                }
            }
        }
    }
}