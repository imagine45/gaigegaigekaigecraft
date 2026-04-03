package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueKusakabe1Procedure {
   public TechniqueKusakabe1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double y_fix = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix_height = 0.0;
         double speed = 0.0;
         double level_newShadowStyle = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         if (entity instanceof Player) {
            label510: {
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr1 = (ServerPlayer)entity;
                  if (_plr1.level() instanceof ServerLevel && _plr1.getAdvancements().getOrStartProgress(_plr1.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_4"))).isDone()) {
                     level_newShadowStyle = 4.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr2 = (ServerPlayer)entity;
                  if (_plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_3"))).isDone()) {
                     level_newShadowStyle = 3.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr3 = (ServerPlayer)entity;
                  if (_plr3.level() instanceof ServerLevel && _plr3.getAdvancements().getOrStartProgress(_plr3.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_2"))).isDone()) {
                     level_newShadowStyle = 2.0;
                     break label510;
                  }
               }

               if (entity instanceof ServerPlayer) {
                  ServerPlayer _plr4 = (ServerPlayer)entity;
                  if (_plr4.level() instanceof ServerLevel && _plr4.getAdvancements().getOrStartProgress(_plr4.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_new_shadow_style_lv_1"))).isDone()) {
                     level_newShadowStyle = 1.0;
                     break label510;
                  }
               }

               level_newShadowStyle = 1.0;
            }
         } else if (entity instanceof KusakabeAtsuyaEntity) {
            level_newShadowStyle = 4.0;
         } else {
            level_newShadowStyle = 1.0;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
            if (level_newShadowStyle <= 1.0 || entity.getPersistentData().getDouble("cnt8") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 9, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt8") == 1.0) {
                  label535: {
                     if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_hollow_wicker_basket")))) {
                        label529: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label529;
                              }
                           }

                           if (!(entity instanceof Player) || num1 != 1.0 && num2 != 1.0 && num1 != 7.0 && num2 != 7.0 && num1 != 12.0 && num2 != 12.0 && num1 != 24.0 && num2 != 24.0) {
                              num1 = -16.0;
                              break label535;
                           }
                        }
                     }

                     num1 = -17.0;
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity17 = (LivingEntity)entity;
                     if (_livingEntity17.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity17.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(num1);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }
            }

            entity.getPersistentData().putDouble("Damage", 15.0);
            entity.getPersistentData().putDouble("Range", 1.5);
            entity.getPersistentData().putDouble("effect", 5.0);
            entity.getPersistentData().putDouble("projectile_type", 1.0);
            entity.getPersistentData().putBoolean("swing", true);
            DamageFixProcedure.execute(entity);
            num1 = entity.getPersistentData().getDouble("cnt8") - 1.0;
            if (!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().getDouble("cnt8") <= 40.0)) {
               num1 = Math.max((num1 - 40.0) * 50.0, 1.0);
               num1 = Math.min(160.0 + num1, 640.0);
            } else {
               num1 = Math.max(num1 * 50.0, 1.0);
               num1 = Math.min(num1, 160.0);
            }

            for(int index0 = 0; index0 < 5; ++index0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)num1, 1, true, true));
                  }
               }

               num1 += 10.0;
               if (num1 > (double)(!(level_newShadowStyle < 4.0) && !(entity.getPersistentData().getDouble("cnt8") <= 60.0) ? 160 : 640)) {
                  break;
               }
            }

            double var10000;
            int var10002;
            label427: {
               var10000 = (double)entity.getBbWidth();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                     break label427;
                  }
               }

               var10002 = 0;
            }

            dis = Math.min(var10000 + 0.025 * (double)var10002, level_newShadowStyle >= 4.0 ? 16.0 : 4.0);
            if (entity.getPersistentData().getDouble("cnt8") > 200.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               entity.getPersistentData().putDouble("skill", 0.0);
            } else {
               entity.getPersistentData().putString("TARGET", "");
               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis * 2.0 / 2.0), (e) -> true)) {
                  if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && entity.getY() + (double)entity.getBbHeight() >= entityiterator.getY() && entity.getY() <= entityiterator.getY() + (double)entityiterator.getBbHeight() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     entity.getPersistentData().putString("TARGET1", entityiterator.getStringUUID());
                     entity.getPersistentData().putDouble("cnt1", 1.0);
                     entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 1.0));
                     entity.getPersistentData().putDouble("cnt7", 1.0);
                     entity.getPersistentData().putDouble("cnt8", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }
                     break;
                  }
               }
            }
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET1"));
         if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
            if (entity_a instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
               dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.getX() - entity.getX()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getY() - entity.getY()) - (double)(entity_a.getBbHeight() + entity.getBbHeight()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getZ() - entity.getZ()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0));
               RotateEntityProcedure.execute(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), entity);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               speed = Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_power"), 2.0));
               speed *= 4.0;
               if (speed != 0.0) {
                  vx = entity.getPersistentData().getDouble("x_power") / speed;
                  vy = entity.getPersistentData().getDouble("y_power") / speed;
                  vz = entity.getPersistentData().getDouble("z_power") / speed;
                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();
                  logic_b = true;

                  for(int index1 = 0; index1 < (int)Math.round(speed * 4.5); ++index1) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.getX() - entity.getX()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getY() - entity.getY()) - (double)(entity_a.getBbHeight() + entity.getBbHeight()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getZ() - entity.getZ()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0));
                     if (dis < 2.5) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), entity);
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().putDouble("cnt7", 2.0);
                        break;
                     }

                     y_pos += vy;
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.isInWall() || world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        y_pos -= vy;
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     x_pos += vx;
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.isInWall()) {
                        x_pos -= vx;
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }

                     z_pos += vz;
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                     }

                     if (entity.isInWall()) {
                        z_pos -= vz;
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                        }
                     }
                  }

                  for(int index2 = 0; index2 < 8; ++index2) {
                     dis = Math.sqrt(Math.pow(Math.max(Math.abs(entity_a.getX() - entity.getX()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getY() - entity.getY()) - (double)(entity_a.getBbHeight() + entity.getBbHeight()), 0.0), 2.0) + Math.pow(Math.max(Math.abs(entity_a.getZ() - entity.getZ()) - (double)(entity_a.getBbWidth() + entity.getBbWidth()), 0.0), 2.0));
                     if (dis < 2.5) {
                        logic_b = false;
                        RotateEntityProcedure.execute(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5, entity_a.getZ(), entity);
                        entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                        entity.getPersistentData().putDouble("cnt7", 2.0);
                        break;
                     }

                     logic_a = true;
                     y_fix_height = 0.0;

                     for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.getBbHeight() + 0.0F)); ++index3) {
                        if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + vy + y_fix_height, z_pos)).canOcclude()) {
                           logic_a = false;
                           break;
                        }

                        ++y_fix_height;
                     }

                     if (logic_a) {
                        x_pos += vx;
                        y_pos += vy;
                        z_pos += vz;
                     } else {
                        y_fix = 0.0;

                        for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * 2.0, 1.0)); ++index4) {
                           if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).canOcclude()) {
                              if (world.getBlockState(BlockPos.containing(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).canOcclude()) {
                                 logic_a = false;
                                 break;
                              }

                              y_fix += 0.5;
                           } else {
                              logic_a = true;
                              y_fix_height = 0.0;

                              for(int index5 = 0; index5 < (int)Math.ceil((double)entity.getBbHeight()); ++index5) {
                                 if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).canOcclude()) {
                                    logic_a = false;
                                    break;
                                 }

                                 ++y_fix_height;
                              }

                              if (logic_a) {
                                 break;
                              }

                              ++y_fix;
                           }
                        }

                        if (logic_a) {
                           y_pos = y_pos + vy + y_fix;
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.isInWall() || world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                              y_pos = y_pos - vy - y_fix;
                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           x_pos += vx;
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.isInWall()) {
                              x_pos -= vx;
                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }

                           z_pos += vz;
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                           }

                           if (entity.isInWall()) {
                              z_pos -= vz;
                              if (!entity.level().isClientSide() && entity.getServer() != null) {
                                 entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s " + x_pos + " " + y_pos + " " + z_pos + " ~ ~");
                              }
                           }
                           continue;
                        }
                     }

                     if (!logic_a) {
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }
               }
            } else {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().putDouble("cnt7", 2.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") > 1.0) {
            if (level_newShadowStyle >= 3.0) {
               entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
               if (entity.getPersistentData().getDouble("cnt5") <= (double)(level_newShadowStyle == 3.0 ? 25 : 50)) {
                  if (entity.getPersistentData().getDouble("cnt2") > 0.0) {
                     entity.getPersistentData().putDouble("cnt1", 1.0);
                     entity.getPersistentData().putDouble("cnt2", 0.0);
                     entity.getPersistentData().putDouble("cnt6", 2.5 + Math.min(entity.getPersistentData().getDouble("cnt5") * 0.01, 0.5));
                     entity.getPersistentData().putDouble("cnt7", 1.0);
                     entity.getPersistentData().putDouble("cnt8", 18.0);
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt6", 10.0);
                  entity.getPersistentData().putDouble("cnt5", 100.0);
               }
            } else {
               entity.getPersistentData().putDouble("cnt6", 10.0);
               entity.getPersistentData().putDouble("cnt5", 100.0);
            }

            for(int index6 = 0; index6 < 5; ++index6) {
               AttackWeakProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().getDouble("cnt5") >= 100.0) {
                  break;
               }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 1.0 && entity_a instanceof LivingEntity && !entity_a.isAlive()) {
               entity.getPersistentData().putDouble("cnt7", 0.0);
               entity.getPersistentData().putDouble("cnt8", 100.0);
            }
         }

      }
   }
}
