package net.tslat.aoa3.entity.mobs.shyrelands;

import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.tslat.aoa3.common.registration.LootSystemRegister;
import net.tslat.aoa3.common.registration.SoundsRegister;
import net.tslat.aoa3.entity.base.AoAMeleeMob;
import net.tslat.aoa3.entity.properties.SpecialPropertyEntity;
import net.tslat.aoa3.library.Enums;
import net.tslat.aoa3.utils.EntityUtil;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.TreeSet;

public class EntityStimulo extends AoAMeleeMob implements SpecialPropertyEntity {
    public static final float entityWidth = 0.6f;

    public EntityStimulo(World world) {
        super(world, entityWidth, 1.875f);

        mobProperties.add(Enums.MobProperties.BLASTER_IMMUNE);
    }

    @Override
    public float getEyeHeight() {
        return 1.78125f;
    }

    @Override
    protected double getBaseKnockbackResistance() {
        return 0;
    }

    @Override
    protected double getBaseMaxHealth() {
        return 164;
    }

    @Override
    protected double getBaseMeleeDamage() {
        return 15.5;
    }

    @Override
    protected double getBaseMovementSpeed() {
        return 0.27;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundsRegister.MOB_STIMULO_LIVING;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundsRegister.MOB_STIMULO_DEATH;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundsRegister.MOB_STIMULO_HIT;
    }

    @Nullable
    @Override
    protected ResourceLocation getLootTable() {
        return LootSystemRegister.entityStimulo;
    }

    @Override
    public boolean getCanSpawnHere() {
        return posY < 35 && super.getCanSpawnHere();
    }

    @Override
    protected boolean isSpecialImmuneTo(DamageSource source, int damage) {
        return EntityUtil.isBlasterDamage(source);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!world.isRemote) {
            float healthPercent = EntityUtil.getCurrentHealthPercent(this);

            if (healthPercent < 0.25) {
                addPotionEffect(new PotionEffect(MobEffects.SPEED, -1, 0, true, false));
            }
            else if (healthPercent < 0.50) {
                addPotionEffect(new PotionEffect(MobEffects.SPEED, -1, 1, true, false));
            }
            else if (healthPercent < 0.75) {
                addPotionEffect(new PotionEffect(MobEffects.SPEED, -1, 2, true, false));
            }
        }
    }

    @Nonnull
    @Override
    public TreeSet<Enums.MobProperties> getMobProperties() {
        return mobProperties;
    }
}
