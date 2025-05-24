package com.samesama.skincloth.client.hud;

import com.samesama.skincloth.SkinCloth;
import com.samesama.skincloth.client.KeyCode;
import com.samesama.skincloth.client.SkinClothClient;
import com.samesama.skincloth.client.config.SkinClothConfig;
import me.shedaniel.autoconfig.AutoConfig;
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
        Identifier CAPE_TEXTURE = client.player.getSkinTextures().capeTexture();


        if (client != null) {

            // 描画位置 (左上隅)
            int posX = 5;
            int posY = 5;

            int size = 2;

            // --- テクスチャ描画 ---
            // 元のテクスチャファイルの幅と高さ (ファイルの実サイズに合わせてください)
            int textureFileWidth = 32;
            int textureFileHeight = 32;

            // 画面に描画する際の幅と高さ (元のサイズと同じにするか、拡大・縮小)
            int drawnWidth = 8;  // 例: 32x32ピクセルで描画
            int drawnHeight = 8;

            // テクスチャのどの部分を描画するか (UV座標)
            // (0, 0) はテクスチャ画像の左上隅を指す
            float u = 16;
            float v = 0;

            // テクスチャ全体を描画する場合、UV座標の幅と高さは
            // 元のテクスチャファイルの幅と高さと同じになります。
            // (これは drawTexture の内部で使われることが多いですが、
            //  明示的に指定するオーバーロードもあります)
            int uWidth = textureFileWidth;
            int vHeight = textureFileHeight;
            SkinClothConfig CONFIG = AutoConfig.getConfigHolder(SkinClothConfig.class).getConfig();

            // テクスチャを描画
            // drawTexture(Identifier texture, int x, int y, float u, float v, int width, int height, int textureWidth, int textureHeight)
            //   - texture: 描画するテクスチャのIdentifier
            //   - x, y: 画面上の描画開始位置 (左上)
            //   - u, v: テクスチャ画像内で描画を開始するピクセル位置 (左上)
            //   - width, height: 画面上に描画するサイズ
            //   - textureWidth, textureHeight: テクスチャファイル全体のサイズ (これによりUV座標が正しくスケーリングされる)
            if(CONFIG.enableOverlay == true){

            drawContext.drawTexture(
                    OVERLAY_TEXTURE,
                    posX,           // 画面X座標
                    posY,           // 画面Y座標
                    16 * size,
                    32 * size,
                    0,              // テクスチャ内U座標 (左端=0)
                    0,              // テクスチャ内V座標 (上端=0)
                    16,     // 画面に描画する幅
                    32,    // 画面に描画する高さ
                    textureFileWidth, // テクスチャファイル自体の幅
                    textureFileHeight // テクスチャファイル自体の高さ
            );

            //head
            if(client.options.isPlayerModelPartEnabled(KeyCode.HAT.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX + 4*size,           // 画面X座標
                        posY,           // 画面Y座標
                        8 * size,
                        8 * size,
                        u + 4,              // テクスチャ内U座標 (左端=0)
                        v,              // テクスチャ内V座標 (上端=0)
                        8,     // 画面に描画する幅
                        8,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //jacket
            if(client.options.isPlayerModelPartEnabled(KeyCode.JACKET.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX + 4*size,           // 画面X座標
                        posY + 8*size,           // 画面Y座標
                        8 * size,
                        12 * size,
                        u + 4,              // テクスチャ内U座標 (左端=0)
                        v + 8,              // テクスチャ内V座標 (上端=0)
                        8,     // 画面に描画する幅
                        12,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //right sleev
            if(client.options.isPlayerModelPartEnabled(KeyCode.RIGHT_SLEEVE.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX,           // 画面X座標
                        posY + 8*size,           // 画面Y座標
                        4 * size,
                        12 * size,
                        u + 0,              // テクスチャ内U座標 (左端=0)
                        v + 8,              // テクスチャ内V座標 (上端=0)
                        4,     // 画面に描画する幅
                        12,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //left sleev
            if(client.options.isPlayerModelPartEnabled(KeyCode.LEFT_SLEEVE.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX + 12*size,           // 画面X座標
                        posY + 8*size,           // 画面Y座標
                        4 * size,
                        12 * size,
                        u + 12,              // テクスチャ内U座標 (左端=0)
                        v + 8,              // テクスチャ内V座標 (上端=0)
                        4,     // 画面に描画する幅
                        12,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //RIGHT PANTS LEG
            if(client.options.isPlayerModelPartEnabled(KeyCode.RIGHT_PANTS_LEG.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX + 4*size,           // 画面X座標
                        posY + 20*size,           // 画面Y座標
                        4 * size,
                        12 * size,
                        u + 4,              // テクスチャ内U座標 (左端=0)
                        v + 20,              // テクスチャ内V座標 (上端=0)
                        4,     // 画面に描画する幅
                        12,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //LEFT PANTS LEG
            if(client.options.isPlayerModelPartEnabled(KeyCode.LEFT_PANTS_LEG.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX + 8*size,           // 画面X座標
                        posY + 20*size,           // 画面Y座標
                        4 * size,
                        12 * size,
                        u + 8,              // テクスチャ内U座標 (左端=0)
                        v + 20,              // テクスチャ内V座標 (上端=0)
                        4,     // 画面に描画する幅
                        12,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }

            //Cape
            if(CAPE_TEXTURE != null){
                if(client.options.isPlayerModelPartEnabled(KeyCode.CAPE.getPart())){
                    drawContext.drawTexture(
                            CAPE_TEXTURE,
                            posX + 16*size,           // 画面X座標
                            posY + 0*size,           // 画面Y座標
                            10 * size,
                            16 * size,
                            1,              // テクスチャ内U座標 (左端=0)
                            1,              // テクスチャ内V座標 (上端=0)
                            10,     // 画面に描画する幅
                            16,    // 画面に描画する高さ
                            64, // テクスチャファイル自体の幅
                            32 // テクスチャファイル自体の高さ
                    );
                }
            }
            }



            /*if(client.options.isPlayerModelPartEnabled(KeyCode.HAT.getPart())){
                drawContext.drawTexture(
                        OVERLAY_TEXTURE,
                        posX,           // 画面X座標
                        posY,           // 画面Y座標
                        u + 4,              // テクスチャ内U座標 (左端=0)
                        v,              // テクスチャ内V座標 (上端=0)
                        drawnWidth,     // 画面に描画する幅
                        drawnHeight,    // 画面に描画する高さ
                        textureFileWidth, // テクスチャファイル自体の幅
                        textureFileHeight // テクスチャファイル自体の高さ
                );
            }*/

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
