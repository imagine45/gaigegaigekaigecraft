package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ThrowingItemOnEntityTickUpdateProcedure {
   public ThrowingItemOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         Entity owner_entity = null;
         double strength = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double speed = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double weapon_size = 0.0;
         double x_power = 0.0;
         double attack_reach = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         boolean logic_a = false;
         boolean logic_b = false;
         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (!entity.getPersistentData().getString("OWNER_UUID").isEmpty()) {
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (!(owner_entity instanceof LivingEntity)) {
               entity.getPersistentData().putString("OWNER_UUID", "");
               owner_entity = null;
            }
         }

         int var10000;
         label216: {
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label216;
               }
            }

            var10000 = 0;
         }

         strength = (double)Math.min(var10000, 50) * CNT6;
         weapon_size = GetWeaponSizeProcedure.execute(entity);
         attack_reach = GetReachProcedure.execute(entity);
         range = ReturnEntitySizeProcedure.execute(entity);
         range = range * range * Math.sqrt(weapon_size * attack_reach);
         ItemStack var100;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var100 = _livEnt.getMainHandItem();
         } else {
            var100 = ItemStack.EMPTY;
         }

         item_a = var100.copy();
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + Mth.nextDouble(RandomSource.create(), 0.0, 90.0) * (entity.getPersistentData().getDouble("cnt_life") % 16.0));
         pitch = Math.toRadians((double)entity.getXRot());
         dis = 2.5 * range;
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
         y_pos = entity.getY() + Math.sin(pitch) * -1.0 * dis;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))));
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(range * 1.0), (float)(1.0 / (weapon_size + item_a.getOrCreateTag().getDouble("Power"))), false);
            }
         }

         ParticleGeneratorProcedure.execute(world, range * 0.1, 1.0, 5.0, 8.0, entity.getX(), x_pos, entity.getY(), y_pos, entity.getZ(), z_pos, "minecraft:crit");
         x_pos = entity.getX();
         y_pos = entity.getY();
         z_pos = entity.getZ();
         if (owner_entity instanceof LivingEntity && item_a.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
            x_power = owner_entity.getX() - entity.getX();
            y_power = owner_entity.getY() + (double)owner_entity.getBbHeight() * 0.75 - entity.getY();
            z_power = owner_entity.getZ() - entity.getZ();
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            speed = 3.0;
            if (dis != 0.0) {
               x_power = x_power / dis * speed;
               y_power = y_power / dis * speed;
               z_power = z_power / dis * speed;
            }

            vx = Math.abs(x_power - entity.getPersistentData().getDouble("x_power")) * (double)(x_power > entity.getPersistentData().getDouble("x_power") ? 1 : -1);
            vy = Math.abs(y_power - entity.getPersistentData().getDouble("y_power")) * (double)(y_power > entity.getPersistentData().getDouble("y_power") ? 1 : -1);
            vz = Math.abs(z_power - entity.getPersistentData().getDouble("z_power")) * (double)(z_power > entity.getPersistentData().getDouble("z_power") ? 1 : -1);
            dis = Math.sqrt(vx * vx + vy * vy + vz * vz);
            speed = 0.2;
            if (dis != 0.0) {
               vx = vx / dis * speed;
               vy = vy / dis * speed;
               vz = vz / dis * speed;
            }

            entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") + vx);
            entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") + vy);
            entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") + vz);
         }

         x_power = entity.getPersistentData().getDouble("x_power");
         y_power = entity.getPersistentData().getDouble("y_power");
         z_power = entity.getPersistentData().getDouble("z_power");
         entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis != 0.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
            if (!logic_a) {
               entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
               entity.getPersistentData().putDouble("knockback", 0.25 * (1.0 + Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0) * 0.1));
               entity.getPersistentData().putDouble("Range", 6.0 * range);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putDouble("projectile_type", 1.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.25, z_pos, (double)entity.getBbHeight() * 0.5, (double)(entity.getBbWidth() * 2.0F))) {
                  d = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                  entity.getPersistentData().putDouble("BlockDamage", (0.1 + strength / 16.0) * Math.max(d * 0.25, 1.0));
                  entity.getPersistentData().putDouble("BlockRange", Math.max(0.5 * range, Math.max(d * 0.25, 1.0)));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putBoolean("noEffect", true);
                  if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.25, z_pos, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5)) {
                     logic_a = true;
                  }
               }

               if (item_a.getItem() == JujutsucraftModItems.DRAGON_BONE.get() && entity.getPersistentData().getDouble("cnt_life") > 20.0 && !logic_b && owner_entity instanceof LivingEntity) {
                  Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entity.getPersistentData().getString("OWNER_UUID").equals(entityiterator.getStringUUID())) {
                        logic_b = true;
                        entity.getPersistentData().putDouble("cnt_return", Math.max(entity.getPersistentData().getDouble("cnt_return"), 1.0));
                        break;
                     }
                  }
               }
            }

            if (logic_a) {
               break;
            }

            x_pos += x_power;
            y_pos += y_power;
            z_pos += z_power;
         }

         entity.getPersistentData().putBoolean("noEffect", false);
         if (item_a.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var100 = _livEnt.getMainHandItem();
            } else {
               var100 = ItemStack.EMPTY;
            }

            var100.getOrCreateTag().putDouble("power_energy", 0.0);
         }

         if (item_a.getItem() == JujutsucraftModItems.GAVEL.get() && entity.getPersistentData().getDouble("cnt_life") > 6.0) {
            entity.getPersistentData().putDouble("cnt_return", Math.max(entity.getPersistentData().getDouble("cnt_return"), 1.0));
         }

         if (entity.getPersistentData().getDouble("cnt_return") > 0.0) {
            entity.getPersistentData().putDouble("cnt_return", entity.getPersistentData().getDouble("cnt_return") + 1.0);
            if (entity.getPersistentData().getDouble("cnt_return") > 2.0 && owner_entity instanceof LivingEntity) {
               if (owner_entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)owner_entity;
                  var100 = _livEnt.getMainHandItem();
               } else {
                  var100 = ItemStack.EMPTY;
               }

               if (var100.getItem() == ItemStack.EMPTY.getItem()) {
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_entity;
                     ItemStack _setstack = item_a.copy().copy();
                     _setstack.setCount(item_a.getCount());
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else {
                  if (owner_entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)owner_entity;
                     var100 = _livEnt.getOffhandItem();
                  } else {
                     var100 = ItemStack.EMPTY;
                  }

                  if (var100.getItem() == ItemStack.EMPTY.getItem()) {
                     if (owner_entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)owner_entity;
                        ItemStack _setstack = item_a.copy().copy();
                        _setstack.setCount(item_a.getCount());
                        _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }
                  } else if (owner_entity instanceof Player) {
                     Player _player = (Player)owner_entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var100 = _livEnt.getMainHandItem();
                     } else {
                        var100 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var100.copy().copy();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10001 = _livEnt.getMainHandItem();
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     _setstack.setCount(var10001.getCount());
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }
               }

               if (owner_entity instanceof Player) {
                  Player _player = (Player)owner_entity;
                  _player.getCooldowns().addCooldown(item_a.getItem(), InlineMethodHandler.checkGamemodeCreative(owner_entity) ? 10 : 10);
               }

               if (!owner_entity.level().isClientSide() && owner_entity.getServer() != null) {
                  owner_entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, owner_entity.position(), owner_entity.getRotationVector(), owner_entity.level() instanceof ServerLevel ? (ServerLevel)owner_entity.level() : null, 4, owner_entity.getName().getString(), owner_entity.getDisplayName(), owner_entity.level().getServer(), owner_entity), "playsound minecraft:entity.item.pickup player @s");
               }

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

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt_life") > 100.0 && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

      }
   }
}
