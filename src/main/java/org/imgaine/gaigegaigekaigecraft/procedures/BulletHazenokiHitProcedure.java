package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.BulletEyeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletHazenokiHitProcedure {
   public BulletHazenokiHitProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         double HP = 0.0;
         CNT6 = 1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1;
         range = (1.0 + ReturnEntitySizeProcedure.execute(immediatesourceentity)) * CNT6;
         old_skill = entity.getPersistentData().getDouble("skill");
         entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
         if (immediatesourceentity instanceof BulletEyeEntity) {
            HP = 40.0;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_IMPACT_WAVE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity7 = (LivingEntity)entityinstance;
                     if (_livingEntity7.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity7.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  entityinstance.getPersistentData().putDouble("cnt6", immediatesourceentity.getPersistentData().getDouble("cnt6"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity14 = (LivingEntity)entityinstance;
                     if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                     }
                  }

                  if (entityinstance instanceof EntityImpactWaveEntity) {
                     EntityImpactWaveEntity animatable = (EntityImpactWaveEntity)entityinstance;
                     animatable.setTexture("clear");
                  }

                  if (entityinstance instanceof EntityImpactWaveEntity) {
                     EntityImpactWaveEntity _datEntSetI = (EntityImpactWaveEntity)entityinstance;
                     _datEntSetI.getEntityData().set(EntityImpactWaveEntity.DATA_mode, 1);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         } else {
            entity.getPersistentData().putDouble("BlockDamage", 6.0 * CNT6);
            entity.getPersistentData().putDouble("BlockRange", 6.0 * range);
            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("Damage", immediatesourceentity.getPersistentData().getDouble("Damage"));
            entity.getPersistentData().putDouble("knockback", 0.5 * CNT6);
            entity.getPersistentData().putDouble("Range", 12.0 * range);
            entity.getPersistentData().putBoolean("attack", false);
            RangeAttackProcedure.execute(world, x, y, z, entity);
         }

         entity.getPersistentData().putDouble("skill", old_skill);
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * CNT6), 0.8F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ " + range * 2.0 + " " + range * 2.0 + " " + range * 2.0 + " " + 0.5 * CNT6 + " " + Math.round(20.0 * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_big_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 0.5 * CNT6 + " " + Math.round(20.0 * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.0 * CNT6 + " " + Math.round(10.0 * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:large_smoke ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 1.0 * CNT6 + " " + Math.round(10.0 * CNT6 * range) + " force");
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
