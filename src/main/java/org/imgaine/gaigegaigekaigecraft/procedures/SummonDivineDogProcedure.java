package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class SummonDivineDogProcedure {
   public SummonDivineDogProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean player = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double NUM_SUM = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         yaw = (double)entity.getYRot();
         picth = (double)entity.getXRot();
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("x_pos", x);
            entity.getPersistentData().putDouble("y_pos", y);
            entity.getPersistentData().putDouble("z_pos", z);
            entity.setYRot((float)yaw);
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5);
            entity.setYRot((float)yaw);
            entity.setXRot((float)picth);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 40, 0.5, 0.0, 0.5, 0.0);
            }

            if (!world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"))).canOcclude()) {
               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity39 = (LivingEntity)entity;
               if (_livingEntity39.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity39.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 40, 0.5, 0.5, 0.5, 0.0);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 40, 0.5, 0.5, 0.5, 0.25);
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (entity.getPersistentData().getDouble("skill") % 2.0 == 1.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_WHITE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity54 = (LivingEntity)entityinstance;
                        if (_livingEntity54.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                           AttributeInstance var56;
                           double var58;
                           label160: {
                              var56 = _livingEntity54.getAttribute(Attributes.ATTACK_DAMAGE);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity50 = (LivingEntity)entityinstance;
                                 if (_livingEntity50.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                    var58 = _livingEntity50.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                    break label160;
                                 }
                              }

                              var58 = 0.0;
                           }

                           double var60;
                           label155: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity51 = (LivingEntity)entity;
                                 if (_livingEntity51.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                    var60 = _livingEntity51.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                    break label155;
                                 }
                              }

                              var60 = 0.0;
                           }

                           int var62;
                           label150: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var62 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label150;
                                 }
                              }

                              var62 = 0;
                           }

                           var56.setBaseValue(var58 + (var60 + (double)(var62 * 3)) * 0.5);
                        }
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(entity.getXRot());
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var59;
                           MobEffect var63;
                           int var64;
                           label138: {
                              var63 = MobEffects.DAMAGE_RESISTANCE;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                    var64 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                    break label138;
                                 }
                              }

                              var64 = 0;
                           }

                           var59 = new MobEffectInstance(var63, 2147483647, Math.max(var64, 0), false, false);
                           _entity.addEffect(var59);
                        }
                     }

                     entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putBoolean("Ambush", true);
                     entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                     entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                     entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("TenShadowsTechnique1", -1.0);
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.DIVINE_DOG_BLACK.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity97 = (LivingEntity)entityinstance;
                        if (_livingEntity97.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                           AttributeInstance var10000;
                           double var10001;
                           label202: {
                              var10000 = _livingEntity97.getAttribute(Attributes.ATTACK_DAMAGE);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity93 = (LivingEntity)entityinstance;
                                 if (_livingEntity93.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                    var10001 = _livingEntity93.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                    break label202;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           double var10002;
                           label197: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity94 = (LivingEntity)entity;
                                 if (_livingEntity94.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                    var10002 = _livingEntity94.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                    break label197;
                                 }
                              }

                              var10002 = 0.0;
                           }

                           int var10003;
                           label192: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label192;
                                 }
                              }

                              var10003 = 0;
                           }

                           var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                        }
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(entity.getXRot());
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var57;
                           MobEffect var61;
                           int var10005;
                           label180: {
                              var61 = MobEffects.DAMAGE_RESISTANCE;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                    var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                    break label180;
                                 }
                              }

                              var10005 = 0;
                           }

                           var57 = new MobEffectInstance(var61, 2147483647, Math.max(var10005, 0), false, false);
                           _entity.addEffect(var57);
                        }
                     }

                     entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putBoolean("Ambush", true);
                     entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                     entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                     entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("TenShadowsTechnique2", -1.0);
            }

            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
