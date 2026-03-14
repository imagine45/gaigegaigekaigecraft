package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CursedToolsAbility2Procedure {
   public CursedToolsAbility2Procedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double power = 0.0;
         ItemStack mainHandItem = ItemStack.f_41583_;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         SetAttributeMainhandProcedure.execute(var10000);
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         mainHandItem = var10000.m_41777_();
         if (entity.getPersistentData().m_128471_("attack")) {
            if (mainHandItem.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               if (mainHandItem.m_41784_().m_128459_("Power") != 0.0) {
                  if (mainHandItem.m_41784_().m_128459_("Power") > 0.0) {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (1.0 + mainHandItem.m_41784_().m_128459_("Power") * Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") * 0.2, 1.0), 0.0)));
                  } else {
                     entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (1.0 + mainHandItem.m_41784_().m_128459_("Power")));
                  }
               }

               if (mainHandItem.m_41784_().m_128459_("Knockback") != 0.0) {
                  if (mainHandItem.m_41784_().m_128459_("Knockback") > 0.0) {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (1.0 + mainHandItem.m_41784_().m_128459_("Knockback") * Math.max(Math.min(entity.getPersistentData().m_128459_("cnt6") * 0.2, 1.0), 0.0)));
                  } else {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (1.0 + mainHandItem.m_41784_().m_128459_("Knockback")));
                  }
               }
            }

            if (mainHandItem.m_204117_(ItemTags.create(new ResourceLocation("forge:cursed_tool")))) {
               if (mainHandItem.m_41720_() == JujutsucraftModItems.PLAYFUL_CLOUD.get()) {
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.25);
                  if (entity.getPersistentData().m_128459_("knockback") >= 1.0) {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * 1.25);
                  }
               }

               if (mainHandItem.m_41720_() == JujutsucraftModItems.SPLIT_SOUL_KATANA.get()) {
                  label109: {
                     if (entity instanceof Player) {
                        Player _plrCldCheck31 = (Player)entity;
                        if (_plrCldCheck31.m_36335_().m_41519_(mainHandItem.m_41720_())) {
                           break label109;
                        }
                     }

                     entity.getPersistentData().m_128379_("ignore", true);
                  }
               }

               if (mainHandItem.m_41720_() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                  entity.getPersistentData().m_128347_("Damage", 1.0);
                  entity.getPersistentData().m_128347_("knockback", 0.0);
               }
            }

            label101: {
               if (entity instanceof Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 7.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 7.0) {
                     break label101;
                  }
               } else if (!(entity instanceof KashimoHajimeEntity)) {
                  break label101;
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.05);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt40 = (LivingEntity)entity;
               if (_livEnt40.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                  label92: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                           var14 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).m_19564_();
                           break label92;
                        }
                     }

                     var14 = 0;
                  }

                  power = (double)(var14 + 1) * 0.1;
                  entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * (1.5 + power));
                  if (entity.getPersistentData().m_128459_("knockback") >= 0.5) {
                     entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * (1.0 + power));
                  }
               }
            }

            if (LogicStartPassiveProcedure.execute(entity)) {
               if (entity instanceof Player) {
                  if (!(entity instanceof ServerPlayer)) {
                     return;
                  }

                  ServerPlayer _plr48 = (ServerPlayer)entity;
                  if (!(_plr48.m_9236_() instanceof ServerLevel) || !_plr48.m_8960_().m_135996_(_plr48.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_strike_strengthening"))).m_8193_() || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique != 2.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 != 2.0) {
                     return;
                  }
               } else if (!(entity instanceof GojoSatoruEntity)) {
                  return;
               }

               entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 1.25);
               if (entity.getPersistentData().m_128459_("knockback") >= 0.5) {
                  entity.getPersistentData().m_128347_("knockback", entity.getPersistentData().m_128459_("knockback") * 1.25);
               }
            }
         }

      }
   }
}
