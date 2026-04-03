package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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

public class SummonMaxElephantProcedure {
   public SummonMaxElephantProcedure() {
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
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            yaw = (double)entity.getYRot();
            picth = (double)entity.getXRot();
            if (entity instanceof FushiguroMegumiEntity) {
               entity.getPersistentData().putDouble("cnt4", 2.0);
            }

            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("x_pos", x);
            entity.getPersistentData().putDouble("y_pos", y);
            entity.getPersistentData().putDouble("z_pos", z);
            entity.setYRot(entity.getYRot());
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
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 1.0, 0.0, 1.0, 0.0);
            }

            if (!world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"))).canOcclude()) {
               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity42 = (LivingEntity)entity;
               if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 50, 1.0, 1.0, 1.0, 0.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 100, 1.0, 1.0, 1.0, 0.25);
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.MAX_ELEPHANT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  label151: {
                     label186: {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        if (entity.getPersistentData().getDouble("TenShadowsTechnique7") != 1.0) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label186;
                           }

                           ServerPlayer _plr59 = (ServerPlayer)entity;
                           if (!(_plr59.level() instanceof ServerLevel) || !_plr59.getAdvancements().getOrStartProgress(_plr59.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_max_elephant"))).isDone()) {
                              break label186;
                           }
                        }

                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putBoolean("Ambush", true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity70 = (LivingEntity)entityinstance;
                           if (_livingEntity70.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              AttributeInstance var10000;
                              double var10001;
                              label138: {
                                 var10000 = _livingEntity70.getAttribute(Attributes.ATTACK_DAMAGE);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                                    if (_livingEntity66.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10001 = _livingEntity66.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label138;
                                    }
                                 }

                                 var10001 = 0.0;
                              }

                              double var10002;
                              label133: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity67 = (LivingEntity)entity;
                                    if (_livingEntity67.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10002 = _livingEntity67.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label133;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              int var10003;
                              label128: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label128;
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
                              MobEffectInstance var45;
                              MobEffect var46;
                              int var10005;
                              label117: {
                                 var46 = MobEffects.DAMAGE_RESISTANCE;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                       var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                       break label117;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var45 = new MobEffectInstance(var46, 2147483647, Math.max(var10005, 2), false, false);
                              _entity.addEffect(var45);
                           }
                        }

                        entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                        entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                        entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                        break label151;
                     }

                     entityinstance.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
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

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.getPersistentData().putDouble("TenShadowsTechnique7", -1.0);
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
