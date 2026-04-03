package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class GojoSatoruSchoolDaysEntityIsHurtProcedure {
   public GojoSatoruSchoolDaysEntityIsHurtProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double dis = 0.0;
         float var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getHealth();
         } else {
            var10000 = -1.0F;
         }

         double var41 = (double)var10000;
         float var10001;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10001 = _livEnt.getMaxHealth();
         } else {
            var10001 = -1.0F;
         }

         if (var41 <= (double)var10001 * 0.75) {
            ItemStack var42;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var42 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var42 = ItemStack.EMPTY;
            }

            if (var42.is(ItemTags.create(new ResourceLocation("forge:blindfold")))) {
               if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT) && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity var43;
                  double var10003 = entity.getX();
                  double var10004 = entity.getY() + (double)entity.getBbHeight() * 0.9;
                  double var10005 = entity.getZ();
                  ItemStack var10006;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10006 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10006 = ItemStack.EMPTY;
                  }

                  var43 = new ItemEntity(_level, var10003, var10004, var10005, var10006);
                  ItemEntity entityToSpawn = var43;
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, ItemStack.EMPTY);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
               }
            }

            if (entity instanceof GojoSatoruSchoolDaysEntity && entity.isAlive()) {
               float var44;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var44 = _livEnt.getHealth();
               } else {
                  var44 = -1.0F;
               }

               double var45 = (double)var44;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10001 = _livEnt.getMaxHealth();
               } else {
                  var10001 = -1.0F;
               }

               if (var45 <= (double)var10001 * 0.25 && entity.getPersistentData().getDouble("skill") > 0.0) {
                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntL18 = (GojoSatoruSchoolDaysEntity)entity;
                     if ((Boolean)_datEntL18.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                        return;
                     }
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                     _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                     _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_dying, true);
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:1b}");
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, ItemStack.EMPTY);
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, ItemStack.EMPTY);
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, ItemStack.EMPTY);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, ItemStack.EMPTY);
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, ItemStack.EMPTY);
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     GojoSatoruSchoolDaysEntity animatable = (GojoSatoruSchoolDaysEntity)entity;
                     animatable.setTexture("gojo_satoru_school");
                  }

                  if (entity instanceof GojoSatoruSchoolDaysEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "death");
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.5);
                  }
               }
            }
         }

      }
   }
}
