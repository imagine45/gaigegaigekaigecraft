package org.imgaine.gaigegaigekaigecraft.entity;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.procedures.BulletHazenokiHit2Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.BulletHazenokiHitProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.BulletHazenokiProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;

@OnlyIn(
   value = Dist.CLIENT,
   _interface = ItemSupplier.class
)
public class BulletEyeEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public BulletEyeEntity(PlayMessages.SpawnEntity packet, Level world) {
      super((EntityType)JujutsucraftModEntities.BULLET_EYE.get(), world);
   }

   public BulletEyeEntity(EntityType<? extends BulletEyeEntity> type, Level world) {
      super(type, world);
   }

   public BulletEyeEntity(EntityType<? extends BulletEyeEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public BulletEyeEntity(EntityType<? extends BulletEyeEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> getAddEntityPacket() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack getItem() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack getPickupItem() {
      return PROJECTILE_ITEM;
   }

   protected void doPostHurtEffects(LivingEntity entity) {
      super.doPostHurtEffects(entity);
      entity.setArrowCount(entity.getArrowCount() - 1);
   }

   public void onHitEntity(EntityHitResult entityHitResult) {
      super.onHitEntity(entityHitResult);
      BulletHazenokiHit2Procedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this, this.getOwner());
   }

   public void onHitBlock(BlockHitResult blockHitResult) {
      super.onHitBlock(blockHitResult);
      BulletHazenokiHitProcedure.execute(this.level(), (double)blockHitResult.getBlockPos().getX(), (double)blockHitResult.getBlockPos().getY(), (double)blockHitResult.getBlockPos().getZ(), this.getOwner(), this);
   }

   public void tick() {
      super.tick();
      BulletHazenokiProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this.getOwner(), this);
      if (this.inGround) {
         this.discard();
      }

   }

   public static BulletEyeEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 1.0F, 0.0, 0);
   }

   public static BulletEyeEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 1.0F, 0.0, 0);
   }

   public static BulletEyeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      BulletEyeEntity entityarrow = new BulletEyeEntity((EntityType)JujutsucraftModEntities.BULLET_EYE.get(), entity, world);
      entityarrow.shoot(entity.getViewVector(1.0F).x, entity.getViewVector(1.0F).y, entity.getViewVector(1.0F).z, power * 2.0F, 0.0F);
      entityarrow.setSilent(true);
      entityarrow.setCritArrow(true);
      entityarrow.setBaseDamage(damage);
      entityarrow.setKnockback(knockback);
      world.addFreshEntity(entityarrow);
      return entityarrow;
   }

   public static BulletEyeEntity shoot(LivingEntity entity, LivingEntity target) {
      BulletEyeEntity entityarrow = new BulletEyeEntity((EntityType)JujutsucraftModEntities.BULLET_EYE.get(), entity, entity.level());
      double dx = target.getX() - entity.getX();
      double dy = target.getY() + (double)target.getEyeHeight() - 1.1;
      double dz = target.getZ() - entity.getZ();
      entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.20000000298023224, dz, 2.0F, 12.0F);
      entityarrow.setSilent(true);
      entityarrow.setBaseDamage(0.0);
      entityarrow.setKnockback(0);
      entityarrow.setCritArrow(true);
      entity.level().addFreshEntity(entityarrow);
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack((ItemLike)JujutsucraftModItems.EYE.get());
   }
}
