package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.KaichiEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AIKaichiProcedure {
   public AIKaichiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean skull = false;
         boolean logic_a = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double size = 0.0;
         double pitch = 0.0;
         double pitch_cal = 0.0;
         double yaw = 0.0;
         double yaw_cal = 0.0;
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt_life") > 10.0) {
            if (entity instanceof KaichiEntity) {
               ((KaichiEntity)entity).setAnimation("spin");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F, false);
               }
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            logic_attack = false;
            entity.getPersistentData().m_128379_("Stop", false);
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
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > 0.0) {
                  logic_attack = true;
                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
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

                  entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                  entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                  entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }

                  if (!entity.m_6084_()) {
                     entity_a.getPersistentData().m_128347_("skill", 0.0);
                  }
               }
            }

            if (!logic_attack || !entity.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 10, 0.25, 0.25, 0.25, 0.5);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_life") > 10.0) {
               entity.getPersistentData().m_128347_("Damage", 6.0);
               entity.getPersistentData().m_128347_("Range", 2.0 * size);
               entity.getPersistentData().m_128347_("knockback", 0.25);
               entity.getPersistentData().m_128347_("effect", 1.0);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128471_("Stop")) {
               entity.getPersistentData().m_128379_("Stop", true);
            } else {
               x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
               y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
               z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
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

                        Level var100 = ((Entity)var10000).m_9236_();
                        ClipContext var10001 = new ClipContext;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var107 = ((Entity)var10003).m_20299_(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.m_5448_();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var112 = ((Entity)var10004).m_20299_(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.m_5448_();
                        } else {
                           var10005 = null;
                        }

                        var112 = var112.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var120 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var107, var112, var120, var10006, var10007);
                        x_pos = (double)var100.m_45547_(var10001).m_82425_().m_123341_();
                        LivingEntity var101;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var101 = _mobEnt.m_5448_();
                        } else {
                           var101 = null;
                        }

                        Level var102 = ((Entity)var101).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var108;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var108 = _mobEnt.m_5448_();
                        } else {
                           var108 = null;
                        }

                        Vec3 var109 = ((Entity)var108).m_20299_(1.0F);
                        LivingEntity var114;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var114 = _mobEnt.m_5448_();
                        } else {
                           var114 = null;
                        }

                        Vec3 var115 = ((Entity)var114).m_20299_(1.0F);
                        LivingEntity var121;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var121 = _mobEnt.m_5448_();
                        } else {
                           var121 = null;
                        }

                        var115 = var115.m_82549_(((Entity)var121).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var122 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var109, var115, var122, var10006, var10007);
                        y_pos = (double)var102.m_45547_(var10001).m_82425_().m_123342_();
                        LivingEntity var103;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var103 = _mobEnt.m_5448_();
                        } else {
                           var103 = null;
                        }

                        Level var104 = ((Entity)var103).m_9236_();
                        var10001 = new ClipContext;
                        LivingEntity var110;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var110 = _mobEnt.m_5448_();
                        } else {
                           var110 = null;
                        }

                        Vec3 var111 = ((Entity)var110).m_20299_(1.0F);
                        LivingEntity var117;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var117 = _mobEnt.m_5448_();
                        } else {
                           var117 = null;
                        }

                        Vec3 var118 = ((Entity)var117).m_20299_(1.0F);
                        LivingEntity var123;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var123 = _mobEnt.m_5448_();
                        } else {
                           var123 = null;
                        }

                        var118 = var118.m_82549_(((Entity)var123).m_20252_(1.0F).m_82490_(0.0));
                        ClipContext.Block var124 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.m_5448_();
                        } else {
                           var10007 = null;
                        }

                        var10001.<init>(var111, var118, var124, var10006, var10007);
                        z_pos = (double)var104.m_45547_(var10001).m_82425_().m_123343_();
                     } else {
                        dis = 8.0;
                        logic_a = false;

                        for(int index0 = 0; index0 < 8; ++index0) {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 logic_a = true;
                                 x_pos = entityiterator.m_20185_();
                                 y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                                 z_pos = entityiterator.m_20189_();
                                 break;
                              }
                           }

                           dis += 8.0;
                           if (logic_a) {
                              break;
                           }
                        }
                     }
                  }
               }

               dis = Math.sqrt(Math.pow(entity.m_20185_() - x_pos, 2.0) + Math.pow(entity.m_20186_() - y_pos, 2.0) + Math.pow(entity.m_20189_() - z_pos, 2.0));
               if (dis > 10.0 && (entity.getPersistentData().m_128459_("cnt1") % 4.0 == 1.0 || dis > 32.0)) {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)(entity.m_146908_() % 360.0F);
                  pitch = (double)entity.m_146909_();
                  if (entity.getPersistentData().m_128459_("cnt1") % 12.0 != 1.0 && dis <= 32.0) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.m_146922_((float)((yaw + (Math.random() - 0.5) * 90.0) % 360.0));
                        entity.m_146926_((float)(pitch + (Math.random() - 0.5) * 45.0));
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                           break;
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 4, 0.25, 0.25, 0.25, 0.2);
                  }
               }

               speed = 3.0;
               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * speed);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * speed);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * speed);
               x_power = entity.getPersistentData().m_128459_("x_power");
               y_power = entity.getPersistentData().m_128459_("y_power");
               z_power = entity.getPersistentData().m_128459_("z_power");
               entity.m_20256_(new Vec3(x_power, y_power, z_power));
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 1.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               } else {
                  dis = 1.0;
               }

               x_pos = entity.m_20185_();
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
               z_pos = entity.m_20189_();

               for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                  entity.getPersistentData().m_128347_("Damage", 15.0);
                  entity.getPersistentData().m_128347_("Range", 3.0 * size);
                  entity.getPersistentData().m_128347_("knockback", 0.5);
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  entity.getPersistentData().m_128379_("attack", true);
                  RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                  entity.m_6021_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() - x_power, entity.m_20186_(), entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() - y_power, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
                     }
                  }

                  entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() + z_power, entity.m_146908_(), entity.m_146909_());
                  }

                  if (entity.m_5830_()) {
                     entity.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_() - z_power, entity.m_146908_(), entity.m_146909_());
                     }
                  }
               }

               entity.getPersistentData().m_128347_("BlockRange", 1.0 * size);
               entity.getPersistentData().m_128347_("BlockDamage", 4.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.15));
               entity.getPersistentData().m_128379_("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 50.0 && !entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
