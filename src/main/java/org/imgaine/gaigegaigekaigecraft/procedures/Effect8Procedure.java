package org.imgaine.gaigegaigekaigecraft.procedures;

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
import net.minecraftforge.registries.ForgeRegistries;

public class Effect8Procedure {
   public Effect8Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entityiterator) {
      if (entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CLAWS.get(), x_pos, y_pos, z_pos, 1, 0.2, 0.2, 0.2, 0.0);
         }

         if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:skeletons"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
            if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_PURPLE.get(), x_pos, y_pos, z_pos, 3, 0.2, 0.2, 0.2, 0.25);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 3, 0.2, 0.2, 0.2, 0.25);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
               }
            }
         }

      }
   }
}
