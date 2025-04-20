package com.samesama.skincloth.datagen;

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

    }
}
