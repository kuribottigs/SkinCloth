package com.samesama.skincloth.client.config;

import com.samesama.skincloth.SkinCloth;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = SkinCloth.MOD_ID)
public class SkinClothConfig implements ConfigData {
    @Comment("This is whether to turn on cape when AllOnOff is selected")
    public boolean enableAllCape = true;
    @Comment("Not implemented : This is whether to turn on jacket when AllOnOff is selected")
    public boolean enableAllJacket = true;
    @Comment("Not implemented : This is whether to turn on left sleeve when AllOnOff is selected")
    public boolean enableAllLeftSleeve = true;
    @Comment("Not implemented : This is whether to turn on right sleeve when AllOnOff is selected")
    public boolean enableAllRightSleeve = true;
    @Comment("Not implemented : This is whether to turn on left pants legs when AllOnOff is selected")
    public boolean enableAllLeftPantsLegs = true;
    @Comment("Not implemented :  is whether to turn on right pants legs when AllOnOff is selected")
    public boolean enableAllRightPantsLegs = true;
    @Comment("Not implemented : This is whether to turn on hat when AllOnOff is selected")
    public boolean enableAllHat = true;
    @Comment("Not implemented : This is whether to turn on hat when AllOnOff is selected")
    public boolean enableOverlay = false;


    @ConfigEntry.Gui.Excluded
    public boolean enableALL = true;
}
