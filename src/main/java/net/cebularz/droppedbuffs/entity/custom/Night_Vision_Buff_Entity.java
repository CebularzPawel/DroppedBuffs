package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class Night_Vision_Buff_Entity extends Basic_Buff_Entity {


    public Night_Vision_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.color=0x9115c2;
    }

    @Override
    public void buffOnPickUpEffect(Player player) {
        MobEffectInstance effect = new MobEffectInstance(MobEffects.NIGHT_VISION,30*20,0);
        player.addEffect(effect);
    }

    public static boolean canSpawn(LivingDeathEvent event) {
        int lightlevel = event.getEntity().level().getBrightness(LightLayer.BLOCK,event.getEntity().blockPosition())+event.getEntity().level().getBrightness(LightLayer.SKY,event.getEntity().blockPosition());
        if (lightlevel>5){
            return false;
        }
        return configactive;
    }

    public static void spawnBuff(Player player, LivingDeathEvent event) {
        if(canSpawn(event)) {
            Entity killedEntity = event.getEntity();
            Night_Vision_Buff_Entity buffentity = new Night_Vision_Buff_Entity(ModEntities.NIGHT_VISION_BUFF_ENTITY.get(), killedEntity.level());
            buffentity.owner = player;
            buffentity.setPos(killedEntity.getX(), killedEntity.getY(), killedEntity.getZ());
            killedEntity.level().addFreshEntity(buffentity);
        }
    }
}
