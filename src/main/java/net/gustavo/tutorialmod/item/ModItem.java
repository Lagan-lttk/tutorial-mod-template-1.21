package net.gustavo.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.gustavo.tutorialmod.TutorialMod;
import net.gustavo.tutorialmod.item.custom.ChiselItem;
import net.gustavo.tutorialmod.item.custom.PoteDeMaizena;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItem {

    public static final Item BANZA_VERDIN = registerItem("banza_verdin", new Item(new Item.Settings()));
    public static final Item PRENSADO = registerItem("prensado", new Item(new Item.Settings()));
    public static final Item MACONHA = registerItem("maconha", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.tutorialmod.maconha.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SEDA = registerItem("seda",new Item(new Item.Settings()));

    public static final Item POLENTA = registerItem("polenta", new Item(new Item.Settings().food(ModFoodComponents.POLENTA)));
    public static final Item POTE_DE_MAIZENA = registerItem("pote_de_maizena", new PoteDeMaizena(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),item);
    }

    public static void registerModItem(){
        TutorialMod.LOGGER.info("Registering mod items for"+ TutorialMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
           fabricItemGroupEntries.add(BANZA_VERDIN);
           fabricItemGroupEntries.add(PRENSADO);
           fabricItemGroupEntries.add(MACONHA);
           fabricItemGroupEntries.add(SEDA);
        });
    }
}
