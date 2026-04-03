package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ProjectileSlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillSukunaCombo3Procedure {
   public SkillSukunaCombo3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_b = ItemStack.EMPTY;
         ItemStack item_a = ItemStack.EMPTY;
         Entity target_entity = null;
         double old_cnt1 = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double size = 0.0;
         double HP = 0.0;
         double yaw1 = 0.0;
         double pitch1 = 0.0;
         boolean sword = false;
         boolean vertical = false;
         entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1") + 1.0, 10.0));
         entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         sword = LogicSwordProcedure.execute(entity);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var45 = var10000;
         if (var45 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var45).getX(), ((Entity)var45).getY() + (double)((Entity)var45).getBbHeight() * 0.5, ((Entity)var45).getZ(), entity);
         }

         old_cnt1 = entity.getPersistentData().getDouble("cnt1");
         old_skill = entity.getPersistentData().getDouble("skill");
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = (double)(0.0F + entity.getBbWidth());
         double var92 = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         var92 = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
         var92 = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt5") <= 100.0) {
            ItemStack var95;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var95 = _livEnt.getMainHandItem();
            } else {
               var95 = ItemStack.EMPTY;
            }

            item_a = var95.copy().copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var95 = _livEnt.getOffhandItem();
            } else {
               var95 = ItemStack.EMPTY;
            }

            item_b = var95.copy().copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.EMPTY.copy();
               _setstack.setCount(1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = ItemStack.EMPTY.copy();
               _setstack.setCount(1);
               _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity.getPersistentData().getDouble("cnt5") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity32 = (LivingEntity)entity;
                  if (_livingEntity32.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity32.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity33 = (LivingEntity)entity;
                  if (_livingEntity33.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity33.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(3.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               entity.setYRot((float)yaw);
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * -3.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * -3.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * -3.0);
               entity.setYRot((float)yaw);
               entity.setXRot((float)pitch);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), 0.5, entity.getPersistentData().getDouble("z_power")));
            }

            if (entity.getPersistentData().getDouble("cnt5") >= 6.0) {
               if (!(entity.getPersistentData().getDouble("cnt5") <= 10.0)) {
                  entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
               } else if (LogicStartPassiveProcedure.execute(entity)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
                     }
                  }

                  yaw1 = (double)entity.getYRot();
                  pitch1 = (double)entity.getXRot();
                  entity.setYRot((float)(yaw1 + Mth.nextDouble(RandomSource.create(), -11.25, 11.25)));
                  entity.setXRot((float)(pitch1 + Mth.nextDouble(RandomSource.create(), -11.25, 11.25)));
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 2.0F, 2.0F, false);
                     }
                  }

                  int var10001;
                  label153: {
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     pitch = Math.toRadians((double)entity.getXRot());
                     distance = 0.5 * (double)entity.getBbWidth();
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label153;
                        }
                     }

                     var10001 = 0;
                  }

                  HP = (double)(30 + var10001 * 7);
                  size = 0.5 * ReturnEntitySizeProcedure.execute(entity);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.PROJECTILE_SLASH.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

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

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity72 = (LivingEntity)entityinstance;
                           if (_livingEntity72.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity72.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity76 = (LivingEntity)entityinstance;
                           if (_livingEntity76.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity76.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                           }
                        }

                        entityinstance.getPersistentData().putDouble("size", size * 5.0 * (1.0 + 0.5 * entity.getPersistentData().getDouble("cnt6")));
                        entityinstance.getPersistentData().putDouble("cnt6", 1.0 + entity.getPersistentData().getDouble("cnt5") * 0.05);
                        entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 9.0);
                        entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 9.0);
                        entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 9.0);
                        entityinstance.getPersistentData().putDouble("skill", 105.0);
                        entityinstance.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
                        if (entityinstance instanceof ProjectileSlashEntity) {
                           RandomSource var97 = RandomSource.create();
                           PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round((float)Mth.nextInt(var97, 1, 5)));
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  entity.setYRot((float)yaw1);
                  entity.setXRot((float)pitch1);
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt5", Math.max(entity.getPersistentData().getDouble("cnt5"), 100.0));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_a.copy();
               _setstack.setCount(item_a.getCount());
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_b.copy();
               _setstack.setCount(item_b.getCount());
               _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }

            entity.getPersistentData().putDouble("cnt1", old_cnt1);
            entity.getPersistentData().putDouble("skill", old_skill);
         } else if (entity.getPersistentData().getDouble("cnt5") > 110.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
