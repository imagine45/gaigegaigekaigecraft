package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.HoshiKiraraEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SummonRabbitEscapeProcedure {
   public SummonRabbitEscapeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double NUM_SUM = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (!(entity instanceof Player) && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            entity.getPersistentData().putDouble("cnt4", 0.025);
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 5.0 && entity.getPersistentData().getDouble("cnt1") < 26.0) {
            yaw = (double)entity.getYRot();
            picth = (double)entity.getXRot();
            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.setYRot((float)(yaw + Math.random() * 180.0 - 90.0));
               entity.setXRot((float)(Math.random() * 22.5 - 11.25));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               dis = 1.0 + Math.random() * 5.0;
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + Math.random() - 0.5;
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + Math.random() - 0.5;
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + Math.random() - 0.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 10, 0.25, 0.25, 0.25, 0.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.RABBIT_ESCAPE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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

                     label106: {
                        label137: {
                           entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                           entityinstance.getPersistentData().putDouble("friend_num2", entity.getPersistentData().getDouble("friend_num"));
                           if (entity.getPersistentData().getDouble("TenShadowsTechnique8") != 1.0) {
                              if (!(entity instanceof ServerPlayer)) {
                                 break label137;
                              }

                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (!(_plr31.level() instanceof ServerLevel) || !_plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_rabbit_escape"))).isDone()) {
                                 break label137;
                              }
                           }

                           entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                           entityinstance.getPersistentData().putBoolean("Ambush", true);
                           entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                           entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                           entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                           break label106;
                        }

                        entityinstance.getPersistentData().putString("TARGET_UUID", entity.getStringUUID());
                        entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     }

                     if (entity instanceof Player) {
                        entityinstance.getPersistentData().putDouble("BaseCursePower", Math.max(Math.floor(entity.getPersistentData().getDouble("cnt10") / 40.0), 1.0));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            entity.setYRot((float)yaw);
            entity.setXRot((float)picth);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 25.0) {
               entity.getPersistentData().putDouble("TenShadowsTechnique8", -1.0);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 35.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
               if (entityiterator instanceof HoshiKiraraEntity) {
                  entityiterator.lookAt(Anchor.EYES, new Vec3(x, y, z));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.HEART, entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight(), entityiterator.getZ(), 1, 0.0, 0.0, 0.0, 0.0);
                  }
               }
            }
         }

      }
   }
}
