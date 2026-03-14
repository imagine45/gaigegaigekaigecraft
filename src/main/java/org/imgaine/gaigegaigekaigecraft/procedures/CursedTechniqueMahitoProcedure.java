package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueMahitoProcedure {
   public CursedTechniqueMahitoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 1503.0) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1504.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1505.0) {
            IdleTransfigurationProcedure.execute(world, entity);
         } else if (skill == 1506.0) {
            TechniqueMahitoHand3Procedure.execute(world, entity);
         } else if (skill == 1507.0) {
            MahitoGunProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1508.0) {
            TechniqueBodyRepelSingleProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1509.0) {
            TechniqueBodyRepelProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1510.0) {
            TechniquePolymorphicSoulIsomerProcedure.execute(world, entity);
         } else if (skill == 1515.0) {
            InstantSpiritBodyofDistortedKillingProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1516.0) {
            AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1520.0) {
            SelfEmbodimentOfPerfectionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Mahito"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
