package net.cebularz.droppedbuffs.event;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.custom.Meat_Buff_Entity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = DroppedBuffs.MOD_ID)
    public static class ForgeEvents {
        @SubscribeEvent
        public static void onLivingDeath(LivingDeathEvent event) {
            Random random = new Random();
            Entity entity = event.getSource().getEntity();
            if(entity instanceof Player){
                int chance = random.nextInt(100);
                if(chance<5) {
                    Player player = (Player) entity;
                    Meat_Buff_Entity buffentity = new Meat_Buff_Entity(ModEntities.MEAT_BUFF_ENTITY.get(), event.getEntity().level());
                    buffentity.owner=player;
                    buffentity.setPos(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ());

                    event.getEntity().level().addFreshEntity(buffentity);
                }
            }
        }
    }
}
