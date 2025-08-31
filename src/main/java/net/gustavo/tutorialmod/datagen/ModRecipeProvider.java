package net.gustavo.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.gustavo.tutorialmod.TutorialMod;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.item.ModItem;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        List<ItemConvertible> FAZEDORES_DE_MACONHA = List.of(ModItem.PRENSADO, ModItem.BANZA_VERDIN, ModBlocks.BLOCO_DE_MACONHA);

        offerSmelting(recipeExporter, FAZEDORES_DE_MACONHA, RecipeCategory.MISC, ModItem.MACONHA,0.25f,100, "maconha");
        offerBlasting(recipeExporter, FAZEDORES_DE_MACONHA, RecipeCategory.MISC, ModItem.MACONHA,0.25f,100, "maconha");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItem.PRENSADO, RecipeCategory.DECORATIONS, ModBlocks.OLHO_NEGRO);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BLOCO_DE_MACONHA)
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .input('M', ModItem.MACONHA)
                .criterion(hasItem(ModItem.MACONHA), conditionsFromItem(ModItem.MACONHA))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItem.MACONHA, 9)
                .input(ModBlocks.BLOCO_DE_MACONHA)
                .criterion(hasItem(ModBlocks.BLOCO_DE_MACONHA), conditionsFromItem(ModBlocks.BLOCO_DE_MACONHA))
                .offerTo(recipeExporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItem.MACONHA, 32)
                .input(ModBlocks.MAGIC_BLOCK)
                .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                .offerTo(recipeExporter, Identifier.of(TutorialMod.MOD_ID,"maconha_from_magic_block"));
    }
}
