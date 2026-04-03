package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade01Entity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MahitoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ZeninMakiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ReturnEnergyColorProcedure {
   public ReturnEnergyColorProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double T1 = 0.0;
         double T2 = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
               return 2.0;
            }
         }

         if (!(entity instanceof CursedSpiritGrade01Entity)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  return 4.0;
               }
            }

            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars = null;
               if (entity instanceof Player) {
                  pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
               }

               T1 = pVars.PlayerCurseTechnique;
               T2 = pVars.PlayerCurseTechnique2;
               if (pVars.PlayerCursePowerMAX <= 150.0) {
                  return 0.0;
               }

               if (T1 == 5.0 || T2 == 5.0) {
                  return 3.0;
               }

               if (T1 == 4.0 || T2 == 4.0 || T1 == 15.0 || T2 == 15.0 || T1 == 43.0 || T2 == 43.0) {
                  return 5.0;
               }
            } else {
               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power"))) || entity instanceof ZeninMakiEntity) {
                  return 0.0;
               }

               if (entity instanceof OkkotsuYutaEntity || entity instanceof OkkotsuYutaCullingGameEntity || entity instanceof RikaEntity || entity instanceof Rika2Entity) {
                  return 3.0;
               }

               if (entity instanceof RozetsuEntity || entity instanceof RozetsuShikigamiEntity || entity instanceof RozetsuShikigamiVessel2Entity || entity instanceof RozetsuShikigamiVesselEntity || entity instanceof JogoEntity || entity instanceof MahitoEntity) {
                  return 5.0;
               }
            }

            return 1.0;
         } else {
            return 2.0;
         }
      }
   }
}
