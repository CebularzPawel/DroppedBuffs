package net.cebularz.droppedbuffs.entity.entities;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Buff_Entity extends Entity {
    private static final EntityDataAccessor<Integer> OWNER_ID = SynchedEntityData.defineId(Buff_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TEXTURE_INDEX = SynchedEntityData.defineId(Buff_Entity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> COLOR_MULTIPLIER = SynchedEntityData.defineId(Buff_Entity.class, EntityDataSerializers.INT);

    private int textureTickCounter = 0;
    private Player owner;
    protected int age;
    public float alpha = 1.0F;

    public Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

        builder.define(OWNER_ID, 0);
        builder.define(TEXTURE_INDEX, 0);
        builder.define(COLOR_MULTIPLIER, 0xFFFFFF);
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

    public void setOwner(Player owner) {
        this.owner = owner;
        this.entityData.set(OWNER_ID, owner.getId());
        this.alpha = 1.0F;
    }

    public Player getOwner() {
        if (this.level().isClientSide()) {
            return (Player) this.level().getEntity(this.entityData.get(OWNER_ID));
        }
        return this.owner;
    }

    @Override
    public void tick() {
        super.tick();

        age = this.tickCount;

        if (!this.level().isClientSide()) {
            textureTickCounter++;
            int framesPerTick = 2;
            if (textureTickCounter >= 1) {
                for (int i = 0; i < framesPerTick; i++) {
                    int newIndex = (this.getTextureIndex() + 1) % getMaxTextureIndex();
                    this.setTextureIndex(newIndex);
                }
                textureTickCounter = 0;
            }
        }

        Player currentOwner = getOwner();
        if (currentOwner == null || !currentOwner.isAlive()) {
            this.discard();
        }

        if (currentOwner != null) {
            double x = currentOwner.getX();
            double y = currentOwner.getY() + 1;
            double z = currentOwner.getZ();
            this.setPos(x, y, z);

            if (age >= 6) {
                this.alpha -= -0.5F;
            }

            if (age >= 8) {
                this.discard();
            }
        }
    }

    public int getTextureIndex() {
        return this.entityData.get(TEXTURE_INDEX);
    }

    public void setTextureIndex(int index) {
        this.entityData.set(TEXTURE_INDEX, index);
    }

    public int getMaxTextureIndex() {
        return 14;
    }

    public void setColorMultiplier(int color) {
        this.entityData.set(COLOR_MULTIPLIER, color);
    }

    public int getColorMultiplier() {
        return this.entityData.get(COLOR_MULTIPLIER);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        input.getInt("ColorMultiplier").ifPresent(color -> this.entityData.set(COLOR_MULTIPLIER, color));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        output.putInt("ColorMultiplier", this.getColorMultiplier());
    }
}
