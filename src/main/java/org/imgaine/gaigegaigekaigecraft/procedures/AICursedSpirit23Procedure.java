package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BathynomusGiganteusEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AICursedSpirit23Procedure {
   public AICursedSpirit23Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         Entity entity_a = null;
         if (entity.isAlive() && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect(MobEffects.MOVEMENT_SPEED);
            }

            if (entity instanceof BathynomusGiganteusEntity) {
               label160: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt6 = (LivingEntity)entity;
                     if (_livEnt6.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        break label160;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 6, false, false));
                     }
                  }
               }

               label155: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        break label155;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 2, false, false));
                     }
                  }
               }

               label150: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt10 = (LivingEntity)entity;
                     if (_livEnt10.hasEffect(MobEffects.DOLPHINS_GRACE)) {
                        break label150;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2147483647, 4, false, false));
                     }
                  }
               }

               label145: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.hasEffect(MobEffects.WATER_BREATHING)) {
                        break label145;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2147483647, 0, false, false));
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
                     label190: {
                        entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                        if (entity_a.isAlive()) {
                           label183: {
                              if (entity_a instanceof LivingEntity) {
                                 LivingEntity _livEnt18 = (LivingEntity)entity_a;
                                 if (_livEnt18.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                    break label183;
                                 }
                              }

                              if (entity.getPersistentData().getDouble("friend_num") != entity_a.getPersistentData().getDouble("friend_num") && !entity.level().isClientSide()) {
                                 entity.discard();
                              }
                              break label190;
                           }
                        }

                        if (!entity.level().isClientSide()) {
                           entity.discard();
                        }
                     }
                  } else if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }

               entity.getPersistentData().putDouble("cnt_settarget", entity.getPersistentData().getDouble("cnt_settarget") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_settarget") > 10.0) {
                  entity.getPersistentData().putDouble("cnt_settarget", -20.0);
                  SetTargetProcedure.execute(world, x, y, z, entity);
               }
            } else {
               label184: {
                  label166: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt28 = (LivingEntity)entity;
                        if (_livEnt28.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           break label166;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 5, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt30 = (LivingEntity)entity;
                     if (_livEnt30.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        break label184;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 1, false, false));
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackBiteProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("skill") == 2.0) {
               AttackGroundBiteProcedure.execute(world, x, y, z, entity);
            } else {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", -50.0);
                     ResetCounterProcedure.execute(entity);
                     if (!(Math.random() < 0.5) && !(entity instanceof BathynomusGiganteusEntity)) {
                        entity.getPersistentData().putDouble("skill", 2.0);
                     } else {
                        entity.getPersistentData().putDouble("skill", 1.0);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:0b}");
            }
         }

      }
   }
}
