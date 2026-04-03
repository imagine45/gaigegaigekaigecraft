package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninOgiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class OgiZeninPassiveSkillProcedure {
   public OgiZeninPassiveSkillProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double PASSIVE_POWERFIX = 0.0;
         double NUM1 = 0.0;
         double T1 = 0.0;
         double T2 = 0.0;
         entity.getPersistentData().putDouble("PASSIVE_POWERFIX", 0.0);
         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = null;
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            T1 = pVars.PlayerCurseTechnique;
            T2 = pVars.PlayerCurseTechnique2;
         }

         if (T1 != 9.0 && T2 != 9.0) {
            if (T1 == 26.0 || T2 == 26.0 || entity instanceof ZeninOgiEntity) {
               CompoundTag var29 = entity.getPersistentData();
               double var10002;
               if (LogicStartPassiveProcedure.execute(entity)) {
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.getHealth();
                  } else {
                     var10003 = -1.0F;
                  }

                  var10003 = Math.max(var10003, 1.0F);
                  float var10004;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10004 = _livEnt.getMaxHealth();
                  } else {
                     var10004 = -1.0F;
                  }

                  var10002 = (double)(1.0F - var10003 / Math.max(var10004, 1.0F)) * 0.25;
               } else {
                  var10002 = 0.0;
               }

               var29.putDouble("PASSIVE_POWERFIX", var10002);
               PASSIVE_POWERFIX = (double)Math.round(Math.max(Math.min(entity.getPersistentData().getDouble("PASSIVE_POWERFIX") * 40.0, 10.0), 0.0));
               if (PASSIVE_POWERFIX >= 10.0) {
                  entity.getPersistentData().putDouble("PASSIVE_POWERFIX", entity.getPersistentData().getDouble("PASSIVE_POWERFIX") * 2.0);
               }

               if (entity instanceof Player) {
                  if (PASSIVE_POWERFIX <= 0.0) {
                     String _setval = "§7POWER";
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.OVERLAY1 = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  } else {
                     String _setval = PASSIVE_POWERFIX >= 10.0 ? "§l§4POWER" : "§cPOWER";
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.OVERLAY1 = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }

                  STR1 = PASSIVE_POWERFIX >= 10.0 ? "§l§4" : "§l§c";
                  NUM1 = 0.0;

                  for(int index1 = 0; index1 < 10; ++index1) {
                     if (NUM1 == PASSIVE_POWERFIX) {
                        STR1 = STR1 + "§r§7";
                     }

                     ++NUM1;
                     STR1 = STR1 + "■";
                  }
                  String STR2 = STR1;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = STR2;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }
         } else if (entity instanceof Player) {
            int var28;
            label116: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                     label112: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get())) {
                              var28 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get()).getAmplifier();
                              break label112;
                           }
                        }

                        var28 = 0;
                     }

                     ++var28;
                     break label116;
                  }
               }

               var28 = 0;
            }

            PASSIVE_POWERFIX = (double)var28;
            if (PASSIVE_POWERFIX <= 0.0) {
               String _setval = "§7" + Component.translatable("effect.star_rage").getString();
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.OVERLAY1 = _setval;
                  capability.syncPlayerVariables(entity);
               });
            } else {
               String _setval = (PASSIVE_POWERFIX >= 10.0 ? "§l§6" : "§e") + Component.translatable("effect.star_rage").getString();
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.OVERLAY1 = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            STR1 = PASSIVE_POWERFIX >= 10.0 ? "§l§6" : "§e";
            NUM1 = 0.0;

            for(int index0 = 0; index0 < (int)Math.max(10.0, Math.min(PASSIVE_POWERFIX, 25.0)); ++index0) {
               if (NUM1 == PASSIVE_POWERFIX) {
                  STR1 = STR1 + "§r§7";
               }

               ++NUM1;
               STR1 = STR1 + "■";
            }
            String STR2 = STR1;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.OVERLAY2 = STR2;
               capability.syncPlayerVariables(entity);
            });
         }

      }
   }
}
