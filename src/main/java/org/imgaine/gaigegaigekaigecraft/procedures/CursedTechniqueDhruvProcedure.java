package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 3700.0);
         if (skill == 5.0) {
            SkillDhruv1Procedure.execute(world, entity);
         } else if (skill == 6.0) {
            SkillDhruv2Procedure.execute(world, entity);
         } else if (skill == 10.0) {
            old_sneak = entity.m_6144_();
            entity.m_20260_(true);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
               if (entity != entityiterator && (entityiterator instanceof ShikigamiHeterocephalusGlaberEntity || entityiterator instanceof ShikigamiPterosaurEntity) && entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entityiterator, entity);
               }
            }

            entity.m_20260_(old_sneak);
            entity.getPersistentData().m_128347_("skill", 0.0);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
