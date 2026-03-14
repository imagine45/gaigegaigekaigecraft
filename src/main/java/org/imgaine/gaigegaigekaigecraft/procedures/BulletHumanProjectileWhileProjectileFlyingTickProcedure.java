package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletHumanProjectileWhileProjectileFlyingTickProcedure {
   public BulletHumanProjectileWhileProjectileFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         Entity entity_a = null;
         double repeat_num = 0.0;
         double damage = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double x_power = 0.0;
         double old_cooldown = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6"));
            immediatesourceentity.getPersistentData().m_128347_("skill", entity.getPersistentData().m_128459_("skill"));
            immediatesourceentity.getPersistentData().m_128347_("COOLDOWN_TICKS", entity.getPersistentData().m_128459_("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().m_128347_("old_x", entity.m_20185_());
            immediatesourceentity.getPersistentData().m_128347_("old_y", entity.m_20186_() + (double)entity.m_20206_() * 0.5);
            immediatesourceentity.getPersistentData().m_128347_("old_z", entity.m_20189_());
            immediatesourceentity.getPersistentData().m_128347_("speed", Math.sqrt(Math.pow(immediatesourceentity.m_20184_().m_7096_(), 2.0) + Math.pow(immediatesourceentity.m_20184_().m_7098_(), 2.0) + Math.pow(immediatesourceentity.m_20184_().m_7094_(), 2.0)));
            entity.getPersistentData().m_128347_("Damage", 10.0);
            DamageFixProcedure.execute(entity);
            immediatesourceentity.getPersistentData().m_128347_("bullet_power", entity.getPersistentData().m_128459_("Damage"));
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
         dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
         if (dis > 0.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         repeat_num = (double)Math.round(Math.max(dis * 5.0, 1.0));
         entity.getPersistentData().m_128347_("Damage", 12.0);

         for(int index0 = 0; index0 < (int)immediatesourceentity.getPersistentData().m_128459_("cnt_life"); ++index0) {
            entity.getPersistentData().m_128347_("Damage", entity.getPersistentData().m_128459_("Damage") * 0.99);
            if (entity.getPersistentData().m_128459_("Damage") < 9.0) {
               entity.getPersistentData().m_128347_("Damage", 9.0);
               break;
            }
         }

         damage = entity.getPersistentData().m_128459_("Damage");

         for(int index1 = 0; index1 < (int)repeat_num; ++index1) {
            ++dis;
            if (dis > 0.0) {
               dis = -5.0;
               entity.getPersistentData().m_128347_("Damage", damage);
               entity.getPersistentData().m_128347_("Range", 2.0);
               entity.getPersistentData().m_128347_("knockback", 0.25);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            x_pos += x_power * 0.2;
            y_pos += y_power * 0.2;
            z_pos += z_power * 0.2;
         }

         immediatesourceentity.getPersistentData().m_128347_("old_x", x);
         immediatesourceentity.getPersistentData().m_128347_("old_y", y);
         immediatesourceentity.getPersistentData().m_128347_("old_z", z);
         entity.getPersistentData().m_128347_("skill", old_skill);
         entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cooldown);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > 30.0 && !immediatesourceentity.m_9236_().m_5776_()) {
            immediatesourceentity.m_146870_();
         }

      }
   }
}
