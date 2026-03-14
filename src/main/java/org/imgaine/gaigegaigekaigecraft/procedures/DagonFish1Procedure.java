package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DagonFish1Procedure {
   public DagonFish1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double damage = 0.0;
         double HP = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean target = false;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().m_128459_("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 4, false, false));
            }
         }

         int var10001;
         label153: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                  var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                  break label153;
               }
            }

            var10001 = 0;
         }

         HP = (double)(10 + var10001 * 2);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity;
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0 && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

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

            double var65 = ((Entity)var10000).m_20186_();
            LivingEntity var71;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var71 = _mobEnt.m_5448_();
            } else {
               var71 = null;
            }

            y_pos = var65 + (double)((Entity)var71).m_20206_() * 0.5;
            LivingEntity var66;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var66 = _mobEnt.m_5448_();
            } else {
               var66 = null;
            }

            z_pos = ((Entity)var66).m_20189_();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         yaw = (double)entity.m_146908_();
         picth = (double)entity.m_146909_();
         if (target) {
            entity.getPersistentData().m_128379_("PRESS_Z", false);
            if (GetDistanceProcedure.execute(entity) > 8.0) {
               label161: {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().m_128459_("skill") != 0.0) {
                     label162: {
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
                              break label162;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("Damage") != 0.0) {
                           break label161;
                        }
                     }
                  }

                  entity.getPersistentData().m_128379_("PRESS_Z", true);
               }
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.fish.swim")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         for(int index0 = 0; index0 < 4; ++index0) {
            entity.m_146922_((float)(yaw + (67.5 + Math.random() * 45.0) * (double)(Math.random() < 0.5 ? -1 : 1)));
            entity.m_146926_((float)(0.0 - Math.random() * 67.5));
            entity.m_5618_(entity.m_146908_());
            entity.m_5616_(entity.m_146908_());
            entity.f_19859_ = entity.m_146908_();
            entity.f_19860_ = entity.m_146909_();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.f_20884_ = _entity.m_146908_();
               _entity.f_20886_ = _entity.m_146908_();
            }

            x_pos = entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * (double)(1.0F + entity.m_20205_());
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5 + Math.sin(Math.toRadians((double)entity.m_146909_())) * -1.0 * (double)(1.0F + entity.m_20205_());
            z_pos = entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * (double)(1.0F + entity.m_20205_());
            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 3.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 3.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 3.0);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.SEA_SERPENT_MINI.get()).m_262451_(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                     LivingEntity _livingEntity58 = (LivingEntity)entityinstance;
                     if (_livingEntity58.m_21204_().m_22171_(Attributes.f_22276_)) {
                        _livingEntity58.getAttribute_(Attributes.f_22276_).m_22100_(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.m_21153_((float)HP);
                  }

                  entityinstance.getPersistentData().m_128347_("movement", 1.0);
                  entityinstance.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") * 1.0);
                  entityinstance.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") * 1.0);
                  entityinstance.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") * 1.0);
                  entityinstance.getPersistentData().m_128347_("cnt1", (double)Math.round(Math.random() * -30.0));
                  entityinstance.m_20256_(new Vec3(entityinstance.getPersistentData().m_128459_("x_power"), entityinstance.getPersistentData().m_128459_("y_power"), entityinstance.getPersistentData().m_128459_("z_power")));
                  entityinstance.getPersistentData().m_128347_("speed", 1.0);
                  _serverLevel.m_7967_(entityinstance);
               }
            }
         }

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

         if (entity.getPersistentData().m_128459_("cnt1") > 6.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         entity.getPersistentData().m_128347_("Damage", 0.1);
      }
   }
}
