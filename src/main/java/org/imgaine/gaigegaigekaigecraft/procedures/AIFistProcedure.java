package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFistProcedure {
   public AIFistProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double move = 0.0;
         double amount = 0.0;
         double CNT6 = 0.0;
         double entity_size = 0.0;
         double speed = 0.0;
         double distance = 0.0;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            move = entity.getPersistentData().m_128459_("move");
            entity_size = ReturnEntitySizeProcedure.execute(entity) * 1.2;
            CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
            if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  entity.getPersistentData().m_128347_("cnt1", 10.0);
               }

               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
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
                  if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged")) {
                     LivingEntity var10000;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     if (var10000 instanceof LivingEntity) {
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        Level var71 = ((Entity)var10000).m_9236_();
                        ClipContext var10001 = new ClipContext;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var78 = ((Entity)var10003).m_20299_(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var83 = ((Entity)var10004).m_20299_(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        var83 = var83.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var91 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var78, var83, var91, var10006, var10007);
                        x_pos = (double)var71.m_45547_(var10001).m_82425_().m_123341_();
                        LivingEntity var72;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var72 = _mobEnt.m_5448_();
                        } else {
                           var72 = null;
                        }

                        Level var73 = ((Entity)var72).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var79;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var79 = _mobEnt.m_5448_();
                        } else {
                           var79 = null;
                        }

                        Vec3 var80 = ((Entity)var79).m_20299_(1.0F);
                        LivingEntity var85;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var85 = _mobEnt.m_5448_();
                        } else {
                           var85 = null;
                        }

                        Vec3 var86 = ((Entity)var85).m_20299_(1.0F);
                        LivingEntity var92;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var92 = _mobEnt.m_5448_();
                        } else {
                           var92 = null;
                        }

                        var86 = var86.m_82549_(((Entity)var92).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var93 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var80, var86, var93, var10006, var10007);
                        y_pos = (double)var73.m_45547_(var10001).m_82425_().m_123342_();
                        LivingEntity var74;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var74 = _mobEnt.m_5448_();
                        } else {
                           var74 = null;
                        }

                        Level var75 = ((Entity)var74).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var81;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var81 = _mobEnt.m_5448_();
                        } else {
                           var81 = null;
                        }

                        Vec3 var82 = ((Entity)var81).m_20299_(1.0F);
                        LivingEntity var88;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var88 = _mobEnt.m_5448_();
                        } else {
                           var88 = null;
                        }

                        Vec3 var89 = ((Entity)var88).m_20299_(1.0F);
                        LivingEntity var94;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var94 = _mobEnt.m_5448_();
                        } else {
                           var94 = null;
                        }

                        var89 = var89.m_82549_(((Entity)var94).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var95 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var82, var89, var95, var10006, var10007);
                        z_pos = (double)var75.m_45547_(var10001).m_82425_().m_123343_();
                     } else {
                        x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                        y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                        z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                     }

                     x_pos += entity.getPersistentData().m_128459_("x_pos");
                     y_pos += entity.getPersistentData().m_128459_("y_pos");
                     z_pos += entity.getPersistentData().m_128459_("z_pos");
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 10.0) {
               x_pos = entity.m_20185_() + distance * entity.getPersistentData().m_128459_("x_power") * -0.33;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + distance * entity.getPersistentData().m_128459_("y_power") * -0.33;
               z_pos = entity.m_20189_() + distance * entity.getPersistentData().m_128459_("z_power") * -0.33;
               if (entity.getPersistentData().m_128459_("cnt1") == 10.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(0.5 * Math.pow(CNT6, 2.0)), 0.75F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(0.5 * Math.pow(CNT6, 2.0)), 0.75F, false);
                  }
               }

               amount = move == 2.0 ? 1.0 : 5.0;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)amount, 0.25, 0.25, 0.25, 0.1);
               }

               distance = (double)entity.m_20205_() * 0.5;
               x_pos = entity.m_20185_() + distance * entity.getPersistentData().m_128459_("x_power") * 0.33;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + distance * entity.getPersistentData().m_128459_("y_power") * 0.33;
               z_pos = entity.m_20189_() + distance * entity.getPersistentData().m_128459_("z_power") * 0.33;
               if (!entity.getPersistentData().m_128471_("Stop")) {
                  if (!entity.m_5830_()) {
                     speed = 0.7 + entity.getPersistentData().m_128459_("speed");
                  } else {
                     speed = (entity.getPersistentData().m_128459_("cnt6") >= 5.0 ? 0.7 + entity.getPersistentData().m_128459_("speed") : 0.0) * 0.25;
                  }

                  logic_a = true;
                  if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.33, entity.m_20186_(), entity.m_20189_(), (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     entity.m_6021_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * speed, entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * speed, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.33, entity.m_20189_(), (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * speed, entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * speed, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.33, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     logic_a = false;
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * speed);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * speed, entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * (0.7 + entity.getPersistentData().m_128459_("speed")), entity.getPersistentData().m_128459_("y_power") * (0.7 + entity.getPersistentData().m_128459_("speed")), entity.getPersistentData().m_128459_("z_power") * (0.7 + entity.getPersistentData().m_128459_("speed"))));
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (entity.m_5830_() || logic_a || InsideSolidCalculateProcedure.execute(world, entity.m_20185_() + entity.getPersistentData().m_128459_("x_power") * 0.33, entity.m_20186_() + entity.getPersistentData().m_128459_("y_power") * 0.33, entity.m_20189_() + entity.getPersistentData().m_128459_("z_power") * 0.33, (double)entity.m_20206_(), (double)entity.m_20205_())) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(4.0 * CNT6 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.25 * CNT6);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)(2.0 * CNT6 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.5 * CNT6);
                     }

                     entity.getPersistentData().m_128347_("BlockRange", 2.0 * entity_size);
                     entity.getPersistentData().m_128347_("BlockDamage", 4.0 * CNT6);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     entity.getPersistentData().m_128379_("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (entity.getPersistentData().m_128459_("cnt6") > 5.0 && entity.m_5830_() && entity.getPersistentData().m_128459_("cnt3") == 0.0) {
                        entity.getPersistentData().m_128347_("cnt3", 1.0);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BIG_SMOKE.get(), x_pos, y_pos, z_pos, (int)(25.0 * CNT6 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 1.0 * CNT6);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F);
                           } else {
                              _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:flame_explode")), SoundSource.NEUTRAL, (float)CNT6, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                        entity.getPersistentData().m_128347_("knockback", 1.0 * CNT6);
                        entity.getPersistentData().m_128347_("Range", 4.5 * entity_size);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
                  }
               } else {
                  entity.getPersistentData().m_128379_("Stop", false);
               }

               entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.25);
               entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.25);
               entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.25);
               if (move == 0.0) {
                  entity.getPersistentData().m_128347_("Damage", 18.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", 0.5 * CNT6);
                  if (entity.getPersistentData().m_128459_("cnt_life") > 0.0) {
                     for(int index0 = 0; index0 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index0) {
                        entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                        if (entity.getPersistentData().m_128459_("Damage") < 14.0) {
                           entity.getPersistentData().m_128347_("Damage", 14.0);
                           break;
                        }
                     }
                  }
               } else if (move == 1.0) {
                  entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", 1.0 * CNT6);
                  if (entity.getPersistentData().m_128459_("cnt_life") > 0.0) {
                     for(int index1 = 0; index1 < (int)Math.round(entity.getPersistentData().m_128459_("cnt_life")); ++index1) {
                        entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
                        if (entity.getPersistentData().m_128459_("Damage") < 11.0) {
                           entity.getPersistentData().m_128347_("Damage", 11.0);
                           break;
                        }
                     }
                  }
               } else if (move == 2.0) {
                  entity.getPersistentData().m_128347_("Damage", 10.0 * CNT6);
                  entity.getPersistentData().m_128347_("knockback", 0.25 * CNT6);
               }

               entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
               entity.getPersistentData().m_128347_("Range", 3.0 * entity_size);
               entity.getPersistentData().m_128379_("attack", false);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (move == 1.0) {
                  entity.getPersistentData().m_128347_("knockback", 1.0);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_knockback", 0.0);
               entity.getPersistentData().m_128347_("y_knockback", 0.0);
               entity.getPersistentData().m_128347_("z_knockback", 0.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 40.0 * CNT6 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
