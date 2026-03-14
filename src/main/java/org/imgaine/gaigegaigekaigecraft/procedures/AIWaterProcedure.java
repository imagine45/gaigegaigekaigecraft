package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWaterProcedure {
   public AIWaterProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         double rnd = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double size = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range = 0.0;
         double speed = 0.0;
         if (entity.getPersistentData().m_128459_("skill") == 1016.0) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 1);
            }
         } else if (entity.getPersistentData().m_128459_("skill") == 409.0) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 2);
            }
         } else if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
            _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 0);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)(entity.m_20206_() * 0.0F);
         z_pos = entity.m_20189_();
         x_power = entity.m_20184_().m_7096_();
         y_power = entity.m_20184_().m_7098_();
         z_power = entity.m_20184_().m_7094_();
         speed = Math.max(Math.min(Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power), 2.0), -2.0);
         int var10000;
         if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
         } else {
            var10000 = 0;
         }

         if (var10000 == 2) {
            ParticleGeneratorProcedure.execute(world, range * 1.0, 1.0 * range, 25.0, 2.0 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_magma");
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_blood_2");
               if (entity.m_20071_() && !entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            } else {
               ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_water_2");
               ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_water");
            }
         }

         if (entity.m_6084_()) {
            size = ReturnEntitySizeProcedure.execute(entity);
            entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
            entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               entity.getPersistentData().m_128347_("Damage", 9.0);
               entity.getPersistentData().m_128347_("Range", 5.0 + size);
               entity.getPersistentData().m_128347_("effect", 10.0);
               entity.getPersistentData().m_128347_("knockback", 0.5);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)(entity.m_20206_() / 2.0F), entity.m_20189_(), entity);
            } else {
               entity.getPersistentData().m_128347_("Damage", 7.0);
               entity.getPersistentData().m_128347_("Range", 5.0 + size);
               CompoundTag var78 = entity.getPersistentData();
               int var10002;
               if (entity instanceof EntityWaterEntity) {
                  EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                  var10002 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
               } else {
                  var10002 = 0;
               }

               var78.m_128347_("effect", (double)(var10002 == 1 ? 11 : 0));
               entity.getPersistentData().m_128347_("knockback", 0.5);
               RangeAttackProcedure.execute(world, entity.m_20185_(), entity.m_20186_() + (double)(entity.m_20206_() / 2.0F), entity.m_20189_(), entity);
            }

            if (entity.getPersistentData().m_128459_("NameRanged_ranged") != 0.0 && entity.m_20096_()) {
               x_power = entity.m_20185_() + entity.m_20184_().m_7096_() * 16.0;
               y_power = entity.m_20186_() + (double)(entity.m_20206_() / 2.0F) + entity.m_20184_().m_7098_() * 16.0;
               z_power = entity.m_20189_() + entity.m_20184_().m_7094_() * 16.0;
               RotateEntityProcedure.execute(x_power, y_power, z_power, entity);
               logic_b = false;
               if (entity.getPersistentData().m_128459_("cnt_x2") > 10.0) {
                  entity.getPersistentData().m_128347_("cnt_x2", Math.random() * 5.0);
                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 2) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.m_5776_()) {
                           _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (Math.random() < 0.1) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.m_5776_()) {
                              _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().m_128347_("BlockRange", 3.0);
                        entity.getPersistentData().m_128347_("BlockDamage", 2.0);
                        entity.getPersistentData().m_128379_("noParticle", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 != 0 && entity.getPersistentData().m_128459_("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
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
                     if (entity.getPersistentData().m_128459_("friend_num") == entity_a.getPersistentData().m_128459_("friend_num")) {
                        logic_b = true;
                        entity.getPersistentData().m_128347_("x_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123341_());
                        entity.getPersistentData().m_128347_("y_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123342_());
                        entity.getPersistentData().m_128347_("z_pos", (double)entity_a.m_9236_().m_45547_(new ClipContext(entity_a.m_20299_(1.0F), entity_a.m_20299_(1.0F).m_82549_(entity_a.m_20252_(1.0F).m_82490_(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).m_82425_().m_123343_());
                        GetPowerForwardProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        RotateEntityProcedure.execute(entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
                        entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.5, entity.getPersistentData().m_128459_("y_power") * 0.75 + 0.25, entity.getPersistentData().m_128459_("z_power") * 0.5));
                     }
                  }
               }

               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() == Type.BLOCK) {
                  yaw = (double)entity.m_146908_();
                  pitch = 0.0;
                  rnd = 10.0;
                  logic_a = false;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.m_146922_((float)(yaw + (Math.random() - 0.5) * rnd));
                        entity.m_146926_((float)(pitch + (Math.random() - 0.5) * rnd));
                        entity.m_5618_(entity.m_146908_());
                        entity.m_5616_(entity.m_146908_());
                        entity.f_19859_ = entity.m_146908_();
                        entity.f_19860_ = entity.m_146909_();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(2.0)), Block.OUTLINE, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                           logic_a = true;
                           break;
                        }
                     }

                     if (logic_a) {
                        break;
                     }

                     rnd += 10.0;
                  }

                  entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                  entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                  entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               }

               if (logic_a || !logic_b) {
                  entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75, entity.getPersistentData().m_128459_("z_power") * 0.75));
               }
            }

            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 != 0) {
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().m_128459_("cnt_x") > 80.0) {
               entity.m_6469_(new DamageSource(world.m_9598_().m_175515_(Registries.f_268580_).m_246971_(DamageTypes.f_268433_)), 9999.0F);
            }
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123744_, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123796_, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
