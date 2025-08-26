package net.gustavo.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.gustavo.tutorialmod.TutorialMod;
import net.gustavo.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup GRUPO_DAS_COISAS_MALUCAS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"grupo_das_coisas_malucas"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItem.BANZA_VERDIN))
                    .displayName(Text.translatable("itemgroup.tutorialmod.grupo_das_coisas_malucas"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItem.PRENSADO);
                        entries.add(ModItem.BANZA_VERDIN);
                        entries.add(ModItem.MACONHA);
                        entries.add(ModItem.SEDA);
                        entries.add(ModItem.CHISEL);
                    })
                    .build());

    public static final ItemGroup GRUPO_DOS_BLOCOS_MALUCoS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID,"grupo_dos_blocos_malucos"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.OLHO_NEGRO))
                    .displayName(Text.translatable("itemgroup.tutorialmod.grupo_dos_blocos_malucos"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.OLHO_NEGRO);
                        entries.add(ModBlocks.BLOCO_DE_MACONHA);
                    })
                    .build());


    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering item groups for "+TutorialMod.MOD_ID);
    }

}
