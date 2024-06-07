package net.cebularz.droppedbuffs.entity.custom;

import net.cebularz.droppedbuffs.Config;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Random;

public class Meat_Buff_Entity extends Entity {
    public Player owner;


    public float bobOffset;

    public int age;
    public float rotationY;
    public float rotationX;
    public float rotationZ;
    public float alpha;
    public float duration;

    public Meat_Buff_Entity(EntityType<?> pEntityType, Level pLevel) {
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
        List<Entity> nearbyEntities = this.level().getEntitiesOfClass(Entity.class, this.getBoundingBox());
        for (Entity entity : nearbyEntities) {
            if (entity instanceof Player&&(entity==owner||owner==null||Config.global_drop)) {
                int food = Math.min(20,((Player) entity).getFoodData().getFoodLevel()+8);
                if(((Player) entity).getFoodData().getFoodLevel()<20) {
                    ((Player) entity).getFoodData().setFoodLevel(food);
                    float saturation = ((Player) entity).getFoodData().getSaturationLevel();
                    ((Player) entity).getFoodData().setSaturation(saturation+6);
                    this.discard();
                    }
                }

            }
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


        if ((player==owner||owner==null||Config.global_drop)) {
            int food = Math.min(20,(player).getFoodData().getFoodLevel()+8);
            if((player).getFoodData().getFoodLevel()<20) {
                ( player).getFoodData().setFoodLevel(food);
                float saturation = (player).getFoodData().getSaturationLevel();
                ( player).getFoodData().setSaturation(saturation + 6);
                if (!this.level().isClientSide) {
                    Buff_Entity buffEntity = new Buff_Entity(ModEntities.BUFF_ENTITY.get(), this.level());
                    buffEntity.setColorMultiplier(0xD87C3F);
                    buffEntity.setPos(this.getX(), this.getY(), this.getZ());
                    buffEntity.setOwner(player);
                    this.level().addFreshEntity(buffEntity);
                    this.discard();
                }
            }
        }
    }
    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }

}
