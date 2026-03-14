package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class CleaveProcedure {
   public CleaveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean worldCutter = false;
         boolean logic_a = false;
         boolean logic_explode = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double CNT6 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double rad = 0.0;
         double d = 0.0;
         double strength = 0.0;
         double HP = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 5, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
         pitch = Math.toRadians((double)entity.m_146909_());
         distance = (double)(2.0F + entity.m_20205_());
         x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            label293: {
               label292: {
                  if (entity instanceof Player) {
                     if (entity.m_6144_()) {
                        break label292;
                     }
                  } else if (GetDistanceProcedure.execute(entity) > distance + 1.0 || Math.random() < 0.25) {
                     break label292;
                  }

                  entity.getPersistentData().m_128347_("cnt2", 0.0);
                  break label293;
               }

               entity.getPersistentData().m_128347_("cnt2", 1.0);
               entity.getPersistentData().m_128347_("cnt1", 6.0);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt1") <= 5.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
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
               EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
               Vec3 var10002 = new Vec3;
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               double var74 = ((Entity)var10004).m_20185_();
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               double var75 = ((Entity)var10005).m_20186_();
               LivingEntity var10006;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var75 += (double)((Entity)var10006).m_20206_() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10006 = _mobEnt.m_5448_();
               } else {
                  var10006 = null;
               }

               var10002.<init>(var74, var75, ((Entity)var10006).m_20189_());
               entity.m_7618_(var10001, var10002);
               entity.getPersistentData().m_128379_("PRESS_Z", false);
            }

            if (entity.getPersistentData().m_128459_("cnt1") >= 4.0) {
               entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.1);
            }

            if (entity.getPersistentData().m_128471_("PRESS_Z")) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 4.0));
            }

            ChargeParticleProcedure.execute(world, entity, 0.0);
         }

         CNT6 = 1.0;
         if (entity.getPersistentData().m_128459_("cnt1") > 5.0) {
            if (entity.getPersistentData().m_128459_("cnt1") == 6.0 && entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               label316: {
                  if (entity instanceof Player) {
                     if (!entity.m_6144_()) {
                        break label316;
                     }
                  } else if (!(GetDistanceProcedure.execute(entity) > distance + 1.0)) {
                     break label316;
                  }

                  entity.getPersistentData().m_128347_("cnt2", 1.0);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               entity.getPersistentData().m_128347_("Damage", 23.0 + entity.getPersistentData().m_128459_("cnt1") * 0.1);
               entity.getPersistentData().m_128347_("Range", distance * 2.0);
               entity.getPersistentData().m_128347_("effect", 4.0);
               entity.getPersistentData().m_128347_("knockback", 0.1);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (entity.getPersistentData().m_128459_("cnt1") == 6.0) {
                  if (!(entity instanceof GeoEntity) && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity52 = (LivingEntity)entity;
                     if (_livingEntity52.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity52.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-7.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().m_128459_("cnt1") > 13.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else {
               if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
                  if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                     entity.getPersistentData().m_128347_("cnt2", 2.0);
                     entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                     entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                     entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(distance * 2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
                  } else if (entity.m_20096_()) {
                     entity.getPersistentData().m_128347_("cnt2", 2.0);
                     entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
                     entity.getPersistentData().m_128347_("y_pos", entity.m_20186_());
                     entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(90.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
                     if (entity.getPersistentData().m_128459_("cnt3") > 120.0) {
                        entity.getPersistentData().m_128347_("skill", 0.0);
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt2") >= 2.0) {
                  if (entity.getPersistentData().m_128459_("cnt2") == 2.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 1.25F, false);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                        }
                     }

                     if (!(entity instanceof GeoEntity) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity85 = (LivingEntity)entity;
                        if (_livingEntity85.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity85.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  entity.getPersistentData().m_128347_("Damage", 15.0);
                  DamageFixProcedure.execute(entity);
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  d = Math.sqrt(entity.getPersistentData().m_128459_("Damage") * 1.0);
                  logic_explode = entity.getPersistentData().m_128459_("cnt2") == (double)Math.round(13.0 + 4.0 * d * 0.2);
                  if (logic_explode) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("BlockDamage", d * 1.0);
                     entity.getPersistentData().m_128347_("BlockRange", 10.0 * d * 0.2);
                     entity.getPersistentData().m_128379_("noParticle", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     entity.getPersistentData().m_128347_("effect", 1.0);
                     entity.getPersistentData().m_128347_("Range", 20.0 * d * 0.2);
                     KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") <= (double)Math.round(3.0 + 4.0 * d * 0.2) || logic_explode) {
                     int var73;
                     label262: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var73 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label262;
                           }
                        }

                        var73 = 0;
                     }

                     HP = (double)(20 + var73 * 4);

                     for(int index0 = 0; index0 < 20; ++index0) {
                        dis = logic_explode ? 0.0 : (double)Math.round((entity.getPersistentData().m_128459_("cnt2") - 3.0) * 3.0);

                        for(int index1 = 0; index1 < (int)(logic_explode ? Math.round(4.0 * d * 0.2 * 3.0) : 3L); ++index1) {
                           logic_a = false;
                           x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * dis;
                           y_pos = entity.getPersistentData().m_128459_("y_pos");
                           z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * dis;
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              y_pos = entity.getPersistentData().m_128459_("y_pos");

                              for(int index2 = 0; index2 < (int)Math.round(dis * 2.0); ++index2) {
                                 ++y_pos;
                                 if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                              y_pos = entity.getPersistentData().m_128459_("y_pos");

                              for(int index3 = 0; index3 < (int)Math.round(dis * 2.0); ++index3) {
                                 --y_pos;
                                 if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                                    logic_a = true;
                                    break;
                                 }
                              }
                           } else {
                              logic_a = true;
                           }

                           if (logic_a) {
                              if (logic_explode) {
                                 entity.getPersistentData().m_128347_("Damage", 15.0);
                                 entity.getPersistentData().m_128347_("Range", 6.0);
                                 entity.getPersistentData().m_128347_("knockback", 1.0);
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 2, 1.0, 1.0, 1.0, 0.5);
                                 }

                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 2, 1.0, 1.0, 1.0, 0.0);
                                 }

                                 RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                                 entity.getPersistentData().m_128347_("Range", 6.0);
                                 entity.getPersistentData().m_128347_("knockback", 1.0);
                                 KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                              } else if (entity.getPersistentData().m_128459_("skill") == 2108.0) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                                 }
                              } else if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SLASH.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                              }
                           }

                           ++dis;
                        }

                        rad += Math.toRadians(18.0);
                     }
                  }

                  if (entity.getPersistentData().m_128459_("cnt2") >= (double)Math.round(23.0 + 4.0 * d * 0.2)) {
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               }
            }
         }

      }
   }
}
