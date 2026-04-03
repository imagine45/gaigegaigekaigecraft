package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class GetDomainBlockProcedure {
   public GetDomainBlockProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double domain_num;
         double var10000;
         label173: {
            boolean noBarrier = false;
            String outside = "";
            String inside = "";
            String floor = "";
            domain_num = 0.0;
            double close_type = 0.0;
            domain_num = entity.getPersistentData().getDouble("select") > 0.0 ? entity.getPersistentData().getDouble("select") : entity.getPersistentData().getDouble("skill_domain");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = (LivingEntity)entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label173;
                     }
                  }

                  var10000 = 0.0;
                  break label173;
               }
            }

            var10000 = entity.getPersistentData().getDouble("cnt2");
         }

         double var15 = var10000;
         String var11 = "gaigegaigekaigecraft:jujutsu_barrier";
         String var12 = "gaigegaigekaigecraft:block_universe";
         String var13 = "gaigegaigekaigecraft:block_universe";
         if (domain_num <= 10.0) {
            if (domain_num == 1.0) {
               var12 = "gaigegaigekaigecraft:domain_bone";
               var13 = "gaigegaigekaigecraft:block_red";
            } else if (domain_num == 2.0) {
               var12 = "gaigegaigekaigecraft:block_universe";
               var13 = "gaigegaigekaigecraft:block_universe";
            } else if (domain_num == 3.0) {
               var12 = "gaigegaigekaigecraft:domain_blue_sky";
            } else if (domain_num == 4.0) {
               var12 = "gaigegaigekaigecraft:coffinofthe_ironmountain_1";
               var13 = "gaigegaigekaigecraft:coffinofthe_ironmountain_2";
            } else if (domain_num == 5.0) {
               var13 = "gaigegaigekaigecraft:block_gravel";
            } else if (domain_num == 6.0) {
               var12 = "gaigegaigekaigecraft:block_universe";
               var13 = "gaigegaigekaigecraft:block_universe";
            } else if (domain_num == 7.0) {
               var12 = "gaigegaigekaigecraft:domain_cloud";
               var13 = "gaigegaigekaigecraft:domain_cloud";
            } else if (domain_num == 8.0) {
               var12 = "gaigegaigekaigecraft:domain_blue_sky";
               var13 = "gaigegaigekaigecraft:domain_sand";
            } else if (domain_num == 9.0) {
               var13 = "gaigegaigekaigecraft:domain_sand";
            } else if (domain_num == 10.0) {
               var12 = "gaigegaigekaigecraft:domain_blood";
               var13 = "gaigegaigekaigecraft:domain_blood";
            }
         } else if (domain_num <= 20.0) {
            if (domain_num == 11.0) {
               var12 = "gaigegaigekaigecraft:domain_cloud";
               var13 = "gaigegaigekaigecraft:domain_podzol";
            } else if (domain_num == 12.0) {
               var12 = "gaigegaigekaigecraft:block_red";
               var13 = "gaigegaigekaigecraft:domain_sand";
            } else if (domain_num == 13.0) {
               var13 = "gaigegaigekaigecraft:domain_stone_bricks";
            } else if (domain_num == 14.0) {
               var12 = "gaigegaigekaigecraft:domain_blue_sky";
               var13 = "gaigegaigekaigecraft:domain_flower";
            } else if (domain_num == 15.0) {
               var12 = "gaigegaigekaigecraft:domain_bone";
            } else if (domain_num == 16.0) {
               var12 = "gaigegaigekaigecraft:block_universe";
            } else if (domain_num == 18.0) {
               var12 = "gaigegaigekaigecraft:domain_blood";
               var13 = "gaigegaigekaigecraft:block_red";
            } else if (domain_num == 20.0) {
               var12 = "gaigegaigekaigecraft:domain_flower";
               var13 = "gaigegaigekaigecraft:domain_blue_sky";
            }
         } else if (domain_num <= 30.0) {
            if (domain_num == 21.0) {
               var12 = "gaigegaigekaigecraft:domain_cloud";
               var13 = "gaigegaigekaigecraft:domain_podzol";
            } else if (domain_num == 22.0) {
               var13 = "gaigegaigekaigecraft:block_universe";
            } else if (domain_num == 23.0) {
               var12 = "gaigegaigekaigecraft:domain_bone";
               var13 = "gaigegaigekaigecraft:block_red";
            } else if (domain_num == 24.0) {
               var12 = "gaigegaigekaigecraft:domain_ice";
               var13 = "gaigegaigekaigecraft:domain_ice";
            } else if (domain_num == 25.0) {
               var13 = "gaigegaigekaigecraft:block_gravel";
            } else if (domain_num == 26.0) {
               var13 = "gaigegaigekaigecraft:block_gravel";
            } else if (domain_num == 27.0) {
               var13 = "gaigegaigekaigecraft:domain_planks";
            } else if (domain_num == 28.0) {
               var12 = "gaigegaigekaigecraft:domain_blue_sky";
               var13 = "gaigegaigekaigecraft:domain_cloud";
            } else if (domain_num == 29.0) {
               var12 = "gaigegaigekaigecraft:domain_white";
               var13 = "gaigegaigekaigecraft:domain_white";
            }
         } else if (domain_num <= 40.0) {
            if (domain_num == 32.0) {
               var12 = "gaigegaigekaigecraft:domain_sand";
               var13 = "gaigegaigekaigecraft:domain_sand";
            } else if (domain_num == 33.0) {
               var12 = "gaigegaigekaigecraft:block_red";
               var13 = "gaigegaigekaigecraft:domain_planks";
            } else if (domain_num == 34.0) {
               var13 = "gaigegaigekaigecraft:domain_podzol";
            } else if (domain_num == 35.0) {
               var12 = "gaigegaigekaigecraft:domain_blood";
               var13 = "gaigegaigekaigecraft:domain_sand";
            } else if (domain_num == 36.0) {
               var13 = "gaigegaigekaigecraft:domain_cloud";
            } else if (domain_num == 37.0) {
               var13 = "gaigegaigekaigecraft:block_red";
            } else if (domain_num == 38.0) {
               var12 = "gaigegaigekaigecraft:domain_blue_sky";
               var13 = "gaigegaigekaigecraft:domain_blue_sky";
            } else if (domain_num == 39.0) {
               var12 = "gaigegaigekaigecraft:domain_white";
               var13 = "gaigegaigekaigecraft:domain_white";
            } else if (domain_num == 40.0) {
               var13 = "gaigegaigekaigecraft:domain_dark_stone";
            }
         } else if (domain_num <= 50.0) {
            if (domain_num == 43.0) {
               var13 = "gaigegaigekaigecraft:domain_dark_stone";
               var12 = "gaigegaigekaigecraft:domain_dark_stone";
            } else if (domain_num == 44.0) {
               var13 = "gaigegaigekaigecraft:domain_white";
               var12 = "gaigegaigekaigecraft:domain_white";
            } else if (domain_num == 45.0) {
               var13 = "gaigegaigekaigecraft:domain_block_red";
               var12 = "gaigegaigekaigecraft:domain_blood";
            } else if (domain_num == 46.0) {
               var12 = "gaigegaigekaigecraft:domain_blood";
               var13 = "gaigegaigekaigecraft:domain_blood";
            } else if (domain_num == 47.0) {
               var12 = "gaigegaigekaigecraft:domain_cloud";
               var13 = "gaigegaigekaigecraft:coffinofthe_ironmountain_1";
            }
         }

         if (var15 > 0.0) {
            if (!entity.getPersistentData().getBoolean("Failed")) {
               var11 = "minecraft:air";
               var12 = "minecraft:air";
               var13 = "minecraft:air";
            } else {
               var11 = "";
               var12 = "";
            }
         } else if (var15 < 0.0 && !entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover")) {
            var11 = "";
            var12 = "";
         }

         entity.getPersistentData().putString("domain_outside", var11);
         entity.getPersistentData().putString("domain_inside", var12);
         entity.getPersistentData().putString("domain_floor", var13);
      }
   }
}
