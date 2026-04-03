package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletNailEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class KugisakiNailProcedure {
   public KugisakiNailProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.HAMMER.get() && world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
            }
         }

         LivingEntity var29;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var29 = _mobEnt.getTarget();
         } else {
            var29 = null;
         }

         if (var29 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.getTarget();
            } else {
               var29 = null;
            }

            x_pos = ((Entity)var29).getX();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.getTarget();
            } else {
               var29 = null;
            }

            double var32 = ((Entity)var29).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var32 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var33;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var33 = _mobEnt.getTarget();
            } else {
               var33 = null;
            }

            z_pos = ((Entity)var33).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         entity.getPersistentData().putDouble("Damage", 0.5);
         DamageFixProcedure.execute(entity);
         Level projectileLevel = entity.level();
         if (!projectileLevel.isClientSide()) {
            Projectile _entityToSpawn = InlineMethodHandler.getArrowBulletNail(projectileLevel, entity, (float)entity.getPersistentData().getDouble("Damage"), 0);
            _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 3.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.NAIL.get());
            _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
