package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.DecimalFormat;
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
         double y_power = 0.0;
         double z_power = 0.0;
         double distance = 0.0;
         double x_power = 0.0;
         double rnd1 = 0.0;
         double rnd2 = 0.0;
         double rnd3 = 0.0;
         double cross1 = 0.0;
         double cross2 = 0.0;
         double cross3 = 0.0;
         double dot = 0.0;
         double rad_inaccuracy = 0.0;
         double cosTheta = 0.0;
         double sinTheta = 0.0;
         boolean logic_vector_set = false;
         rad_inaccuracy = Math.toRadians(inaccuracy * 0.5);
         cosTheta = Math.cos(rad_inaccuracy);
         sinTheta = Math.sin(rad_inaccuracy);

         for(int index0 = 0; index0 < (int)Math.max(count, 1.0); ++index0) {
            if (!logic_vector_set) {
               logic_vector_set = true;
               x_power = x2 - x1;
               y_power = y2 - y1;
               z_power = z2 - z1;
               distance = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (distance != 0.0) {
                  x_power /= distance;
                  y_power /= distance;
                  z_power /= distance;
               }
            }

            if (inaccuracy != 0.0) {
               logic_vector_set = false;
               rnd1 = Math.random() - 0.5;
               rnd2 = Math.random() - 0.5;
               rnd3 = Math.random() - 0.5;
               distance = Math.sqrt(rnd1 * rnd1 + rnd2 * rnd2 + rnd3 * rnd3);
               if (distance != 0.0) {
                  rnd1 /= distance;
                  rnd2 /= distance;
                  rnd3 /= distance;
               }

               cross1 = rnd2 * z_power - rnd3 * y_power;
               cross2 = rnd3 * x_power - rnd1 * z_power;
               cross3 = rnd1 * y_power - rnd2 * x_power;
               dot = rnd1 * x_power + rnd2 * y_power + rnd3 * z_power;
               x_power = x_power * cosTheta + cross1 * sinTheta + rnd1 * dot * (1.0 - cosTheta);
               y_power = y_power * cosTheta + cross2 * sinTheta + rnd2 * dot * (1.0 - cosTheta);
               z_power = z_power * cosTheta + cross3 * sinTheta + rnd3 * dot * (1.0 - cosTheta);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x1 + caliber_radius * (Math.random() - 0.5), y1 + caliber_radius * (Math.random() - 0.5), z1 + caliber_radius * (Math.random() - 0.5)), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "particle " + id + " ~ ~ ~ " + (new DecimalFormat("#####.#####")).format(x_power * 1.0) + " " + (new DecimalFormat("#####.#####")).format(y_power * 1.0) + " " + (new DecimalFormat("#####.#####")).format(z_power * 1.0) + " " + (new DecimalFormat("#####.#####")).format(1.0 * speed) + " 0 force");
            }
         }

      }
   }
}
