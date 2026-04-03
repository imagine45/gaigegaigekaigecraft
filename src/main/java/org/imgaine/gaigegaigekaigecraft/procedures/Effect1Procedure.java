package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect1Procedure {
   public Effect1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         boolean living = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double amount = 0.0;
         Entity entity_a = null;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:skeletons")))) {
               if (!entityiterator.isAlive()) {
                  world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
               }
            } else {
               if (!entityiterator.isAlive()) {
                  amount = 10.0;
               } else {
                  amount = 0.5;
               }

               if (Math.random() < amount) {
                  if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), x_pos, y_pos, z_pos, (int)(amount * 2.0), 0.2, 0.2, 0.2, 0.25);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(amount * 2.0), 0.2, 0.2, 0.2, 0.25);
                  }
               }
            }

            if (entity instanceof CrowEntity && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.75F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.75F, 1.0F, false);
               }
            }
         }

         if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
            entity.getPersistentData().putDouble("cnt_attack", -20.0);
         }

      }
   }
}
