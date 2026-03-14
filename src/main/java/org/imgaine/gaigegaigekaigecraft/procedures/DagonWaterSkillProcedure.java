package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonWaterSkillProcedure {
   public DagonWaterSkillProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean pitch = false;
         boolean player = false;
         boolean blood = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double strength = 0.0;
         double HP = 0.0;
         double y_velocity = 0.0;
         double y_power = 0.0;
         double level = 0.0;
         double height = 0.0;
         double distance = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         dis = ReturnEntitySizeProcedure.execute(entity);
         blood = entity.getPersistentData().m_128459_("skill") == 1016.0;
         if (!(entity instanceof MaxElephantEntity) && entity.getPersistentData().m_128459_("skill") == 805.0) {
            if (entity.getPersistentData().m_128459_("cnt4") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity88 = (LivingEntity)entity;
                  if (_livingEntity88.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity88.getAttribute_((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).m_22100_(-3.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (!(entity instanceof Player)) {
               entity.f_19789_ = 0.0F;
               y_velocity = Math.min(Math.max(y_velocity, -0.5), 0.5);
               if (!entity.m_6144_()) {
                  height = GetHeightFromGroundProcedure.execute(world, entity);
                  if (height < 10.0) {
                     y_velocity = entity.m_20184_().m_7098_() + 0.1;
                  } else if (height > 12.0) {
                     y_velocity = entity.m_20184_().m_7098_() - 0.1;
                  } else {
                     y_velocity = 0.0;
                  }
               }

               entity.m_20256_(new Vec3(entity.m_20184_().m_7096_(), y_velocity, entity.m_20184_().m_7094_()));
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() + 1.5);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21011_(InteractionHand.MAIN_HAND, true);
               }

               int var93;
               label221: {
                  x_pos = entity.getPersistentData().m_128459_("x_pos");
                  y_pos = entity.getPersistentData().m_128459_("y_pos");
                  z_pos = entity.getPersistentData().m_128459_("z_pos");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var93 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label221;
                     }
                  }

                  var93 = 0;
               }

               HP = (double)(50 + var93 * 5);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER_2.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     _serverLevel.m_7967_(entityinstance);
                  }
               }
            }

            entity.getPersistentData().m_128347_("cnt5", entity.getPersistentData().m_128459_("cnt5") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt5") < 100.0 && (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > 24.0)) {
               entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 15.0));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") <= 15.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt4", entity.getPersistentData().m_128459_("cnt4") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt4") == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               } else if (entity.getPersistentData().m_128459_("cnt4") > 60.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") < 15.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
                  }
               }

               if (blood) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, 0.0);
                  }
               } else {
                  yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
                  dis = Math.toRadians((double)entity.m_146909_());
                  x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * dis;
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(dis) * -1.0 * dis;
                  z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * dis;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)(4.0 * dis), 0.1 * dis, 0.1 * dis, 0.1 * dis, 0.0);
                  }
               }

               if (entity.getPersistentData().m_128471_("PRESS_Z") || !(entity instanceof Player) && GetDistanceProcedure.execute(entity) > 24.0) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 13.0));
               }
            } else {
               entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
               yaw = (double)(entity.m_146908_() % 360.0F);
               picth = (double)entity.m_146909_();
               entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 90.0));
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  x_pos = ((Entity)var10000).m_20185_();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  double var89 = ((Entity)var10000).m_20186_();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var89 + (double)((Entity)var10001).m_20206_() * 0.5;
                  LivingEntity var90;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var90 = _mobEnt.m_5448_();
                  } else {
                     var90 = null;
                  }

                  z_pos = ((Entity)var90).m_20189_();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
               entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
               entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
               entity.m_146922_((float)yaw);
               entity.m_146926_((float)picth);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               dis = Math.toRadians((double)entity.m_146909_());
               distance = (double)(2.0F + entity.m_20205_()) * dis;
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(dis) * distance;
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(dis) * -1.0 * distance;
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(dis) * distance;
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_WATER.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.75);
                     entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.75);
                     entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.75);
                     entityinstance.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75, entity.getPersistentData().m_128459_("z_power") * 0.75));
                     if (blood) {
                        if (entityinstance instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntSetI = (EntityWaterEntity)entityinstance;
                           _datEntSetI.m_20088_().m_135381_(EntityWaterEntity.DATA_type, 1);
                        }

                        entityinstance.getPersistentData().m_128379_("death_painting", entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 : entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:death_painting"))));
                     }

                     _serverLevel.m_7967_(entityinstance);
                  }
               }

               if (blood) {
                  int var10002;
                  label175: {
                     var91 = entity.getPersistentData().m_128459_("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label175;
                        }
                     }

                     var10002 = 0;
                  }

                  if (var91 > (double)Math.min(20 + var10002, 35)) {
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               } else {
                  int var94;
                  label180: {
                     var92 = entity.getPersistentData().m_128459_("cnt2");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var94 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label180;
                        }
                     }

                     var94 = 0;
                  }

                  if (var92 > (double)Math.min(10 + var94, 25)) {
                     entity.getPersistentData().m_128347_("skill", 0.0);
                  }
               }
            }
         }

      }
   }
}
