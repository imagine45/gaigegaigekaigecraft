package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraftforge.registries.ForgeRegistries;

public class AIRyuProcedure {
   public AIRyuProcedure() {
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
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt_life") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21011_(InteractionHand.MAIN_HAND, true);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 25, 0.25, 0.25, 0.25, 0.5);
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
         z_pos = entity.m_20189_();
         if (!entity.getPersistentData().m_128471_("Stop")) {
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

                     Level var93 = ((Entity)var10000).m_9236_();
                     ClipContext var10001 = new ClipContext;
                     LivingEntity var10003;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10003 = _mobEnt.m_5448_();
                     } else {
                        var10003 = null;
                     }

                     Vec3 var100 = ((Entity)var10003).m_20299_(1.0F);
                     LivingEntity var10004;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10004 = _mobEnt.m_5448_();
                     } else {
                        var10004 = null;
                     }

                     Vec3 var105 = ((Entity)var10004).m_20299_(1.0F);
                     LivingEntity var10005;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10005 = _mobEnt.m_5448_();
                     } else {
                        var10005 = null;
                     }

                     var105 = var105.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var113 = Block.OUTLINE;
                     ClipContext.Fluid var10006 = Fluid.NONE;
                     LivingEntity var10007;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.m_5448_();
                     } else {
                        var10007 = null;
                     }

                     var10001.<init>(var100, var105, var113, var10006, var10007);
                     x_pos = (double)var93.m_45547_(var10001).m_82425_().m_123341_();
                     LivingEntity var94;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var94 = _mobEnt.m_5448_();
                     } else {
                        var94 = null;
                     }

                     Level var95 = ((Entity)var94).m_9236_();
                     var10001 = new ClipContext;
                     LivingEntity var101;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var101 = _mobEnt.m_5448_();
                     } else {
                        var101 = null;
                     }

                     Vec3 var102 = ((Entity)var101).m_20299_(1.0F);
                     LivingEntity var107;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var107 = _mobEnt.m_5448_();
                     } else {
                        var107 = null;
                     }

                     Vec3 var108 = ((Entity)var107).m_20299_(1.0F);
                     LivingEntity var114;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var114 = _mobEnt.m_5448_();
                     } else {
                        var114 = null;
                     }

                     var108 = var108.m_82549_(((Entity)var114).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var115 = Block.OUTLINE;
                     var10006 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.m_5448_();
                     } else {
                        var10007 = null;
                     }

                     var10001.<init>(var102, var108, var115, var10006, var10007);
                     y_pos = (double)var95.m_45547_(var10001).m_82425_().m_123342_();
                     LivingEntity var96;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var96 = _mobEnt.m_5448_();
                     } else {
                        var96 = null;
                     }

                     Level var97 = ((Entity)var96).m_9236_();
                     var10001 = new ClipContext;
                     LivingEntity var103;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var103 = _mobEnt.m_5448_();
                     } else {
                        var103 = null;
                     }

                     Vec3 var104 = ((Entity)var103).m_20299_(1.0F);
                     LivingEntity var110;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var110 = _mobEnt.m_5448_();
                     } else {
                        var110 = null;
                     }

                     Vec3 var111 = ((Entity)var110).m_20299_(1.0F);
                     LivingEntity var116;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var116 = _mobEnt.m_5448_();
                     } else {
                        var116 = null;
                     }

                     var111 = var111.m_82549_(((Entity)var116).m_20252_(1.0F).m_82490_(0.0));
                     ClipContext.Block var117 = Block.OUTLINE;
                     var10006 = Fluid.NONE;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10007 = _mobEnt.m_5448_();
                     } else {
                        var10007 = null;
                     }

                     var10001.<init>(var104, var111, var117, var10006, var10007);
                     z_pos = (double)var97.m_45547_(var10001).m_82425_().m_123343_();
                  } else {
                     dis = 8.0;
                     logic_a = false;

                     for(int index0 = 0; index0 < 8; ++index0) {
                        x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                        y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                        z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(12.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
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
            yaw = (double)(entity.m_146908_() % 360.0F);
            pitch = (double)entity.m_146909_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (dis < 0.0 || dis > 14.0) {
               entity.m_146922_(entity.m_146908_() % 360.0F);
               entity.m_146926_(entity.m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               yaw_cal = (double)entity.m_146908_() - yaw;
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 6 : -6);
               pitch = (double)entity.m_146909_();
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_life") == 1.0) {
               speed = 3.0;
            } else {
               speed = Math.min(3.0, Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0)) + 0.33);
            }

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
            entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_());
            entity.getPersistentData().m_128347_("y_knockback", 0.5);
            entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_());
            speed = Math.min(Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7098_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0)), 3.0);

            for(int index1 = 0; index1 < (int)Math.round(dis); ++index1) {
               entity.getPersistentData().m_128347_("Damage", 15.0 + speed * 3.0);
               entity.getPersistentData().m_128347_("Range", 3.0 * size);
               entity.getPersistentData().m_128347_("knockback", 0.5);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               x_pos -= x_power;
               y_pos -= y_power;
               z_pos -= z_power;
            }

            entity.getPersistentData().m_128347_("x_knockback", 0.0);
            entity.getPersistentData().m_128347_("y_knockback", 0.0);
            entity.getPersistentData().m_128347_("z_knockback", 0.0);
            BulletDomainHit2Procedure.execute(world, entity);
         } else {
            entity.getPersistentData().m_128379_("Stop", true);
         }

         if (entity.getPersistentData().m_128459_("cnt1") > 120.0 && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
