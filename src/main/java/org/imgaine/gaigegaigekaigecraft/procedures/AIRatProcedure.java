package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.CockroachesEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AIRatProcedure {
   public AIRatProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         boolean logic_a = false;
         double rnd = 0.0;
         double speed = 0.0;
         double lv_df = 0.0;
         double lv_st = 0.0;
         double entity_size = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         speed = 0.5;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
               }
            }

            label112: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label112;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_(MobEffects.f_19597_);
               }
            }

            label107: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label107;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 1, false, false));
                  }
               }
            }

            label102: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label102;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 0, false, false));
                  }
               }
            }

            if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0) {
               owner_uuid = (new BiFunction<LevelAccessor, String, Entity>() {
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
               if (owner_uuid instanceof LivingEntity) {
                  if (entity.getPersistentData().m_128459_("skill") > -900.0) {
                     entity.getPersistentData().m_128347_("skill", 2306.0);
                     entity.getPersistentData().m_128347_("Damage", 9.0);
                     entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
                     entity.getPersistentData().m_128347_("knockback", 0.1);
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), entity);
                     entity.getPersistentData().m_128347_("skill", 0.0);
                     entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt_life") > 120.0 && !entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                     }
                  }

                  entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
                  if (entity.getPersistentData().m_128459_("skill") > -900.0 && entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.m_20096_()) {
                     entity.getPersistentData().m_128347_("cnt_x", Math.random() * 5.0);
                     if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                        if (entity.getPersistentData().m_128459_("friend_num") == owner_uuid.getPersistentData().m_128459_("friend_num")) {
                           logic_a = true;
                           LivingEntity var10000;
                           if (owner_uuid instanceof Mob) {
                              Mob _mobEnt = (Mob)owner_uuid;
                              var10000 = _mobEnt.m_5448_();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 instanceof LivingEntity && owner_uuid.getPersistentData().m_128459_("cnt_target") > 6.0) {
                              CompoundTag var34 = entity.getPersistentData();
                              LivingEntity var10002;
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var34.m_128347_("x_pos", ((Entity)var10002).m_20185_());
                              var34 = entity.getPersistentData();
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var34.m_128347_("y_pos", ((Entity)var10002).m_20186_());
                              var34 = entity.getPersistentData();
                              if (owner_uuid instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_uuid;
                                 var10002 = _mobEnt.m_5448_();
                              } else {
                                 var10002 = null;
                              }

                              var34.m_128347_("z_pos", ((Entity)var10002).m_20189_());
                           } else {
                              entity.getPersistentData().m_128347_("x_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123341_());
                              entity.getPersistentData().m_128347_("y_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123342_());
                              entity.getPersistentData().m_128347_("z_pos", (double)owner_uuid.m_9236_().m_45547_(new ClipContext(owner_uuid.m_20299_(1.0F), owner_uuid.m_20299_(1.0F).m_82549_(owner_uuid.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, owner_uuid)).m_82425_().m_123343_());
                           }
                        }

                        if (logic_a) {
                           RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                           GetPowerForwardProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                           if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(4.0)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                              entity.getPersistentData().m_128347_("y_power", Math.max(entity.getPersistentData().m_128459_("y_power"), 0.5 * (1.0 / speed)));
                           }

                           entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * speed, Math.max(entity.getPersistentData().m_128459_("y_power") * speed, entity instanceof CockroachesEntity ? 0.1 : 0.25), entity.getPersistentData().m_128459_("z_power") * speed));
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
