package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletCursePowerProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.entity.BulletPistolEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackRifleProcedure {
   public AttackRifleProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double strength = 0.0;
         double range = 0.0;
         double inaccuracy = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double weapon_size = 0.0;
         double y_pos = 0.0;
         double attack_reach = 0.0;
         double pitch = 0.0;
         boolean logic_strong = false;
         boolean logic_final = false;
         ItemStack item_mainHand = ItemStack.EMPTY;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         logic_strong = entity.getPersistentData().getDouble("skill") % 50.0 == 1.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         item_mainHand = var10000.copy();
         LivingEntity var78;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var78 = _mobEnt.getTarget();
         } else {
            var78 = null;
         }

         if (var78 instanceof LivingEntity && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity7 = (LivingEntity)entity;
            if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var78 = _mobEnt.getTarget();
         } else {
            var78 = null;
         }

         if (var78 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var78 = _mobEnt.getTarget();
            } else {
               var78 = null;
            }

            x_pos = ((Entity)var78).getX();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var78 = _mobEnt.getTarget();
            } else {
               var78 = null;
            }

            double var82 = ((Entity)var78).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var82 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var83;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var83 = _mobEnt.getTarget();
            } else {
               var83 = null;
            }

            z_pos = ((Entity)var83).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") < (double)(logic_strong ? 8 : 2)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }
            int var84;
            label210: {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var84 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label210;
                  }
               }

               var84 = 0;
            }

            strength = (double)Math.min(var84, 50) * CNT6;
            weapon_size = GetWeaponSizeProcedure.execute(entity);
            attack_reach = GetReachProcedure.execute(entity);
            range = ReturnEntitySizeProcedure.execute(entity);
            range = range * range * Math.sqrt(weapon_size * attack_reach);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               dis = 1.0 + (double)entity.getBbWidth() * 0.5;
               entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis);
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis);
               entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);
               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(range * 8.0), range * 0.05, range * 0.05, range * 0.05, 1.0);
               }

               if (item_mainHand.is(ItemTags.create(new ResourceLocation("forge:rifle")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F, false);
                     }
                  }

                  if (logic_strong) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_SHOCK_HIT.get(), x_pos, y_pos, z_pos, 1, range * 0.0, range * 0.0, range * 0.0, 0.0);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(range * 4.0), range * 0.05, range * 0.05, range * 0.05, 1.0);
                     }
                  }
               } else if (item_mainHand.is(ItemTags.create(new ResourceLocation("forge:bow")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.NEUTRAL, (float)(range * 1.0), 1.0F, false);
                     }
                  }
               }

               logic_final = entity.getPersistentData().getDouble("cnt5") == 0.0 || entity.getPersistentData().getDouble("cnt5") >= 100.0;
               if (logic_strong) {
                  entity.getPersistentData().putDouble("Damage", 3.3);
               } else if (logic_final) {
                  entity.getPersistentData().putDouble("Damage", 2.7);
               } else {
                  entity.getPersistentData().putDouble("Damage", 2.25);
               }

               DamageFixProcedure.execute(entity);
               if (entity instanceof Player) {
                  inaccuracy = logic_final ? 0.0 : 5.0;
               } else {
                  inaccuracy = 5.0;
               }

               if (item_mainHand.is(ItemTags.create(new ResourceLocation("forge:rifle")))) {
                  Level projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = InlineMethodHandler.getArrowBulletPistol(projectileLevel, entity, (float)entity.getPersistentData().getDouble("Damage"), 0, (byte)((int)(50.0 * CNT6)));
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)((double)(logic_strong ? 5 : 4) * CNT6), (float)inaccuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, item_mainHand) == 0 && entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _stktoremove = new ItemStack((ItemLike)JujutsucraftModItems.ITEM_BULLET.get());
                     _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else if (item_mainHand.is(ItemTags.create(new ResourceLocation("forge:bow")))) {
                  Level projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = InlineMethodHandler.getArrow(projectileLevel, entity, (float)entity.getPersistentData().getDouble("Damage"), 0, (byte)((int)(50.0 * CNT6)));
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)((double)(logic_strong ? 5 : 4) * CNT6), (float)inaccuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }

                  if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, item_mainHand) == 0 && entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack _stktoremove = new ItemStack(Items.ARROW);
                     _player.getInventory().clearOrCountMatchingItems((p) -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                  }
               } else {
                  Level projectileLevel = entity.level();
                  if (!projectileLevel.isClientSide()) {
                     Projectile _entityToSpawn = InlineMethodHandler.getArrowBulletCursePower(projectileLevel, entity, (float)entity.getPersistentData().getDouble("Damage"), 0, (byte)((int)(50.0 * CNT6)));
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)((double)(logic_strong ? 5 : 4) * CNT6), (float)inaccuracy);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= (double)(9 + (logic_strong ? 8 : 2))) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
