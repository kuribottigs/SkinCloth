package com.samesama.skincloth.datagen;

import com.samesama.skincloth.client.KeyCode;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SkinClothEnglishLangProvider extends FabricLanguageProvider {
    protected SkinClothEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup){
        super(dataOutput,"en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("key.categories.skincloth", "Skin Cloth Key");
        for(KeyCode keyCode : KeyCode.values()){
                    //"key.skincloth." + keyCode.getName(),
            translationBuilder.add(keyCode.getLangName(), keyCode.getUsLang());
        }
    }
}
