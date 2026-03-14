package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRozetsuShikigamiProcedure {
   public SkillRozetsuShikigamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double mode = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double distance = 0.0;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity instanceof Player) {
            if (entity.m_6144_()) {
               mode = 1.0;
            } else {
               mode = 0.0;
            }
         } else if (Math.random() < 0.5) {
            mode = 0.0;
         } else if (Math.random() < 0.5) {
            mode = 1.0;
         } else {
            mode = 2.0;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21011_(InteractionHand.MAIN_HAND, true);
         }

         if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
            entity.getPersistentData().m_128347_("friend_num", Math.random());
         }

         yaw = (double)entity.m_146908_();
         pitch = (double)entity.m_146909_();
         distance = (double)(1.0F + entity.m_20205_());

         for(int index0 = 0; index0 < 3; ++index0) {
            entity.m_146922_((float)(yaw + (Math.random() - 0.5) * 40.0));
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

            x_pos = entity.m_20185_() + Math.cos(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * distance;
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.m_20189_() + Math.sin(Math.toRadians((double)(entity.m_146908_() + 90.0F))) * Math.cos(Math.toRadians((double)entity.m_146909_())) * distance;
            if (mode == 1.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(entity.m_146908_());
                     entityToSpawn.m_5618_(entity.m_146908_());
                     entityToSpawn.m_5616_(entity.m_146908_());
                     entityToSpawn.m_146926_(entity.m_146909_());
                  }
               }
            } else if (mode == 2.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL_2.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.m_146922_(entity.m_146908_());
                     entityToSpawn.m_5618_(entity.m_146908_());
                     entityToSpawn.m_5616_(entity.m_146908_());
                     entityToSpawn.m_146926_(entity.m_146909_());
                  }
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI.get()).m_262496_(_level, BlockPos.m_274561_(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.m_146922_(entity.m_146908_());
                  entityToSpawn.m_5618_(entity.m_146908_());
                  entityToSpawn.m_5616_(entity.m_146908_());
                  entityToSpawn.m_146926_(entity.m_146909_());
               }
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if ((mode == 0.0 && entityiterator instanceof RozetsuShikigamiEntity || mode == 1.0 && entityiterator instanceof RozetsuShikigamiVesselEntity || mode == 2.0 && entityiterator instanceof RozetsuShikigamiVessel2Entity) && entityiterator.getPersistentData().m_128459_("friend_num") == 0.0) {
                  entityiterator.getPersistentData().m_128359_("OWNER_UUID", entity.m_20149_());
                  if (mode == 2.0) {
                     entity.getPersistentData().m_128359_("SHIKIGAMI_ROZETSU_UUID", entityiterator.m_20149_());
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity39 = (LivingEntity)entityiterator;
                     if (_livingEntity39.m_21204_().m_22171_(Attributes.f_22281_)) {
                        AttributeInstance var10000;
                        double var10001;
                        label159: {
                           var10000 = _livingEntity39.getAttribute_(Attributes.f_22281_);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity36 = (LivingEntity)entityiterator;
                              if (_livingEntity36.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var10001 = _livingEntity36.getAttribute_(Attributes.f_22281_).m_22115_();
                                 break label159;
                              }
                           }

                           var10001 = 0.0;
                        }

                        double var10002;
                        label154: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity37 = (LivingEntity)entity;
                              if (_livingEntity37.m_21204_().m_22171_(Attributes.f_22281_)) {
                                 var10002 = _livingEntity37.getAttribute_(Attributes.f_22281_).m_22115_();
                                 break label154;
                              }
                           }

                           var10002 = 0.0;
                        }

                        int var10003;
                        label149: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var10003 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label149;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.m_22100_(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.m_9236_().m_5776_()) {
                        MobEffectInstance var52;
                        MobEffect var53;
                        int var10005;
                        label138: {
                           var52 = new MobEffectInstance;
                           var53 = MobEffects.f_19606_;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                 var10005 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                 break label138;
                              }
                           }

                           var10005 = 0;
                        }

                        var52.<init>(var53, 2147483647, Math.max(var10005, 0), false, false);
                        _entity.m_7292_(var52);
                     }
                  }

                  entityiterator.getPersistentData().m_128347_("friend_num", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.getPersistentData().m_128347_("friend_num_worker", entity.getPersistentData().m_128459_("friend_num"));
                  entityiterator.getPersistentData().m_128379_("Shikigami", true);
                  entityiterator.getPersistentData().m_128379_("Player", entity instanceof Player || entity.getPersistentData().m_128471_("Player"));
                  entityiterator.getPersistentData().m_128379_("JujutsuSorcerer", entity.getPersistentData().m_128471_("JujutsuSorcerer"));
                  entityiterator.getPersistentData().m_128379_("CurseUser", entity.getPersistentData().m_128471_("CurseUser"));
                  entityiterator.getPersistentData().m_128379_("CursedSpirit", true);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123771_, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123771_, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, 0.25);
            }

            if (mode != 0.0) {
               break;
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.m_5776_()) {
               _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

         entity.getPersistentData().m_128347_("skill", 0.0);
      }
   }
}
