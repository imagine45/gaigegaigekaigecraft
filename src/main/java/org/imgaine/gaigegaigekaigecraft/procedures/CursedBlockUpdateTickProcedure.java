package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CursedBlockUpdateTickProcedure {
   public CursedBlockUpdateTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      double NUM1 = 0.0;
      boolean logic_start = false;
      NUM1 = (double)Math.round(((<undefinedtype>)(new Object() {
         public double getValue(LevelAccessor world, BlockPos pos, String tag) {
            BlockEntity blockEntity = world.m_7702_(pos);
            return blockEntity != null ? blockEntity.getPersistentData().m_128459_(tag) : -1.0;
         }
      })).getValue(world, BlockPos.m_274561_(x, y, z), "run_type"));
      if (NUM1 != 0.0) {
         if (!world.m_6443_(Player.class, AABB.m_165882_(new Vec3(x, y, z), 64.0, 64.0, 64.0), (e) -> true).isEmpty() && world.m_46791_() != Difficulty.PEACEFUL && world.m_6106_().m_5470_().m_46207_(GameRules.f_46134_)) {
            if (NUM1 <= 5.0) {
               if (NUM1 == 1.0) {
                  BuildReformatoryProcedure.execute(world, x, y, z);
               } else if (NUM1 == 2.0) {
                  BuildTempleWoodenProcedure.execute(world, x, y, z);
               } else if (NUM1 == 3.0) {
                  BuildGraveyardProcedure.execute(world, x, y, z);
               } else if (NUM1 == 4.0) {
                  BuildGraveyard2Procedure.execute(world, x, y, z);
               } else if (NUM1 == 5.0) {
                  BuildHospital1Procedure.execute(world, x, y, z);
               }
            } else if (NUM1 <= 10.0) {
               if (NUM1 == 6.0) {
                  BuildEatingHouse1Procedure.execute(world, x, y, z);
               } else if (NUM1 == 7.0) {
                  BuildSchoolProcedure.execute(world, x, y, z);
               } else if (NUM1 == 8.0) {
                  BuildShoppingStreetProcedure.execute(world, x, y, z);
               } else if (NUM1 == 9.0) {
                  BuildGate1Procedure.execute(world, x, y, z);
               } else if (NUM1 == 10.0) {
                  BuildApartmenthouse1Procedure.execute(world, x, y, z);
               }
            } else if (NUM1 <= 15.0) {
               if (NUM1 == 11.0) {
                  BuildHouseZeninProcedure.execute(world, x, y, z);
               } else if (NUM1 == 12.0) {
                  BuildTowerTempleProcedure.execute(world, x, y, z);
               }
            }
         }

         if (NUM1 >= 29.0) {
            BuildVillageProcedure.execute(world, x, y, z);
         }
      }

   }
}
