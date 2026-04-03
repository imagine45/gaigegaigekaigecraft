package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueMythicalBeastAmberProcedure {
   public TechniqueMythicalBeastAmberProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 5, 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (((Entity)var10000).isAlive()) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)(1.0 * range), 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, (float)(1.0 * range), 0.5F, false);
               }
            }

            entity.getPersistentData().putDouble("Damage", 6.0);
            DamageFixProcedure.execute(entity);
            if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(""), true);
                  }
               }

               entity.getPersistentData().putDouble("skill", 0.0);
            } else {
               power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt1")) * 0.25);
               STR1 = Component.translatable("jujutsu.message.long_press").getString();

               for(int index0 = 0; index0 < (int)power; ++index0) {
                  STR1 = "■" + STR1 + "■";
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(STR1), true);
                  }
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 4.0 * range, 90.0, 0.5 * range, 0.75 * range, 1.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_thunder_blue");
         } else {
            entity.getPersistentData().putDouble("Damage", 15.0);
            DamageFixProcedure.execute(entity);
            if (entity.getPersistentData().getDouble("cnt1") <= 21.0) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(""), true);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var10001;
                     MobEffect var10003;
                     int var10005;
                     label96: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label96;
                           }
                        }

                        var10005 = 0;
                     }

                     var10001 = new MobEffectInstance(var10003, 2147483647, var10005, true, true);
                     _entity.addEffect(var10001);
                  }
               }

               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + 500.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
               boolean _setvalbool = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setvalbool;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }

            ParticleGeneratorCircleProcedure.execute(world, 8.0 * range, 90.0, 0.5 * range, 0.75 * range, 4.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_flame_purple");
            ParticleGeneratorCircleProcedure.execute(world, 8.0 * range, 90.0, 0.0 * range, 8.0 * range, 4.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_thunder_blue");
            if (entity.getPersistentData().getDouble("cnt1") >= 35.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
