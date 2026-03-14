package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class GaragaraProcedure {
   public GaragaraProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double rad = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         entity.f_19789_ = 0.0F;
         if (entity.getPersistentData().m_128459_("cnt2") <= 1.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y + (double)entity.m_20206_() * 0.5, z, 2, 0.25, 0.5, 0.25, 0.2);
            }

            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               dis = 3.0 * ReturnEntitySizeProcedure.execute(entity);
               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
                  entity.getPersistentData().m_128347_("x_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_());
                  entity.getPersistentData().m_128347_("y_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_());
                  entity.getPersistentData().m_128347_("z_pos", (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());
               } else if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
                  entity.getPersistentData().m_128347_("cnt4", 1.0);
                  entity.getPersistentData().m_128347_("x_pos", x);
                  entity.getPersistentData().m_128347_("y_pos", y);
                  entity.getPersistentData().m_128347_("z_pos", z);
               }
            }

            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 25, 9, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_NANAMI_2.get(), x_pos, y_pos + 0.5, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity30 = (LivingEntity)entity;
                     if (_livingEntity30.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity30.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity31 = (LivingEntity)entity;
                     if (_livingEntity31.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity31.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).m_22100_(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  entity.getPersistentData().m_128347_("cnt2", 2.0);
                  if (entity.getPersistentData().m_128459_("cnt4") == 1.0) {
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
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
            x_pos = entity.getPersistentData().m_128459_("x_pos");
            y_pos = entity.getPersistentData().m_128459_("y_pos");
            z_pos = entity.getPersistentData().m_128459_("z_pos");
            if (entity.getPersistentData().m_128459_("cnt2") <= 8.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 25, 0.7, 0.2, 0.7, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 50, 0.7, 0.2, 0.7, 1.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 50, 0.7, 0.2, 0.7, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().m_128347_("Damage", 27.0);
               entity.getPersistentData().m_128347_("Range", 6.0);
               entity.getPersistentData().m_128347_("knockback", 1.5);
               entity.getPersistentData().m_128379_("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            } else {
               entity.getPersistentData().m_128379_("attack", false);
            }

            if (entity.getPersistentData().m_128459_("cnt2") < 11.0) {
               for(int index0 = 0; index0 < 20; ++index0) {
                  dis = (entity.getPersistentData().m_128459_("cnt2") - 3.0) * 3.0;

                  for(int index1 = 0; index1 < 3; ++index1) {
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
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 6, 0.5, 0.25, 0.5, 0.1);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.2);
                        }
                     }

                     ++dis;
                  }

                  rad += Math.toRadians(18.0);
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") >= 20.0 && entity.getPersistentData().m_128459_("cnt2") <= 30.0 && entity.getPersistentData().m_128459_("cnt2") % 3.0 == 2.0) {
               int var10001;
               label239: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label239;
                     }
                  }

                  var10001 = 0;
               }

               HP = (double)(40 + var10001 * 8);
               if (entity.getPersistentData().m_128459_("NameRanged") == 0.0) {
                  entity.getPersistentData().m_128347_("NameRanged", Math.random());
               }

               entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);

               for(int index4 = 0; index4 < 72; ++index4) {
                  dis = (entity.getPersistentData().m_128459_("cnt3") - 0.5) * 6.0;
                  logic_a = false;
                  x_pos = entity.getPersistentData().m_128459_("x_pos") + Math.cos(rad) * dis;
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos") + Math.sin(rad) * dis;
                  if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                     y_pos = entity.getPersistentData().m_128459_("y_pos");

                     for(int index5 = 0; index5 < (int)Math.round(dis * 2.0); ++index5) {
                        ++y_pos;
                        if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                           logic_a = true;
                           break;
                        }
                     }
                  } else if (!world.m_8055_(BlockPos.m_274561_(x_pos, y_pos - 1.0, z_pos)).m_60815_()) {
                     y_pos = entity.getPersistentData().m_128459_("y_pos");

                     for(int index6 = 0; index6 < (int)Math.round(dis * 2.0); ++index6) {
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
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, 6, 0.5, 0.5, 0.5, 0.2);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, 6, 0.5, 0.5, 0.5, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 6, 0.5, 0.5, 0.5, 0.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 0.02F, 1.0F);
                        } else {
                           _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.NEUTRAL, 0.02F, 1.0F, false);
                        }
                     }

                     entity.getPersistentData().m_128347_("Damage", 15.0);
                     entity.getPersistentData().m_128347_("Range", 6.0);
                     entity.getPersistentData().m_128347_("knockback", 1.0);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (Math.random() < 0.1) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 1.0);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_254849_((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROCK_FRAGMENT.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                              SetRangedAmmoProcedure.execute(entity, entityinstance);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity94 = (LivingEntity)entityinstance;
                                 if (_livingEntity94.m_21204_().m_22171_(Attributes.f_22276_)) {
                                    _livingEntity94.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.m_21153_((float)HP);
                              }

                              entityinstance.m_20256_(new Vec3((Math.random() - 0.5) * 3.0, Math.random() * 1.5 + 0.75, (Math.random() - 0.5) * 3.0));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity100 = (LivingEntity)entityinstance;
                                 if (_livingEntity100.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    _livingEntity100.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(Math.random() + 1.0);
                                 }
                              }

                              _serverLevel.m_7967_(entityinstance);
                           }
                        }
                     }
                  }

                  rad += Math.random() * 10.0;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt2") > 60.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

         entity.getPersistentData().m_128379_("attack", true);
      }
   }
}
