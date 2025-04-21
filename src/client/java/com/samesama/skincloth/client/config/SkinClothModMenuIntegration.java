package com.samesama.skincloth.client.config;

import com.samesama.skincloth.SkinCloth;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SkinClothModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        // AutoConfig を使って設定画面を生成するファクトリを返す
        return parent -> AutoConfig.getConfigScreen(SkinClothConfig.class, parent).get();
    }
}
