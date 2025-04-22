package com.samesama.skincloth.client.hud;

import com.samesama.skincloth.SkinCloth;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SkinClothHudOverlay implements HudRenderCallback {

    private static final Identifier OVERLAY_TEXTURE = new Identifier(SkinCloth.MOD_ID, "textures/gui/layer.png");

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta){
        MinecraftClient client = MinecraftClient.getInstance();

        if (client != null) {
            // 描画位置 (左上隅)
            int posX = 5;
            int posY = 5;

            // --- テクスチャ描画 ---
            // 元のテクスチャファイルの幅と高さ (ファイルの実サイズに合わせてください)
            int textureFileWidth = 32;
            int textureFileHeight = 32;

            // 画面に描画する際の幅と高さ (元のサイズと同じにするか、拡大・縮小)
            int drawnWidth = 32;  // 例: 32x32ピクセルで描画
            int drawnHeight = 32;

            // テクスチャのどの部分を描画するか (UV座標)
            // (0, 0) はテクスチャ画像の左上隅を指す
            float u = 0;
            float v = 0;

            // テクスチャ全体を描画する場合、UV座標の幅と高さは
            // 元のテクスチャファイルの幅と高さと同じになります。
            // (これは drawTexture の内部で使われることが多いですが、
            //  明示的に指定するオーバーロードもあります)
            int uWidth = textureFileWidth;
            int vHeight = textureFileHeight;


            // テクスチャを描画
            // drawTexture(Identifier texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight)
            //   - texture: 描画するテクスチャのIdentifier
            //   - x, y: 画面上の描画開始位置 (左上)
            //   - u, v: テクスチャ画像内で描画を開始するピクセル位置 (左上)
            //   - width, height: 画面上に描画するサイズ
            //   - textureWidth, textureHeight: テクスチャファイル全体のサイズ (これによりUV座標が正しくスケーリングされる)
            drawContext.drawTexture(
                    OVERLAY_TEXTURE,
                    posX,           // 画面X座標
                    posY,           // 画面Y座標
                    u,              // テクスチャ内U座標 (左端=0)
                    v,              // テクスチャ内V座標 (上端=0)
                    drawnWidth,     // 画面に描画する幅
                    drawnHeight,    // 画面に描画する高さ
                    textureFileWidth, // テクスチャファイル自体の幅
                    textureFileHeight // テクスチャファイル自体の高さ
            );

            // --- テキスト描画コードは削除またはコメントアウト ---
            /*
            TextRenderer textRenderer = client.textRenderer;
            ClientPlayerEntity player = client.player;
            if (player != null && textRenderer != null) {
                double x = player.getX();
                double y = player.getY();
                double z = player.getZ();
                String coordsText = String.format("X: %.2f / Y: %.2f / Z: %.2f", x, y, z);
                int color = 0xFFFFFF;
                drawContext.drawTextWithShadow(textRenderer, Text.literal(coordsText), posX, posY, color);
            }
            */
        }
    }
}
