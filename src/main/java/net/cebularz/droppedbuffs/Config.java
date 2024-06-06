package net.cebularz.droppedbuffs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;
import org.lwjgl.opengl.GL;
import org.openjdk.nashorn.internal.objects.Global;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = DroppedBuffs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.IntValue LOG_BUFF_CHANCE = BUILDER
            .comment("Basic chance of dropping buffs")
            .defineInRange("log_buff_chance", 5,0,Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue LOOTING_EXTRA_CHANCE = BUILDER
            .comment("Extra chance of dropping buffs for each looting level")
            .defineInRange("looting_extra_chance", 2,0,Integer.MAX_VALUE);

    private static final ForgeConfigSpec.BooleanValue GLOBAL_DROP = BUILDER
            .comment("Dropped buffs can be picked up by every player not only by the one who killed the enemy who dropped the buff")
            .define("global_drop", false);
    private static final ForgeConfigSpec.IntValue BUFF_ON_GROUND_DURATION = BUILDER
            .comment("How long the buff should stay on the ground in seconds")
            .defineInRange("buff_on_ground_duration", 20,0,Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int log_buff_chance;
    public static int looting_extra_chance;

    public static boolean global_drop;

    public static int buff_on_ground_duration;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        log_buff_chance = LOG_BUFF_CHANCE.get();
        looting_extra_chance = LOOTING_EXTRA_CHANCE.get();
        global_drop = GLOBAL_DROP.get();
        buff_on_ground_duration = BUFF_ON_GROUND_DURATION.get();
    }
}
