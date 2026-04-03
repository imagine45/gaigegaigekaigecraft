package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityCrackOnEntityTickUpdateProcedure {
   public EntityCrackOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            entity.getPersistentData().putDouble("cnt3", 1.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         if (entity_a instanceof LivingEntity) {
            if (entity_a.getPersistentData().getDouble("skill") <= 0.0) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
         }

         if (entity.getPersistentData().getDouble("cnt3") > 20.0 && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
