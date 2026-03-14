package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletCursePowerWhileBulletFlyingTickProcedure {
   public BulletCursePowerWhileBulletFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double num = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == 1.0) {
            immediatesourceentity.m_20242_(true);
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            if (entity.getPersistentData().m_128459_("cnt7") > 0.0) {
               immediatesourceentity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("cnt7"));
               immediatesourceentity.getPersistentData().m_128347_("cnt6", 1.0 + entity.getPersistentData().m_128459_("cnt7") * 0.03);
            } else {
               immediatesourceentity.getPersistentData().m_128347_("Damage", 13.0 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.1));
               immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            }

            immediatesourceentity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", immediatesourceentity.m_20185_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", immediatesourceentity.m_20186_());
            immediatesourceentity.getPersistentData().m_128347_("old_z", immediatesourceentity.m_20189_());
         }

         old_skill = entity.getPersistentData().m_128459_("skill");
         old_cooldown = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
         entity.getPersistentData().m_128347_("skill", immediatesourceentity.getPersistentData().m_128459_("skill"));
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
         x_pos = immediatesourceentity.getPersistentData().m_128459_("old_x");
         y_pos = immediatesourceentity.getPersistentData().m_128459_("old_y");
         z_pos = immediatesourceentity.getPersistentData().m_128459_("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 1.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.round(Math.max(dis * 4.0, 1.0)); ++index0) {
            ++num;
            if (num > 0.0) {
               num = -4.0;
               entity.getPersistentData().m_128347_("Damage", immediatesourceentity.getPersistentData().m_128459_("Damage"));
               entity.getPersistentData().m_128347_("Range", 3.0);
               if (immediatesourceentity.getPersistentData().m_128459_("skill") == 3606.0) {
                  entity.getPersistentData().m_128347_("knockback", 1.0);
               } else {
                  entity.getPersistentData().m_128347_("knockback", 0.25);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            if (immediatesourceentity.getPersistentData().m_128459_("skill") == 154.0) {
               if (Math.random() < 0.5) {
                  ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 5.0, 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "minecraft:soul_fire_flame");
               } else {
                  ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 5.0, 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_curse_power_blue");
               }
            } else if (immediatesourceentity.getPersistentData().m_128459_("skill") == 3606.0) {
               if (Math.random() < 0.1) {
                  ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 5.0, 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "minecraft:cloud");
               }
            } else {
               ParticleGeneratorProcedure.execute(world, 0.5, 1.0, 5.0, 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "jujutsucraft:particle_curse_power_orange");
            }

            x_pos += x_power * 0.25;
            y_pos += y_power * 0.25;
            z_pos += z_power * 0.25;
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("skill", old_skill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > 40.0 && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
