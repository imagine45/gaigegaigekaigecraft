package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletKitchenKnifeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntityReceiptEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityReceiptOnEntityTickUpdateProcedure {
   public EntityReceiptOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double damage = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         Entity owner_entity = null;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (!(owner_entity instanceof LivingEntity)) {
            owner_entity = entity;
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         x_power = entity.getLookAngle().x;
         y_power = entity.getLookAngle().y;
         z_power = entity.getLookAngle().z;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }
            }

            if ((entity.getPersistentData().getDouble("cnt1") == 1.0 || Math.random() < 0.2) && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.LARGE_SMOKE, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
            }

            int var10000;
            if (entity instanceof EntityReceiptEntity) {
               EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityReceiptEntity.DATA_mode);
            } else {
               var10000 = 0;
            }

            if (var10000 != 0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 0.5);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.item.pickup")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof EntityReceiptEntity) {
                  EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                  var10000 = (Integer)_datEntI.getEntityData().get(EntityReceiptEntity.DATA_mode);
               } else {
                  var10000 = 0;
               }

               if (var10000 == 1) {
                  entity.getPersistentData().putDouble("Damage", 2.4);
                  DamageFixProcedure.execute(entity);
                  damage = entity.getPersistentData().getDouble("Damage");
                  if (world instanceof ServerLevel) {
                     ServerLevel projectileLevel = (ServerLevel)world;
                     Projectile _entityToSpawn = ((new InlineMethodHandler() {
                        public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BulletKitchenKnifeEntity((EntityType)JujutsucraftModEntities.BULLET_KITCHEN_KNIFE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           entityToSpawn.setCritArrow(true);
                           return entityToSpawn;
                        }
                     })).getArrowO(projectileLevel, owner_entity, (float)damage, 0, (byte)1);
                     _entityToSpawn.setPos(x_pos, y_pos, z_pos);
                     _entityToSpawn.shoot(x_power, y_power, z_power, 5.0F, 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
                  }
               } else {
                  if (entity instanceof EntityReceiptEntity) {
                     EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                     var10000 = (Integer)_datEntI.getEntityData().get(EntityReceiptEntity.DATA_mode);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 5) {
                     speed = 6.5;
                     if (world instanceof ServerLevel) {
                        ServerLevel _serverLevel = (ServerLevel)world;
                        Entity entityinstance = ((EntityType)JujutsucraftModEntities.CAR.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                        if (entityinstance != null) {
                           entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                           SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                           entityinstance.setYRot(entity.getYRot());
                           entityinstance.setXRot(entity.getXRot());
                           entityinstance.setYBodyRot(entityinstance.getYRot());
                           entityinstance.setYHeadRot(entityinstance.getYRot());
                           entityinstance.yRotO = entityinstance.getYRot();
                           entityinstance.xRotO = entityinstance.getXRot();
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           entityinstance.push(x_power * speed, y_power * speed, z_power * speed);
                           entityinstance.setDeltaMovement(new Vec3(x_power * speed, y_power * speed, z_power * speed));
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                              }
                           }

                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              }
                           }

                           entityinstance.getPersistentData().putBoolean("Shikigami", true);
                           entityinstance.getPersistentData().putBoolean("canFly", true);
                           entityinstance.getPersistentData().putDouble("skill", 1706.0);
                           entityinstance.getPersistentData().putDouble("cnt1", 6.0);
                           entityinstance.getPersistentData().putDouble("cnt6", 2.5);
                           entityinstance.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                           entityinstance.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                           entityinstance.getPersistentData().putDouble("x_power", x_power * speed * 0.5);
                           entityinstance.getPersistentData().putDouble("y_power", y_power * speed * 0.5);
                           entityinstance.getPersistentData().putDouble("z_power", z_power * speed * 0.5);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entityinstance;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }

                           _serverLevel.addFreshEntity(entityinstance);
                        }
                     }
                  } else {
                     if (entity instanceof EntityReceiptEntity) {
                        EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                        var10000 = (Integer)_datEntI.getEntityData().get(EntityReceiptEntity.DATA_mode);
                     } else {
                        var10000 = 0;
                     }

                     if (var10000 == 6) {
                        speed = 6.5;
                        if (world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.TRUCK.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                              entityinstance.setYRot(entity.getYRot());
                              entityinstance.setXRot(entity.getXRot());
                              entityinstance.setYBodyRot(entityinstance.getYRot());
                              entityinstance.setYHeadRot(entityinstance.getYRot());
                              entityinstance.yRotO = entityinstance.getYRot();
                              entityinstance.xRotO = entityinstance.getXRot();
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 _entity.yBodyRotO = _entity.getYRot();
                                 _entity.yHeadRotO = _entity.getYRot();
                              }

                              entityinstance.push(x_power * speed, y_power * speed, z_power * speed);
                              entityinstance.setDeltaMovement(new Vec3(x_power * speed, y_power * speed, z_power * speed));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 if (!_entity.level().isClientSide()) {
                                    _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                 }
                              }

                              entityinstance.getPersistentData().putBoolean("Shikigami", true);
                              entityinstance.getPersistentData().putBoolean("canFly", true);
                              entityinstance.getPersistentData().putDouble("skill", 1706.0);
                              entityinstance.getPersistentData().putDouble("cnt1", 6.0);
                              entityinstance.getPersistentData().putDouble("cnt6", 5.0);
                              entityinstance.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                              entityinstance.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                              entityinstance.getPersistentData().putDouble("x_power", x_power * speed * 0.5);
                              entityinstance.getPersistentData().putDouble("y_power", y_power * speed * 0.5);
                              entityinstance.getPersistentData().putDouble("z_power", z_power * speed * 0.5);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity103 = (LivingEntity)entityinstance;
                                 if (_livingEntity103.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    _livingEntity103.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.5);
                                 }
                              }

                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SLAUGHTER_DEMON.get())).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     } else {
                        if (entity instanceof EntityReceiptEntity) {
                           EntityReceiptEntity _datEntI = (EntityReceiptEntity)entity;
                           var10000 = (Integer)_datEntI.getEntityData().get(EntityReceiptEntity.DATA_mode);
                        } else {
                           var10000 = 0;
                        }

                        if (var10000 == 15 && world instanceof ServerLevel) {
                           ServerLevel _serverLevel = (ServerLevel)world;
                           Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_HOUSE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos") + 16.0, entity.getPersistentData().getDouble("z_pos")), MobSpawnType.MOB_SUMMONED, false, false);
                           if (entityinstance != null) {
                              entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                              SetRangedAmmoProcedure.execute(owner_entity, entityinstance);
                              entityinstance.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
                              entityinstance.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entityinstance;
                                 ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_ARM.get())).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }

                              _serverLevel.addFreshEntity(entityinstance);
                           }
                        }
                     }
                  }
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
