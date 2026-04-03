package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSoulExplosionProcedure {
   public SkillSoulExplosionProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         boolean player = false;
         boolean GRAVESTONE = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double old_skill = 0.0;
         double HP = 0.0;
         double range = 0.0;
         double tick = 0.0;
         double MAX_ST = 0.0;
         double damage = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               ChargeParticleProcedure.execute(world, entity, 1.0);
            } else {
               ChargeParticleProcedure.execute(world, entity, 0.0);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                  }
               }

               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 6.0) {
                  label245: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label246: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                 break label246;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label245;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 0.0));
               if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  entity.getPersistentData().putDouble("cnt6", 5.0);
               } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
               } else {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
               }
            }

            LivingEntity var79;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var79 = _mobEnt.getTarget();
            } else {
               var79 = null;
            }

            if (var79 instanceof LivingEntity) {
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               double var80 = ((Entity)var10004).getX();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               double var81 = ((Entity)var10005).getY();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var81 += (double)((Entity)var10006).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.getTarget();
               } else {
                  var10006 = null;
               }

               var10002 = new Vec3(var80, var81, ((Entity)var10006).getZ());
               entity.lookAt(var10001, var10002);
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
                     y_pos = entityiterator.getY();
                     z_pos = entityiterator.getZ();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += 6.0;
            }

            for(int index1 = 0; index1 < 255 && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))); ++index1) {
               ++y_pos;
            }

            for(int index2 = 0; index2 < 255 && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))); ++index2) {
               --y_pos;
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity77 = (LivingEntity)entity;
               if (_livingEntity77.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity77.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         dis = 6.0 * CNT6;
         if (entity.getPersistentData().getDouble("cnt1") > 1.0 && entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 2.0F, 0.9F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_portal.spawn")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 10.0, 90.0, dis, dis, 0.25, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:sculk_soul");
            ParticleGeneratorCircleProcedure.execute(world, 10.0, 90.0, dis, dis, 0.25, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:squid_ink");
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0 && entity.getPersistentData().getDouble("cnt1") < 20.0) {
            entity.getPersistentData().putDouble("y_knockback", 0.26);
            entity.getPersistentData().putDouble("Damage", 14.0 * CNT6);
            entity.getPersistentData().putDouble("knockback", 0.1);
            entity.getPersistentData().putDouble("Range", 2.0 * dis);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("BlockRange", 1.0 * dis);
            entity.getPersistentData().putDouble("BlockDamage", 0.2 * CNT6);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("y_knockback", 0.0);
            ParticleGeneratorCircleProcedure.execute(world, 10.0, 90.0, dis, dis, 0.5, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:sculk_soul");
            ParticleGeneratorCircleProcedure.execute(world, 10.0, 90.0, dis, dis, 1.5, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:squid_ink");

            for(int index3 = 0; index3 < 10; ++index3) {
               dis = Mth.nextDouble(RandomSource.create(), 0.0, 6.0);
               ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, dis, dis, 0.5, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:soul");
               dis = Mth.nextDouble(RandomSource.create(), 0.0, 6.0);
               ParticleGeneratorCircleProcedure.execute(world, 2.0, 90.0, dis, dis, 1.5, x_pos, x_pos, y_pos, y_pos + 1.0, 0.0, z_pos, z_pos, "minecraft:squid_ink");
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
