package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityTornadoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AITornadeProcedure {
   public AITornadeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         ItemStack old_health = ItemStack.EMPTY;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean player = false;
         double x_knockback = 0.0;
         double CNT6 = 0.0;
         double z_knockback = 0.0;
         double z_pos = 0.0;
         double power_attenuation = 0.0;
         double y_knockback = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double yaw = 0.0;
         double height = 0.0;
         if (entity instanceof EntityTornadoEntity) {
            EntityTornadoEntity _datEntSetL = (EntityTornadoEntity)entity;
            _datEntSetL.getEntityData().set(EntityTornadoEntity.DATA_blue, entity.getPersistentData().getDouble("skill") >= 3600.0 && entity.getPersistentData().getDouble("skill") < 3700.0);
         }

         label265: {
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity instanceof EntityTornadoEntity) {
               EntityTornadoEntity _datEntL4 = (EntityTornadoEntity)entity;
               if ((Boolean)_datEntL4.getEntityData().get(EntityTornadoEntity.DATA_blue)) {
                  if (entity instanceof EntityTornadoEntity) {
                     EntityTornadoEntity animatable = (EntityTornadoEntity)entity;
                     animatable.setTexture("tornado_blue");
                  }

                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt2") > 60.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }

                  double var10000;
                  label230: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity10 = (LivingEntity)entity;
                        if (_livingEntity10.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label230;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 6.0 + entity.getPersistentData().getDouble("cnt6") && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entity;
                     if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10001;
                        AttributeInstance var84;
                        label223: {
                           var84 = _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity12 = (LivingEntity)entity;
                              if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                 break label223;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var84.setBaseValue(Math.min(var10001 + 0.2 * CNT6, 6.0 + entity.getPersistentData().getDouble("cnt6")));
                     }
                  }

                  entity.getPersistentData().putDouble("BlockRange", (double)(2.0F + 2.0F * entity.getBbWidth()) * 0.5);
                  entity.getPersistentData().putDouble("BlockDamage", 0.2 * CNT6);
                  BlockDestroyAllDirectionProcedure.execute(world, x, entity.getY() + (double)entity.getBbHeight() * 0.5, z, entity);
                  BulletDomainHit2Procedure.execute(world, entity);
                  power_attenuation = 1.0;
                  logic_b = false;

                  for(int index0 = 0; index0 < 5; ++index0) {
                     entity.getPersistentData().putDouble("Range", Math.min(30.0 * power_attenuation * CNT6, 50.0));
                     entity.getPersistentData().putDouble("knockback", Math.max(-2.5 * (1.2 - power_attenuation) * CNT6, -5.0));
                     Vec3 _center = new Vec3(x, entity.getY() + (double)entity.getBbHeight() * 0.5, z);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator) {
                           label254: {
                              logic_a = true;
                              if (entityiterator instanceof Player) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 16.0 && ((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 16.0) {
                                    break label254;
                                 }
                              } else if (!(entityiterator instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity)) {
                                 break label254;
                              }

                              ItemStack var85;
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                                 var85 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                              } else {
                                 var85 = ItemStack.EMPTY;
                              }

                              old_health = var85.copy();
                              if (entityiterator instanceof Player) {
                                 Player _plrCldCheck29 = (Player)entityiterator;
                                 if (_plrCldCheck29.getCooldowns().isOnCooldown(old_health.getItem())) {
                                    break label254;
                                 }
                              }

                              if (old_health.getItem() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get() || old_health.getItem() == JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                                 CompoundTag var86 = old_health.getOrCreateTag();
                                 CompoundTag var87 = entity.getPersistentData();
                                 if (var86.getDouble("skill" + Math.round(var87.getDouble("skill"))) >= 100.0) {
                                    logic_a = false;
                                 }
                              }
                           }

                           if (logic_a) {
                              player = entityiterator instanceof Player;
                              x_knockback = entityiterator.getX() - entity.getX();
                              y_knockback = entityiterator.getY() - entity.getY();
                              z_knockback = entityiterator.getZ() - entity.getZ();
                              num2 = Math.sqrt(Math.pow(x_knockback, 2.0) + Math.pow(y_knockback, 2.0) + Math.pow(z_knockback, 2.0));
                              if (!(num2 < (double)Math.max(entity.getBbWidth(), 1.0F)) || entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged")) {
                                 x_knockback = x_knockback / num2 * entity.getPersistentData().getDouble("knockback");
                                 y_knockback = y_knockback / num2 * entity.getPersistentData().getDouble("knockback");
                                 z_knockback = z_knockback / num2 * entity.getPersistentData().getDouble("knockback");
                                 if (!(x_knockback * 1.1 < entityiterator.getDeltaMovement().x()) && !(x_knockback * 0.9 > entityiterator.getDeltaMovement().x())) {
                                    x_knockback = entityiterator.getDeltaMovement().x();
                                 } else {
                                    x_knockback = entityiterator.getDeltaMovement().x() + x_knockback * 0.05;
                                 }

                                 if (!(y_knockback * 1.1 < entityiterator.getDeltaMovement().y()) && !(y_knockback * 0.9 > entityiterator.getDeltaMovement().y())) {
                                    y_knockback = entityiterator.getDeltaMovement().y();
                                 } else {
                                    y_knockback = entityiterator.getDeltaMovement().y() + y_knockback * 0.05;
                                 }

                                 if (!(z_knockback * 1.1 < entityiterator.getDeltaMovement().z()) && !(z_knockback * 0.9 > entityiterator.getDeltaMovement().z())) {
                                    z_knockback = entityiterator.getDeltaMovement().z();
                                 } else {
                                    z_knockback = entityiterator.getDeltaMovement().z() + z_knockback * 0.05;
                                 }

                                 if (entityiterator.onGround()) {
                                    y_knockback = Math.max(y_knockback, 0.5 * (1.2 - power_attenuation) * CNT6);
                                 }

                                 entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                                 if (player) {
                                    if (entity_a == entityiterator || !world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                                       continue;
                                    }

                                    if (entityiterator instanceof Player) {
                                       Player _plr = (Player)entityiterator;
                                       if (_plr.getAbilities().instabuild) {
                                          continue;
                                       }
                                    }

                                    if (InlineMethodHandler.checkGamemodeSpectator(entityiterator)) {
                                       continue;
                                    }
                                 } else if (entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged")) {
                                    continue;
                                 }

                                 EntityVectorProcedure.execute(entityiterator, x_knockback, Math.min(y_knockback, 1.5), z_knockback);
                              }
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("knockback", 0.0);
                     power_attenuation *= 0.75;
                  }

                  entity.getPersistentData().putDouble("Damage", 11.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 1.0);
                  entity.getPersistentData().putDouble("y_knockback", 1.0 * CNT6);
                  break label265;
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     entity.teleportTo(entity_a.getX(), entity_a.getY() - (double)entity.getBbHeight(), entity_a.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity_a.getX(), entity_a.getY() - (double)entity.getBbHeight(), entity_a.getZ(), entity.getYRot(), entity.getXRot());
                     }

                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                     if (entity_a.getPersistentData().getDouble("skill") <= 0.0) {
                        entity.getPersistentData().putDouble("cnt2", 1.0);
                     }

                     if (!entity.isAlive()) {
                        entity_a.getPersistentData().putDouble("skill", 0.0);
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt2", 1.0);
                  }

                  if (!entity_a.isAlive() && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt2", 1.0);
               }
            } else {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt2") > 25.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }

               BulletDomainHit2Procedure.execute(world, entity);
            }

            entity.getPersistentData().putDouble("Damage", 11.0 * CNT6);
            entity.getPersistentData().putDouble("knockback", 1.0);
            entity.getPersistentData().putDouble("y_knockback", 0.15 * CNT6);
         }

         entity.getPersistentData().putDouble("Range", (double)(2.0F + 2.0F * entity.getBbWidth()));
         RangeAttackProcedure.execute(world, x, entity.getY() + (double)entity.getBbHeight() * 0.5, z, entity);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.7F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(0.5 * CNT6), 0.7F, false);
            }
         }

         for(int index1 = 0; index1 < (int)(4.0F * entity.getBbHeight()); ++index1) {
            double var88;
            double var10006;
            double var10008;
            double var10010;
            String var10011;
            label140: {
               yaw = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = Mth.nextDouble(RandomSource.create(), 0.5, 1.0);
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               double var70 = entity.getY() + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth();
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               y_pos = var70 + (distance - 0.5) * 2.0 * (double)entity.getBbHeight();
               var88 = (double)entity.getBbWidth() * 0.25;
               var10006 = x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               var10008 = y_pos + Math.sin(pitch) * -1.0 * distance * (double)entity.getBbWidth();
               var10010 = z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance * (double)entity.getBbWidth();
               if (entity instanceof EntityTornadoEntity) {
                  EntityTornadoEntity _datEntL123 = (EntityTornadoEntity)entity;
                  if ((Boolean)_datEntL123.getEntityData().get(EntityTornadoEntity.DATA_blue)) {
                     var10011 = "minecraft:cloud";
                     break label140;
                  }
               }

               var10011 = "minecraft:squid_ink";
            }

            ParticleGeneratorProcedure.execute(world, var88, 1.0, 0.0, 1.0, x_pos, var10006, y_pos, var10008, z_pos, var10010, var10011);
         }

      }
   }
}
