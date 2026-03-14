package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIMeteorProcedure {
   public AIMeteorProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double rad = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         Entity entity_a = null;
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
         if (entity.getPersistentData().m_128459_("cnt4") <= 80.0) {
            entity.f_19789_ = 0.0F;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && entity_a instanceof LivingEntity && entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
               entity_a.f_19789_ = 0.0F;
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= 200.0) {
               y_pos = y - 1.0;
               dis = (double)entity.m_20205_() * 0.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x, y_pos, z, 30, dis, dis, dis, 0.1);
               }

               logic_a = false;

               for(int index0 = 0; index0 < 128; ++index0) {
                  dis = (Math.random() - 0.5) * (double)entity.m_20205_() * 2.0;
                  rad = Math.toRadians(Math.random() * 360.0);
                  x_pos = x + Math.sin(rad) * dis;
                  z_pos = z + Math.cos(rad) * dis;
                  if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                     logic_a = true;
                     entity.getPersistentData().m_128347_("BlockRange", 8.0);
                     entity.getPersistentData().m_128347_("BlockDamage", 32.0);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("BlockRange", 24.0);
                     entity.getPersistentData().m_128347_("BlockDamage", 32.0);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y + 4.0, z, entity);
                     if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos, z_pos))) {
                        logic_a = false;
                     }
                     break;
                  }
               }

               if ((logic_a || entity.m_20184_().m_7098_() > -0.5 || entity.m_20096_()) && entity.getPersistentData().m_128459_("cnt1") > 40.0 && !entity.getPersistentData().m_128471_("Stop")) {
                  entity.m_20256_(new Vec3(0.0, -0.5, 0.0));
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 50.0);
               } else {
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.1, -0.5, entity.getPersistentData().m_128459_("z_power") * 0.1));
               }

               entity.getPersistentData().m_128379_("Stop", false);
            } else {
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
               entity.m_20256_(new Vec3(0.0, -0.5, 0.0));
               if (!entity.m_6084_() || entity.getPersistentData().m_128459_("cnt4") <= 30.0) {
                  if (entity.getPersistentData().m_128459_("cnt4") <= 15.0) {
                     pitch = 0.5 + entity.getPersistentData().m_128459_("cnt4") * 0.1;

                     for(int index1 = 0; index1 < 2; ++index1) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, (float)pitch);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, 5.0F, (float)pitch, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, (float)pitch);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 5.0F, (float)pitch, false);
                           }
                        }

                        if (entity.getPersistentData().m_128459_("cnt4") <= 14.0) {
                           break;
                        }
                     }

                     entity.getPersistentData().m_128347_("Damage", 70.0);
                     entity.getPersistentData().m_128347_("Range", 60.0);
                     entity.getPersistentData().m_128347_("knockback", 2.0);
                     entity.getPersistentData().m_128347_("effect", 3.0);
                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     entity.getPersistentData().m_128347_("Damage", 50.0);
                     entity.getPersistentData().m_128347_("Range", 85.0);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("effect", 3.0);
                     RangeAttackProcedure.execute(world, x, y, z, entity);
                     if (entity.getPersistentData().m_128459_("cnt4") == 1.0 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flash ~ ~ ~ 8 4 8 4.00 50 force");
                     }

                     if (entity.getPersistentData().m_128459_("cnt4") <= 5.0 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle explosion_emitter ~ ~ ~ 7 4 7 4.00 25 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x, y, z), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flame ~ ~ ~ 8 4 8 4.00 50 force");
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt4") == 1.0 || entity.getPersistentData().m_128459_("cnt4") == 15.0) {
                     entity.getPersistentData().m_128347_("BlockRange", 40.0);
                     entity.getPersistentData().m_128347_("BlockDamage", 0.33);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") < 20.0) {
                  num1 = Math.toRadians(Math.random() * 360.0);
                  num2 = entity.getPersistentData().m_128459_("cnt4") * 2.0;
                  y_pos = y;

                  for(int index2 = 0; index2 < 72; ++index2) {
                     x_pos = x + Math.sin(num1) * num2;
                     z_pos = z + Math.cos(num1) * num2;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flame ~ ~ ~ 2 2 2 0.5 5 force");
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle cloud ~ ~ ~ 2 2 2 0.5 5 force");
                     }

                     if (Math.random() < 0.25 && world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle jujutsucraft:particle_flame ~ ~ ~ 2 2 2 0.5 1 force");
                     }

                     num1 += Math.toRadians(Math.random() * 10.0);
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
            entity.m_20256_(new Vec3(0.0, -0.5, 0.0));

            for(Entity entityiterator : entity.m_146897_()) {
               entityiterator.m_8127_();
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
