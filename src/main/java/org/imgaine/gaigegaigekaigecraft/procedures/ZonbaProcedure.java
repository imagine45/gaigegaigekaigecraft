package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ZonbaProcedure {
   public ZonbaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         double dis;
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label264: {
            boolean logic_a = false;
            boolean pitch = false;
            SUCCESS = false;
            boolean logic_b = false;
            Entity entity_a = null;
            dis = 0.0;
            x_pos = 0.0;
            y_pos = 0.0;
            z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double yaw2 = 0.0;
            double pitch2 = 0.0;
            double power = 0.0;
            double strength = 0.0;
            double distance = 0.0;
            double d = 0.0;
            double range = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label264;
               }
            }

            var10000 = 0;
         }

         double var71 = (double)Math.min(var10000, 50);
         double var77 = ReturnEntitySizeProcedure.execute(entity);
         double var80 = 1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1;
         if (entity.getPersistentData().m_128459_("cnt2") % 3.0 == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(207.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity8.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         LivingEntity var106;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var106 = _mobEnt.m_5448_();
         } else {
            var106 = null;
         }

         Entity var54 = var106;
         if (!(var54 instanceof LivingEntity) && entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
            var54 = (new BiFunction<LevelAccessor, String, Entity>() {
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
            if (var54 instanceof LivingEntity) {
               if (var54 instanceof Mob) {
                  Mob _mobEnt = (Mob)var54;
                  var106 = _mobEnt.m_5448_();
               } else {
                  var106 = null;
               }

               if (var106 instanceof LivingEntity) {
                  if (var54 instanceof Mob) {
                     Mob _mobEnt = (Mob)var54;
                     var106 = _mobEnt.m_5448_();
                  } else {
                     var106 = null;
                  }

                  var54 = var106;
               } else {
                  dis = 6.0;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     x_pos = (double)((Entity)var54).m_9236_().m_45547_(new ClipContext(((Entity)var54).m_20299_(1.0F), ((Entity)var54).m_20299_(1.0F).m_82549_(((Entity)var54).m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).m_82425_().m_123341_();
                     y_pos = (double)((Entity)var54).m_9236_().m_45547_(new ClipContext(((Entity)var54).m_20299_(1.0F), ((Entity)var54).m_20299_(1.0F).m_82549_(((Entity)var54).m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).m_82425_().m_123342_();
                     z_pos = (double)((Entity)var54).m_9236_().m_45547_(new ClipContext(((Entity)var54).m_20299_(1.0F), ((Entity)var54).m_20299_(1.0F).m_82549_(((Entity)var54).m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).m_82425_().m_123343_();
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, (Entity)var54, entityiterator) && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var54 = entityiterator;
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += 6.0;
                  }

                  if (!SUCCESS) {
                     var54 = null;
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }
               }

               if (var54 instanceof LivingEntity && entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  if (var54 instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)var54;
                     _entity.m_6710_(_ent);
                  }
               }
            } else {
               var54 = null;
            }
         }

         if (var54 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var54).m_20185_(), ((Entity)var54).m_20186_() + (double)((Entity)var54).m_20206_() * 0.9, ((Entity)var54).m_20189_(), entity);
         }

         if (entity.getPersistentData().m_128459_("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 2, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 9.0) {
               if (var54 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               } else if (!(entity instanceof Player)) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 8.0));
                  if (entity.getPersistentData().m_128459_("cnt6") < 5.0) {
                     entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
                     if (entity.getPersistentData().m_128459_("cnt6") >= 5.0) {
                        entity.getPersistentData().m_128347_("cnt6", 5.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }
            }

            double var67 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
            dis = Math.toRadians((double)entity.m_146909_());
            double var72 = 1.0 + 0.5 * (double)entity.m_20205_();
            x_pos = entity.m_20185_() + Math.cos(var67) * Math.cos(dis) * var72;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(dis) * -1.0 * var72;
            z_pos = entity.m_20189_() + Math.sin(var67) * Math.cos(dis) * var72;
            var72 = (double)(3.0F + entity.m_20205_());

            for(int index1 = 0; index1 < (int)(2.0 * var77); ++index1) {
               var67 = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               dis = Math.toRadians(Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, var72, x_pos + Math.cos(var67) * Math.cos(dis) * var72, x_pos, y_pos + Math.sin(dis) * -1.0 * var72, y_pos, z_pos + Math.sin(var67) * Math.cos(dis) * var72, z_pos, entity.getPersistentData().m_128459_("cnt6") >= 5.0 ? "minecraft:enchanted_hit" : "minecraft:crit");
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
               }
            }

            entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.01);
            if (entity.getPersistentData().m_128459_("cnt1") == 10.0) {
               if (entity instanceof Player) {
                  if (entity.m_6144_()) {
                     entity.getPersistentData().m_128347_("cnt10", 1.0);
                  }
               } else if (GetDistanceProcedure.execute(entity) > 16.0 || GetDistanceProcedure.execute(entity) > 6.0 && Math.random() < 0.25) {
                  entity.getPersistentData().m_128347_("cnt10", 1.0);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt10") > 0.0) {
               ZonbaFallProcedure.execute(world, entity);
            } else {
               if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
                  double var70 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  dis = Math.toRadians(0.0);
                  double var75 = (double)(2.0F + entity.m_20205_());
                  x_pos = entity.m_20185_() + Math.cos(var70) * Math.cos(dis) * var75;
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.65 + Math.sin(dis) * -1.0 * var75;
                  z_pos = entity.m_20189_() + Math.sin(var70) * Math.cos(dis) * var75;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle minecraft:flash ~ ~ ~ " + var77 * 1.0 + " " + var77 * 1.0 + " " + var77 * 1.0 + " 0 " + Math.round(10.0 * var77) + " force");
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                  double var74 = (double)(1.0F + entity.m_20205_());
                  if (entity.getPersistentData().m_128459_("cnt1") <= 15.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                        }
                     }

                     double var69 = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                     dis = Math.toRadians((double)entity.m_146909_());
                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_() + Math.cos(var69) * Math.cos(dis) * var74);
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(dis) * -1.0 * var74);
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_() + Math.sin(var69) * Math.cos(dis) * var74);
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_);
                  }

                  if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
                     x_pos = entity.getPersistentData().m_128459_("x_pos");
                     y_pos = entity.getPersistentData().m_128459_("y_pos");
                     z_pos = entity.getPersistentData().m_128459_("z_pos");
                     double var83 = entity.getPersistentData().m_128459_("x_power");
                     double var81 = entity.getPersistentData().m_128459_("y_power");
                     double var82 = entity.getPersistentData().m_128459_("z_power");
                     var77 = ReturnEntitySizeProcedure.execute(entity) * var80 * var80 * var80;

                     for(int index2 = 0; index2 < (int)(var77 * 12.0); ++index2) {
                        ParticleGeneratorProcedure.execute(world, var77 * 1.0, 4.0, 1.0, Mth.m_216263_(RandomSource.m_216327_(), 0.0, 6.0), x_pos, x_pos + var83, y_pos, y_pos + var81, z_pos, z_pos + var82, "end_rod");
                     }

                     var77 *= 0.5;

                     for(int index3 = 0; index3 < (int)Math.min(entity.getPersistentData().m_128459_("cnt3") * 12.0, 48.0); ++index3) {
                        if (var74 > 0.0) {
                           var74 = 2.0 * var77 * -0.5;
                           entity.getPersistentData().m_128347_("Damage", 15.0 * var80);
                           entity.getPersistentData().m_128347_("Range", 4.0 * var77);
                           entity.getPersistentData().m_128347_("knockback", 0.75);
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                              if (entity != entityiterator && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 boolean var53 = true;
                                 break;
                              }
                           }
                        }

                        if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos - 3.0 * var77, z_pos, 6.0 * var77, 6.0 * var77)) {
                           if (dis > 0.0) {
                              dis = 2.0 * var77 * -0.5;
                              double var76 = Math.sqrt(entity.getPersistentData().m_128459_("Damage"));
                              entity.getPersistentData().m_128347_("BlockDamage", 8.0 * var80);
                              entity.getPersistentData().m_128347_("BlockRange", 4.0 * var77);
                              entity.getPersistentData().m_128379_("noParticle", true);
                              entity.getPersistentData().m_128379_("noEffect", true);
                              BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           }
                        } else if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle flash ~ ~ ~ " + var77 * 0.1 + " " + var77 * 0.1 + " " + var77 * 0.1 + " 0 " + Math.round(2.0 * var77) + " force");
                        }

                        x_pos += var83;
                        y_pos += var81;
                        z_pos += var82;
                        ++dis;
                        ++var74;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 20.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

      }
   }
}
