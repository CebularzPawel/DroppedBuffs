package net.cebularz.droppedbuffs.api;

import net.minecraft.resources.ResourceLocation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BuffRegistry {
    private static final Map<ResourceLocation, Buff> BUFFS = new HashMap<>();

    public static void register(ResourceLocation id, Buff buff) {
        if (BUFFS.containsKey(id)) {
            throw new IllegalStateException("Duplicate buff ID: " + id);
        }
        buff.setId(id);
        BUFFS.put(id, buff);
    }

    public static Buff getBuff(ResourceLocation id) {
        return BUFFS.get(id);
    }

    public static Collection<Buff> getAllBuffs() {
        return Collections.unmodifiableCollection(BUFFS.values());
    }
}
