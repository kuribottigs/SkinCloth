package com.samesama.skincloth.client;

import com.samesama.skincloth.SkinCloth;
import net.minecraft.client.render.entity.PlayerModelPart;

import static com.samesama.skincloth.client.SkinClothClient.CONFIG;

public enum KeyCode {
    CAPE(0, "cape",PlayerModelPart.CAPE,"Cape"),
    JACKET(1, "jacket",PlayerModelPart.JACKET,"Jacket"),
    LEFT_SLEEVE(2, "left_sleeve",PlayerModelPart.LEFT_SLEEVE,"Left Sleeve"),
    RIGHT_SLEEVE(3, "right_sleeve",PlayerModelPart.RIGHT_SLEEVE,"Right Sleeve"),
    LEFT_PANTS_LEG(4, "left_pants_leg",PlayerModelPart.LEFT_PANTS_LEG,"Left Pants Leg"),
    RIGHT_PANTS_LEG(5, "right_pants_leg",PlayerModelPart.RIGHT_PANTS_LEG,"Right Pants Leg"),
    HAT(6, "hat",PlayerModelPart.HAT,"Hat");
    //OVERLAY(7,"overlay","OverLay");

    private final int id;
    private final String name;
    private final String usLang;
    private final PlayerModelPart part;
    private final String langName;
    //private final boolean takeon;

    private KeyCode(int id, String name, PlayerModelPart part, String us_lang ) {
        this.id = id;
        this.name = name;
        this.part = part;
        this.usLang = us_lang;
        this.langName = "key." + SkinCloth.MOD_ID + name;
        //this.takeon = b;
    }

    public int getId() { return id; }

    public String getName() {
        return this.name;
    }

    public PlayerModelPart getPart(){ return this.part; }

    public String getUsLang(){ return this.usLang; }

    public String getLangName(){ return this.langName; }
    //public boolean isTakeon(){ return this.takeon;}
}
