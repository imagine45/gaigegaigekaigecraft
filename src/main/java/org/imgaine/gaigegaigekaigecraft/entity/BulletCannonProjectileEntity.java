package org.imgaine.gaigegaigekaigecraft.entity;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.procedures.CannonFlyingProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.CannonHitProcedure;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
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
public class BulletCannonProjectileEntity extends AbstractArrow implements ItemSupplier {
   public static final ItemStack PROJECTILE_ITEM;

   public BulletCannonProjectileEntity(PlayMessages.SpawnEntity packet, Level world) {
      super((EntityType)JujutsucraftModEntities.BULLET_CANNON_PROJECTILE.get(), world);
   }

   public BulletCannonProjectileEntity(EntityType<? extends BulletCannonProjectileEntity> type, Level world) {
      super(type, world);
   }

   public BulletCannonProjectileEntity(EntityType<? extends BulletCannonProjectileEntity> type, double x, double y, double z, Level world) {
      super(type, x, y, z, world);
   }

   public BulletCannonProjectileEntity(EntityType<? extends BulletCannonProjectileEntity> type, LivingEntity entity, Level world) {
      super(type, entity, world);
   }

   public Packet<ClientGamePacketListener> m_5654_() {
      return NetworkHooks.getEntitySpawningPacket(this);
   }

   @OnlyIn(Dist.CLIENT)
   public ItemStack m_7846_() {
      return PROJECTILE_ITEM;
   }

   protected ItemStack m_7941_() {
      return PROJECTILE_ITEM;
   }

   protected void m_7761_(LivingEntity entity) {
      super.m_7761_(entity);
      entity.m_21317_(entity.m_21234_() - 1);
   }

   public void m_5790_(EntityHitResult entityHitResult) {
      super.m_5790_(entityHitResult);
      CannonHitProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), entityHitResult.m_82443_(), this);
   }

   public void m_8060_(BlockHitResult blockHitResult) {
      super.m_8060_(blockHitResult);
      CannonHitProcedure.execute(this.m_9236_(), (double)blockHitResult.m_82425_().m_123341_(), (double)blockHitResult.m_82425_().m_123342_(), (double)blockHitResult.m_82425_().m_123343_(), this.m_19749_(), this);
   }

   public void m_8119_() {
      super.m_8119_();
      CannonFlyingProcedure.execute(this.m_9236_(), this.m_20185_(), this.m_20186_(), this.m_20189_(), this.m_19749_(), this);
      if (this.f_36703_) {
         this.m_146870_();
      }

   }

   public static BulletCannonProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source) {
      return shoot(world, entity, source, 2.3F, 5.0, 1);
   }

   public static BulletCannonProjectileEntity shoot(Level world, LivingEntity entity, RandomSource source, float pullingPower) {
      return shoot(world, entity, source, pullingPower * 2.3F, 5.0, 1);
   }

   public static BulletCannonProjectileEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
      BulletCannonProjectileEntity entityarrow = new BulletCannonProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CANNON_PROJECTILE.get(), entity, world);
      entityarrow.m_6686_(entity.m_20252_(1.0F).f_82479_, entity.m_20252_(1.0F).f_82480_, entity.m_20252_(1.0F).f_82481_, power * 2.0F, 0.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36762_(false);
      entityarrow.m_36781_(damage);
      entityarrow.m_36735_(knockback);
      world.m_7967_(entityarrow);
      return entityarrow;
   }

   public static BulletCannonProjectileEntity shoot(LivingEntity entity, LivingEntity target) {
      BulletCannonProjectileEntity entityarrow = new BulletCannonProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CANNON_PROJECTILE.get(), entity, entity.m_9236_());
      double dx = target.m_20185_() - entity.m_20185_();
      double dy = target.m_20186_() + (double)target.m_20192_() - 1.1;
      double dz = target.m_20189_() - entity.m_20189_();
      entityarrow.m_6686_(dx, dy - entityarrow.m_20186_() + Math.hypot(dx, dz) * 0.20000000298023224, dz, 4.6F, 12.0F);
      entityarrow.m_20225_(true);
      entityarrow.m_36781_(5.0);
      entityarrow.m_36735_(1);
      entityarrow.m_36762_(false);
      entity.m_9236_().m_7967_(entityarrow);
      return entityarrow;
   }

   static {
      PROJECTILE_ITEM = new ItemStack(Blocks.f_50016_);
   }
}
