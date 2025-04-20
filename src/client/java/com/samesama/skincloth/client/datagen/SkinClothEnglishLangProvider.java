package com.samesama.skincloth.client.datagen;

import com.samesama.skincloth.SkinCloth;
import com.samesama.skincloth.client.KeyCode;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SkinClothEnglishLangProvider extends FabricLanguageProvider {
    protected SkinClothEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataOutput,"en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("key.categories.skincloth", "Skin Cloth Key");
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".allon","All On");
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".alloff","All Off");
        for(KeyCode keyCode : KeyCode.values()){
                    //"key.skincloth." + keyCode.getName(),
            translationBuilder.add(keyCode.getLangName(), keyCode.getUsLang());
        }
    }
}
