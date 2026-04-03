package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CockroachLarvaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectAttackProcedure {
   public EffectAttackProcedure() {
   }

   public static void execute(LevelAccessor world, Entity damaged_entity, Entity entity) {
      if (damaged_entity != null && entity != null) {
         Entity entity_a = null;
         ItemStack item_A = ItemStack.EMPTY;
         String STR1 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         double T1 = 0.0;
         double T1source = 0.0;
         double T2Source = 0.0;
         double T2 = 0.0;
         entity_a = damaged_entity;
         if (damaged_entity instanceof LivingEntity) {
            if (damaged_entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)damaged_entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                  return;
               }
            }

            if (entity instanceof Player) {
               JujutsucraftModVariables.PlayerVariables pVars_source = null;
               pVars_source = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
               T1source = pVars_source.PlayerCurseTechnique;
               T2Source = pVars_source.PlayerCurseTechnique2;
            }

            label240: {
               x_pos = damaged_entity.getX();
               y_pos = damaged_entity.getY() + (double)damaged_entity.getBbHeight() * 0.5;
               z_pos = damaged_entity.getZ();
               if (entity instanceof Player) {
                  if (T1source != 7.0 && T2Source != 7.0) {
                     break label240;
                  }
               } else if (!(entity instanceof KashimoHajimeEntity)) {
                  break label240;
               }

               NUM1 = damaged_entity.getPersistentData().getDouble("Thunder");
               if (entity.getPersistentData().getDouble("cnt5") != 0.0 && !(entity.getPersistentData().getDouble("cnt5") >= 100.0)) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
                  }

                  damaged_entity.getPersistentData().putDouble("Thunder", damaged_entity.getPersistentData().getDouble("Thunder") + 0.1);
               } else {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 5, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.1);
                  }

                  damaged_entity.getPersistentData().putDouble("Thunder", damaged_entity.getPersistentData().getDouble("Thunder") + 1.0);
               }

               if (NUM1 < 5.0 && damaged_entity.getPersistentData().getDouble("Thunder") >= 5.0 || damaged_entity.getPersistentData().getDouble("Thunder") >= 15.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 10, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.25);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                     }
                  }
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            item_A = var10000.copy();
            if (entity instanceof Player) {
               Player _plrCldCheck32 = (Player)entity;
               if (_plrCldCheck32.getCooldowns().isOnCooldown(item_A.getItem())) {
                  return;
               }
            }

            if (item_A.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get() && (damaged_entity.getPersistentData().getDouble("skill") == 0.0 || !damaged_entity.getPersistentData().getBoolean("attack"))) {
               label237: {
                  if (damaged_entity instanceof LivingEntity) {
                     LivingEntity _livEnt36 = (LivingEntity)damaged_entity;
                     if (_livEnt36.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                        break label237;
                     }
                  }

                  NUM1 = 0.0;

                  for(int index0 = 0; index0 < 200; ++index0) {
                     ++NUM1;
                     STR1 = item_A.getOrCreateTag().getString("TARGET" + Math.round(NUM1));
                     if (STR1.isEmpty()) {
                        break;
                     }

                     if (STR1.equals(entity_a.getStringUUID())) {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                        }

                        if (!entity_a.level().isClientSide() && entity_a.getServer() != null) {
                           entity_a.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity_a.position(), entity_a.getRotationVector(), entity_a.level() instanceof ServerLevel ? (ServerLevel)entity_a.level() : null, 4, entity_a.getName().getString(), entity_a.getDisplayName(), entity_a.level().getServer(), entity_a), "kill @s");
                        }
                        break;
                     }
                  }
               }
            }

            if (item_A.getItem() == JujutsucraftModItems.FESTER_LIFE_BLADE.get()) {
               label229: {
                  if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                     LivingEntity _livEnt43 = (LivingEntity)entity;
                     if (_livEnt43.hasEffect(MobEffects.UNLUCK)) {
                        break label229;
                     }
                  }

                  if (!(entity_a instanceof CockroachLarvaEntity) && !entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && (entity_a.getPersistentData().getDouble("skill") == 0.0 || !entity_a.getPersistentData().getBoolean("attack"))) {
                     label238: {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt48 = (LivingEntity)entity_a;
                           if (_livEnt48.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                              break label238;
                           }
                        }

                        if (entity instanceof Player) {
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getCooldowns().addCooldown(item_A.getItem(), 200);
                           }
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.UNLUCK, 200, 0, false, false));
                           }
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 4, false, false));
                           }
                        }

                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity_a;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 60, 9, false, false));
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           Entity entityToSpawn = ((EntityType)JujutsucraftModEntities.COCKROACH_LARVA.get()).spawn(_level, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED);
                           if (entityToSpawn != null) {
                              entityToSpawn.setYRot((float)(Math.random() * 720.0));
                              entityToSpawn.setYBodyRot((float)(Math.random() * 720.0));
                              entityToSpawn.setYHeadRot((float)(Math.random() * 720.0));
                              entityToSpawn.setXRot(-90.0F);
                              entityToSpawn.setDeltaMovement((Math.random() - 0.5) * 0.1, 0.5, (Math.random() - 0.5) * 0.1);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1.0F, 1.25F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.NEUTRAL, 1.0F, 1.25F, false);
                           }
                        }

                        Effect1Procedure.execute(world, entity, entity_a);
                     }
                  }
               }
            }

            if (item_A.getItem() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get() || item_A.getItem() == JujutsucraftModItems.BLACK_ROPE.get()) {
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CANCEL_CURSED_TECHNIQUE.get(), 1, 0, false, false));
                  }
               }

               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get(), 10, 0, false, false));
                  }
               }
            }

         }
      }
   }
}
