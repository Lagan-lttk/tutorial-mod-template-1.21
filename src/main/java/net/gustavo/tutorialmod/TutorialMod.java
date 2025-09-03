package net.gustavo.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.gustavo.tutorialmod.block.ModBlocks;
import net.gustavo.tutorialmod.component.ModDataComponentTypes;
import net.gustavo.tutorialmod.item.ModItem;
import net.gustavo.tutorialmod.item.ModItemGroups;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItem.registerModItem();
        ModBlocks.registerModBlocks();

        ModItemGroups.registerItemGroups();

        ModDataComponentTypes.registerDataComponentTypes();
	}
}