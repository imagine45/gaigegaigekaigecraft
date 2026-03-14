package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;

public class CursedSpeechProcedure {
   public CursedSpeechProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double Damage = 0.0;
         double Effect = 0.0;
         double Knockback = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double distance = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         if (entity.getPersistentData().m_128459_("skill") == 305.0) {
            Damage = 28.0;
         } else if (entity.getPersistentData().m_128459_("skill") == 306.0) {
            Damage = 22.0;
         } else if (entity.getPersistentData().m_128459_("skill") == 307.0) {
            Damage = 33.0;
         } else if (entity.getPersistentData().m_128459_("skill") == 308.0) {
            Damage = 2.0;
         } else if (entity.getPersistentData().m_128459_("skill") == 309.0) {
            Damage = 18.0;
            Knockback = 4.0;
         }

         AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
         LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
         Objects.requireNonNull(_iitemhandlerref);
         var10000.ifPresent(_iitemhandlerref::set);
         if (_iitemhandlerref.get() != null) {
            for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
               ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
               if (itemstackiterator.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && itemstackiterator.m_41784_().m_128471_("Used")) {
                  entity.getPersistentData().m_128347_("cnt6", 5.0);
                  Damage *= 0.75;
                  break;
               }
            }
         }

         Effect = entity.getPersistentData().m_128459_("skill");
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
            entity.getPersistentData().m_128347_("yaw", (double)(entity.m_146908_() + 90.0F));
            entity.getPersistentData().m_128347_("pitch", (double)entity.m_146909_());
            entity.getPersistentData().m_128347_("x_pos", entity.m_20185_());
            entity.getPersistentData().m_128347_("y_pos", entity.m_20186_() + (double)entity.m_20206_() * 0.7);
            entity.getPersistentData().m_128347_("z_pos", entity.m_20189_());
            LivingEntity var54;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var54 = _mobEnt.m_5448_();
            } else {
               var54 = null;
            }

            if (var54 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var54 = _mobEnt.m_5448_();
               } else {
                  var54 = null;
               }

               x_pos = ((Entity)var54).m_20185_();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var54 = _mobEnt.m_5448_();
               } else {
                  var54 = null;
               }

               double var57 = ((Entity)var54).m_20186_();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.m_5448_();
               } else {
                  var10001 = null;
               }

               y_pos = var57 + (double)((Entity)var10001).m_20206_() * 0.7;
               LivingEntity var58;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.m_5448_();
               } else {
                  var58 = null;
               }

               z_pos = ((Entity)var58).m_20189_();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().m_128347_("x_power", entity.m_20154_().f_82479_ * 2.0);
            entity.getPersistentData().m_128347_("y_power", entity.m_20154_().f_82480_ * 2.0);
            entity.getPersistentData().m_128347_("z_power", entity.m_20154_().f_82481_ * 2.0);
         }

         rad_now = Math.toRadians(entity.getPersistentData().m_128459_("yaw") + 90.0);

         for(int index0 = 0; index0 < 2; ++index0) {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            dis = (entity.getPersistentData().m_128459_("cnt3") - 0.5) * 0.8 * (1.0 + entity.getPersistentData().m_128459_("cnt6") * 0.2);
            entity.getPersistentData().m_128347_("Damage", Damage);
            entity.getPersistentData().m_128347_("Range", dis * 2.0);
            entity.getPersistentData().m_128347_("effect", Effect);
            entity.getPersistentData().m_128347_("effectConfirm", 2.0);
            entity.getPersistentData().m_128347_("knockback", Knockback);
            entity.getPersistentData().m_128379_("onlyLiving", true);
            RangeAttackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
            if (entity.getPersistentData().m_128459_("skill") == 309.0) {
               entity.getPersistentData().m_128347_("effect", 0.0);
               entity.getPersistentData().m_128347_("knockback", Knockback);
               KnockbackProcedure.execute(world, entity.getPersistentData().m_128459_("x_pos"), entity.getPersistentData().m_128459_("y_pos"), entity.getPersistentData().m_128459_("z_pos"), entity);
            }

            entity.getPersistentData().m_128379_("onlyLiving", false);
            entity.getPersistentData().m_128347_("x_pos", entity.getPersistentData().m_128459_("x_pos") + entity.getPersistentData().m_128459_("x_power") * 1.0);
            entity.getPersistentData().m_128347_("y_pos", entity.getPersistentData().m_128459_("y_pos") + entity.getPersistentData().m_128459_("y_power") * 1.0);
            entity.getPersistentData().m_128347_("z_pos", entity.getPersistentData().m_128459_("z_pos") + entity.getPersistentData().m_128459_("z_power") * 1.0);
         }

         entity.getPersistentData().m_128347_("Damage", 0.0);
         if (entity.getPersistentData().m_128459_("cnt1") > 4.0) {
            entity.getPersistentData().m_128347_("skill", 0.0);
         }

         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.8;
         z_pos = entity.m_20189_();
         range = ReturnEntitySizeProcedure.execute(entity);
         ParticleGeneratorCircleProcedure.execute(world, 36.0, entity.getPersistentData().m_128459_("pitch"), 0.0, 2.0, 8.0, x_pos, x_pos + entity.getPersistentData().m_128459_("x_power"), y_pos, y_pos + entity.getPersistentData().m_128459_("y_power"), entity.getPersistentData().m_128459_("yaw") - 90.0, z_pos, z_pos + entity.getPersistentData().m_128459_("z_power"), "minecraft:enchanted_hit");
      }
   }
}
