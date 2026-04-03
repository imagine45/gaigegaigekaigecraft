package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIImpactWaveProcedure {
   public AIImpactWaveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double CNT6 = 0.0;
         double size = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double life = 0.0;
         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         range = (double)(entity.getBbHeight() + entity.getBbWidth()) * 0.75 + 4.0;
         int var10000;
         if (entity instanceof EntityImpactWaveEntity) {
            EntityImpactWaveEntity _datEntI = (EntityImpactWaveEntity)entity;
            var10000 = (Integer)_datEntI.getEntityData().get(EntityImpactWaveEntity.DATA_mode);
         } else {
            var10000 = 0;
         }

         if (var10000 == 2) {
            life = 12.0;
            size = 6.0;
         } else {
            if (entity instanceof EntityImpactWaveEntity) {
               EntityImpactWaveEntity _datEntI = (EntityImpactWaveEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityImpactWaveEntity.DATA_mode);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               life = 10.0;
               size = 6.0 + entity.getPersistentData().getDouble("cnt6");
            } else {
               life = 15.0;
               size = 12.0;
            }
         }
         double var36;
         label109: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity13 = (LivingEntity)entity;
               if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  var36 = _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                  break label109;
               }
            }

            var36 = 0.0;
         }

         if (var36 < size) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity15 = (LivingEntity)entity;
               if (_livingEntity15.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  double var10001;
                  AttributeInstance var37;
                  label100: {
                     var37 = _livingEntity15.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity14 = (LivingEntity)entity;
                        if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10001 = _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label100;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var37.setBaseValue(var10001 + Math.max(life / size, 1.5));
               }
            }

            entity.teleportTo(entity.getX(), entity.getY() - Math.max(life / size, 1.5) * 0.5, entity.getZ());
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity.getX(), entity.getY() - Math.max(life / size, 1.5) * 0.5, entity.getZ(), entity.getYRot(), entity.getXRot());
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               BlockPos var10002;
               SoundEvent var10003;
               SoundSource var10004;
               double var10005;
               label88: {
                  var10002 = BlockPos.containing(x_pos, y_pos, z_pos);
                  var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode"));
                  var10004 = SoundSource.NEUTRAL;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10005 = _livingEntity20.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label88;
                     }
                  }

                  var10005 = 0.0;
               }

               _level.playSound((Player)null, var10002, var10003, var10004, (float)(var10005 * 0.1 + 1.0), 0.5F);
            } else {
               SoundEvent var38;
               SoundSource var39;
               double var10006;
               label83: {
                  var38 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode"));
                  var39 = SoundSource.NEUTRAL;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        var10006 = _livingEntity20.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                        break label83;
                     }
                  }

                  var10006 = 0.0;
               }

               _level.playLocalSound(x_pos, y_pos, z_pos, var38, var39, (float)(var10006 * 0.1 + 1.0), 0.5F, false);
            }
         }

         entity.getPersistentData().putDouble("Damage", (double)(entity.getPersistentData().getDouble("cnt1") > life - 6.0 ? 18 : 16) * CNT6 + entity.getPersistentData().getDouble("cnt1") * 0.001);
         entity.getPersistentData().putDouble("Range", 1.5 * range);
         entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("cnt1") > life - 6.0 ? Math.min(0.5 * CNT6, 2.0) : 0.1);
         entity.getPersistentData().putDouble("effect", 0.0);
         RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (entity.getPersistentData().getDouble("cnt1") % 6.0 == 1.0) {
            entity.getPersistentData().putDouble("BlockRange", 0.5 * range);
            entity.getPersistentData().putDouble("BlockDamage", 8.0);
            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         entity.getPersistentData().putDouble("Range", 1.5 * range);
         entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("cnt1") > life - 6.0 ? Math.min(0.5 * CNT6, 2.0) : 0.1);
         KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:cloud ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " 4 " + Math.round(2.0 * range) + " force");
         }

         if (entity.getPersistentData().getDouble("cnt1") > life && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
