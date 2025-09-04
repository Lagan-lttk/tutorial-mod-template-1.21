package net.gustavo.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.block.custom.PinkGarnetLampBlock;
import net.gustavo.tutorialmod.item.ModItem;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        BlockStateModelGenerator.BlockTexturePool blocoDeMaconhaPoll =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLOCO_DE_MACONHA);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OLHO_NEGRO);

        blocoDeMaconhaPoll.stairs(ModBlocks.BLOCO_DE_MACONHA_STAIRS);
        blocoDeMaconhaPoll.slab(ModBlocks.BLOCO_DE_MACONHA_SLAB);

        blocoDeMaconhaPoll.button(ModBlocks.BLOCO_DE_MACONHA_BOTAO);
        blocoDeMaconhaPoll.pressurePlate(ModBlocks.BLOCO_DE_MACONHA_PRESSURE_PLATE);

        blocoDeMaconhaPoll.fence(ModBlocks.BLOCO_DE_MACONHA_FENCE);
        blocoDeMaconhaPoll.fenceGate(ModBlocks.BLOCO_DE_MACONHA_FENCE_GATE);
        blocoDeMaconhaPoll.wall(ModBlocks.BLOCO_DE_MACONHA_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.BLOCO_DE_MACONHA_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BLOCO_DE_MACONHA_TRAPDOOR);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.PINK_GARNET_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.PINK_GARNET_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.PINK_GARNET_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(PinkGarnetLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

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

        itemModelGenerator.register(ModItem.MACONHA_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItem.MACONHA_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.MACONHA_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.MACONHA_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItem.MACONHA_HOE, Models.HANDHELD);
    }
}

