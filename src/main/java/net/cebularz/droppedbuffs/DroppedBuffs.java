package net.cebularz.droppedbuffs;

import com.mojang.logging.LogUtils;
import net.cebularz.droppedbuffs.entity.ModEntities;
import net.cebularz.droppedbuffs.entity.client.Buff.Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Haste_Buff.Haste_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Heal_Buff.Heal_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Invisibility_Buff.Invisibility_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Meat_Buff.Meat_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Resistance_Buff.Resistance_Buff_Renderer;
import net.cebularz.droppedbuffs.entity.client.Strength_Buff.Strength_Buff_Renderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(DroppedBuffs.MOD_ID)
public class DroppedBuffs
{
    public static final String MOD_ID = "droppedbuffs";
    private static final Logger LOGGER = LogUtils.getLogger();



    public DroppedBuffs()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);


        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
        ModEntities.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("HELLO FROM COMMON SETUP");

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.MEAT_BUFF_ENTITY.get(), Meat_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.INVISIBILITY_BUFF_ENTITY.get(), Invisibility_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.RESISTANCE_BUFF_ENTITY.get(), Resistance_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.HEAL_BUFF_ENTITY.get(), Heal_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.STRENGTH_BUFF_ENTITY.get(), Strength_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.HASTE_BUFF_ENTITY.get(), Haste_Buff_Renderer::new);
            EntityRenderers.register(ModEntities.BUFF_ENTITY.get(), Buff_Renderer::new);
        }
    }
}
