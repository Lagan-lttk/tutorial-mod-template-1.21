package net.gustavo.tutorialmod.util;

import net.gustavo.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks{

        public static final TagKey<Block> NEEDS_MACONHA_TOOL = createTag("needs_maconha_tool");
        public static final TagKey<Block> INCORRECT_FOR_MACONHA_TOOL = createTag("incorrect_for_maconha_tool");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID,name));
        }
    }

    public static class Items{
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }
    }
}
