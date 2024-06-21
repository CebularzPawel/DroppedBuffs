package net.cebularz.droppedbuffs.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

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
    protected void defineSynchedData() {

        this.entityData.define(OWNER_ID, 0);
        this.entityData.define(TEXTURE_INDEX, 0);
        this.entityData.define(COLOR_MULTIPLIER, 0xFFFFFF);
    }

    public void setOwner(Player owner) {
        this.owner = owner;
        this.entityData.set(OWNER_ID, owner.getId());
        this.alpha = 1.0F;
    }

    public Player getOwner() {
        if (this.level().isClientSide) {
            return (Player) this.level().getEntity(this.entityData.get(OWNER_ID));
        }
        return this.owner;
    }

    @Override
    public void tick() {
        super.tick();

        age = this.tickCount;

        if (!this.level().isClientSide) {
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
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("ColorMultiplier")) {
            this.entityData.set(COLOR_MULTIPLIER, pCompound.getInt("ColorMultiplier"));
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putInt("ColorMultiplier", this.getColorMultiplier());
    }


}
