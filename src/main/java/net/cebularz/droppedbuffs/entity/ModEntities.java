package net.cebularz.droppedbuffs.entity;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.BuffEntity;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DroppedBuffs.MOD_ID);


    public static final RegistryObject<EntityType<BuffEntity>> BUFFENTITY =
            ENTITY_TYPES.register("buff",()-> EntityType.Builder.of(BuffEntity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f).build("buff"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
