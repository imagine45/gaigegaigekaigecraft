package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SummonGreatSerpentProcedure {
   public SummonGreatSerpentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double NUM_SUM = 0.0;
         double dis = 0.0;
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
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               x_pos = ((Entity)var10000).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var59 = ((Entity)var10000).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var59 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var60;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var60 = _mobEnt.getTarget();
               } else {
                  var60 = null;
               }

               z_pos = ((Entity)var60).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            dis = 6.0;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_pos = entityiterator.getX();
                     y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                     z_pos = entityiterator.getZ();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += 6.0;
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);

            for(int index1 = 0; index1 < 255; ++index1) {
               if (world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"))).canOcclude() || entity.getPersistentData().getDouble("y_pos") < 0.0) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 12.0);
                  break;
               }

               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
            }
         }

         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 60, 0.75, 0.0, 0.75, 0.0);
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
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 60, 0.5, 1.0, 0.5, 0.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 60, 0.5, 1.0, 0.5, 0.25);
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.GREAT_SERPENT.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  label178: {
                     label245: {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        entityinstance.getPersistentData().putDouble("skill", 1.0);
                        entityinstance.getPersistentData().putDouble("mode", 1.0);
                        entityinstance.getPersistentData().putDouble("cnt1", 3.0);
                        entityinstance.getPersistentData().putDouble("cnt2", 1.0);
                        entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                        if (entity.getPersistentData().getDouble("TenShadowsTechnique5") != 1.0) {
                           if (!(entity instanceof ServerPlayer)) {
                              break label245;
                           }

                           ServerPlayer _plr67 = (ServerPlayer)entity;
                           if (!(_plr67.level() instanceof ServerLevel) || !_plr67.getAdvancements().getOrStartProgress(_plr67.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_great_serpent"))).isDone()) {
                              break label245;
                           }
                        }

                        entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                        entityinstance.getPersistentData().putBoolean("Ambush", true);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity78 = (LivingEntity)entityinstance;
                           if (_livingEntity78.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              AttributeInstance var61;
                              double var62;
                              label165: {
                                 var61 = _livingEntity78.getAttribute(Attributes.ATTACK_DAMAGE);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity74 = (LivingEntity)entityinstance;
                                    if (_livingEntity74.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var62 = _livingEntity74.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label165;
                                    }
                                 }

                                 var62 = 0.0;
                              }

                              double var10002;
                              label160: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livingEntity75 = (LivingEntity)entity;
                                    if (_livingEntity75.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var10002 = _livingEntity75.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label160;
                                    }
                                 }

                                 var10002 = 0.0;
                              }

                              int var10003;
                              label155: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label155;
                                    }
                                 }

                                 var10003 = 0;
                              }

                              var61.setBaseValue(var62 + (var10002 + (double)(var10003 * 3)) * 0.5);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           if (!_entity.level().isClientSide()) {
                              MobEffectInstance var63;
                              MobEffect var64;
                              int var10005;
                              label144: {
                                 var64 = MobEffects.DAMAGE_RESISTANCE;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                       var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                       break label144;
                                    }
                                 }

                                 var10005 = 0;
                              }

                              var63 = new MobEffectInstance(var64, 2147483647, Math.max(var10005, 1), false, false);
                              _entity.addEffect(var63);
                           }
                        }

                        entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                        entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                        entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                        break label178;
                     }

                     entityinstance.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                  }

                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt10"));
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            entity.getPersistentData().putDouble("TenShadowsTechnique5", -1.0);
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
