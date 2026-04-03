package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillJudgementProcedure {
   public SkillJudgementProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         Entity entity_b = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double pitch = 0.0;
         double tick = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean failed = false;
         ItemStack item_mainHand = ItemStack.EMPTY;
         entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
         if (entity.getPersistentData().getDouble("cnt3") == 4.0 || entity.getPersistentData().getDouble("cnt3") == 9.0 || entity.getPersistentData().getDouble("cnt3") == 14.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-49.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt3") == 5.0 || entity.getPersistentData().getDouble("cnt3") == 10.0) {
            GetGavelProcedure.execute(world, x, y, z, entity);

            for(int index0 = 0; index0 < 5; ++index0) {
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               item_mainHand = var10000.copy();
               if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                  break;
               }

               GavelRightClicked2Procedure.execute(world, x, y, z, entity);
            }

            ItemStack var47;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var47 = _livEnt.getMainHandItem();
            } else {
               var47 = ItemStack.EMPTY;
            }

            if (var47.getItem() == JujutsucraftModItems.GAVEL.get()) {
               if (entity instanceof Player && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 1.5F, 1.25F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity16 = (LivingEntity)entity;
                  if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity17.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(4.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }
         }

         int var48;
         label92: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var48 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label92;
               }
            }

            var48 = 0;
         }

         if (var48 < 200 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               MobEffectInstance var10001;
               MobEffect var10003;
               int var10004;
               label83: {
                  var10003 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                        break label83;
                     }
                  }

                  var10004 = 0;
               }

               var10001 = new MobEffectInstance(var10003, var10004 + 200, 0, false, false);
               _entity.addEffect(var10001);
            }
         }

      }
   }
}
