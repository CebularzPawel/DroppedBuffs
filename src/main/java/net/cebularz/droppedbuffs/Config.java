package net.cebularz.droppedbuffs;

import net.cebularz.droppedbuffs.entity.entities.*;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import java.util.ArrayList;
import java.util.List;

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
    private static final ForgeConfigSpec.IntValue LUCK_EXTRA_CHANCE = BUILDER
            .comment("Extra chance of dropping buffs when luck effect is applied")
            .defineInRange("luck_extra_chance", 3,0,Integer.MAX_VALUE);

    private static final ForgeConfigSpec.BooleanValue GLOBAL_DROP = BUILDER
            .comment("Dropped buffs can be picked up by every player not only by the one who killed the enemy who dropped the buff")
            .define("global_drop", false);
    private static final ForgeConfigSpec.IntValue BUFF_ON_GROUND_DURATION = BUILDER
            .comment("How long the buff should stay on the ground in seconds")
            .defineInRange("buff_on_ground_duration", 20,0,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.DoubleValue BUFF_SIZE = BUILDER
            .comment("Size of the buff (it only change visual model, not the hitbox)")
            .defineInRange("buff_size", 1,0,Float.MAX_VALUE);
    private static final ForgeConfigSpec.BooleanValue ABSORPTION_BUFF = BUILDER
            .comment("Absorption Buff active")
            .define("absorption_buff",true);
    private static final ForgeConfigSpec.BooleanValue HASTE_BUFF = BUILDER
            .comment("Haste Buff active")
            .define("haste_buff",true);
    private static final ForgeConfigSpec.BooleanValue HEAL_BUFF = BUILDER
            .comment("Heal Buff active")
            .define("heal_buff",true);
    private static final ForgeConfigSpec.BooleanValue INVISIBILITY_BUFF = BUILDER
            .comment("Invisibility Buff active")
            .define("invisibility_buff",true);
    private static final ForgeConfigSpec.BooleanValue LUCK_BUFF = BUILDER
            .comment("Luck Buff active")
            .define("luck_buff",true);
    private static final ForgeConfigSpec.BooleanValue MEAT_BUFF = BUILDER
            .comment("Meat Buff active")
            .define("meat_buff",true);
    private static final ForgeConfigSpec.BooleanValue RESISTANCE_BUFF = BUILDER
            .comment("Resistance Buff active")
            .define("resistance_buff",true);
    private static final ForgeConfigSpec.BooleanValue SPEED_BUFF = BUILDER
            .comment("Speed Buff active")
            .define("speed_buff",true);
    private static final ForgeConfigSpec.BooleanValue STRENGTH_BUFF = BUILDER
            .comment("Strength Buff active")
            .define("strength_buff",true);
    private static final ForgeConfigSpec.BooleanValue WATER_BREATHING_BUFF = BUILDER
            .comment("Water Breathing Buff active")
            .define("water_breathing_buff",true);
    private static final ForgeConfigSpec.BooleanValue NIGHT_VISION_BUFF = BUILDER
            .comment("Night Vision Buff active")
            .define("night_vision_buff",true);
    private static final ForgeConfigSpec.BooleanValue FIRE_RESISTANCE_BUFF = BUILDER
            .comment("Fire Resistance Buff active")
            .define("fire_resistance_buff",true);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int log_buff_chance;
    public static int looting_extra_chance;
    public static int luck_extra_chance;

    public static boolean global_drop;
    public static double buff_size_original;
    public static float buff_size;

    public static int buff_on_ground_duration;
    public static List<Boolean> activelist;


    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

        log_buff_chance = LOG_BUFF_CHANCE.get();
        looting_extra_chance = LOOTING_EXTRA_CHANCE.get();
        global_drop = GLOBAL_DROP.get();
        buff_on_ground_duration = BUFF_ON_GROUND_DURATION.get();
        luck_extra_chance = LUCK_EXTRA_CHANCE.get();
        buff_size_original = BUFF_SIZE.get();
        buff_size= (float)buff_size_original;
        activelist = new ArrayList<>();
        if(!ABSORPTION_BUFF.get()){
            Absorption_Buff_Entity.configactive=false;
        }
        if(!HASTE_BUFF.get()){
            Haste_Buff_Entity.configactive=false;
        }
        if(!WATER_BREATHING_BUFF.get()){
            Water_Breathing_Buff_Entity.configactive=false;
        }
        if(!HEAL_BUFF.get()){
            Heal_Buff_Entity.configactive=false;
        }
        if(!INVISIBILITY_BUFF.get()){
            Invisibility_Buff_Entity.configactive=false;
        }
        if(!LUCK_BUFF.get()){
            Luck_Buff_Entity.configactive=false;
        }
        if(!MEAT_BUFF.get()){
            Meat_Buff_Entity.configactive=false;
        }
        if(!RESISTANCE_BUFF.get()){
            Resistance_Buff_Entity.configactive=false;
        }
        if(!SPEED_BUFF.get()){
            Speed_Buff_Entity.configactive=false;
        }
        if(!STRENGTH_BUFF.get()){
            Strength_Buff_Entity.configactive=false;
        }
        if(!NIGHT_VISION_BUFF.get()){
            Night_Vision_Buff_Entity.configactive=false;
        }
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(true);
        activelist.add(FIRE_RESISTANCE_BUFF.get());
    }
}
