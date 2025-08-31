package net.gustavo.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.item.ModItem;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCO_DE_MACONHA);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OLHO_NEGRO);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItem.POLENTA, Models.GENERATED);
        itemModelGenerator.register(ModItem.BANZA_VERDIN, Models.GENERATED);
        itemModelGenerator.register(ModItem.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModItem.MACONHA, Models.GENERATED);
        itemModelGenerator.register(ModItem.PRENSADO, Models.GENERATED);
        itemModelGenerator.register(ModItem.SEDA, Models.GENERATED);
        itemModelGenerator.register(ModItem.POTE_DE_MAIZENA, Models.GENERATED);
    }
}

