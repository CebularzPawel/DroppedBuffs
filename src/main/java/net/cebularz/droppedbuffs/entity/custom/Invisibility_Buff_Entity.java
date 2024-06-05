package net.cebularz.droppedbuffs.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class Invisibility_Buff_Entity extends Entity {
    public Player owner;



    public int age;
    public float rotationY;

    public float size;
    public Invisibility_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.age=0;
        this.owner=null;
        Random random = new Random();
        rotationY = random.nextFloat() * 360.0F;
        size=1.5F;

    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    public void tick() {
        List<Entity> nearbyEntities = this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox());
        for (Entity entity : nearbyEntities) {
            if (entity instanceof Player) {
                int food = Math.min(20,((Player) entity).getFoodData().getFoodLevel()+8);
                if(((Player) entity).getFoodData().getFoodLevel()<20) {
                    ((Player) entity).getFoodData().setFoodLevel(food);
                    float saturation = ((Player) entity).getFoodData().getSaturationLevel();
                    ((Player) entity).getFoodData().setSaturation(saturation+6);
                    this.discard();
                    }
                }
            }
        super.tick();
        this.age++;
        if(this.age>=400){
            this.discard();
        }
        rotationY += 3.0F;

        if(age>=340){
            size-=0.025f;
        }
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
