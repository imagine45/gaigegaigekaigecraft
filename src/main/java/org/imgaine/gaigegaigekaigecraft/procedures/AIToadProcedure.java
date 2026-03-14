package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.Toad2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.ToadEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIToadProcedure {
   public AIToadProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean reChange = false;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double speed = 0.0;
         double NUM1 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            FollowEntityProcedure.execute(world, entity);
            if (entity instanceof ToadEntity) {
               if (entity.m_20096_()) {
                  speed = Math.sqrt(Math.pow(entity.m_20184_().m_7096_(), 2.0) + Math.pow(entity.m_20184_().m_7094_(), 2.0));
                  if (speed > 0.1) {
                     int var10000;
                     label201: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                              var10000 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                              break label201;
                           }
                        }

                        var10000 = 0;
                     }

                     if (var10000 < 9) {
                        entity.m_20256_(new Vec3(entity.m_20154_().f_82479_ * 1.0, Math.min(entity.m_20154_().f_82480_ + 0.6, 1.0), entity.m_20154_().f_82481_ * 1.0));
                        if (entity instanceof ToadEntity) {
                           ((ToadEntity)entity).setAnimation("empty");
                        }

                        if (entity instanceof ToadEntity) {
                           ((ToadEntity)entity).setAnimation("walk");
                        }
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                  }
               }
            }

            if (entity instanceof Toad2Entity) {
               entity.m_20256_(new Vec3(0.0, Math.min(entity.m_20184_().m_7098_(), -0.25), 0.0));
               if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entity.getPersistentData().m_128347_("friend_num", Math.random());
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(3.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  if (entity != entityiterator) {
                     if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        rnd = -200.0 - Math.random() * 50.0;
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Entity entityToSpawn = EntityType.f_20555_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), rnd, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                           }
                        }
                     }

                     reChange = false;
                     if (!world.m_6443_(Chicken.class, AABB.m_165882_(new Vec3(entity.m_20185_(), rnd, entity.m_20189_()), 1.0, 1.0, 1.0), (e) -> true).isEmpty()) {
                        if (!((Entity)world.m_6443_(Chicken.class, AABB.m_165882_(new Vec3(entity.m_20185_(), rnd, entity.m_20189_()), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                           Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                              return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                           }
                        })).compareDistOf(entity.m_20185_(), rnd, entity.m_20189_())).findFirst().orElse((Object)null)).m_9236_().m_5776_()) {
                           ((Entity)world.m_6443_(Chicken.class, AABB.m_165882_(new Vec3(entity.m_20185_(), rnd, entity.m_20189_()), 1.0, 1.0, 1.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                              }
                           })).compareDistOf(entity.m_20185_(), rnd, entity.m_20189_())).findFirst().orElse((Object)null)).m_146870_();
                        }

                        reChange = true;
                        break;
                     }

                     if (reChange) {
                        entityiterator.m_6021_(x, y, z);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.f_8906_.m_9774_(x, y, z, entityiterator.m_146908_(), entityiterator.m_146909_());
                        }

                        entityiterator.m_20256_(new Vec3(entity.m_20184_().m_7096_(), entity.m_20184_().m_7098_(), entity.m_20184_().m_7094_()));
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 20, false, false));
                           }
                        }
                        break;
                     }
                  }
               }
            }

            double var10001;
            label180: {
               NUM1 = (double)(2L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity37 = (LivingEntity)entity;
                  if (_livingEntity37.m_21204_().m_22171_(Attributes.f_22281_)) {
                     var10001 = _livingEntity37.getAttribute_(Attributes.f_22281_).m_22115_();
                     break label180;
                  }
               }

               var10001 = 0.0;
            }

            label175: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt38 = (LivingEntity)entity;
                  if (_livEnt38.m_21023_(MobEffects.f_19600_)) {
                     break label175;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var58;
            label170: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                     var58 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                     break label170;
                  }
               }

               var58 = 0;
            }

            if ((double)var58 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
               }
            }

            label164: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt42 = (LivingEntity)entity;
                  if (_livEnt42.m_21023_(MobEffects.f_19603_)) {
                     break label164;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 2147483647, 4, false, false));
                  }
               }
            }

            if (entity.m_20160_()) {
               for(Entity entityiterator : new ArrayList(entity.m_20197_())) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 2, 4, false, false));
                     }
                  }
               }
            }

            if (entity instanceof ToadEntity) {
               LivingEntity var59;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var59 = _mobEnt.m_5448_();
               } else {
                  var59 = null;
               }

               if (var59 instanceof LivingEntity) {
                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     CalculateAttackProcedure.execute(world, entity);
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > 0.0) {
               LivingEntity var60;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var60 = _mobEnt.m_5448_();
               } else {
                  var60 = null;
               }

               if (var60 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var60 = _mobEnt.m_5448_();
                  } else {
                     var60 = null;
                  }

                  x_pos = ((Entity)var60).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var60 = _mobEnt.m_5448_();
                  } else {
                     var60 = null;
                  }

                  double var63 = ((Entity)var60).m_20186_();
                  LivingEntity var65;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var65 = _mobEnt.m_5448_();
                  } else {
                     var65 = null;
                  }

                  y_pos = var63 + (double)((Entity)var65).m_20206_() * 0.5;
                  LivingEntity var64;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.m_5448_();
                  } else {
                     var64 = null;
                  }

                  z_pos = ((Entity)var64).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 6, 9, false, false));
                  }
               }
            }
         }

      }
   }
}
