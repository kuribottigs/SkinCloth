package com.samesama.skincloth.client.config;

import com.samesama.skincloth.SkinCloth;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = SkinCloth.MOD_ID)
public class SkinClothConfig implements ConfigData {
    @Comment("This is whether to turn on hat when AllOnOff is selected")
    public boolean enableAllCape = true;

    @ConfigEntry.Gui.Excluded
    public boolean enableALL = true;
}
