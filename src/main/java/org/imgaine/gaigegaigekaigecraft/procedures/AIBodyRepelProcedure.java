package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIBodyRepelProcedure {
   public AIBodyRepelProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double num1 = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double num4 = 0.0;
         double num3 = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.m_6084_()) {
            double var10000;
            label239: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity2.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                     break label239;
                  }
               }

               var10000 = 0.0;
            }

            if (var10000 < entity.getPersistentData().m_128459_("size") && entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  label232: {
                     var81 = _livingEntity6.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity4 = (LivingEntity)entity;
                        if (_livingEntity4.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity4.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22115_();
                           break label232;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var81.m_22100_(Math.min(var10001 + 0.2, entity.getPersistentData().m_128459_("size")));
               }
            }

            if (entity.getPersistentData().m_128459_("move") == 1.0) {
               if (entity.getPersistentData().m_128459_("cnt1") < 35.0 * CNT6) {
                  AIFistProcedure.execute(world, entity);
               } else {
                  entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
                  entity.m_146922_(entity.m_146908_());
                  entity.m_146926_(0.0F);
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= 140.0 && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               if (entity.getPersistentData().m_128459_("cnt1") <= 40.0) {
                  num1 = (double)(entity.m_146908_() % 360.0F);
                  num3 = (double)entity.m_146909_();
                  RotateEntityProcedure.execute(entity.m_20185_() + entity.m_20184_().m_7096_() * 999.0, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + entity.m_20184_().m_7098_() * 999.0, entity.m_20189_() + entity.m_20184_().m_7094_() * 999.0, entity);
                  num2 = num1 - (double)entity.m_146908_();
                  num4 = num3 - (double)entity.m_146909_();
                  entity.m_146922_((float)(num1 + Math.min(8.0, Math.abs(num2)) * (double)((!(Math.abs(num2) > 180.0) || !(num2 < 0.0)) && (!(Math.abs(num2) <= 180.0) || !(num2 > 0.0)) ? 1 : -1)));
                  entity.m_146926_((float)(num3 + Math.min(8.0, Math.abs(num4)) * (double)(num4 < 0.0 ? -1 : 1)));
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  x_power = entity.getPersistentData().m_128459_("x_power");
                  y_power = entity.getPersistentData().m_128459_("y_power");
                  z_power = entity.getPersistentData().m_128459_("z_power");
                  if (!(entity.getPersistentData().m_128459_("cnt1") <= 12.0)) {
                     x_power = entity.getPersistentData().m_128459_("x_pos") * 1.0;
                     y_power = entity.getPersistentData().m_128459_("y_pos") * 1.0;
                     z_power = entity.getPersistentData().m_128459_("z_pos") * 1.0;
                  } else {
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
                           LivingEntity var82;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var82 = _mobEnt.m_5448_();
                           } else {
                              var82 = null;
                           }

                           if (var82 instanceof LivingEntity) {
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.m_5448_();
                              } else {
                                 var82 = null;
                              }

                              x_pos = ((Entity)var82).m_20185_();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var82 = _mobEnt.m_5448_();
                              } else {
                                 var82 = null;
                              }

                              double var85 = ((Entity)var82).m_20186_();
                              LivingEntity var87;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var87 = _mobEnt.m_5448_();
                              } else {
                                 var87 = null;
                              }

                              y_pos = var85 + (double)((Entity)var87).m_20206_() * 0.75;
                              LivingEntity var86;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var86 = _mobEnt.m_5448_();
                              } else {
                                 var86 = null;
                              }

                              z_pos = ((Entity)var86).m_20189_();
                           } else {
                              x_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_();
                              y_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_();
                              z_pos = (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_();
                           }
                        }
                     }

                     distance = 8.0 * ReturnEntitySizeProcedure.execute(entity);
                     Vec3 _center = new Vec3(entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.m_20186_() + (double)entity.m_20206_() * 0.5 + Math.sin(pitch) * -1.0 * distance, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(2.0 * distance / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           x_pos = entityiterator.m_20185_();
                           y_pos = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5;
                           z_pos = entityiterator.m_20189_();
                           break;
                        }
                     }

                     num1 = (double)(entity.m_146908_() % 360.0F);
                     num3 = (double)entity.m_146909_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
                     entity.m_146922_((float)num1);
                     entity.m_146926_((float)num3);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entity.m_20184_().m_7096_() > entity.getPersistentData().m_128459_("x_power") * 0.8) {
                        x_power = entity.m_20184_().m_7096_() - 0.175;
                     } else {
                        x_power = entity.m_20184_().m_7096_() + 0.175;
                     }

                     if (entity.m_20184_().m_7098_() > entity.getPersistentData().m_128459_("y_power") * 0.8) {
                        y_power = entity.m_20184_().m_7098_() - 0.175;
                     } else {
                        y_power = entity.m_20184_().m_7098_() + 0.175;
                     }

                     if (entity.m_20184_().m_7094_() > entity.getPersistentData().m_128459_("z_power") * 0.8) {
                        z_power = entity.m_20184_().m_7094_() - 0.175;
                     } else {
                        z_power = entity.m_20184_().m_7094_() + 0.175;
                     }

                     entity.getPersistentData().m_128347_("x_pos", x_power);
                     entity.getPersistentData().m_128347_("y_pos", y_power);
                     entity.getPersistentData().m_128347_("z_pos", z_power);
                  }

                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > 0.0 && dis < 0.8) {
                     x_power *= 0.8 / dis;
                     y_power *= 0.8 / dis;
                     z_power *= 0.8 / dis;
                  }

                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();

                  for(int index0 = 0; index0 < 1; ++index0) {
                     entity.getPersistentData().m_128347_("Damage", 15.0 * CNT6);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("Range", (double)(1.0F + entity.m_20205_()));
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     if (!entity.getPersistentData().m_128471_("Stop")) {
                        yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                        pitch = Math.toRadians((double)entity.m_146909_());
                        distance = (double)entity.m_20205_() * 0.5;
                        RangeAttackProcedure.execute(world, entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance, entity.m_20186_() + (double)entity.m_20206_() * 0.9 + Math.sin(pitch) * -1.0 * distance, entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance, entity);
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                     if (world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos))) {
                        entity.getPersistentData().m_128379_("Stop", false);
                     } else {
                        entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 8.0);
                        if (!entity.getPersistentData().m_128471_("Stop")) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.m_5776_()) {
                                 _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                              }
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                           }

                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                           }

                           entity.getPersistentData().m_128347_("BlockRange", 1.5 * ReturnEntitySizeProcedure.execute(entity));
                           entity.getPersistentData().m_128347_("BlockDamage", 4.0 * CNT6);
                           BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos, entity);
                           if (!world.m_46859_(BlockPos.m_274561_(x_pos, y_pos + (double)entity.m_20206_() * 0.5, z_pos))) {
                              entity.getPersistentData().m_128379_("Stop", true);
                              break;
                           }
                        }
                     }
                  }
               } else {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:0b}");
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") >= 140.0 && !entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            entity.getPersistentData().m_128347_("cnt3", 1.0);
            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(4.0F * entity.m_20206_() * entity.m_20205_() * entity.m_20205_()), 0.2 * (double)entity.m_20205_(), 0.2 * (double)entity.m_20206_(), 0.2 * (double)entity.m_20205_(), 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
               } else {
                  _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
               }
            }

            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
         }

      }
   }
}
