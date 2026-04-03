package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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

public class SummonNueProcedure {
   public SummonNueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
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

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("x_pos", x);
            entity.getPersistentData().putDouble("y_pos", y);
            entity.getPersistentData().putDouble("z_pos", z);
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5);
            entity.getPersistentData().putDouble("cnt6", (double)(!((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.equals(Component.translatable("entity.gaigegaigekaigecraft.nue_totality").getString()) && !(entity instanceof SukunaFushiguroEntity) ? 0 : 10));
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
               LivingEntity _livingEntity38 = (LivingEntity)entity;
               if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 40, 0.5, 0.5, 0.5, 0.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 40, 0.5, 0.5, 0.5, 0.25);
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.NUE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
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

                  label221: {
                     label275: {
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        if (entity.getPersistentData().getDouble("TenShadowsTechnique4") != 1.0) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label275;
                           }

                           ServerPlayer _plr59 = (ServerPlayer)entity;
                           if (!(_plr59.level() instanceof ServerLevel) || !_plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_nue"))).isDone()) {
                              break label275;
                           }
                        }

                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putBoolean("Ambush", true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                           if (_livingEntity70.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              AttributeInstance var10000;
                              double var10001;
                              label208: {
                                 var10000 = _livingEntity70.getAttribute(Attributes.ATTACK_DAMAGE);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                                    if (_livingEntity66.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10001 = _livingEntity66.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label208;
                                    }
                                 }

                                 var10001 = 0.0;
                              }

                              double var10002;
                              label203: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity67 = (LivingEntity)entity;
                                    if (_livingEntity67.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10002 = _livingEntity67.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label203;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              int var10003;
                              label198: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label198;
                                    }
                                 }

                                 var10003 = 0;
                              }

                              var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.level().isClientSide()) {
                              MobEffectInstance var56;
                              MobEffect var61;
                              int var10005;
                              label187: {
                                 var61 = MobEffects.DAMAGE_RESISTANCE;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                       var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                       break label187;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var56 = new MobEffectInstance(var61, 2147483647, Math.max(var10005, 1), false, false);
                              _entity.addEffect(var56);
                           }
                        }

                        entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                        entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                        entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                        break label221;
                     }

                     entityinstance.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                  }

                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     entityinstance.getPersistentData().putBoolean("Giant", true);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity92 = (LivingEntity)entityinstance;
                        if (_livingEntity92.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity92.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.0 + entity.getPersistentData().getDouble("cnt6") * 0.25);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity96 = (LivingEntity)entityinstance;
                        if (_livingEntity96.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           AttributeInstance var53;
                           double var57;
                           label168: {
                              var53 = _livingEntity96.getAttribute(Attributes.MAX_HEALTH);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity94 = (LivingEntity)entityinstance;
                                 if (_livingEntity94.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                    var57 = _livingEntity94.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                                    break label168;
                                 }
                              }

                              var57 = 0.0;
                           }

                           var53.setBaseValue(var57 * 2.5);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity100 = (LivingEntity)entityinstance;
                        if (_livingEntity100.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                           AttributeInstance var54;
                           double var58;
                           label157: {
                              var54 = _livingEntity100.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity98 = (LivingEntity)entityinstance;
                                 if (_livingEntity98.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                    var58 = _livingEntity98.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                                    break label157;
                                 }
                              }

                              var58 = 0.0;
                           }

                           var54.setBaseValue(Math.max(var58, 8.0));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity104 = (LivingEntity)entityinstance;
                        if (_livingEntity104.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                           AttributeInstance var55;
                           double var59;
                           label146: {
                              var55 = _livingEntity104.getAttribute(Attributes.FOLLOW_RANGE);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity102 = (LivingEntity)entityinstance;
                                 if (_livingEntity102.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                                    var59 = _livingEntity102.getAttribute(Attributes.FOLLOW_RANGE).getBaseValue();
                                    break label146;
                                 }
                              }

                              var59 = 0.0;
                           }

                           var55.setBaseValue(Math.max(var59, 64.0));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        float var60;
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityinstance;
                           var60 = _livEnt.getMaxHealth();
                        } else {
                           var60 = -1.0F;
                        }

                        _entity.setHealth(var60);
                     }
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
                  }

                  if (entity instanceof RozetsuShikigamiVessel2Entity && entityinstance instanceof NueEntity) {
                     NueEntity animatable = (NueEntity)entityinstance;
                     animatable.setTexture("nue_black");
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.getPersistentData().putDouble("TenShadowsTechnique4", -1.0);
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") > 25.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
