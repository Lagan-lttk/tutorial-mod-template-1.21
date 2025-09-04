package net.gustavo.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.OLHO_NEGRO)
                .add(ModBlocks.BLOCO_DE_MACONHA)
                .add(ModBlocks.MAGIC_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.OLHO_NEGRO)
                .add(ModBlocks.BLOCO_DE_MACONHA);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.BLOCO_DE_MACONHA_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.BLOCO_DE_MACONHA_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.BLOCO_DE_MACONHA_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_MACONHA_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
