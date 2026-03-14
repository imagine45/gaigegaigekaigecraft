package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label149;
               }
            }

            var10000 = 0;
         }

         double var40 = (double)Math.min(var10000, 50);
         double var42 = ReturnEntitySizeProcedure.execute(entity);
         double var51 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         double var45 = entity.getPersistentData().m_128459_("x_pos");
         double var55 = entity.getPersistentData().m_128459_("y_pos");
         double var47 = entity.getPersistentData().m_128459_("z_pos");
         if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 10.0) {
               LivingEntity var71;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var71 = _mobEnt.m_5448_();
               } else {
                  var71 = null;
               }

               Entity var39 = var71;
               if (var39 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("x_pos", ((Entity)var39).m_20185_());
                  entity.getPersistentData().m_128347_("y_pos", ((Entity)var39).m_20186_() + (double)((Entity)var39).m_20206_());
                  entity.getPersistentData().m_128347_("z_pos", ((Entity)var39).m_20189_());
               } else {
                  dis = 6.0;
                  double var49 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  double var57 = Math.toRadians((double)entity.m_146909_());

                  for(int index0 = 0; index0 < 8; ++index0) {
                     var45 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                     var55 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                     var47 = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var45 = entityiterator.m_20185_();
                           var55 = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                           var47 = entityiterator.m_20189_();
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += 6.0;
                  }

                  entity.getPersistentData().m_128347_("x_pos", var45);
                  entity.getPersistentData().m_128347_("y_pos", var55);
                  entity.getPersistentData().m_128347_("z_pos", var47);
               }

               entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + 24.0);
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55 - 8.0, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:flash ~ ~ ~ " + var42 * 1.0 + " 4 " + var42 * 1.0 + " 0 " + Math.round(10.0 * var42) + " force");
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt1") <= 15.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                  } else {
                     _level.m_7785_(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(var45, var55, var47), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                  } else {
                     _level.m_7785_(var45, var55, var47, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                  }
               }

               entity.getPersistentData().m_128347_("x_power", 0.0);
               entity.getPersistentData().m_128347_("y_power", -1.0);
               entity.getPersistentData().m_128347_("z_power", 0.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
               var45 = entity.getPersistentData().m_128459_("x_pos");
               var55 = entity.getPersistentData().m_128459_("y_pos");
               var47 = entity.getPersistentData().m_128459_("z_pos");
               double var54 = entity.getPersistentData().m_128459_("x_power");
               double var52 = entity.getPersistentData().m_128459_("y_power");
               double var53 = entity.getPersistentData().m_128459_("z_power");
               var42 = ReturnEntitySizeProcedure.execute(entity) * var51 * var51 * var51;

               for(int index1 = 0; index1 < (int)(var42 * 12.0); ++index1) {
                  ParticleGeneratorProcedure.execute(world, var42 * 1.0, 5.0, 1.0, Mth.m_216263_(RandomSource.m_216327_(), 0.0, 6.0), var45, var45 + var54, var55, var55 + var52, var47, var47 + var53, "end_rod");
               }

               var42 = ReturnEntitySizeProcedure.execute(entity) * 0.5;

               for(int index2 = 0; index2 < (int)Math.min(entity.getPersistentData().m_128459_("cnt3") * 12.0, 48.0); ++index2) {
                  if (distance > 0.0) {
                     distance = 2.0 * var42 * -0.5;
                     entity.getPersistentData().m_128347_("Damage", 15.0 * var51);
                     entity.getPersistentData().m_128347_("Range", 4.0 * var42);
                     entity.getPersistentData().m_128347_("knockback", 0.5);
                     RangeAttackProcedure.execute(world, var45, var55, var47, entity);
                     Vec3 _center = new Vec3(var45, var55, var47);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           boolean var38 = true;
                           break;
                        }
                     }
                  }

                  if (InsideSolidCalculateProcedure.execute(world, var45, var55, var47, 10.0 * var42, 10.0 * var42)) {
                     if (!InsideSolidCalculateProcedure.execute(world, var45 - var54, var55 - var52, var47 - var53, 10.0 * var42, 10.0 * var42)) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_big_smoke ~ ~ ~ " + var42 * 0.25 + " " + var42 * 0.25 + " " + var42 * 0.25 + " 1 " + Math.round(4.0 * var42) + " force");
                        }

                        ParticleGeneratorCircleProcedure.execute(world, 4.0 * var42, 90.0, 0.0 * var42, 2.0 * var42, 2.0, var45, var45, var55, var55 + var42 * 0.5 * Math.random(), 0.0, var47, var47, "jujutsucraft:particle_big_smoke");
                     }

                     if (dis > 0.0) {
                        dis = 2.0 * var42 * -0.5;
                        double var41 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                        entity.getPersistentData().m_128347_("BlockDamage", 8.0 * var51);
                        entity.getPersistentData().m_128347_("BlockRange", 4.0 * var42);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        entity.getPersistentData().m_128379_("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, var45, var55, var47, entity);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(var45, var55, var47), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flash ~ ~ ~ " + var42 * 0.25 + " " + var42 * 0.25 + " " + var42 * 0.25 + " 0 " + Math.round(4.0 * var42) + " force");
                  }

                  var45 += var54;
                  var55 += var52;
                  var47 += var53;
                  ++dis;
                  ++distance;
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt5") > 2.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            } else {
               entity.getPersistentData().m_128347_("cnt1", 9.0);
               entity.getPersistentData().m_128347_("cnt3", 0.0);
            }
         }

      }
   }
}
