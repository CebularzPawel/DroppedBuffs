package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.api.Buff;
import net.cebularz.droppedbuffs.api.BuffRegistry;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import java.util.Random;

public class Basic_Buff_Entity extends Entity {
    private ResourceLocation buffId;
    public Player owner;

    public float bobOffset;
    public int age;
    public float rotationY;
    public float rotationX;
    public float rotationZ;
    public float alpha;
    public float duration;
    protected int color;

    public Basic_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.age = 0;
        this.owner = null;
        Random random = new Random();
        rotationX = random.nextFloat() * 360.0F;
        rotationY = random.nextFloat() * 360.0F;
        rotationZ = random.nextFloat() * 360.0F;

        alpha = 1F;
        duration = Config.buff_on_ground_duration * 20;

        color = 0xffffff;
    }

    public void setBuffId(ResourceLocation buffId) {
        this.buffId = buffId;
    }

    public Buff getBuff() {
        return BuffRegistry.getBuff(this.buffId);
    }

    @Override
    protected void defineSynchedData() {
    }

    @Override
    public void tick() {
        bobOffset = (float) (Math.sin(this.tickCount * 0.1) * 0.1);

        if (age >= duration - 80) {
            alpha -= 0.0125F;
        }

        super.tick();
        this.age++;
        if (this.age >= duration) {
            this.discard();
        }
        rotationX += 1.5F;
        rotationY += 1.5F;
        rotationZ += 1.5F;

        rotationX %= 360.0F;
        rotationY %= 360.0F;
        rotationZ %= 360.0F;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.contains("BuffID")) {
            buffId = new ResourceLocation(compoundTag.getString("BuffID"));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        if (buffId != null) {
            compoundTag.putString("BuffID", buffId.toString());
        }
    }

    @Override
    public void playerTouch(Player player) {
        super.playerTouch(player);

        if (player == owner || owner == null || Config.global_drop) {
            if (!this.level().isClientSide) {
                Buff buff = this.getBuff();
                if (buff != null) {
                    buff.onPickup(player);

                    Buff_Entity buffEntity = new Buff_Entity(ModEntities.BUFF_ENTITY.get(), this.level());
                    buffEntity.setColorMultiplier(buff.getColor());
                    buffEntity.setPos(this.getX(), this.getY(), this.getZ());
                    buffEntity.setOwner(player);

                    this.level().playSound(null,
                            this.blockPosition(),
                            SoundEvents.AMETHYST_BLOCK_RESONATE,
                            SoundSource.BLOCKS,
                            2.0F,
                            1.0F);
                    this.level().addFreshEntity(buffEntity);
                }
                this.discard();
            }
        }
    }

    public void buffOnPickUpEffect(Player player) {
        // Default effect
    }
    public static boolean canSpawn(LivingDeathEvent event){
        return configactive;
    }
    public static boolean configactive = true;
    public static void spawnBuff(Player player, LivingDeathEvent event){

    }
}
