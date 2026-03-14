package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWater2Procedure {
   public AIWater2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_attack = false;
         boolean type = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double range = 0.0;
         double cnt1_local = 0.0;
         double rad_now = 0.0;
         double dis = 0.0;
         double cnt2 = 0.0;
         double HP = 0.0;
         if (entity.getPersistentData().m_128459_("cnt3") == 0.0) {
            logic_attack = false;
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
               if (entity.getPersistentData().m_128459_("NameRanged_ranged") == entity_a.getPersistentData().m_128459_("NameRanged") && entity_a.getPersistentData().m_128459_("skill") > 0.0 && entity_a.getPersistentData().m_128459_("cnt4") == 0.0) {
                  logic_attack = true;
                  if (!(entity_a instanceof Player)) {
                     entity.getPersistentData().m_128347_("x_power", 0.0);
                     entity.getPersistentData().m_128347_("y_power", -0.5);
                     entity.getPersistentData().m_128347_("z_power", 0.0);
                  } else {
                     entity.getPersistentData().m_128347_("x_power", entity_a.getPersistentData().m_128459_("x_power"));
                     entity.getPersistentData().m_128347_("y_power", entity_a.getPersistentData().m_128459_("y_power"));
                     entity.getPersistentData().m_128347_("z_power", entity_a.getPersistentData().m_128459_("z_power"));
                  }

                  entity.m_6021_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(entity_a.getPersistentData().m_128459_("x_pos"), entity_a.getPersistentData().m_128459_("y_pos"), entity_a.getPersistentData().m_128459_("z_pos"), entity.m_146908_(), entity.m_146909_());
                  }

                  entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               }
            }

            if (!logic_attack || !entity.m_6084_()) {
               entity.getPersistentData().m_128347_("cnt3", 1.0);
               entity.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75 + 0.5, entity.getPersistentData().m_128459_("z_power") * 0.75));
            }

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.m_146922_((float)((double)entity.m_146908_() + 22.5 * Math.random()));
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
            }
         } else {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               if (entity.getPersistentData().m_128459_("cnt1") > 5.0 && entity.m_20096_() || entity.getPersistentData().m_128459_("cnt1") > 100.0 || !entity.m_6084_()) {
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
               }
            } else {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19609_, 60, 0, false, false));
                  }
               }

               double var10000;
               int var10002;
               label97: {
                  entity.getPersistentData().m_128347_("cnt2", entity.getPersistentData().m_128459_("cnt2") + 1.0);
                  var10000 = entity.getPersistentData().m_128459_("cnt2");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10002 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label97;
                     }
                  }

                  var10002 = 0;
               }

               if (var10000 < (double)(15 + var10002)) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 15, 0.25, 0.25, 0.25, 2.0);
                  }

                  entity.getPersistentData().m_128347_("NameRanged", entity.getPersistentData().m_128459_("NameRanged_ranged"));

                  for(int index1 = 0; index1 < 2; ++index1) {
                     entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
                     entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
                     entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
                     x_pos = entity.m_20185_() + entity.m_20154_().f_82479_ * 2.0;
                     y_pos = entity.m_20186_() + entity.m_20154_().f_82480_ * 2.0;
                     z_pos = entity.m_20189_() + entity.m_20154_().f_82481_ * 2.0;
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

                           entityinstance.getPersistentData().m_128359_("OWNER_UUID", entity.getPersistentData().m_128461_("OWNER_UUID"));
                           entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 0.75);
                           entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 0.75);
                           entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 0.75);
                           entityinstance.m_20256_(new Vec3(entity.getPersistentData().m_128459_("x_power") * 0.75, entity.getPersistentData().m_128459_("y_power") * 0.75, entity.getPersistentData().m_128459_("z_power") * 0.75));
                           _serverLevel.m_7967_(entityinstance);
                        }
                     }

                     entity.m_146922_((float)((double)entity.m_146908_() + 22.5 * Math.random()));
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
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }
               } else if (!entity.m_9236_().m_5776_()) {
                  entity.m_146870_();
               }
            }
         }

      }
   }
}
