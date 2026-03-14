package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class IcefallProcedure {
   public IcefallProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         double CNT6 = 0.0;
         double range_2 = 0.0;
         double HP = 0.0;
         double dis = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         picth = Math.toRadians((double)entity.m_146909_());
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
               }
            }

            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002 = new Vec3;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.m_5448_();
            } else {
               var10004 = null;
            }

            double var110 = ((Entity)var10004).m_20185_();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.m_5448_();
            } else {
               var10005 = null;
            }

            double var111 = ((Entity)var10005).m_20186_() + (double)entity.m_20206_() * 0.5;
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.m_5448_();
            } else {
               var10006 = null;
            }

            var10002.<init>(var110, var111, ((Entity)var10006).m_20189_());
            entity.m_7618_(var10001, var10002);
         }

         if (entity.getPersistentData().m_128459_("cnt1") < 20.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 10, 5.0, 0.1, 5.0, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 2, 5.0, 0.1, 5.0, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 2.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 1.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 18.0 && entity.getPersistentData().m_128459_("cnt5") < 60.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().m_128379_("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) < 5.0 || GetDistanceProcedure.execute(entity) > 16.0) {
                     label421: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                           label389: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().m_128471_("attack")) {
                                    break label389;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                                 break label421;
                              }
                           }
                        }

                        entity.getPersistentData().m_128379_("PRESS_Z", true);
                     }
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 18.0));
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 3.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            entity.getPersistentData().m_128347_("Damage", 3.0);
            entity.getPersistentData().m_128347_("Range", Math.min(24.0, entity.getPersistentData().m_128459_("cnt5") * 2.0));
            entity.getPersistentData().m_128347_("knockback", 0.01);
            entity.getPersistentData().m_128347_("effect", 14.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("Damage", 6.0);
            entity.getPersistentData().m_128347_("Range", Math.min(12.0, entity.getPersistentData().m_128459_("cnt5") * 2.0));
            entity.getPersistentData().m_128347_("knockback", 0.01);
            entity.getPersistentData().m_128347_("effect", 14.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("BlockRange", Math.min(12.0, entity.getPersistentData().m_128459_("cnt5") * 1.0));
            BlockToIceProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().m_128459_("cnt5") % 2.0 == 1.0 && entity.getPersistentData().m_128459_("cnt5") < 20.0) {
               range = Math.min(16.0, 6.0 + entity.getPersistentData().m_128459_("cnt5") * 2.0);
               num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt5") * 20.0);
               x_pos += Math.cos(num1) * range;
               z_pos += Math.sin(num1) * range;

               for(int index0 = 0; index0 < (int)range; ++index0) {
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     ++y_pos;
                  } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                        break;
                     }

                     --y_pos;
                  }
               }

               int var108;
               label330: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var108 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label330;
                     }
                  }

                  var108 = 0;
               }

               HP = (double)(20 + var108 * 4);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ICE_SPEAR_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     entityinstance.m_146922_((float)Math.toDegrees(num1 + 90.0));
                     entityinstance.m_146926_(-45.0F);
                     entityinstance.m_5618_(entityinstance.m_146908_());
                     entityinstance.m_5616_(entityinstance.m_146908_());
                     entityinstance.f_19859_ = entityinstance.m_146908_();
                     entityinstance.f_19860_ = entityinstance.m_146909_();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity73 = (LivingEntity)entityinstance;
                        if (_livingEntity73.m_21204_().m_22171_(Attributes.f_22276_)) {
                           _livingEntity73.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.m_21153_((float)HP);
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity77 = (LivingEntity)entityinstance;
                        if (_livingEntity77.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity77.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(0.1);
                        }
                     }

                     if (!entityinstance.m_9236_().m_5776_() && entityinstance.m_20194_() != null) {
                        entityinstance.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityinstance.m_20182_(), entityinstance.m_20155_(), entityinstance.m_9236_() instanceof ServerLevel ? (ServerLevel)entityinstance.m_9236_() : null, 4, entityinstance.m_7755_().getString(), entityinstance.m_5446_(), entityinstance.m_9236_().m_7654_(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.getPersistentData().m_128347_("y_power", 1.0);
                     entityinstance.getPersistentData().m_128347_("move", 0.0);
                     entityinstance.getPersistentData().m_128347_("cnt6", 0.0);
                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:ice_generate")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("cnt3", (double)entity.m_146908_());
               dis = 6.0;
               SUCCESS = false;

               for(int index1 = 0; index1 < 8; ++index1) {
                  x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123341_();
                  y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123342_();
                  z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.VISUAL, Fluid.NONE, entity)).m_82425_().m_123343_();
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(6.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
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

               entity.getPersistentData().m_128347_("x_power", x_pos);
               entity.getPersistentData().m_128347_("y_power", y_pos);
               entity.getPersistentData().m_128347_("z_power", z_pos);
            }

            if (entity.getPersistentData().m_128459_("cnt2") <= 15.0) {
               num2 = (double)(entity.m_20205_() + 4.0F);

               for(int index2 = 0; index2 < 12; ++index2) {
                  num1 = Math.toRadians(entity.getPersistentData().m_128459_("cnt3"));
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.sin(num1) * num2;
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.cos(num1) * num2;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123815_, x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 1, 0.25, 0.25, 0.25, 0.0);
                  }

                  entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 10.0 * Math.random());
                  entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + 0.1);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= 10.0) {
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);

               for(int index3 = 0; index3 < 2; ++index3) {
                  num1 = Math.toRadians(720.0 * Math.random());
                  num2 = 10.0 * Math.random();
                  x_pos = entity.getPersistentData().m_128459_("x_power") + Math.sin(num1) * num2;
                  y_pos = entity.getPersistentData().m_128459_("y_power");
                  z_pos = entity.getPersistentData().m_128459_("z_power") + Math.cos(num1) * num2;
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     for(int index4 = 0; index4 < 16; ++index4) {
                        ++y_pos;
                        if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                           break;
                        }
                     }
                  }

                  for(int index5 = 0; index5 < 16 && !world.m_8055_(BlockPos.m_274561_(x_pos, y_pos + 1.0, z_pos)).m_60815_(); ++index5) {
                     ++y_pos;
                  }

                  int var109;
                  label281: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var109 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label281;
                        }
                     }

                     var109 = 0;
                  }

                  HP = (double)(80 + var109 * 16);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ICE_SPEAR.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        entityinstance.m_146922_(entity.m_146908_());
                        entityinstance.m_146926_(entity.m_146909_());
                        entityinstance.m_5618_(entityinstance.m_146908_());
                        entityinstance.m_5616_(entityinstance.m_146908_());
                        entityinstance.f_19859_ = entityinstance.m_146908_();
                        entityinstance.f_19860_ = entityinstance.m_146909_();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity143 = (LivingEntity)entityinstance;
                           if (_livingEntity143.m_21204_().m_22171_(Attributes.f_22276_)) {
                              _livingEntity143.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.m_21153_((float)HP);
                        }

                        entityinstance.getPersistentData().m_128347_("move", 0.0);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity149 = (LivingEntity)entityinstance;
                           if (_livingEntity149.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity149.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(3.0);
                           }
                        }

                        if (entityinstance instanceof IceSpearEntity) {
                           ((IceSpearEntity)entityinstance).setAnimation("idle_stand");
                        }

                        _serverLevel.m_7967_(entityinstance);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_ICE.get(), x_pos, y_pos, z_pos, 4, 1.0, 1.0, 1.0, 0.0);
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt4") > 12.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

      }
   }
}
