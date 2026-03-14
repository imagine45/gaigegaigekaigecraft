package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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

public class AIEnergyBallWhiteProcedure {
   public AIEnergyBallWhiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double speed2 = 0.0;
         double range_fix = 0.0;
         double range = 0.0;
         double d = 0.0;
         boolean logic_attack = false;
         boolean granite = false;
         boolean energy_wave = false;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean skull = false;
         boolean flame = false;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         energy_wave = entity.getPersistentData().m_128459_("skill") >= 700.0 && entity.getPersistentData().m_128459_("skill") < 800.0;
         granite = entity.getPersistentData().m_128459_("skill") >= 1200.0 && entity.getPersistentData().m_128459_("skill") < 1300.0;
         flame = entity.getPersistentData().m_128459_("skill") >= 400.0 && entity.getPersistentData().m_128459_("skill") < 500.0;
         entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            logic_attack = false;
            entity.getPersistentData().m_128379_("Stop", false);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && energy_wave && LogicOwnerExistProcedure.execute(world, entity)) {
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                  logic_attack = true;
                  entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), entity_a.getPersistentData().m_128459_("cnt6")));
                  entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  entity.m_146922_(entity_a.m_146908_());
                  entity.m_146926_(entity_a.m_146909_());
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }
               }

               if (entity_a.getPersistentData().m_128459_("skill") <= 0.0) {
                  logic_attack = false;
               }
            }

            if (!logic_attack || !entity.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt3") != 0.0) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.0);
            entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.0);
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            range_fix = 1.0;
            RotateEntityProcedure.execute(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 50.0, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.getPersistentData().m_128459_("y_power") * 50.0, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 50.0, entity);
            if (energy_wave) {
               ParticleGeneratorCircleProcedure.execute(world, 18.0 * range, (double)entity.m_146909_(), 0.0 * range, 1.0 * range, 4.0, entity.m_20185_(), entity.m_20185_() - entity.getPersistentData().m_128459_("x_power") * range, entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20186_() + (double)entity.m_20206_() * 0.5 - entity.getPersistentData().m_128459_("y_power") * range, (double)entity.m_146908_(), entity.m_20189_(), entity.m_20189_() - entity.getPersistentData().m_128459_("z_power") * range, "jujutsucraft:particle_thunder_blue");
            }

            if (entity.getPersistentData().m_128471_("Stop")) {
               entity.getPersistentData().m_128379_("Stop", false);
               speed = 0.0;
               speed2 = 0.0;
            } else {
               speed = energy_wave ? 3.0 : 1.25;
               speed2 = 0.25;
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (granite && entity_a instanceof LivingEntity) {
               entity.getPersistentData().m_128379_("free", true);
               GetPowerForwardProcedure.execute((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_(), entity);
               x_power = entity.m_20184_().m_7096_() + Math.min(speed2, Math.abs(entity.m_20184_().m_7096_() - entity.getPersistentData().m_128459_("x_power") * speed)) * (double)(entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * speed ? -1 : 1);
               y_power = entity.m_20184_().m_7098_() + Math.min(speed2, Math.abs(entity.m_20184_().m_7098_() - entity.getPersistentData().m_128459_("y_power") * speed)) * (double)(entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * speed ? -1 : 1);
               z_power = entity.m_20184_().m_7094_() + Math.min(speed2, Math.abs(entity.m_20184_().m_7094_() - entity.getPersistentData().m_128459_("z_power") * speed)) * (double)(entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * speed ? -1 : 1);
            } else {
               x_power = entity.getPersistentData().m_128459_("x_power") * speed;
               y_power = entity.getPersistentData().m_128459_("y_power") * speed;
               z_power = entity.getPersistentData().m_128459_("z_power") * speed;
            }

            entity.m_20256_(new Vec3(x_power, y_power, z_power));
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > 1.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            } else {
               dis = 1.0;
            }

            for(int index0 = 0; index0 < (int)dis; ++index0) {
               range = ReturnEntitySizeProcedure.execute(entity);
               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               z_pos = entity.m_20189_();
               if (granite) {
                  entity.getPersistentData().m_128347_("Damage", 20.0);
               } else if (energy_wave) {
                  entity.getPersistentData().m_128347_("Damage", 24.0);
               } else if (flame) {
                  entity.getPersistentData().m_128347_("Damage", 17.0);
                  entity.getPersistentData().m_128347_("effect", 10.0);
               } else {
                  entity.getPersistentData().m_128347_("Damage", 10.0);
               }

               if (entity.getPersistentData().m_128459_("cnt_life") > 0.0) {
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * Math.pow(0.99, Math.min(entity.getPersistentData().m_128459_("cnt_life"), 25.0)));
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * CNT6);
               entity.getPersistentData().m_128347_("Range", 3.0 * range_fix);
               entity.getPersistentData().m_128347_("knockback", 0.5);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_b = true;
                     break;
                  }
               }

               d = Math.sqrt(1.0 + entity.getPersistentData().m_128459_("Damage"));
               if (logic_b || entity.m_5830_() || !entity.m_6084_()) {
                  entity.getPersistentData().m_128379_("Stop", true);
                  range = d * 0.25 + 3.0 * range_fix;
                  entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                  entity.getPersistentData().m_128347_("Range", range * 2.0);
                  entity.getPersistentData().m_128347_("knockback", 1.0);
                  if (flame) {
                     entity.getPersistentData().m_128347_("effect", 10.0);
                  } else {
                     entity.getPersistentData().m_128347_("effect", 0.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().m_128347_("BlockDamage", d * 1.0);
                  entity.getPersistentData().m_128347_("BlockRange", range);
                  entity.getPersistentData().m_128379_("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F, false);
                     }
                  }

                  if (granite) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle cloud ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                     }
                  } else if (energy_wave) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_thunder_blue ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                     }
                  } else if (flame && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flame ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle explosion ~ ~ ~ " + range * 0.75 + " " + range * 0.75 + " " + range * 0.75 + " 1 " + Math.round(10.0 * range) + " force");
                  }

                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") - 1.0);
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  break;
               }

               entity.m_6021_(entity.m_20185_() + x_power * 1.0, entity.m_20186_() + y_power * 1.0, entity.m_20189_() + z_power * 1.0);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power * 1.0, entity.m_20186_() + y_power * 1.0, entity.m_20189_() + z_power * 1.0, entity.m_146908_(), entity.m_146909_());
               }
            }

            if ((entity.getPersistentData().m_128459_("cnt1") > (double)(granite ? 35 : 15) || entity.getPersistentData().m_128459_("cnt2") > 10.0 * CNT6) && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt_life") > 1.0) {
            x_pos = entity.getPersistentData().m_128459_("old_x");
            y_pos = entity.getPersistentData().m_128459_("old_y");
            z_pos = entity.getPersistentData().m_128459_("old_z");
            x_power = entity.m_20185_() - x_pos;
            y_power = entity.m_20186_() - y_pos;
            z_power = entity.m_20189_() - z_pos;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > 1.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            range = ReturnEntitySizeProcedure.execute(entity);

            for(int index1 = 0; index1 < (int)Math.max(dis * 4.0, 1.0); ++index1) {
               if (flame) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:flame ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:end_rod ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
                  }
               } else if (granite && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:cloud ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
               }

               if (energy_wave) {
                  ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 22.5, 4.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, z_pos, z_pos - z_power, "minecraft:cloud");
               }

               x_pos += x_power * 0.25;
               y_pos += y_power * 0.25;
               z_pos += z_power * 0.25;
            }
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_());
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_());
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_());
      }
   }
}
