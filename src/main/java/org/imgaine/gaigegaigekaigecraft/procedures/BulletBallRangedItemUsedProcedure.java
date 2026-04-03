package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletBallProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BulletBallRangedItemUsedProcedure {
   public BulletBallRangedItemUsedProcedure() {
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double old_select = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         Level projectileLevel = entity.level();
         if (!projectileLevel.isClientSide()) {
            Projectile _entityToSpawn = (new InlineMethodHandler() {
               public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback) {
                  AbstractArrow entityToSpawn = new BulletBallProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_BALL_PROJECTILE.get(), level);
                  entityToSpawn.setOwner(shooter);
                  entityToSpawn.setBaseDamage((double)damage);
                  entityToSpawn.setKnockback(knockback);
                  entityToSpawn.setCritArrow(true);
                  return entityToSpawn;
               }
            }).getArrowO(projectileLevel, entity, 0.0F, 0);
            _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
            _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.0F, 0.0F);
            projectileLevel.addFreshEntity(_entityToSpawn);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getCooldowns().addCooldown(itemstack.getItem(), 21);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            _player.getInventory().clearOrCountMatchingItems((p) -> itemstack.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
         }

      }
   }
}
