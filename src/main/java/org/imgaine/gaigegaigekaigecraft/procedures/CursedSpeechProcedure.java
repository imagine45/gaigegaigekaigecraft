package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class CursedSpeechProcedure {
   public CursedSpeechProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rad_now = 0.0;
         double Knockback = 0.0;
         double Effect = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double Damage = 0.0;
         double dis = 0.0;
         double power = 0.0;
         double old2 = 0.0;
         double old1 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         Effect = entity.getPersistentData().getDouble("skill");
         if (entity.getPersistentData().getDouble("cnt1") <= 5.0) {
            if (entity instanceof Player) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
               }
            }

            if (Effect == 305.0) {
               Damage = 42.0;
            } else if (Effect == 306.0) {
               Damage = 33.0;
            } else if (Effect == 307.0) {
               Damage = 50.0;
            } else if (Effect == 308.0) {
               Damage = 1.0;
            } else if (Effect == 309.0) {
               Damage = 27.0;
               Knockback = 4.0;
            }

            if (Damage >= 10.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ATTACKING.get(), 1, 1, false, false));
               }
            }

            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var10000 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var10000.ifPresent(new NonNullConsumer<IItemHandler>() {
               @Override
               public void accept(@NotNull IItemHandler o) {
                  _iitemhandlerref.set(o);
               }
            });
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                  if (itemstackiterator.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && itemstackiterator.getOrCreateTag().getBoolean("Used")) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     Damage *= 0.75;
                     break;
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() + 90.0F));
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               entity.getPersistentData().putDouble("x_pos", entity.getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.7);
               entity.getPersistentData().putDouble("z_pos", entity.getZ());
               LivingEntity var64;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var64 = _mobEnt.getTarget();
               } else {
                  var64 = null;
               }

               if (var64 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.getTarget();
                  } else {
                     var64 = null;
                  }

                  x_pos = ((Entity)var64).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var64 = _mobEnt.getTarget();
                  } else {
                     var64 = null;
                  }

                  double var67 = ((Entity)var64).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var67 + (double)((Entity)var10001).getBbHeight() * 0.7;
                  LivingEntity var68;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var68 = _mobEnt.getTarget();
                  } else {
                     var68 = null;
                  }

                  z_pos = ((Entity)var68).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 2.0);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 2.0);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 2.0);
            }

            rad_now = Math.toRadians(entity.getPersistentData().getDouble("yaw") + 90.0);

            for(int index0 = 0; index0 < 2; ++index0) {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
               dis = (entity.getPersistentData().getDouble("cnt3") - 0.0) * 0.8 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2);
               entity.getPersistentData().putDouble("Damage", Damage);
               entity.getPersistentData().putDouble("Range", dis * 2.0);
               entity.getPersistentData().putDouble("effect", Effect);
               entity.getPersistentData().putDouble("effectConfirm", 2.0);
               entity.getPersistentData().putDouble("knockback", Knockback);
               entity.getPersistentData().putBoolean("onlyLiving", true);
               RangeAttackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
               if (Effect == 309.0) {
                  entity.getPersistentData().putDouble("effect", 0.0);
                  entity.getPersistentData().putDouble("knockback", Knockback);
                  KnockbackProcedure.execute(world, entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
               }

               entity.getPersistentData().putBoolean("onlyLiving", false);
               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power") * 1.0);
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power") * 1.0);
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power") * 1.0);
            }

            entity.getPersistentData().putDouble("Damage", 0.0);
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.8;
            z_pos = entity.getZ();
            ParticleGeneratorCircleProcedure.execute(world, 36.0, entity.getPersistentData().getDouble("pitch"), 0.0, 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2, 8.0, x_pos, x_pos + entity.getPersistentData().getDouble("x_power"), y_pos, y_pos + entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("yaw") - 90.0, z_pos, z_pos + entity.getPersistentData().getDouble("z_power"), "minecraft:enchanted_hit");
         }

         if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
            label214: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt83 = (LivingEntity)entity;
                  if (_livEnt83.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                     break label214;
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") == 0.0) {
                  if (!(entity.getPersistentData().getDouble("cnt10") >= 1.0)) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange + entity.getPersistentData().getDouble("used_technique_cost");
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                     }

                     entity.getPersistentData().putDouble("skill", 0.0);
                  } else {
                     double var69;
                     int var72;
                     label205: {
                        var69 = entity.getPersistentData().getDouble("cnt10");
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var72 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label205;
                           }
                        }

                        var72 = 0;
                     }

                     power = var69 - (double)var72;
                     if (power >= 0.0) {
                        label199: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var69 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label199;
                              }
                           }

                           var69 = 0.0;
                        }

                        label194: {
                           old1 = var69;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var69 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration();
                                 break label194;
                              }
                           }

                           var69 = 0.0;
                        }

                        old2 = var69;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect(MobEffects.DAMAGE_RESISTANCE);
                        }

                        entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("gaigegaigekaigecraft:damage_curse")))), (float)((2.5 + power * 1.25) * (double)(entity instanceof Player ? 1 : 5)));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, (int)old2, (int)old1, false, false));
                           }
                        }

                        for(int index1 = 0; index1 < (int)Math.min(power + 1.0, 10.0); ++index1) {
                           Effect1Procedure.execute(world, entity, entity);
                           if (!entity.isAlive()) {
                              break;
                           }
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound gaigegaigekaigecraft:tinnitus master @s");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 20, 0, false, false));
                           }
                        }

                        power = Math.min(Math.max(entity.getPersistentData().getDouble("COOLDOWN_TICKS") * (1.0 + Math.max(power, 0.0) * 0.1), 1.0), 1200.0);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity = (LivingEntity)entity;
                           _livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                        }
                     }
                  }

                  if (Effect == 308.0) {
                     power = entity.getPersistentData().getDouble("COOLDOWN_TICKS") * 2.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity = (LivingEntity)entity;
                        _livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)power, 0, false, false));
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
