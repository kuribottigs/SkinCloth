package com.samesama.skincloth.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public abstract class GameOptionsWriteMixin {
    /*@Inject(method = "write", at = @At("HEAD"))
    private void skincloth_onSetteingSaved(CallbackInfo ci){
        MinecraftClient client = MinecraftClient.getInstance();
        client.execute(() -> {
            // プレイヤーがワールドに参加している場合のみメッセージを送信
            if (client.player != null && client.world != null) {
                // 送信するメッセージを作成 (Text.literalを使用)
                // §e は黄色のカラーコード
                Text message = Text.literal("§e[MyMod] 設定が変更・保存されました。");

                // プレイヤーのチャットにメッセージを送信 (falseはアクションバーではなくチャット欄へ)
                client.player.sendMessage(message, false);

                // デバッグ用にコンソールにも出力する場合
                // System.out.println("[MyMod] GameOptions written, sending chat message.");
            }
        });
    }*/
}
