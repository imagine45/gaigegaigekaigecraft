package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ZonbaFallProcedure {
   public ZonbaFallProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         double distance;
         double dis;
         int var10000;
         label149: {
            SUCCESS = false;
            boolean logic_b = false;
            Entity entity_a = null;
            double strength = 0.0;
            distance = 0.0;
            double d = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            dis = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label149;
               }
            }

            var10000 = 0;
         }

         double var40 = (double)Math.min(var10000, 50);
         double var42 = ReturnEntitySizeProcedure.execute(entity);
         double var51 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         double var45 = entity.getPersistentData().getDouble("x_pos");
         double var55 = entity.getPersistentData().getDouble("y_pos");
         double var47 = entity.getPersistentData().getDouble("z_pos");
         if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
               LivingEntity var71;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.getTarget();
               } else {
                  var71 = null;
               }

               Entity var39 = var71;
               if (var39 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("x_pos", ((Entity)var39).getX());
                  entity.getPersistentData().putDouble("y_pos", ((Entity)var39).getY() + (double)((Entity)var39).getBbHeight());
                  entity.getPersistentData().putDouble("z_pos", ((Entity)var39).getZ());
               } else {
                  dis = 6.0;
                  double var49 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  double var57 = Math.toRadians((double)entity.getXRot());

                  for(int index0 = 0; index0 < 8; ++index0) {
                     var45 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
                     var55 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
                     var47 = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var45 = entityiterator.getX();
                           var55 = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                           var47 = entityiterator.getZ();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += 6.0;
                  }

                  entity.getPersistentData().putDouble("x_pos", var45);
                  entity.getPersistentData().putDouble("y_pos", var55);
                  entity.getPersistentData().putDouble("z_pos", var47);
               }

               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + 24.0);
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(var45, var55 - 8.0, var47), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:flash ~ ~ ~ " + var42 * 1.0 + " 4 " + var42 * 1.0 + " 0 " + Math.round(10.0 * var42) + " force");
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") <= 15.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                  } else {
                     _level.playLocalSound(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                  } else {
                     _level.playLocalSound(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                  }
               }

               entity.getPersistentData().putDouble("x_power", 0.0);
               entity.getPersistentData().putDouble("y_power", -1.0);
               entity.getPersistentData().putDouble("z_power", 0.0);
            }

            if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
               var45 = entity.getPersistentData().getDouble("x_pos");
               var55 = entity.getPersistentData().getDouble("y_pos");
               var47 = entity.getPersistentData().getDouble("z_pos");
               double var54 = entity.getPersistentData().getDouble("x_power");
               double var52 = entity.getPersistentData().getDouble("y_power");
               double var53 = entity.getPersistentData().getDouble("z_power");
               var42 = ReturnEntitySizeProcedure.execute(entity) * var51 * var51 * var51;

               for(int index1 = 0; index1 < (int)(var42 * 12.0); ++index1) {
                  ParticleGeneratorProcedure.execute(world, var42 * 1.0, 5.0, 1.0, Mth.nextDouble(RandomSource.create(), 0.0, 6.0), var45, var45 + var54, var55, var55 + var52, var47, var47 + var53, "end_rod");
               }

               var42 = ReturnEntitySizeProcedure.execute(entity) * 0.5;

               for(int index2 = 0; index2 < (int)Math.min(entity.getPersistentData().getDouble("cnt3") * 12.0, 48.0); ++index2) {
                  if (distance > 0.0) {
                     distance = 2.0 * var42 * -0.5;
                     entity.getPersistentData().putDouble("Damage", 15.0 * var51);
                     entity.getPersistentData().putDouble("Range", 4.0 * var42);
                     entity.getPersistentData().putDouble("knockback", 0.5);
                     RangeAttackProcedure.execute(world, var45, var55, var47, entity);
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           boolean var38 = true;
                           break;
                        }
                     }
                  }

                  if (InsideSolidCalculateProcedure.execute(world, var45, var55, var47, 10.0 * var42, 10.0 * var42)) {
                     if (!InsideSolidCalculateProcedure.execute(world, var45 - var54, var55 - var52, var47 - var53, 10.0 * var42, 10.0 * var42)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(var45, var55, var47), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_big_smoke ~ ~ ~ " + var42 * 0.25 + " " + var42 * 0.25 + " " + var42 * 0.25 + " 1 " + Math.round(4.0 * var42) + " force");
                        }

                        ParticleGeneratorCircleProcedure.execute(world, 4.0 * var42, 90.0, 0.0 * var42, 2.0 * var42, 2.0, var45, var45, var55, var55 + var42 * 0.5 * Math.random(), 0.0, var47, var47, "gaigegaigekaigecraft:particle_big_smoke");
                     }

                     if (dis > 0.0) {
                        dis = 2.0 * var42 * -0.5;
                        double var41 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                        entity.getPersistentData().putDouble("BlockDamage", 8.0 * var51);
                        entity.getPersistentData().putDouble("BlockRange", 4.0 * var42);
                        entity.getPersistentData().putBoolean("noParticle", true);
                        entity.getPersistentData().putBoolean("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, var45, var55, var47, entity);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(var45, var55, var47), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle flash ~ ~ ~ " + var42 * 0.25 + " " + var42 * 0.25 + " " + var42 * 0.25 + " 0 " + Math.round(4.0 * var42) + " force");
                  }

                  var45 += var54;
                  var55 += var52;
                  var47 += var53;
                  ++dis;
                  ++distance;
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
            entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
            if (entity.getPersistentData().getDouble("cnt5") > 2.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            } else {
               entity.getPersistentData().putDouble("cnt1", 9.0);
               entity.getPersistentData().putDouble("cnt3", 0.0);
            }
         }

      }
   }
}
