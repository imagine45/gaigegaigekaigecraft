package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LightningStrikeProcedure {
   public LightningStrikeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_power = 0.0;
         double energy = 0.0;
         double repeat_num_now = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double x_pos_test = 0.0;
         double y_pos_test = 0.0;
         double z_pos_test = 0.0;
         double CNT6 = 0.0;
         if ((entity.getPersistentData().getDouble("cnt1") != 0.0 || !entity.isInWater()) && !(entity.getPersistentData().getDouble("cnt2") > 180.0)) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(8.0 * ReturnEntitySizeProcedure.execute(entity)), 0.25 * (double)entity.getBbWidth(), 0.25 * (double)entity.getBbHeight(), 0.25 * (double)entity.getBbWidth(), 0.1);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               for(int index0 = 0; index0 < 100; ++index0) {
                  logic_attack = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
                     if (entity != entityiterator) {
                        if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (!(entityiterator instanceof EntityItemEntity)) {
                              continue;
                           }

                           ItemStack var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           if (var10000.getItem() != JujutsucraftModItems.NYOI_STAFF.get() || !entity.getStringUUID().equals(entityiterator.getPersistentData().getString("OWNER_UUID"))) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().getDouble("Thunder") >= 5.0) {
                           logic_a = true;
                           logic_attack = true;
                           power = Math.min(entityiterator.getPersistentData().getDouble("Thunder"), 15.0) - 5.0;
                           dis = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           x_target = entityiterator.getX();
                           y_target = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5 + (double)entityiterator.getBbHeight() * 0.5 * Math.random();
                           z_target = entityiterator.getZ();
                           entityiterator.getPersistentData().putDouble("Thunder", 0.0);
                           break;
                        }
                     }
                  }

                  if (!logic_attack) {
                     entity.getPersistentData().putDouble("Damage", max_power);
                     break;
                  }

                  x_pos = entity.getX();
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  z_pos = entity.getZ();
                  energy = 1.0 + power * 0.05;
                  repeat_num = (double)Math.round(dis * 4.0 + 4.0);
                  repeat_num_now = 0.0;

                  for(int index1 = 0; index1 < (int)repeat_num; ++index1) {
                     repeat_num_now = (double)Math.round(repeat_num_now + 1.0);
                     x_power = x_target - x_pos;
                     y_power = y_target - y_pos;
                     z_power = z_target - z_pos;
                     dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                     if (dis != 0.0) {
                        x_power /= dis * 4.0;
                        y_power /= dis * 4.0;
                        z_power /= dis * 4.0;
                        if (repeat_num_now < repeat_num) {
                           if (repeat_num_now % 4.0 == 1.0 || world.getBlockState(BlockPos.containing(x_pos + x_power * 2.0, y_pos + y_power * 2.0, z_pos + z_power * 2.0)).canOcclude()) {
                              for(int index2 = 0; index2 < 32; ++index2) {
                                 x_power = (Math.random() - 0.5) * dis * 3.0;
                                 y_power = (Math.random() - 0.5) * dis * 3.0;
                                 z_power = (Math.random() - 0.5) * dis * 3.0;
                                 x_power = x_target + x_power;
                                 y_power = y_target + y_power;
                                 z_power = z_target + z_power;
                                 entity.getPersistentData().putDouble("x_power", x_power - x_pos);
                                 entity.getPersistentData().putDouble("y_power", y_power - y_pos);
                                 entity.getPersistentData().putDouble("z_power", z_power - z_pos);
                                 entity.getPersistentData().putDouble("cnt2", Math.sqrt(Math.pow(entity.getPersistentData().getDouble("x_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("y_power"), 2.0) + Math.pow(entity.getPersistentData().getDouble("z_power"), 2.0)));
                                 if (entity.getPersistentData().getDouble("cnt2") != 0.0) {
                                    entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") / (entity.getPersistentData().getDouble("cnt2") * 4.0));
                                    entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") / (entity.getPersistentData().getDouble("cnt2") * 4.0));
                                    entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") / (entity.getPersistentData().getDouble("cnt2") * 4.0));
                                 }

                                 x_power = entity.getPersistentData().getDouble("x_power");
                                 y_power = entity.getPersistentData().getDouble("y_power");
                                 z_power = entity.getPersistentData().getDouble("z_power");
                                 x_pos_test = x_pos;
                                 y_pos_test = y_pos;
                                 z_pos_test = z_pos;
                                 logic_attack = true;

                                 for(int index3 = 0; index3 < 2; ++index3) {
                                    if (world.getBlockState(BlockPos.containing(x_pos_test, y_pos_test, z_pos_test)).canOcclude()) {
                                       logic_attack = false;
                                       break;
                                    }

                                    x_pos_test += x_power;
                                    y_pos_test += y_power;
                                    z_pos_test += z_power;
                                 }

                                 if (logic_attack) {
                                    break;
                                 }
                              }
                           }

                           x_power = entity.getPersistentData().getDouble("x_power");
                           y_power = entity.getPersistentData().getDouble("y_power");
                           z_power = entity.getPersistentData().getDouble("z_power");
                        }
                     }

                     if (repeat_num_now % 2.0 == 0.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                        }

                        if (repeat_num_now % 4.0 == 0.0) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                           }

                           entity.getPersistentData().putDouble("Damage", 30.0 * energy);
                           entity.getPersistentData().putDouble("Range", 5.0);
                           entity.getPersistentData().putDouble("knockback", 0.1);
                           entity.getPersistentData().putDouble("projectile_type", 1.0);
                           entity.getPersistentData().putDouble("effect", 1.0);
                           entity.getPersistentData().putDouble("effectConfirm", 2.0);
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)(20.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(4.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(4.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              entity.getPersistentData().putDouble("BlockRange", 1.0 * energy);
                              entity.getPersistentData().putDouble("BlockDamage", 4.0 * energy);
                              entity.getPersistentData().putBoolean("noEffect", true);
                              BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           }
                        }
                     }

                     if (repeat_num_now + 1.0 >= repeat_num) {
                        if (dis > 1.5) {
                           repeat_num = (double)Math.round(repeat_num + 1.0);
                        } else if (repeat_num_now >= repeat_num) {
                           if (dis < 0.3) {
                              break;
                           }

                           repeat_num = (double)Math.round(repeat_num + 1.0);
                        }
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)(25.0 * energy), 0.5, 0.5, 0.5, 1.0 * energy);
                  }

                  max_power = Math.max(max_power, entity.getPersistentData().getDouble("Damage"));
               }

               if (logic_a) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s slowness 1 4 true");
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            power = entity.getPersistentData().getDouble("Damage");
            entity.getPersistentData().putDouble("Damage", 10.0);
            entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbWidth()));
            entity.getPersistentData().putDouble("knockback", 0.1);
            entity.getPersistentData().putDouble("effect", 9.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().putDouble("Damage", Math.max(power, entity.getPersistentData().getDouble("Damage")));
         } else {
            LightningStrike2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
