package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade37Entity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;

public class FushiguroTojiEntityDiesProcedure {
   public FushiguroTojiEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            if (entity instanceof FushiguroTojiEntity) {
               rnd = Math.ceil(Math.random() * 3.0);
               if (rnd == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.SPLIT_SOUL_KATANA.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }
               } else if (rnd == 2.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()));
                     entityToSpawn.setPickUpDelay(10);
                     _level.addFreshEntity(entityToSpawn);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get()));
                  entityToSpawn.setPickUpDelay(10);
                  _level.addFreshEntity(entityToSpawn);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack((ItemLike)JujutsucraftModItems.PLAYFUL_CLOUD.get()));
               entityToSpawn.setPickUpDelay(10);
               _level.addFreshEntity(entityToSpawn);
            }
         }

         if (entity instanceof FushiguroTojiEntity) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_37.get()).spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
               if (entityToSpawn != null) {
                  entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
               }
            }

            if (!world.getEntitiesOfClass(CursedSpiritGrade37Entity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).isEmpty()) {
               Entity var22 = (Entity)world.getEntitiesOfClass(CursedSpiritGrade37Entity.class, AABB.ofSize(new Vec3(x, y, z), 4.0, 4.0, 4.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x, y, z)).findFirst().orElse((CursedSpiritGrade37Entity) null);
               if (var22 instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)var22;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 5, 9, false, false));
                  }
               }
            }
         }

      }
   }
}
