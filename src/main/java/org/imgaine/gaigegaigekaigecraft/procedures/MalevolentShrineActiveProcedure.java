package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;

import net.minecraft.nbt.CompoundTag;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class MalevolentShrineActiveProcedure {
   public MalevolentShrineActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double count_A;
         double var10000;
         int var10001;
         label186: {
            String STR1 = "";
            double old_skill = 0.0;
            count_A = 0.0;
            double z_center = 0.0;
            double range = 0.0;
            double old_cooldown = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double y_center = 0.0;
            double dis = 0.0;
            double dust_amount = 0.0;
            double x_center = 0.0;
            double num1 = 0.0;
            double y_pos = 0.0;
            double num2 = 0.0;
            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                  break label186;
               }
            }

            var10001 = 0;
         }

         double var39 = var10000 * (double)(var10001 > 0 ? 18 : 2);
         double var36 = entity.getPersistentData().getDouble("skill");
         double var40 = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
         entity.getPersistentData().putDouble("y_knockback", -0.1);

         for(int index0 = 0; index0 < 4; ++index0) {
            double var41;
            double var44;
            double var54;
            int var73;
            label177: {
               double var51 = count_A % 2.0 == 0.0 ? 1.0 : -1.0;
               double var57 = count_A % 4.0 <= 1.0 ? 1.0 : -1.0;
               var41 = entity.getPersistentData().getDouble("x_pos_doma") + var39 * 0.25 * var51;
               var54 = entity.getPersistentData().getDouble("y_pos_doma") + var39 * 0.25 - 15.0;
               var44 = entity.getPersistentData().getDouble("z_pos_doma") + var39 * 0.25 * var57;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var73 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label177;
                  }
               }

               var73 = 0;
            }

            if (var73 % 2 == 1) {
               entity.getPersistentData().putDouble("skill", 105.0);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
            } else {
               entity.getPersistentData().putDouble("skill", 106.0);
               entity.getPersistentData().putDouble("COOLDOWN_TICKS", 100.0);
            }

            int var10003;
            CompoundTag var74;
            label171: {
               var74 = entity.getPersistentData();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10003 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label171;
                  }
               }

               var10003 = 0;
            }

            var74.putDouble("Damage", 10.5 + (double)(var10003 % 10) * 0.1);
            entity.getPersistentData().putDouble("Range", var39 * 0.5);
            entity.getPersistentData().putDouble("effect", 1.0);
            entity.getPersistentData().putDouble("effectConfirm", 1.0);
            entity.getPersistentData().putDouble("knockback", 0.001);
            entity.getPersistentData().putBoolean("swing", false);
            entity.getPersistentData().putBoolean("attack", false);
            entity.getPersistentData().putBoolean("DomainAttack", true);
            entity.getPersistentData().putBoolean("ExtinctionBlock", true);
            RangeAttackProcedure.execute(world, var41, var54, var44, entity);
            ++count_A;
         }
         int var75;
         label163: {
            entity.getPersistentData().putBoolean("ExtinctionBlock", false);
            entity.getPersistentData().putDouble("y_knockback", 0.0);
            entity.getPersistentData().putDouble("skill", var36);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", var40);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var75 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                  break label163;
               }
            }

            var75 = 0;
         }

         if (var75 > 0) {
            if (entity.getPersistentData().getDouble("dust_amount") <= 0.0) {
               entity.getPersistentData().putDouble("dust_amount", 1.0);
            }

            double var50 = entity.getPersistentData().getDouble("x_pos_doma");
            double var47 = entity.getPersistentData().getDouble("y_pos_doma");
            double var38 = entity.getPersistentData().getDouble("z_pos_doma");
            double var52 = 0.0;

            for(int index1 = 0; index1 < 512; ++index1) {
               count_A = Math.toRadians(Math.random() * 360.0);
               double var48 = var39 * 0.5 * (Math.random() * 2.0 - 1.0);
               double var42 = var50 + Math.sin(count_A) * var48;
               double var55 = var47 + Math.random() * var39 * 0.2;
               double var45 = var38 + Math.cos(count_A) * var48;
               if (!world.isEmptyBlock(BlockPos.containing(var42, var55, var45))) {
                  entity.getPersistentData().putDouble("dust_amount", Math.min(entity.getPersistentData().getDouble("dust_amount") + 1.0, 200.0));
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.EXPLOSION, var42, var55, var45, 2, 1.5, 1.5, 1.5, 0.0);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, var42, var55, var45, 2, 1.5, 1.5, 1.5, 0.5);
                  }

                  entity.getPersistentData().putBoolean("noParticle", true);
                  entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                  entity.getPersistentData().putDouble("BlockRange", 16.0);
                  entity.getPersistentData().putDouble("BlockDamage", 99.0);
                  BlockDestroyAllDirectionProcedure.execute(world, var42, Math.max(var55, var47 + 8.0), var45, entity);
                  if (var52 < 32.0 || var52 / 512.0 < Math.random()) {
                     break;
                  }
               }

               ++var52;
            }

            double var49 = (double)Math.round(entity.getPersistentData().getDouble("dust_amount") / 200.0 * 10.0);
            if (entity instanceof Player) {
               int var76;
               label140: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var76 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                        break label140;
                     }
                  }

                  var76 = 0;
               }

               if (var76 % 10 == 0) {
                  String _setval1 = "DUST";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY1 = _setval1;
                     capability.syncPlayerVariables(entity);
                  });
                  String _setval2 = "";
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval2;
                     capability.syncPlayerVariables(entity);
                  });
                  String _setval3 = "§l§4";
                  var52 = 0.0;

                  for(int index2 = 0; index2 < 10; ++index2) {
                     if (var52 == var49) {
                        _setval3 = _setval3 + "§r§7";
                     }

                     ++var52;
                     _setval3 = _setval3 + "■";
                  }
                  String _setval4 = _setval3;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.OVERLAY2 = _setval4;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            double var43 = entity.getPersistentData().getDouble("x_pos_doma");
            double var56 = entity.getPersistentData().getDouble("y_pos_doma");
            double var46 = entity.getPersistentData().getDouble("z_pos_doma");
            if (entity.getPersistentData().getDouble("skill") == 107.0) {
               for(int index3 = 0; index3 < (int)(var49 + 1.0); ++index3) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.WHITE_ASH, var43, var56, var46, 50, var39 * 0.25, var39 * 0.25, var39 * 0.25, 0.1);
                  }
               }
            } else {
               for(int index4 = 0; index4 < (int)(var49 + 1.0); ++index4) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ASH, var43, var56, var46, 50, var39 * 0.25, var39 * 0.25, var39 * 0.25, 0.1);
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("Failed")) {
               for(Entity entityiterator : new ArrayList<Entity>(world.players())) {
                  if (CanSeeSukunaSlashProcedure.execute(world, entity, entityiterator) && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "particle gaigegaigekaigecraft:particle_slash_large " + var50 + " " + var47 + " " + var38 + " " + var39 * 0.25 + " " + var39 * 0.25 + " " + var39 * 0.25 + " 0.01 " + Math.round(4.0 * var39) + " normal");
                  }
               }
            }
         }

      }
   }
}
