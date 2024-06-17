package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;

public class Strength_Buff_Entity extends Entity {
    public Player owner;


    public float bobOffset;

    public int age;
    public float rotationY;
    public float rotationX;
    public float rotationZ;
    public float alpha;
    public float duration;

    public Strength_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.age=0;
        this.owner=null;
        Random random = new Random();
        rotationX = random.nextFloat() * 360.0F;
        rotationY = random.nextFloat() * 360.0F;
        rotationZ = random.nextFloat() * 360.0F;

        alpha = 1F;
        duration = Config.buff_on_ground_duration*20;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {

        bobOffset = (float) (Math.sin(this.tickCount * 0.1) * 0.1);

        if (age >= duration-80 ) {
            alpha -= 0.0125F;
        }


        super.tick();
        this.age++;
        if(this.age>=duration){
            this.discard();
        }
        rotationX += 1.5F;
        rotationY += 1.5F;
        rotationZ += 1.5F;

        rotationX %= 360.0F;
        rotationY %= 360.0F;
        rotationZ %= 360.0F;


        // Keep values within 0-360 degrees

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }
    @Override
    public void playerTouch(Player player) {
        super.playerTouch(player);


        if (player==owner||owner==null||Config.global_drop) {
            if (!this.level().isClientSide) {
                MobEffectInstance effect = new MobEffectInstance(MobEffects.DAMAGE_BOOST,30*20,0);
                player.addEffect(effect);
                Buff_Entity buffEntity = new Buff_Entity(ModEntities.BUFF_ENTITY.get(), this.level());
                buffEntity.setColorMultiplier(0x9c2703);
                buffEntity.setPos(this.getX(), this.getY(), this.getZ());
                buffEntity.setOwner(player);
                this.level().playSound(null,this.blockPosition(), SoundEvents.AMETHYST_BLOCK_RESONATE, SoundSource.BLOCKS,2.0F,1.0F);
                this.level().addFreshEntity(buffEntity);
                this.discard();
            }
        }
    }
    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

}
