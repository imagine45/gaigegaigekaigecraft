package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AICrowProcedure {
   public AICrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         boolean logic_a = false;
         Entity entity_a = null;
         if (entity.m_6084_()) {
            if (entity.getPersistentData().m_128459_("NameRanged_ranged") == 0.0) {
               AICursedSpirit3FishProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 20.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  logic_a = false;
                  if (!entity.getPersistentData().m_128461_("OWNER_UUID").isEmpty()) {
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
                     if (entity_a instanceof LivingEntity) {
                        entity.getPersistentData().m_128359_("FOLLOW_ID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                        if (Math.random() < 0.25) {
                           if (entity_a.getPersistentData().m_128459_("NameRanged") == 0.0) {
                              entity.getPersistentData().m_128347_("NameRanged", Math.random());
                           }

                           entity.getPersistentData().m_128347_("NameRanged_ranged", entity_a.getPersistentData().m_128459_("NameRanged"));
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 MobEffectInstance var10001;
                                 MobEffect var10003;
                                 int var10005;
                                 label207: {
                                    var10001 = new MobEffectInstance;
                                    var10003 = MobEffects.f_19600_;
                                    if (entity_a instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity_a;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label207;
                                       }
                                    }

                                    var10005 = 0;
                                 }

                                 var10001.<init>(var10003, 2147483647, var10005, false, false);
                                 _entity.m_7292_(var10001);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 5, false, false));
                              }
                           }
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128461_("FOLLOW_ID").isEmpty()) {
                     label193: {
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           if (_tamEnt.m_21824_()) {
                              LivingEntity var10000;
                              if (entity instanceof TamableAnimal) {
                                 TamableAnimal _tamEnt = (TamableAnimal)entity;
                                 var10000 = _tamEnt.m_269323_();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity) {
                                 CompoundTag var82 = entity.getPersistentData();
                                 LivingEntity var10002;
                                 if (entity instanceof TamableAnimal) {
                                    TamableAnimal _tamEnt = (TamableAnimal)entity;
                                    var10002 = _tamEnt.m_269323_();
                                 } else {
                                    var10002 = null;
                                 }

                                 var82.m_128359_("FOLLOW_ID", ((Entity)var10002).m_20149_());
                                 break label193;
                              }
                           }
                        }

                        if (!world.m_6443_(MeiMeiEntity.class, AABB.m_165882_(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty()) {
                           entity.getPersistentData().m_128359_("FOLLOW_ID", ((Entity)world.m_6443_(MeiMeiEntity.class, AABB.m_165882_(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                              Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                                 return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                              }
                           })).compareDistOf(x, y, z)).findFirst().orElse((Object)null)).m_20149_());
                        } else {
                           entity.getPersistentData().m_128347_("cnt_x", -80.0);
                        }
                     }
                  } else {
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
                     }).apply(world, entity.getPersistentData().m_128461_("FOLLOW_ID"));
                     if (entity_a instanceof LivingEntity) {
                        logic_a = true;
                        x_pos = entity_a.m_20185_();
                        y_pos = entity_a.m_20186_();
                        z_pos = entity_a.m_20189_();
                     } else {
                        entity.getPersistentData().m_128359_("FOLLOW_ID", "");
                     }
                  }

                  if (logic_a) {
                     dis = Math.sqrt(Math.pow(entity.m_20185_() - x_pos, 2.0) + Math.pow(entity.m_20186_() - y_pos, 2.0) + Math.pow(entity.m_20189_() - z_pos, 2.0));
                     if (dis < 24.0) {
                        if (entity instanceof Mob) {
                           Mob _entity = (Mob)entity;
                           _entity.m_21573_().m_26519_(x_pos + (Math.random() - 0.5) * 16.0, y_pos + 8.0 + Math.random() * 8.0, z_pos + (Math.random() - 0.5) * 16.0, 1.0);
                        }
                     } else {
                        entity.getPersistentData().m_128379_("canFly", true);
                        GetPowerForwardProcedure.execute(x_pos + (Math.random() - 0.5) * 16.0, y_pos + 8.0 + Math.random() * 8.0, z_pos + (Math.random() - 0.5) * 16.0, entity);
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.25, entity.getPersistentData().m_128459_("y_power") * 0.25, entity.getPersistentData().m_128459_("z_power") * 0.25));
                        RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 10.0, entity);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("skill", 1.0);
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               logic_a = false;
               if (entity.getPersistentData().m_128459_("cnt1") < 3.0) {
                  if (LogicOwnerExistProcedure.execute(world, entity)) {
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
                        logic_a = true;
                        LivingEntity var83;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var83 = _mobEnt.m_5448_();
                        } else {
                           var83 = null;
                        }

                        if (var83 instanceof LivingEntity) {
                           CompoundTag var84 = entity.getPersistentData();
                           LivingEntity var87;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var87 = _mobEnt.m_5448_();
                           } else {
                              var87 = null;
                           }

                           Level var88 = ((Entity)var87).m_9236_();
                           ClipContext var93 = new ClipContext;
                           LivingEntity var96;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var96 = _mobEnt.m_5448_();
                           } else {
                              var96 = null;
                           }

                           Vec3 var97 = ((Entity)var96).m_20299_(1.0F);
                           LivingEntity var10006;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10006 = _mobEnt.m_5448_();
                           } else {
                              var10006 = null;
                           }

                           Vec3 var100 = ((Entity)var10006).m_20299_(1.0F);
                           LivingEntity var10007;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10007 = _mobEnt.m_5448_();
                           } else {
                              var10007 = null;
                           }

                           var100 = var100.m_82549_(((Entity)var10007).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var105 = Block.OUTLINE;
                           ClipContext.Fluid var10008 = Fluid.NONE;
                           LivingEntity var10009;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var93.<init>(var97, var100, var105, var10008, var10009);
                           var84.m_128347_("x_pos", (double)var88.m_45547_(var93).m_82425_().m_123341_());
                           var84 = entity.getPersistentData();
                           LivingEntity var89;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var89 = _mobEnt.m_5448_();
                           } else {
                              var89 = null;
                           }

                           double var90 = ((Entity)var89).m_20186_();
                           LivingEntity var94;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var94 = _mobEnt.m_5448_();
                           } else {
                              var94 = null;
                           }

                           var84.m_128347_("y_pos", var90 + (double)((Entity)var94).m_20206_() * 0.5);
                           var84 = entity.getPersistentData();
                           LivingEntity var91;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var91 = _mobEnt.m_5448_();
                           } else {
                              var91 = null;
                           }

                           Level var92 = ((Entity)var91).m_9236_();
                           ClipContext var95 = new ClipContext;
                           LivingEntity var98;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var98 = _mobEnt.m_5448_();
                           } else {
                              var98 = null;
                           }

                           Vec3 var99 = ((Entity)var98).m_20299_(1.0F);
                           LivingEntity var102;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var102 = _mobEnt.m_5448_();
                           } else {
                              var102 = null;
                           }

                           Vec3 var103 = ((Entity)var102).m_20299_(1.0F);
                           LivingEntity var106;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var106 = _mobEnt.m_5448_();
                           } else {
                              var106 = null;
                           }

                           var103 = var103.m_82549_(((Entity)var106).m_20252_(1.0F).m_82490_(0.0));
                           ClipContext.Block var107 = Block.OUTLINE;
                           var10008 = Fluid.NONE;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10009 = _mobEnt.m_5448_();
                           } else {
                              var10009 = null;
                           }

                           var95.<init>(var99, var103, var107, var10008, var10009);
                           var84.m_128347_("z_pos", (double)var92.m_45547_(var95).m_82425_().m_123343_());
                        } else {
                           x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                           y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                           z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           entity.getPersistentData().m_128347_("x_pos", x_pos);
                           entity.getPersistentData().m_128347_("y_pos", y_pos);
                           entity.getPersistentData().m_128347_("z_pos", z_pos);
                           dis = 8.0;
                           logic_a = false;

                           for(int index0 = 0; index0 < 8; ++index0) {
                              Vec3 _center = new Vec3((double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_(), (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());

                              for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                                 if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
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

                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  entity.getPersistentData().m_128379_("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  x_power = entity.getPersistentData().m_128459_("x_power") * 2.0;
                  y_power = entity.getPersistentData().m_128459_("y_power") * 2.0;
                  z_power = entity.getPersistentData().m_128459_("z_power") * 2.0;
                  entity.getPersistentData().m_128347_("old_x", x);
                  entity.getPersistentData().m_128347_("old_y", y);
                  entity.getPersistentData().m_128347_("old_z", z);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.1, 0.1, 0.1, 0.4);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.bat.takeoff")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                     }
                  }
               } else {
                  if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 2.0) {
                     x_power = entity.m_20184_().m_7096_() - 0.15;
                  } else {
                     x_power = entity.m_20184_().m_7096_() + 0.15;
                  }

                  if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 2.0) {
                     y_power = entity.m_20184_().m_7098_() - 0.15;
                  } else {
                     y_power = entity.m_20184_().m_7098_() + 0.15;
                  }

                  if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 2.0) {
                     z_power = entity.m_20184_().m_7094_() - 0.15;
                  } else {
                     z_power = entity.m_20184_().m_7094_() + 0.15;
                  }
               }

               if (!entity.getPersistentData().m_128471_("Stop")) {
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  RotateEntityProcedure.execute((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_() + entity.m_20184_().m_7096_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_() + entity.m_20184_().m_7098_() * 10.0, (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_() + entity.m_20184_().m_7094_() * 10.0, entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 1, 0.1, 0.1, 0.1, 0.1);
                  }
               } else {
                  entity.getPersistentData().m_128379_("Stop", false);
               }

               x_pos = entity.getPersistentData().m_128459_("old_x");
               y_pos = entity.getPersistentData().m_128459_("old_y");
               z_pos = entity.getPersistentData().m_128459_("old_z");
               x_power = x_pos - x;
               y_power = y_pos - y;
               z_power = z_pos - z;
               dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
               if (dis > 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;

                  for(int index1 = 0; index1 < (int)Math.ceil(dis * 2.0); ++index1) {
                     entity.getPersistentData().m_128347_("Damage", 24.0);
                     entity.getPersistentData().m_128347_("Range", 3.0);
                     entity.getPersistentData().m_128347_("knockback", 0.25);
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     entity.getPersistentData().m_128379_("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     x_pos += x_power * 0.5;
                     y_pos += y_power * 0.5;
                     z_pos += z_power * 0.5;
                  }
               }

               entity.getPersistentData().m_128347_("old_x", x);
               entity.getPersistentData().m_128347_("old_y", y);
               entity.getPersistentData().m_128347_("old_z", z);
               entity.getPersistentData().m_128347_("BlockRange", 1.0);
               entity.getPersistentData().m_128347_("BlockDamage", 1.0);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().m_128459_("cnt1") > 15.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21153_(0.0F);
                  }

                  entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(ResourceKey.m_135785_(Registries.f_268580_, new ResourceLocation("jujutsucraft:damage_combat")))), 9999.0F);
               }
            }
         }

      }
   }
}
