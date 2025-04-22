package com.samesama.skincloth.client.datagen;

import com.samesama.skincloth.SkinCloth;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SkinClothJapaneseLangProvider extends FabricLanguageProvider {
    protected SkinClothJapaneseLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataOutput,"ja_jp");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("key.categories.skincloth", "Skin Clothのキー");
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".allon","すべてON!");
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".alloff","すべてOFF");
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".allonoff","オン・オフ切り替え");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllJacket", "All Jacket");
        translationBuilder.add("text.autoconfig.skincloth.title", "SkinCloth Config");
    }
}
