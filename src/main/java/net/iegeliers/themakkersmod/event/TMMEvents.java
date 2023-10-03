package net.iegeliers.themakkersmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.iegeliers.themakkersmod.TheMakkersMod;
import net.iegeliers.themakkersmod.block.TMMBlocks;
import net.iegeliers.themakkersmod.item.TMMItems;
import net.iegeliers.themakkersmod.villager.TMMVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TheMakkersMod.MODID)
public class TMMEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == TMMVillagers.KNAKWORST_BUTCHER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack1 = new ItemStack(TMMItems.KNAKWORST.get(), 4);
            ItemStack stack2 = new ItemStack(TMMItems.CAN_OF_KNAKWORST.get(), 1);
            ItemStack stack3 = new ItemStack(TMMItems.CAN_OPENER.get(), 1);
            ItemStack stack4 = new ItemStack(TMMBlocks.BLOCK_OF_KNAKWORST.get(), 1);
            ItemStack stack5 = new ItemStack(TMMBlocks.MOOS_STATUE.get(), 1);
            int villagerLevel1 = 1;
            int villagerLevel2 = 2;
            int villagerLevel3 = 3;

            // Level 1 Trades
            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    stack1, 10, 8, 0.02F));
            trades.get(villagerLevel1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 15),
                    stack2, 10, 8, 0.02F));

            // Level 2 Trades
            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 20),
                    stack3, 10, 8, 0.02F));
            trades.get(villagerLevel2).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 24),
                    stack4, 10, 8, 0.02F));

            // Level 3 Trades
            trades.get(villagerLevel3).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 50),
                    stack5, 10, 8, 0.02F));
        }
    }
}