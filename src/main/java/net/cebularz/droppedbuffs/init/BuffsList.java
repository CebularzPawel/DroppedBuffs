package net.cebularz.droppedbuffs.init;

import net.cebularz.droppedbuffs.entity.custom.*;

public class BuffsList {
    public static Class<? extends Basic_Buff_Entity>[] classes = new Class[] {
            Fire_Resistance_Buff_Entity.class,
            Haste_Buff_Entity.class,
            Night_Vision_Buff_Entity.class,
            Resistance_Buff_Entity.class

    };
    public static Class<? extends Basic_Buff_Entity> getBuffByIndex(int Index){
        return classes[Index];
    }
    public int getLength(){
        return classes.length;
    }
}
