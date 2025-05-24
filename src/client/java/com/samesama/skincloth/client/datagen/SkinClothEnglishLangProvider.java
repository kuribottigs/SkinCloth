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
        translationBuilder.add("key." + SkinCloth.MOD_ID + ".allonoff","Key for Switch On Off");

        translationBuilder.add("text.autoconfig.skincloth.title", "SkinCloth Config");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllCape", "All Feature including Cape");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllJacket", "All Feature including Jacket");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllLeftSleeve", "All Feature including Left Sleeve");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllRightSleeve", "All Feature including Right Sleeve");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllLeftPantsLegs", "All Feature including Left Pants Leg");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllRightPantsLegs", "All Feature including Right Pants Leg");
        translationBuilder.add("text.autoconfig.skincloth.option.enableAllHat", "All Feature including Hat");
        translationBuilder.add("text.autoconfig.skincloth.option.enableOverlay", "Enable Overlay");

        for(KeyCode keyCode : KeyCode.values()){
                    //"key.skincloth." + keyCode.getName(),
            translationBuilder.add(keyCode.getLangName(), keyCode.getUsLang());
        }
    }
}
