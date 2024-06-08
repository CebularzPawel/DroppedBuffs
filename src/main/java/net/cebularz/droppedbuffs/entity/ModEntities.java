package net.cebularz.droppedbuffs.entity;

import net.cebularz.droppedbuffs.DroppedBuffs;
import net.cebularz.droppedbuffs.entity.custom.Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Invisibility_Buff_Entity;
import net.cebularz.droppedbuffs.entity.custom.Meat_Buff_Entity;
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
                    .sized(1.0f,1.0f).build("meat_buff"));
    public static final RegistryObject<EntityType<Invisibility_Buff_Entity>> INVISIBILITY_BUFF_ENTITY =
            ENTITY_TYPES.register("invisibility_buff",()-> EntityType.Builder.of(Invisibility_Buff_Entity::new, MobCategory.MISC)
                    .sized(1.0f,1.0f).build("invisibility_buff"));

    public static final RegistryObject<EntityType<Buff_Entity>> BUFF_ENTITY =
            ENTITY_TYPES.register("buff" , () -> EntityType.Builder.of(Buff_Entity::new, MobCategory.MISC)
                    .sized(1F, 2F)
                    .build("buff"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

}
