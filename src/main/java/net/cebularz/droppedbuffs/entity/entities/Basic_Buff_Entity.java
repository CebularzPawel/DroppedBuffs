package net.cebularz.droppedbuffs.entity.entities;

import net.cebularz.droppedbuffs.DroppedBuffsConfig;
import net.cebularz.droppedbuffs.api.Buff;
import net.cebularz.droppedbuffs.api.BuffRegistry;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.sound.ModSounds;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

import java.util.Random;

public class Basic_Buff_Entity extends Entity {
    private Identifier buffId;
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

        rotationX = 180.0F;
        rotationY = 0.0F;
        rotationZ = 0.0F;

        alpha = 1F;
        duration = DroppedBuffsConfig.buff_on_ground_duration * 20;

        color = 0xffffff;
    }

    public void setBuffId(Identifier buffId) {
        this.buffId = buffId;
    }

    public Buff getBuff() {
        return BuffRegistry.getBuff(this.buffId);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float damage) {
        // Same as the default Entity#hurt behavior from 1.20.1
        if (this.isInvulnerableToBase(source)) {
            return false;
        }
        this.markHurt();
        return false;
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
        rotationY = (rotationY + 2.0f) % 360;

        float oscillationFactor = 0.5f;
        float speedFactor = 0.1f;

        rotationX = 180 + 30.0f * (float)Math.sin(this.tickCount * speedFactor * 0.7f) * oscillationFactor;
        rotationZ = 30.0f * (float)Math.cos(this.tickCount * speedFactor) * oscillationFactor;


    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        input.getString("BuffID").ifPresent(id -> buffId = Identifier.parse(id));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        if (buffId != null) {
            output.putString("BuffID", buffId.toString());
        }
    }

    @Override
    public void playerTouch(Player player) {
        super.playerTouch(player);

        if (player == owner || owner == null || DroppedBuffsConfig.global_drop) {
            if (!this.level().isClientSide()) {
                Buff buff = this.getBuff();
                if (buff != null) {
                    buff.onPickup(player);

                    Buff_Entity buffEntity = new Buff_Entity(ModEntities.BUFF_ENTITY.get(), this.level());
                    buffEntity.setColorMultiplier(buff.getColor());
                    buffEntity.setPos(this.getX(), this.getY(), this.getZ());
                    buffEntity.setOwner(player);

                    this.level().playSound(null,
                            this.blockPosition(),
                            ModSounds.BUFF_PICKUP.get(),
                            SoundSource.BLOCKS,
                            1.0F,
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
    public static void spawnBuff(Player player, LivingDeathEvent event){

    }

}
