package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class Effect11Procedure {
   public Effect11Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("minecraft:skeletons")))) {
            if (!(entity instanceof EntityWaterEntity)) {
               world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), Block.getId(Blocks.BONE_BLOCK.defaultBlockState()));
            }
         } else if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
            if (!(entity instanceof EntityWaterEntity)) {
               Effect1Procedure.execute(world, entity, entityiterator);
            }

            if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))) || entity.getPersistentData().getBoolean("death_painting") || entity.getPersistentData().getBoolean("CursedSpirit")) {
               int var10000;
               label44: {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entityiterator;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getDuration();
                        break label44;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 < 1200 && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10004;
                     label36: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get();
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get()).getDuration();
                              break label36;
                           }
                        }

                        var10004 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, Math.min(var10004 + 400, 1200), 0);
                     _entity.addEffect(var10001);
                  }
               }
            }
         }

      }
   }
}
