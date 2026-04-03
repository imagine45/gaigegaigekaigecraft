package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class DaitenguFanRightclickedProcedure {
   public DaitenguFanRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.EMPTY;
         double old_skill = 0.0;
         double distance = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double entity_size = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.DAITENGU_FAN.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_a = var10000.copy();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.DAITENGU_FAN.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               item_a = var10000.copy();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.OFF_HAND, true);
               }
            }
         }

         if (item_a.getItem() == JujutsucraftModItems.DAITENGU_FAN.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity9 = (LivingEntity)entity;
               if (_livingEntity9.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity9.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity11 = (LivingEntity)entity;
               if (_livingEntity11.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity11.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue((double)Mth.nextInt(RandomSource.create(), 0, 1));
               }
            }

            label120: {
               PlayAnimationProcedure.execute(world, entity);
               if (entity instanceof Player) {
                  Player _plr = (Player)entity;
                  if (_plr.getAbilities().instabuild) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getCooldowns().addCooldown(item_a.getItem(), 20);
                     }
                     break label120;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getCooldowns().addCooldown(item_a.getItem(), 200);
               }
            }

            old_skill = entity.getPersistentData().getDouble("skill");
            entity.getPersistentData().putDouble("skill", 1.0);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
               }
            }

            entity_size = ReturnEntitySizeProcedure.execute(entity);
            CNT6 = 1.0;
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(1.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            x_power = entity.getLookAngle().x;
            y_power = entity.getLookAngle().y;
            z_power = entity.getLookAngle().z;

            for(int index0 = 0; index0 < 16; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               entity.getPersistentData().putDouble("Damage", 15.0);
               if (dis > 0.0) {
                  for(int index1 = 0; index1 < (int)dis; ++index1) {
                     entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.9);
                     if (entity.getPersistentData().getDouble("Damage") < 10.0) {
                        entity.getPersistentData().putDouble("Damage", 10.0);
                        break;
                     }
                  }
               }

               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * CNT6);
               entity.getPersistentData().putDouble("Range", 10.0 * CNT6 * entity_size);
               entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("BlockRange", 4.0 * CNT6 * entity_size);
               entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
               entity.getPersistentData().putBoolean("noEffect", true);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               ++dis;
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            distance = (double)(1.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 16.0 * CNT6 * entity_size);
            entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("Range", 16.0 * CNT6 * entity_size);
            entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
            KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(10.0 * CNT6 * entity_size), 4.0 * entity_size, 4.0 * entity_size, 4.0 * entity_size, 1.0);
            }

            for(int index2 = 0; index2 < (int)(36.0 * CNT6 * entity_size); ++index2) {
               ParticleGeneratorProcedure.execute(world, entity_size * 0.1, 1.0, 35.0, Mth.nextDouble(RandomSource.create(), 4.0, 8.0), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "minecraft:cloud");
            }

            entity.getPersistentData().putDouble("skill", old_skill);
         }

      }
   }
}
