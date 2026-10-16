package net.cebularz.droppedbuffs;

import com.mojang.logging.LogUtils;
import net.cebularz.droppedbuffs.api.Buff;
import net.cebularz.droppedbuffs.api.BuffRegistry;
import net.cebularz.droppedbuffs.buffs.*;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.client.Absorption_Buff.Absorption_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Buff.Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Fire_Resistance_Buff.Fire_Resistance_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Haste_Buff.Haste_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Heal_Buff.Heal_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Invisibility_Buff.Invisibility_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Luck_Buff.Luck_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Meat_Buff.Meat_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Night_Vision_Buff.Night_Vision_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Resistance_Buff.Resistance_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Speed_Buff.Speed_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Strength_Buff.Strength_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Water_Breathing_Buff.Water_Breathing_Buff_Renderer;
import net.cebularz.droppedbuffs.sound.ModSounds;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DroppedBuffs.MOD_ID)
public class DroppedBuffs
{
    public static final String MOD_ID = "droppedbuffs";
    private static final Logger LOGGER = LogUtils.getLogger();



    public DroppedBuffs(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);


        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, DroppedBuffsConfig.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        Buff absorptionBuff = new AbsorptionBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "absorption"), absorptionBuff);

        Buff fireResistBuff = new FireResistanceBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "fireresist"), fireResistBuff);

        Buff hasteBuff = new HasteBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "haste"), hasteBuff);

        Buff healBuff = new HealBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "heal"), healBuff);

        Buff invisibilityBuff = new InvisibilityBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "invisibility"), invisibilityBuff);

        Buff luckBuff = new LuckBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "luck"), luckBuff);

        Buff meatBuff = new MeatBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "meat"), meatBuff);

        Buff nightVisionBuff = new NightVisionBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "nightvision"), nightVisionBuff);

        Buff resistBuff = new ResistanceBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "resist"), resistBuff);

        Buff speedBuff = new SpeedBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "speed"), speedBuff);

        Buff strengthBuff = new StrengthBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "strength"), strengthBuff);

        Buff waterBreathingBuff = new WaterBreathingBuff();
        BuffRegistry.register(Identifier.fromNamespaceAndPath(MOD_ID, "waterbreathing"), waterBreathingBuff);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
        {
            event.registerEntityRenderer(ModEntities.MEAT_BUFF_ENTITY.get(), Meat_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.INVISIBILITY_BUFF_ENTITY.get(), Invisibility_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.RESISTANCE_BUFF_ENTITY.get(), Resistance_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.HEAL_BUFF_ENTITY.get(), Heal_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.STRENGTH_BUFF_ENTITY.get(), Strength_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.HASTE_BUFF_ENTITY.get(), Haste_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.SPEED_BUFF_ENTITY.get(), Speed_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.LUCK_BUFF_ENTITY.get(), Luck_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.ABSORPTION_BUFF_ENTITY.get(), Absorption_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.WATER_BREATHING_BUFF_ENTITY.get(), Water_Breathing_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.NIGHT_VISION_BUFF_ENTITY.get(), Night_Vision_Buff_Renderer::new);
            event.registerEntityRenderer(ModEntities.FIRE_RESISTANCE_BUFF_ENTITY.get(), Fire_Resistance_Buff_Renderer::new);

            event.registerEntityRenderer(ModEntities.BUFF_ENTITY.get(), Buff_Renderer::new);
        }
    }
}
