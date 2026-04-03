package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillRozetsuShikigami2Procedure {
   public SkillRozetsuShikigami2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double mode = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
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
         x_pos = entity.getX() + Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians((double)entity.getXRot())) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians((double)entity.getXRot())) * distance;
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ROZETSU_SHIKIGAMI_VESSEL.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               entityinstance.setYRot(entity.getYRot());
               entityinstance.setXRot(entity.getXRot());
               entityinstance.setYBodyRot(entityinstance.getYRot());
               entityinstance.setYHeadRot(entityinstance.getYRot());
               entityinstance.yRotO = entityinstance.getYRot();
               entityinstance.xRotO = entityinstance.getXRot();
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity28 = (LivingEntity)entityinstance;
                  if (_livingEntity28.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     AttributeInstance var10000;
                     double var10001;
                     label97: {
                        var10000 = _livingEntity28.getAttribute(Attributes.ATTACK_DAMAGE);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity24 = (LivingEntity)entityinstance;
                           if (_livingEntity24.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10001 = _livingEntity24.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label97;
                           }
                        }

                        var10001 = 0.0;
                     }

                     double var10002;
                     label92: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity25 = (LivingEntity)entity;
                           if (_livingEntity25.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10002 = _livingEntity25.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label92;
                           }
                        }

                        var10002 = 0.0;
                     }

                     int var10003;
                     label87: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label87;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var46;
                     MobEffect var47;
                     int var10005;
                     label76: {
                        var47 = MobEffects.DAMAGE_RESISTANCE;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                              break label76;
                           }
                        }

                        var10005 = 0;
                     }

                     var46 = new MobEffectInstance(var47, 2147483647, Math.max(var10005, 0), false, false);
                     _entity.addEffect(var46);
                  }
               }

               entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
               entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
               entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
               entityinstance.getPersistentData().putBoolean("CursedSpirit", true);
               entityinstance.getPersistentData().putBoolean("Shikigami", true);
               if (entity instanceof Player) {
                  entityinstance.getPersistentData().putDouble("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
               }

               _serverLevel.addFreshEntity(entityinstance);
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

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.flap")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
            }
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
