package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRika3Procedure {
   public AIRika3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double rnd = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double distance = 0.0;
         Entity entity_a = null;
         Entity target_entity = null;
         if (entity instanceof RikaEntity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         if (entity instanceof Rika2Entity) {
            PlayAnimationEntity2Procedure.execute(entity, "pure_love");
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (target_entity instanceof LivingEntity) {
            x_pos = target_entity.getX();
            y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
            z_pos = target_entity.getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
               if (entity_a instanceof Mob) {
                  Mob _mobEnt = (Mob)entity_a;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               target_entity = var10000;
               if (target_entity instanceof LivingEntity) {
                  x_pos = target_entity.getX();
                  y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
                  z_pos = target_entity.getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               } else {
                  entity.setYRot(entity_a.getYRot());
                  entity.setXRot(entity_a.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               }

               if (entity_a.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 78.0));
               }
            }
         }

         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 20, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(3.0F + entity.getBbWidth());
         entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance);
         entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * distance);
         entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
         x_pos = entity.getPersistentData().getDouble("x_pos");
         y_pos = entity.getPersistentData().getDouble("y_pos");
         z_pos = entity.getPersistentData().getDouble("z_pos");
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                  if (entity_a.getPersistentData().getDouble("NameRanged") == 0.0) {
                     entity_a.getPersistentData().putDouble("NameRanged", Math.random());
                  }

                  entity.getPersistentData().putDouble("NameRanged", entity_a.getPersistentData().getDouble("NameRanged"));
                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 100, 0, false, false));
                     }
                  }

                  if (!(entity_a instanceof Player) && entity_a instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_a;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 9, false, false));
                     }
                  }
               }
            }

            int var10001;
            label132: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label132;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(400 + var10001 * 40);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.PURE_LOVE_CANNON.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
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

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                     if (_livingEntity63.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity63.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(Math.max(4.0 * ReturnEntitySizeProcedure.execute(entity), 0.25));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity65 = (LivingEntity)entityinstance;
                     if (_livingEntity65.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity65.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt1") < 80.0) {
            if (Math.random() < 0.05 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 100.0) {
            if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
               entity.getPersistentData().putDouble("despawn_flag", 1.0);
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
