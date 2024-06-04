package net.cebularz.droppedbuffs.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Random;

public class Meat_Buff_Entity extends Entity {
    private Player owner;



    public int age;
    public float rotationY;
    public Meat_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.age=0;
        Random random = new Random();
        rotationY = random.nextFloat() * 360.0F;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        super.tick();
        this.age++;
        if(this.age>=400){
            this.discard();
        }
        rotationY += 3.0F;


        // Keep values within 0-360 degrees
        rotationY %= 360.0F;
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

}
