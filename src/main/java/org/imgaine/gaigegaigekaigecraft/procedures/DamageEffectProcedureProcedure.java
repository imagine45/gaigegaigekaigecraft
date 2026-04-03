package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DamageEffectProcedureProcedure {
   public DamageEffectProcedureProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator, double damage_amount) {
      if (entity != null && entityiterator != null) {
         boolean var10000;
         label92: {
            label98: {
               boolean entity_sword = false;
               boolean guard = false;
               boolean iron_body = false;
               boolean iron_attack = false;
               boolean iron_guard = false;
               double num1 = 0.0;
               double num2 = 0.0;
               double x_pos = 0.0;
               double y_pos = 0.0;
               double z_pos = 0.0;
               double soundPitch = 0.0;
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt0 = (LivingEntity)entityiterator;
                  if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label98;
                  }
               }

               if (entityiterator.getPersistentData().getDouble("skill") == 0.0 || !(entityiterator.getPersistentData().getDouble("Damage") > 0.0) || !entityiterator.getPersistentData().getBoolean("attack")) {
                  var10000 = false;
                  break label92;
               }
            }

            var10000 = true;
         }

         boolean var24 = var10000;
         boolean var26 = LogicSwordProcedure.execute(entity);
         boolean var27 = LogicSwordProcedure.execute(entityiterator);
         boolean var25 = LogicIronBodyProcedure.execute(entityiterator);
         double var28 = (double)Math.round(Math.min(1.0 + (damage_amount - 20.0) / 40.0, 4.0));
         double var29 = entityiterator.getX();
         double var30 = entityiterator.getY();
         double var31 = entityiterator.getZ();

         for(int index0 = 0; index0 < (int)var28; ++index0) {
            if (var26) {
               if (var27 && var24) {
                  double var34 = Mth.nextDouble(RandomSource.create(), 0.9, 1.1);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_sword")), SoundSource.NEUTRAL, 1.0F, (float)var34);
                     } else {
                        _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:guard_sword")), SoundSource.NEUTRAL, 1.0F, (float)var34, false);
                     }
                  }
               } else if (var25) {
                  double var32 = Mth.nextDouble(RandomSource.create(), 1.0, 1.2);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, (float)var32);
                     } else {
                        _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, (float)var32, false);
                     }
                  }
               } else {
                  double var33 = Mth.nextDouble(RandomSource.create(), 0.75, 1.25);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)var33);
                     } else {
                        _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)var33, false);
                     }
                  }
               }
            } else if (var27 && var24) {
               double var37 = Mth.nextDouble(RandomSource.create(), 1.25, 1.5);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:strong_hit")), SoundSource.NEUTRAL, 1.0F, (float)var37);
                  } else {
                     _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:strong_hit")), SoundSource.NEUTRAL, 1.0F, (float)var37, false);
                  }
               }
            } else if (var25) {
               double var35 = Mth.nextDouble(RandomSource.create(), 0.8, 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, (float)var35);
                  } else {
                     _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, (float)var35, false);
                  }
               }
            } else {
               double var36 = Mth.nextDouble(RandomSource.create(), 0.5, 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var29, var30, var31), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:strong_hit")), SoundSource.NEUTRAL, 1.0F, (float)var36);
                  } else {
                     _level.playLocalSound(var29, var30, var31, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:strong_hit")), SoundSource.NEUTRAL, 1.0F, (float)var36, false);
                  }
               }
            }
         }

      }
   }
}
