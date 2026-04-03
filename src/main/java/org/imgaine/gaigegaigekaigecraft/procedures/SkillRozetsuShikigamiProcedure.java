package org.imgaine.gaigegaigekaigecraft.procedures;

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
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof Player) {
            if (entity.isShiftKeyDown()) {
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
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         yaw = (double)entity.getYRot();
         pitch = (double)entity.getXRot();
         distance = (double)(1.0F + entity.getBbWidth());

         for(int index0 = 0; index0 < 3; ++index0) {
            entity.setYRot((float)(yaw + (Math.random() - 0.5) * 40.0));
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            x_pos = entity.getX() + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians((double)entity.getXRot())) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians((double)entity.getXRot())) * distance;
            if (mode == 1.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(entity.getYRot());
                     entityToSpawn.setYBodyRot(entity.getYRot());
                     entityToSpawn.setYHeadRot(entity.getYRot());
                     entityToSpawn.setXRot(entity.getXRot());
                  }
               }
            } else if (mode == 2.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL_2.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                  if (entityToSpawn != null) {
                     entityToSpawn.setYRot(entity.getYRot());
                     entityToSpawn.setYBodyRot(entity.getYRot());
                     entityToSpawn.setYHeadRot(entity.getYRot());
                     entityToSpawn.setXRot(entity.getXRot());
                  }
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(entity.getYRot());
                  entityToSpawn.setYBodyRot(entity.getYRot());
                  entityToSpawn.setYHeadRot(entity.getYRot());
                  entityToSpawn.setXRot(entity.getXRot());
               }
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
               if ((mode == 0.0 && entityiterator instanceof RozetsuShikigamiEntity || mode == 1.0 && entityiterator instanceof RozetsuShikigamiVesselEntity || mode == 2.0 && entityiterator instanceof RozetsuShikigamiVessel2Entity) && entityiterator.getPersistentData().getDouble("friend_num") == 0.0) {
                  entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  if (mode == 2.0) {
                     entity.getPersistentData().putString("SHIKIGAMI_ROZETSU_UUID", entityiterator.getStringUUID());
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity39 = (LivingEntity)entityiterator;
                     if (_livingEntity39.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        AttributeInstance var10000;
                        double var10001;
                        label159: {
                           var10000 = _livingEntity39.getAttribute(Attributes.ATTACK_DAMAGE);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity36 = (LivingEntity)entityiterator;
                              if (_livingEntity36.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var10001 = _livingEntity36.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label159;
                              }
                           }

                           var10001 = 0.0;
                        }

                        double var10002;
                        label154: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity37 = (LivingEntity)entity;
                              if (_livingEntity37.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var10002 = _livingEntity37.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label154;
                              }
                           }

                           var10002 = 0.0;
                        }

                        int var10003;
                        label149: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label149;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var52;
                        MobEffect var53;
                        int var10005;
                        label138: {
                           var53 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label138;
                              }
                           }

                           var10005 = 0;
                        }

                        var52 = new MobEffectInstance(var53, 2147483647, Math.max(var10005, 0), false, false);
                        _entity.addEffect(var52);
                     }
                  }

                  entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.getPersistentData().putBoolean("Shikigami", true);
                  entityiterator.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                  entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityiterator.getPersistentData().putBoolean("CursedSpirit", true);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.WITCH, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.WITCH, x_pos, y_pos, z_pos, 15, 0.2, 0.2, 0.2, 0.25);
            }

            if (mode != 0.0) {
               break;
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         entity.setYRot((float)yaw);
         entity.setXRot((float)pitch);
         entity.setYBodyRot(entity.getYRot());
         entity.setYHeadRot(entity.getYRot());
         entity.yRotO = entity.getYRot();
         entity.xRotO = entity.getXRot();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.yBodyRotO = _entity.getYRot();
            _entity.yHeadRotO = _entity.getYRot();
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
