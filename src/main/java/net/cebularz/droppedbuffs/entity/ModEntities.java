package net.cebularz.droppedbuffs.entity;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DroppedBuffs.MOD_ID);


    public static final RegistryObject<EntityType<Meat_Buff_Entity>> MEAT_BUFF_ENTITY =
            ENTITY_TYPES.register("meat_buff",()-> EntityType.Builder.of(Meat_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("meat_buff"));
    public static final RegistryObject<EntityType<Invisibility_Buff_Entity>> INVISIBILITY_BUFF_ENTITY =
            ENTITY_TYPES.register("invisibility_buff",()-> EntityType.Builder.of(Invisibility_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("invisibility_buff"));
    public static final RegistryObject<EntityType<Resistance_Buff_Entity>> RESISTANCE_BUFF_ENTITY =
            ENTITY_TYPES.register("resistance_buff",()-> EntityType.Builder.of(Resistance_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("resistance_buff"));
    public static final RegistryObject<EntityType<Heal_Buff_Entity>> HEAL_BUFF_ENTITY =
            ENTITY_TYPES.register("heal_buff",()-> EntityType.Builder.of(Heal_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("heal_buff"));
    public static final RegistryObject<EntityType<Strength_Buff_Entity>> STRENGTH_BUFF_ENTITY =
            ENTITY_TYPES.register("strength_buff",()-> EntityType.Builder.of(Strength_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("strength_buff"));
    public static final RegistryObject<EntityType<Haste_Buff_Entity>> HASTE_BUFF_ENTITY =
            ENTITY_TYPES.register("haste_buff",()-> EntityType.Builder.of(Haste_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("strength_buff"));
    public static final RegistryObject<EntityType<Speed_Buff_Entity>> SPEED_BUFF_ENTITY =
            ENTITY_TYPES.register("speed_buff",()-> EntityType.Builder.of(Speed_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("speed_buff"));
    public static final RegistryObject<EntityType<Luck_Buff_Entity>> LUCK_BUFF_ENTITY =
            ENTITY_TYPES.register("luck_buff",()-> EntityType.Builder.of(Luck_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("luck_buff"));
    public static final RegistryObject<EntityType<Absorption_Buff_Entity>> ABSORPTION_BUFF_ENTITY =
            ENTITY_TYPES.register("absorption_buff",()-> EntityType.Builder.of(Absorption_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("absorption_buff"));
    public static final RegistryObject<EntityType<Water_Breathing_Buff_Entity>> WATER_BREATHING_BUFF_ENTITY =
            ENTITY_TYPES.register("water_breathing_buff",()-> EntityType.Builder.of(Water_Breathing_Buff_Entity::new, MobCategory.MISC)
                    .sized(0.5f,1.0f).build("water_breathing_buff"));
    public static final RegistryObject<EntityType<Buff_Entity>> BUFF_ENTITY =
            ENTITY_TYPES.register("buff" , () -> EntityType.Builder.of(Buff_Entity::new, MobCategory.MISC)
                    .sized(1F, 2F)
                    .build("buff"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
