package net.tslat.aoa3.entity.npcs.trader;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.ItemRegister;
import net.tslat.aoa3.common.registration.LootSystemRegister;
import net.tslat.aoa3.common.registration.WeaponRegister;
import net.tslat.aoa3.entity.base.AoATrader;
import net.tslat.aoa3.entity.base.AoATraderRecipe;
import net.tslat.aoa3.library.Enums;
import net.tslat.aoa3.utils.ConfigurationUtil;

import javax.annotation.Nullable;

public class EntityGorbArmsDealer extends AoATrader {
	public static final float entityWidth = 0.5625f;

	public EntityGorbArmsDealer(World world) {
		super(world, entityWidth, 1.6875f);
	}

	@Override
	public float getEyeHeight() {
		return 1.5f;
	}

	@Override
	protected double getBaseMaxHealth() {
		return 30;
	}

	@Override
	protected double getBaseMovementSpeed() {
		return 0.329;
	}

	@Nullable
	@Override
	protected ResourceLocation getLootTable() {
		return LootSystemRegister.entityGorbArmsDealer;
	}

	@Override
	protected Enums.ModGuis getTraderGui() {
		return Enums.ModGuis.TRADER_GORB_ARMS_DEALER;
	}

	@Override
	protected boolean canDespawn() {
		return world.provider.getDimension() != ConfigurationUtil.MainConfig.dimensionIds.mysterium;
	}

	@Override
	protected void getTradesList(final NonNullList<AoATraderRecipe> newTradesList) {
		newTradesList.add(new AoATraderRecipe(new ItemStack(ItemRegister.SILVER_COIN), new ItemStack(WeaponRegister.GRENADE, 5)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(WeaponRegister.RUNIC_BOMB), new ItemStack(ItemRegister.COPPER_COIN, 7)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(ItemRegister.HOLLY_ARROW), new ItemStack(ItemRegister.COPPER_COIN, 2)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(ItemRegister.GOLD_COIN, 3), new ItemStack(WeaponRegister.LASER_BLASTER)));
		newTradesList.add(new AoATraderRecipe(new ItemStack(ItemRegister.GOLD_COIN, 10), new ItemStack(ItemRegister.WEAPON_PARTS)));
	}
}
