package net.gustavo.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gustavo.tutorialmod.TutorialMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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
                    strength(4f).
                    sounds(BlockSoundGroup.CHERRY_LEAVES)));

    public static final Block OLHO_NEGRO = registerBlock("olho_negro",
            new Block(AbstractBlock.Settings.create()
                    .strength(7f)
                    .noCollision()
                    .sounds(BlockSoundGroup.FUNGUS)));


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
        });
    }
}
