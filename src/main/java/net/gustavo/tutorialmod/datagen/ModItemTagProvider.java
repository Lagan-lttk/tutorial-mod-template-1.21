package net.gustavo.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.gustavo.tutorialmod.TutorialMod;
import net.gustavo.tutorialmod.item.ModItem;
import net.gustavo.tutorialmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
            .add(ModItem.BANZA_VERDIN)
            .add(ModItem.MACONHA)
            .add(ModItem.POLENTA)
            .add(ModItem.PRENSADO)
            .add(Items.BELL)
            .add(Items.AXOLOTL_SPAWN_EGG);
    }
}
