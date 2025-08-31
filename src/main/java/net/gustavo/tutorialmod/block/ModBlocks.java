package net.gustavo.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gustavo.tutorialmod.TutorialMod;
import net.gustavo.tutorialmod.block.custom.MagicBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLOCO_DE_MACONHA = registerBlock("bloco_de_maconha",
            new Block(AbstractBlock.Settings.create().
                    requiresTool().
                    strength(4f).
                    sounds(BlockSoundGroup.CHERRY_LEAVES)));

    public static final Block OLHO_NEGRO = registerBlock("olho_negro",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f)
                    .requiresTool()
                    .noCollision()
                    .sounds(BlockSoundGroup.FUNGUS)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create()
                    .strength(3f)
                    ));

    public static final Block BLOCO_DE_MACONHA_STAIRS = registerBlock("bloco_de_maconha_stairs",
            new StairsBlock(ModBlocks.BLOCO_DE_MACONHA.getDefaultState()
                    ,AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOCO_DE_MACONHA_SLAB = registerBlock("bloco_de_maconha_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block BLOCO_DE_MACONHA_BOTAO = registerBlock("bloco_de_maconha_botao",
            new ButtonBlock(BlockSetType.IRON,2,
                    AbstractBlock.Settings.create().strength(2f).requiresTool().noCollision()));
    public static final Block BLOCO_DE_MACONHA_PRESSURE_PLATE = registerBlock("bloco_de_maconha_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON,
                    AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block BLOCO_DE_MACONHA_FENCE = registerBlock("bloco_de_maconha_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOCO_DE_MACONHA_FENCE_GATE= registerBlock("bloco_de_maconha_fence_gate",
            new FenceGateBlock(WoodType.ACACIA,AbstractBlock.Settings.create().strength(2f).requiresTool()));
    public static final Block BLOCO_DE_MACONHA_WALL = registerBlock("bloco_de_maconha_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f).requiresTool()));

    public static final Block BLOCO_DE_MACONHA_DOOR = registerBlock("bloco_de_maconha_door",
            new DoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));
    public static final Block BLOCO_DE_MACONHA_TRAPDOOR = registerBlock("bloco_de_maconha_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON,AbstractBlock.Settings.create().strength(2f).requiresTool().nonOpaque()));




    public static Block registerBlock(String name, Block block){
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID,name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
            new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        TutorialMod.LOGGER.info("Registrando blocos para "+ TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.BLOCO_DE_MACONHA);
            fabricItemGroupEntries.add(ModBlocks.OLHO_NEGRO);
            fabricItemGroupEntries.add(ModBlocks.MAGIC_BLOCK);
        });
    }
}
