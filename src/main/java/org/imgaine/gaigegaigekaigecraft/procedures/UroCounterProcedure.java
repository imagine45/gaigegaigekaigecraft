package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class UroCounterProcedure {
   public UroCounterProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double num1 = 0.0;
         double num2 = 0.0;
         double speed = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num3 = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
               return;
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            Level var85 = ((Entity)var10000).m_9236_();
            ClipContext var10001 = new ClipContext;
            LivingEntity var10003;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10003 = _mobEnt.m_5448_();
            } else {
               var10003 = null;
            }

            Vec3 var96 = ((Entity)var10003).m_20299_(1.0F);
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            Vec3 var98 = ((Entity)var10004).m_20299_(1.0F);
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.m_5448_();
            } else {
               var10005 = null;
            }

            var98 = var98.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
            ClipContext.Block var102 = Block.OUTLINE;
            ClipContext.Fluid var10006 = Fluid.NONE;
            LivingEntity var10007;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10007 = _mobEnt.m_5448_();
            } else {
               var10007 = null;
            }

            var10001.<init>(var96, var98, var102, var10006, var10007);
            double var86 = (double)var85.m_45547_(var10001).m_82425_().m_123341_();
            LivingEntity var90;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var90 = _mobEnt.m_5448_();
            } else {
               var90 = null;
            }

            Level var91 = ((Entity)var90).m_9236_();
            ClipContext var10002 = new ClipContext;
            LivingEntity var100;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var100 = _mobEnt.m_5448_();
            } else {
               var100 = null;
            }

            Vec3 var101 = ((Entity)var100).m_20299_(1.0F);
            LivingEntity var103;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var103 = _mobEnt.m_5448_();
            } else {
               var103 = null;
            }

            Vec3 var104 = ((Entity)var103).m_20299_(1.0F);
            LivingEntity var108;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var108 = _mobEnt.m_5448_();
            } else {
               var108 = null;
            }

            var104 = var104.m_82549_(((Entity)var108).m_20252_(1.0F).m_82490_(0.0));
            ClipContext.Block var109 = Block.OUTLINE;
            ClipContext.Fluid var113 = Fluid.NONE;
            LivingEntity var10008;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10008 = _mobEnt.m_5448_();
            } else {
               var10008 = null;
            }

            var10002.<init>(var101, var104, var109, var113, var10008);
            double var92 = (double)var91.m_45547_(var10002).m_82425_().m_123342_();
            LivingEntity var94;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var94 = _mobEnt.m_5448_();
            } else {
               var94 = null;
            }

            Level var95 = ((Entity)var94).m_9236_();
            ClipContext var97 = new ClipContext;
            LivingEntity var106;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var106 = _mobEnt.m_5448_();
            } else {
               var106 = null;
            }

            Vec3 var107 = ((Entity)var106).m_20299_(1.0F);
            LivingEntity var110;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var110 = _mobEnt.m_5448_();
            } else {
               var110 = null;
            }

            Vec3 var111 = ((Entity)var110).m_20299_(1.0F);
            LivingEntity var114;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var114 = _mobEnt.m_5448_();
            } else {
               var114 = null;
            }

            var111 = var111.m_82549_(((Entity)var114).m_20252_(1.0F).m_82490_(0.0));
            ClipContext.Block var115 = Block.OUTLINE;
            ClipContext.Fluid var116 = Fluid.NONE;
            LivingEntity var10009;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10009 = _mobEnt.m_5448_();
            } else {
               var10009 = null;
            }

            var97.<init>(var107, var111, var115, var116, var10009);
            RotateEntityProcedure.execute(var86, var92, (double)var95.m_45547_(var97).m_82425_().m_123343_(), entity);
         }

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
         dis = 6.0;

         for(int index0 = 0; index0 < 8; ++index0) {
            x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
            y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
            z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                  SUCCESS = true;
                  x_pos = entityiterator.m_20185_();
                  y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                  z_pos = entityiterator.m_20189_();
                  break;
               }
            }

            if (SUCCESS) {
               break;
            }

            dis += 6.0;
         }

         logic_a = false;
         Vec3 _center = new Vec3(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_((double)(entity.m_20205_() + 10.0F) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (!entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo_no_move")))) {
               double var87;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var87 = _projEnt.m_20184_().m_82553_();
               } else {
                  var87 = 0.0;
               }

               if (var87 == 0.0) {
                  continue;
               }
            }

            if (entityiterator.m_20205_() + entityiterator.m_20206_() <= (entity.m_20205_() + entity.m_20206_()) * 4.0F) {
               logic_a = true;
               entityiterator.getPersistentData().m_128379_("betrayal", true);
               double var88;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var88 = _projEnt.m_20184_().m_82553_();
               } else {
                  var88 = 0.0;
               }

               if (var88 != 0.0 && entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  if (entity instanceof LivingEntity) {
                     _projEnt.m_5602_((LivingEntity)entity);
                  }
               }

               if (entity instanceof Player) {
                  logic_b = entity.m_6144_();
               } else {
                  label251: {
                     logic_b = entity.getPersistentData().m_128459_("cnt_uro") < 15.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var89 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19557_();
                           break label251;
                        }
                     }

                     var89 = 0;
                  }

                  int var93;
                  label246: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                           var93 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.GUARD.get()).m_19557_();
                           break label246;
                        }
                     }

                     var93 = 0;
                  }

                  if (var89 < (var93 > 10 ? 18 : 8)) {
                     logic_b = false;
                  }
               }

               speed = 3.0;
               num1 = (double)(entity.m_146908_() % 360.0F);
               num2 = (double)(entityiterator.m_146908_() % 360.0F);
               num3 = Math.abs(num1 - num2);
               entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
               if (logic_b || num3 > 135.0 && num3 < 315.0) {
                  RotateEntityProcedure.execute(entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.9, entity.m_20189_(), entityiterator);
                  entityiterator.m_146922_(entityiterator.m_146908_() + (float)(GetDistanceIteratorProcedure.execute(entity, entityiterator) > 3.0 ? 45 : 90));
                  entityiterator.m_146926_(entityiterator.m_146909_());
                  entityiterator.m_5618_(entityiterator.m_146908_());
                  entityiterator.m_5616_(entityiterator.m_146908_());
                  entityiterator.f_19859_ = entityiterator.m_146908_();
                  entityiterator.f_19860_ = entityiterator.m_146909_();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 20, 0, false, false));
                     }
                  }
               } else {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entityiterator);
               }

               x_power = entityiterator.m_20154_().f_82479_ * speed;
               y_power = entityiterator.m_20154_().f_82480_ * speed;
               z_power = entityiterator.m_20154_().f_82481_ * speed;
               entityiterator.m_20256_(new Vec3(x_power, y_power, z_power));
               entityiterator.getPersistentData().m_128347_("x_power", x_power);
               entityiterator.getPersistentData().m_128347_("y_power", y_power);
               entityiterator.getPersistentData().m_128347_("z_power", z_power);
            }
         }

         if (entity instanceof Player) {
            entity.getPersistentData().m_128347_("cnt_uro", entity.getPersistentData().m_128459_("cnt_uro") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_uro") > 0.0) {
               entity.getPersistentData().m_128347_("cnt_uro", -5.0);
            } else {
               logic_a = false;
            }
         } else {
            if (logic_a) {
               entity.getPersistentData().m_128347_("cnt_uro", Math.max(entity.getPersistentData().m_128459_("cnt_uro"), 1.0));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 5, 9));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get());
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_uro") > 0.0) {
               entity.getPersistentData().m_128347_("cnt_uro", entity.getPersistentData().m_128459_("cnt_uro") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_uro") > 100.0) {
                  entity.getPersistentData().m_128347_("cnt_uro", 0.0);
               }
            }
         }

         if (logic_a) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 10, 9));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity77 = (LivingEntity)entity;
               if (_livingEntity77.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity77.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-8.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity78 = (LivingEntity)entity;
               if (_livingEntity78.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity78.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(1.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

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
   }
}
