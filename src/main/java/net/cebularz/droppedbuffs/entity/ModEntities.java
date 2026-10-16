package net.cebularz.droppedbuffs.entity;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.entities.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {

    public static final DeferredRegister.Entities ENTITY_TYPES =
            DeferredRegister.createEntities(DroppedBuffs.MOD_ID);


    public static final DeferredHolder<EntityType<?>, EntityType<Meat_Buff_Entity>> MEAT_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("meat_buff", Meat_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Invisibility_Buff_Entity>> INVISIBILITY_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("invisibility_buff", Invisibility_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Resistance_Buff_Entity>> RESISTANCE_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("resistance_buff", Resistance_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Heal_Buff_Entity>> HEAL_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("heal_buff", Heal_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Strength_Buff_Entity>> STRENGTH_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("strength_buff", Strength_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Haste_Buff_Entity>> HASTE_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("haste_buff", Haste_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Speed_Buff_Entity>> SPEED_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("speed_buff", Speed_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Luck_Buff_Entity>> LUCK_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("luck_buff", Luck_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Absorption_Buff_Entity>> ABSORPTION_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("absorption_buff", Absorption_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Water_Breathing_Buff_Entity>> WATER_BREATHING_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("water_breathing_buff", Water_Breathing_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Night_Vision_Buff_Entity>> NIGHT_VISION_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("night_vision_buff", Night_Vision_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Fire_Resistance_Buff_Entity>> FIRE_RESISTANCE_BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("fire_resistance_buff", Fire_Resistance_Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(0.5f,1.0f));
    public static final DeferredHolder<EntityType<?>, EntityType<Buff_Entity>> BUFF_ENTITY =
            ENTITY_TYPES.registerEntityType("buff" , Buff_Entity::new, MobCategory.MISC, builder -> builder
                    .sized(1F, 2F));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
