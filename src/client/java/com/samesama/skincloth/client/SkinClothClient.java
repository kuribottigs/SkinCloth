package com.samesama.skincloth.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.text.Text;

public class SkinClothClient implements ClientModInitializer {
	private static KeyBinding keyBinding;
	//private final MinecraftClient client = MinecraftClient.getInstance();
	//private final GameOptions options = client.options;

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ClientPlayConnectionEvents.JOIN.register((handler,sender,client) -> {
			client.execute(() -> {
				if(client.player != null){
					Text message = Text.literal(String.valueOf(client.options.isPlayerModelPartEnabled(PlayerModelPart.CAPE)));
					client.player.sendMessage(message, false);
				}
			});
		});
		//options.isPlayerModelPartEnabled(PlayerModelPart.CAPE);
	}
}