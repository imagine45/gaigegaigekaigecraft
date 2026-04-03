package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedTechniqueDhruvProcedure {
   public CursedTechniqueDhruvProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         double NUM_SUM = 0.0;
         double NUM_SUM_TRUE = 0.0;
         double NUM1 = 0.0;
         boolean old_sneak = false;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 3700.0);
         if (skill == 5.0) {
            SkillDhruv1Procedure.execute(world, entity);
         } else if (skill == 6.0) {
            SkillDhruv2Procedure.execute(world, entity);
         } else if (skill == 10.0) {
            old_sneak = entity.isShiftKeyDown();
            entity.setShiftKeyDown(true);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
               if (entity != entityiterator && (entityiterator instanceof ShikigamiHeterocephalusGlaberEntity || entityiterator instanceof ShikigamiPterosaurEntity) && entity.getStringUUID().equals(entityiterator.getPersistentData().getString("OWNER_UUID"))) {
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entityiterator, entity);
               }
            }

            entity.setShiftKeyDown(old_sneak);
            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
