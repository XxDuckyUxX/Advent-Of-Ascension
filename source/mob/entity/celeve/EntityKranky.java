package net.nevermine.mob.entity.celeve;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.nevermine.izer.Itemizer;
import net.nevermine.izer.SpecialBlockizer;

public class EntityKranky extends EntityMob {
	public EntityKranky(final World par1World) {
		super(par1World);
		setSize(0.6f, 2.3f);
	}

	protected String getLivingSound() {
		final int pick = rand.nextInt(5);
		if (pick == 1) {
			return "nevermine:CeleveClownLiving1";
		}
		if (pick == 2) {
			return "nevermine:CeleveClownLiving2";
		}
		if (pick == 3) {
			return "nevermine:CeleveClownLiving3";
		}
		if (pick == 4) {
			return "nevermine:CeleveClownLiving4";
		}
		return "nevermine:CeleveClownLiving5";
	}

	protected String getDeathSound() {
		return "nevermine:CeleveClownDeath";
	}

	protected String getHurtSound() {
		return "nevermine:CeleveClownHit";
	}

	protected void dropFewItems(final boolean par1, final int par2) {
		if (rand.nextInt(2) == 1) {
			dropItem(Itemizer.CoinCircus, 1);
		}
		if (rand.nextInt(2) == 1) {
			dropItem(Itemizer.CoinsCeleve, 3);
		}
		if (rand.nextInt(7) == 2) {
			dropItem(Item.getItemFromBlock(SpecialBlockizer.ClownBanner), 1);
		}
		if (rand.nextInt(200) == 64) {
			dropItem(Itemizer.UpgradeKitSmiley, 1);
		}
	}

	protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_, final Block p_145780_4_) {
		playSound("mob.pig.step", 1.0f, 1.0f);
	}

	public boolean getCanSpawnHere() {
		return worldObj.difficultySetting != EnumDifficulty.PEACEFUL && rand.nextInt(3) == 1 && worldObj.checkNoEntityCollision(boundingBox) && worldObj.getCollidingBoundingBoxes(this, boundingBox).isEmpty() && !worldObj.isAnyLiquid(boundingBox);
	}

	protected boolean isValidLightLevel() {
		return true;
	}

	protected Entity findPlayerToAttack() {
		final EntityPlayer entityPlayer = worldObj.getClosestVulnerablePlayerToEntity(this, 16.0);
		return (entityPlayer != null && canEntityBeSeen(entityPlayer)) ? entityPlayer : null;
	}

	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0);
		getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(52.0);
		getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.1);
		getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.8);
		getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(85.0);
	}

	public boolean attackEntityAsMob(final Entity par1) {
		if (super.attackEntityAsMob(par1)) {
			if (par1 instanceof EntityLivingBase) {
				addPotionEffect(new PotionEffect(Potion.invisibility.id, 60, 30));
			}
			return true;
		}
		return false;
	}
}