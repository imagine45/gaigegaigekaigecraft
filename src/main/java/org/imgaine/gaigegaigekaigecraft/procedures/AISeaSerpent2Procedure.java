package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentMiniEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
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

public class AISeaSerpent2Procedure {
   public AISeaSerpent2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double z_pwoer = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double strength = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("old_x") == 0.0) {
            entity.getPersistentData().m_128347_("old_x", entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25);
            entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25);
            entity.getPersistentData().m_128347_("old_z", entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25);
         }

         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("cnt1") < 12.0) {
               entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.6);
               entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.6);
               entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.6);
               x_power = entity.getPersistentData().m_128459_("x_power");
               y_power = entity.getPersistentData().m_128459_("y_power");
               z_pwoer = entity.getPersistentData().m_128459_("z_power");
               entity.getPersistentData().m_128347_("speed", Math.max(0.5, entity.getPersistentData().m_128459_("speed")));
               if (entity instanceof SeaSerpentEntity) {
                  entity.getPersistentData().m_128347_("cnt1", Math.max(entity.getPersistentData().m_128459_("cnt1"), 11.0));
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") == 12.0) {
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
                           CompoundTag var75 = entity.getPersistentData();
                           LivingEntity var10002;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10002 = _mobEnt.m_5448_();
                           } else {
                              var10002 = null;
                           }

                           Level var79 = ((Entity)var10002).m_9236_();
                           ClipContext var10003 = new ClipContext;
                           LivingEntity var10005;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10005 = _mobEnt.m_5448_();
                           } else {
                              var10005 = null;
                           }

                           Vec3 var86 = ((Entity)var10005).m_20299_(1.0F);
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.m_5448_();
                           } else {
                              var10006 = null;
                           }

                           Vec3 var91 = ((Entity)var10006).m_20299_(1.0F);
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var91 = var91.m_82549_(((Entity)var10007).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var99 = Block.OUTLINE;
                           ClipContext.Fluid var10008 = Fluid.NONE;
                           LivingEntity var10009;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var10003.<init>(var86, var91, var99, var10008, var10009);
                           var75.m_128347_("x_pos", (double)var79.m_45547_(var10003).m_82425_().m_123341_());
                           var75 = entity.getPersistentData();
                           LivingEntity var80;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var80 = _mobEnt.m_5448_();
                           } else {
                              var80 = null;
                           }

                           Level var81 = ((Entity)var80).m_9236_();
                           var10003 = new ClipContext;
                           LivingEntity var87;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var87 = _mobEnt.m_5448_();
                           } else {
                              var87 = null;
                           }

                           Vec3 var88 = ((Entity)var87).m_20299_(1.0F);
                           LivingEntity var93;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var93 = _mobEnt.m_5448_();
                           } else {
                              var93 = null;
                           }

                           Vec3 var94 = ((Entity)var93).m_20299_(1.0F);
                           LivingEntity var100;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var100 = _mobEnt.m_5448_();
                           } else {
                              var100 = null;
                           }

                           var94 = var94.m_82549_(((Entity)var100).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var101 = Block.OUTLINE;
                           var10008 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var10003.<init>(var88, var94, var101, var10008, var10009);
                           var75.m_128347_("y_pos", (double)var81.m_45547_(var10003).m_82425_().m_123342_());
                           var75 = entity.getPersistentData();
                           LivingEntity var82;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var82 = _mobEnt.m_5448_();
                           } else {
                              var82 = null;
                           }

                           Level var83 = ((Entity)var82).m_9236_();
                           var10003 = new ClipContext;
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.m_5448_();
                           } else {
                              var89 = null;
                           }

                           Vec3 var90 = ((Entity)var89).m_20299_(1.0F);
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.m_5448_();
                           } else {
                              var96 = null;
                           }

                           Vec3 var97 = ((Entity)var96).m_20299_(1.0F);
                           LivingEntity var102;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var102 = _mobEnt.m_5448_();
                           } else {
                              var102 = null;
                           }

                           var97 = var97.m_82549_(((Entity)var102).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var103 = Block.OUTLINE;
                           var10008 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var10003.<init>(var90, var97, var103, var10008, var10009);
                           var75.m_128347_("z_pos", (double)var83.m_45547_(var10003).m_82425_().m_123343_());
                        } else {
                           entity.getPersistentData().m_128347_("x_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_());
                           entity.getPersistentData().m_128347_("y_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_());
                           entity.getPersistentData().m_128347_("z_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                           if (entity instanceof SeaSerpentMiniEntity) {
                              dis = 8.0;
                              logic_a = false;

                              for(int index0 = 0; index0 < 8; ++index0) {
                                 Vec3 _center = new Vec3((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());

                                 for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                    if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                       logic_a = true;
                                       entity.getPersistentData().m_128347_("x_pos", entityiterator.m_20185_());
                                       entity.getPersistentData().m_128347_("y_pos", entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5);
                                       entity.getPersistentData().m_128347_("z_pos", entityiterator.m_20189_());
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
                  }

                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") != 12.0 && !(entity instanceof SeaSerpentEntity)) {
                  x_power = entity.m_20184_().m_7096_() + (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  y_power = entity.m_20184_().m_7098_() + (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  z_pwoer = entity.m_20184_().m_7094_() + (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("speed") ? -0.1 : 0.1);
                  speed = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                  if (speed < 1.5 * entity.getPersistentData().m_128459_("speed")) {
                     speed = 1.5 * entity.getPersistentData().m_128459_("speed") / Math.max(speed, 0.01);
                     x_power *= speed;
                     y_power *= speed;
                     double var78 = z_power * speed;
                  }
               } else {
                  if (entity.getPersistentData().m_128459_("cnt1") == 12.0) {
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                        }
                     }
                  }

                  x_power = entity.getPersistentData().m_128459_("x_power") * entity.getPersistentData().m_128459_("speed");
                  y_power = entity.getPersistentData().m_128459_("y_power") * entity.getPersistentData().m_128459_("speed");
                  z_pwoer = entity.getPersistentData().m_128459_("z_power") * entity.getPersistentData().m_128459_("speed");
               }
            }

            if (entity.getPersistentData().m_128459_("skill") > -999.0) {
               entity.m_20256_(new Vec3(x_power, y_power, z_pwoer));
            }

            if (!entity.m_20160_() && entity.getPersistentData().m_128459_("skill") > -999.0) {
               y_power = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25 - entity.getPersistentData().m_128459_("old_x");
               y_power = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25 - entity.getPersistentData().m_128459_("old_y");
               z_power = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25 - entity.getPersistentData().m_128459_("old_z");
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 1.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");

               for(int index1 = 0; index1 < (int)Math.max(dis, 1.0); ++index1) {
                  if (entity instanceof SeaSerpentMiniEntity) {
                     entity.getPersistentData().m_128347_("Damage", 12.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 0.1);
                  } else {
                     entity.getPersistentData().m_128347_("Damage", 14.0 * CNT6);
                     entity.getPersistentData().m_128347_("x_knockback", entity.m_20184_().m_7096_() * 1.25);
                     entity.getPersistentData().m_128347_("y_knockback", entity.m_20184_().m_7098_() * 1.25);
                     entity.getPersistentData().m_128347_("z_knockback", entity.m_20184_().m_7094_() * 1.25);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                  }

                  entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("effect", 1.0);
                  entity.getPersistentData().m_128379_("swing", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25;
               z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25;
               if (!(entity instanceof SeaSerpentMiniEntity)) {
                  entity.getPersistentData().m_128347_("Range", (double)(1.0F + entity.m_20205_()));
                  entity.getPersistentData().m_128347_("effect", -1.0);
                  entity.getPersistentData().m_128347_("knockback", 1.0);
                  KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_() && entity.getPersistentData().m_128459_("cnt1") % 20.0 == 10.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     entity.getPersistentData().m_128347_("BlockRange", (double)(1.0F * entity.m_20205_()));
                     entity.getPersistentData().m_128347_("BlockDamage", (double)entity.m_20205_() * 0.25 * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }
               }
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") >= (double)(entity instanceof SeaSerpentMiniEntity ? 40 : 80) && !entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

         entity.getPersistentData().m_128347_("old_x", entity.m_20185_() + entity.m_20154_().f_82479_ * (double)entity.m_20205_() * 0.25);
         entity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5 + entity.m_20154_().f_82480_ * (double)entity.m_20205_() * 0.25);
         entity.getPersistentData().m_128347_("old_z", entity.m_20189_() + entity.m_20154_().f_82481_ * (double)entity.m_20205_() * 0.25);
      }
   }
}
