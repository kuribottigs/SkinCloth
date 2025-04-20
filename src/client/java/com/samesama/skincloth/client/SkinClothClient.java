package com.samesama.skincloth.client;

import com.samesama.skincloth.SkinCloth;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class SkinClothClient implements ClientModInitializer {
    // --- キーバインドの定義 ---
    private static final KeyBinding[] keys = new KeyBinding[KeyCode.values().length];
    private static KeyBinding all_on;
    private static KeyBinding all_off;
    private static final String KEY_CATEGORY = "key.categories." + SkinCloth.MOD_ID;

    @Override
    public void onInitializeClient() {

        // ーーー　キーバインドの初期化と登録　ーーー
        // 初期化
        for(KeyCode keyCode : KeyCode.values()){
            keys[keyCode.getId()] = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                    keyCode.getLangName(), // 翻訳キー (langファイルで定義)
                    InputUtil.Type.KEYSYM,        // 入力タイプ (キーボード)
                    InputUtil.UNKNOWN_KEY.getCode(),              // デフォルトのキー (Gキー)
                    KEY_CATEGORY                  // キーバインドのカテゴリ
            ));
        }
        all_on = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key." + SkinCloth.MOD_ID + ".allon", // 翻訳キー (langファイルで定義)
                InputUtil.Type.KEYSYM,        // 入力タイプ (キーボード)
                InputUtil.UNKNOWN_KEY.getCode(),              // デフォルトのキー (Gキー)
                KEY_CATEGORY                  // キーバインドのカテゴリ
        ));
        all_off = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key." + SkinCloth.MOD_ID + ".alloff", // 翻訳キー (langファイルで定義)
                InputUtil.Type.KEYSYM,        // 入力タイプ (キーボード)
                InputUtil.UNKNOWN_KEY.getCode(),              // デフォルトのキー (Gキー)
                KEY_CATEGORY                  // キーバインドのカテゴリ
        ));

        // --- キー入力の処理 ---
        // クライアントのティック（ゲームの更新タイミング）ごとにキーが押されたかチェック
        for(KeyCode keyCode : KeyCode.values()){
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                // firstKeyBindingが押された瞬間を検出
                while (keys[keyCode.getId()].wasPressed()) {
                    // プレイヤーが存在する場合のみ実行 (ワールドに入っていない場合などはnull)
                    if (client.player != null) {
                        //client.player.sendMessage(Text.literal("First Key Pressed!"), false);
                        // ここにキーが押されたときのアクションを記述
                        client.options.togglePlayerModelPart(keyCode.getPart(), !client.options.isPlayerModelPartEnabled(keyCode.getPart()));
                        client.options.write();
                    }
                }
            });
        }
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // firstKeyBindingが押された瞬間を検出
            while (all_on.wasPressed() || all_off.wasPressed()) {
                // プレイヤーが存在する場合のみ実行 (ワールドに入っていない場合などはnull)
                if (all_on.wasPressed()) {
                    AllOnOff(true,client);
                }
                if(all_off.wasPressed()){
                    AllOnOff(false,client);
                }
            }
        });

    }

    public void AllOnOff(boolean b, MinecraftClient client){
        if (client.player != null) {
            //client.player.sendMessage(Text.literal("First Key Pressed!"), false);
            // ここにキーが押されたときのアクションを記述
            for(KeyCode keyCode : KeyCode.values()) {
                client.options.togglePlayerModelPart(keyCode.getPart(), b);
                client.options.write();
            }
        }
    }
}
