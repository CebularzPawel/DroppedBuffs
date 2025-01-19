package net.cebularz.droppedbuffs;

import net.cebularz.droppedbuffs.buffs.*;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = DroppedBuffs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DroppedBuffsConfig
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
    private static final ForgeConfigSpec.IntValue BUFF_EFFECT_DURATION = BUILDER
            .comment("Duration (in seconds) of an effect got from a buff (applies only to buffs that gives effects with a duration)")
            .defineInRange("buff_effect_duration", 30,0,Integer.MAX_VALUE);
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
    private static final ForgeConfigSpec.IntValue HEALING_VALUE = BUILDER
            .comment("Amount of healing in hp you will get from healing buff")
            .defineInRange("healing_value", 10,0,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue FOOD_VALUE = BUILDER
            .comment("Amount of hunger points restored from a meat buff")
            .defineInRange("food_value", 8,0,Integer.MAX_VALUE);
    private static final ForgeConfigSpec.IntValue SATURATION_VALUE = BUILDER
            .comment("Amount of saturation points restored from a meat buff")
            .defineInRange("saturation_value", 6,0,Integer.MAX_VALUE);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static int log_buff_chance;
    public static int looting_extra_chance;
    public static int luck_extra_chance;

    public static boolean global_drop;
    public static double buff_size_original;
    public static float buff_size;

    public static int buff_on_ground_duration;

    public static int buff_effect_duration;

    public static int heal_value;

    public static int food_value;
    public static int saturation_value;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {

        log_buff_chance = LOG_BUFF_CHANCE.get();
        looting_extra_chance = LOOTING_EXTRA_CHANCE.get();
        global_drop = GLOBAL_DROP.get();
        buff_on_ground_duration = BUFF_ON_GROUND_DURATION.get();
        luck_extra_chance = LUCK_EXTRA_CHANCE.get();
        buff_size_original = BUFF_SIZE.get();
        buff_size= (float)buff_size_original;

        buff_effect_duration = BUFF_EFFECT_DURATION.get();

        heal_value = HEALING_VALUE.get();
        food_value = FOOD_VALUE.get();
        saturation_value = SATURATION_VALUE.get();

        if(!ABSORPTION_BUFF.get()){
            AbsorptionBuff.configactive=false;
        }
        if(!HASTE_BUFF.get()){
            HasteBuff.configactive=false;
        }
        if(!WATER_BREATHING_BUFF.get()){
            WaterBreathingBuff.configactive=false;
        }
        if(!HEAL_BUFF.get()){
            HealBuff.configactive=false;
        }
        if(!INVISIBILITY_BUFF.get()){
            InvisibilityBuff.configactive=false;
        }
        if(!LUCK_BUFF.get()){
            LuckBuff.configactive=false;
        }
        if(!MEAT_BUFF.get()){
            MeatBuff.configactive=false;
        }
        if(!RESISTANCE_BUFF.get()){
            ResistanceBuff.configactive=false;
        }
        if(!SPEED_BUFF.get()){
            SpeedBuff.configactive=false;
        }
        if(!STRENGTH_BUFF.get()){
            StrengthBuff.configactive=false;
        }
        if(!NIGHT_VISION_BUFF.get()){
            NightVisionBuff.configactive=false;
        }
        if(!FIRE_RESISTANCE_BUFF.get()){
            FireResistanceBuff.configactive=false;
        }
    }
}
