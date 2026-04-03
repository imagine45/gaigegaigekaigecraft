package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIPurpleProcedure {
   public AIPurpleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean big = false;
         boolean logic_attack = false;
         double damage = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double power = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         big = entity.getPersistentData().getBoolean("explode");
         power = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (big) {
            range *= 3.0;
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               logic_attack = false;
               if (LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     logic_attack = true;
                     entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                     entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                     entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                     entity.getPersistentData().putDouble("cnt3", 1.0);
                  }
               }

               if (Math.random() < 0.05 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)(0.5 + Math.random()));
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, (float)(0.5 + Math.random()), false);
                  }
               }

               if (!logic_attack || !entity.isAlive()) {
                  entity.getPersistentData().putDouble("cnt3", 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") != 0.0) {
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
                  double var10000;
                  label185: {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity25 = (LivingEntity)entity;
                        if (_livingEntity25.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity25.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label185;
                        }
                     }

                     var10000 = 0.0;
                  }
                  AttributeInstance var74;
                  if (var10000 < entity.getPersistentData().getDouble("size") && entity instanceof LivingEntity) {
                     LivingEntity _livingEntity30 = (LivingEntity)entity;
                     if (_livingEntity30.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        double var10001;
                        label178: {
                           var74 = _livingEntity30.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity27 = (LivingEntity)entity;
                              if (_livingEntity27.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                 var10001 = _livingEntity27.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                 break label178;
                              }
                           }

                           var10001 = 0.0;
                        }

                        var74.setBaseValue(Math.min(var10001 + (entity.getPersistentData().getDouble("size") - 5.0) * 0.2, entity.getPersistentData().getDouble("size")));
                     }
                  }

                  if (big) {
                     entity.teleportTo(entity.getX(), entity.getY() + 1.0, entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY() + 1.0, entity.getZ(), entity.getYRot(), entity.getXRot());
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY(), entity.getZ(), (int)(1.0 * range), range, range, range, range);
                     }
                  } else if (LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                        yaw = Math.toRadians((double)(entity_a.getYRot() + 90.0F));
                        pitch = Math.toRadians((double)entity_a.getXRot());
                        dis = ((double)(2.0F + entity_a.getBbWidth()) + Math.max(entity.getPersistentData().getDouble("size"), 5.0) * 0.2) * 0.75;
                        entity.teleportTo(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity_a.getX() + Math.cos(yaw) * Math.cos(pitch) * dis, entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + Math.sin(pitch) * -1.0 * dis, entity_a.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis, entity.getYRot(), entity.getXRot());
                        }

                        entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                        entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                        entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                     }
                  }
               } else {
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (!big) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(5.0 * range), range, range, range, range);
                     }
                  } else {
                     double var75;
                     label234: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity58 = (LivingEntity)entity;
                           if (_livingEntity58.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              var75 = _livingEntity58.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                              break label234;
                           }
                        }

                        var75 = 0.0;
                     }
                     AttributeInstance var76;
                     if (var75 < 100.0 && entity instanceof LivingEntity) {
                        LivingEntity _livingEntity60 = (LivingEntity)entity;
                        if (_livingEntity60.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           double var77;
                           label225: {
                              var76 = _livingEntity60.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity59 = (LivingEntity)entity;
                                 if (_livingEntity59.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    var77 = _livingEntity59.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                    break label225;
                                 }
                              }

                              var77 = 0.0;
                           }

                           var76.setBaseValue(Math.min(var77 + 10.0, 100.0));
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt1") == 10.0 && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, 0.75F, false);
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0 && world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)(0.5 + Math.random()));
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 4.0F, (float)(0.5 + Math.random()), false);
                        }
                     }

                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();

                     for(int index0 = 0; index0 < (int)(36.0 * range); ++index0) {
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, Mth.nextDouble(RandomSource.create(), -45.0, 45.0) * Math.random() * Math.random() * Math.random(), 0.0, 1.0, 12.0, x_pos, x_pos, y_pos, y_pos, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), z_pos, z_pos, "gaigegaigekaigecraft:particle_thunder_purple");
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, Mth.nextDouble(RandomSource.create(), -45.0, 45.0) * Math.random() * Math.random() * Math.random(), 0.0, 1.0, 12.0, x_pos, x_pos, y_pos, y_pos, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), z_pos, z_pos, "cloud");
                     }
                  }

                  x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
                  y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
                  z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
                  dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                  if (dis > 0.0) {
                     x_power /= dis;
                     y_power /= dis;
                     z_power /= dis;
                  }

                  damage = Math.max(80.0 * Math.pow(0.99, entity.getPersistentData().getDouble("cnt_life")), 55.0) * power;

                  for(int index1 = 0; index1 < (int)Math.round(Math.max(dis, 1.0)); ++index1) {
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();
                     if (!big && entity.getPersistentData().getDouble("cnt1") >= 12.0) {
                        if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                           if (world instanceof Level) {
                              Level _level = (Level)world;
                              if (!_level.isClientSide()) {
                                 _level.explode((Entity)null, x_pos, y_pos, z_pos, (float)(2.0 * range), ExplosionInteraction.MOB);
                              }
                           }
                        } else if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }

                     if (!big || entity.getPersistentData().getDouble("cnt1") <= 30.0) {
                        entity.getPersistentData().putDouble("Damage", damage);
                        entity.getPersistentData().putDouble("Range", 8.0 * range);
                        if (big) {
                           entity.getPersistentData().putDouble("knockback", 2.0);
                        } else {
                           entity.getPersistentData().putDouble("knockback", entity.getPersistentData().getDouble("cnt6") >= 2.0 ? 1.0 : 0.1);
                        }

                        entity.getPersistentData().putDouble("effectConfirm", 2.0);
                        if (big) {
                           entity.getPersistentData().putBoolean("betrayal", true);
                        }

                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!big || entity.getPersistentData().getDouble("cnt1") % 4.0 == 1.0) {
                        entity.getPersistentData().putDouble("BlockRange", 3.0 * range);
                        entity.getPersistentData().putDouble("BlockDamage", 18.0 * power);
                        entity.getPersistentData().putBoolean("noParticle", true);
                        entity.getPersistentData().putBoolean("noEffect", true);
                        entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (big) {
                        break;
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_PURPLE.get(), x_pos, y_pos, z_pos, (int)(5.0 * range), range, range, range, range);
                     }

                     if (entity.getPersistentData().getBoolean("Stop")) {
                        entity.getPersistentData().putBoolean("Stop", false);
                        break;
                     }

                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }
                  }

                  if (big) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  } else {
                     entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.0, entity.getPersistentData().getDouble("y_power") * 1.0, entity.getPersistentData().getDouble("z_power") * 1.0));
                  }

                  entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt1") >= (double)(big ? 80 : 30) && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         }

      }
   }
}
