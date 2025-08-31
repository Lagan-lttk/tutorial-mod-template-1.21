package net.gustavo.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.item.ModItem;
import net.minecraft.client.render.RenderLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOCO_DE_MACONHA_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLOCO_DE_MACONHA_TRAPDOOR, RenderLayer.getCutout());
    }
}
