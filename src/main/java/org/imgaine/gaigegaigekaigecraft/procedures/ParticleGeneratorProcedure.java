package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Locale;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class ParticleGeneratorProcedure {
   public ParticleGeneratorProcedure() {
   }

   public static void execute(LevelAccessor world, double caliber_radius, double count, double inaccuracy, double speed, double x1, double x2, double y1, double y2, double z1, double z2, String id) {
      if (id != null) {
         String particleCmd = "";
         double cosTheta = 0.0;
         double dirZ = 0.0;
         double dirY = 0.0;
         double dirX = 0.0;
         double dot = 0.0;
         double spawnX = 0.0;
         double spawnZ = 0.0;
         double baseDist = 0.0;
         double rad_inaccuracy = 0.0;
         double spawnY = 0.0;
         double maxCount = 0.0;
         double dx = 0.0;
         double dy = 0.0;
         double dz = 0.0;
         double cross2 = 0.0;
         double cross3 = 0.0;
         double cross1 = 0.0;
         double rnd1 = 0.0;
         double sinTheta = 0.0;
         double rnd3 = 0.0;
         double rDist = 0.0;
         double rnd2 = 0.0;
         dx = x2 - x1;
         dy = y2 - y1;
         dz = z2 - z1;
         baseDist = Math.sqrt(dx * dx + dy * dy + dz * dz);
         if (baseDist != 0.0) {
            dx /= baseDist;
            dy /= baseDist;
            dz /= baseDist;
         }

         rad_inaccuracy = Math.toRadians(inaccuracy * 0.5);
         cosTheta = Math.cos(rad_inaccuracy);
         sinTheta = Math.sin(rad_inaccuracy);
         maxCount = Math.max(count, 1.0);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;

            for(int index0 = 0; index0 < (int)maxCount; ++index0) {
               dirX = dx;
               dirY = dy;
               dirZ = dz;
               if (inaccuracy != 0.0) {
                  rnd1 = Math.random() - 0.5;
                  rnd2 = Math.random() - 0.5;
                  rnd3 = Math.random() - 0.5;
                  rDist = Math.sqrt(rnd1 * rnd1 + rnd2 * rnd2 + rnd3 * rnd3);
                  if (rDist != 0.0) {
                     rnd1 /= rDist;
                     rnd2 /= rDist;
                     rnd3 /= rDist;
                  }

                  cross1 = rnd2 * dz - rnd3 * dy;
                  cross2 = rnd3 * dx - rnd1 * dz;
                  cross3 = rnd1 * dy - rnd2 * dx;
                  dot = rnd1 * dx + rnd2 * dy + rnd3 * dz;
                  dirX = dx * cosTheta + cross1 * sinTheta + rnd1 * dot * (1.0 - cosTheta);
                  dirY = dy * cosTheta + cross2 * sinTheta + rnd2 * dot * (1.0 - cosTheta);
                  dirZ = dz * cosTheta + cross3 * sinTheta + rnd3 * dot * (1.0 - cosTheta);
               }

               spawnX = x1 + caliber_radius * (Math.random() - 0.5);
               spawnY = y1 + caliber_radius * (Math.random() - 0.5);
               spawnZ = z1 + caliber_radius * (Math.random() - 0.5);
               particleCmd = String.format(Locale.US, "particle %s ~ ~ ~ %.4f %.4f %.4f %.4f 0 force", id, dirX, dirY, dirZ, speed);
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(spawnX, spawnY, spawnZ), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), particleCmd);
            }
         }

      }
   }
}
