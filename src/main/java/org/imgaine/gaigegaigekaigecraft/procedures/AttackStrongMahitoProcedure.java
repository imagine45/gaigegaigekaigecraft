package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackStrongMahitoProcedure {
   public AttackStrongMahitoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean player = false;
         String color3 = "";
         String color1 = "";
         String color2 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double dis = 0.0;
         double strength = 0.0;
         double range = 0.0;
         double loop_num = 0.0;
         double CNT6 = 0.0;
         double count = 0.0;
         double counter = 0.0;
         double size = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double attack_reach = 0.0;
         double dis_start = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double cnt6_old = 0.0;
         player = entity instanceof Player;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         if (entity.getPersistentData().getDouble("cnt1") <= 7.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 6.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  dis = GetDistanceNearestEnemyProcedure.execute(world, entity);
                  if (dis > 1.0 && dis < 4.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") == 0.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 6.0));
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)(entity.getPersistentData().getDouble("COOLDOWN_TICKS") * 2.0), 0, false, false));
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                  entity.getPersistentData().putDouble("cnt6", 5.0);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x, y + (double)entity.getBbHeight() * 0.5, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  strength = 0.5;
               } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                  strength = 0.2;
               } else {
                  ChangeCurseEnergyProcedure.execute(entity, -1.0);
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.125);
                  if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                  }

                  strength = 0.1;
               }

               if (entity.getPersistentData().getDouble("cnt1") >= 6.0) {
                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ChargeParticleProcedure.execute(world, entity, 10.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }
               }
            }
         }

         int var106;
         label194: {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var106 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label194;
               }
            }

            var106 = 0;
         }

         strength = (double)Math.min(var106, 50) * CNT6;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + strength * 0.025);
         if (entity.getPersistentData().getDouble("cnt1") < 8.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               entity.getPersistentData().putDouble("cnt5", (double)(entity.getYRot() + 15.0F));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               ItemStack var107;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var107 = _livEnt.getMainHandItem();
               } else {
                  var107 = ItemStack.EMPTY;
               }

               if (var107.is(ItemTags.create(new ResourceLocation("minecraft:swords")))) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var107 = _livEnt.getMainHandItem();
                  } else {
                     var107 = ItemStack.EMPTY;
                  }

                  if (!var107.is(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))) && world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity49 = (LivingEntity)entity;
                  if (_livingEntity49.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity49.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            range = ReturnEntitySizeProcedure.execute(entity);
            if (entity.getPersistentData().getDouble("cnt2") < 4.0) {
               color1 = "1 1 1 1";
               color2 = "0.75 0.75 0.75 1";
               size = Math.max(ReturnEntitySizeProcedure.execute(entity), 0.01);
               attack_reach = GetReachProcedure.execute(entity);
               dis_start = 1.7;
               rad_now = Math.toRadians((double)entity.getXRot());
               yaw_now = Math.toRadians((double)(entity.getYRot() + 90.0F));
               cnt6_old = entity.getPersistentData().getDouble("cnt6");
               entity.getPersistentData().putDouble("cnt6", -1.0);

               for(int index0 = 0; (long)index0 < Math.round(10.0 * size); ++index0) {
                  rad = Math.toRadians(entity.getPersistentData().getDouble("cnt5") + entity.getPersistentData().getDouble("cnt4"));
                  dis = dis_start;
                  count = 0.0;
                  counter = 0.0;
                  x_power = Math.cos(rad) * (Math.cos(rad_now) + Math.abs(Math.sin(yaw_now) * Math.sin(rad_now)));
                  y_power = Math.sin(Math.toRadians(entity.getPersistentData().getDouble("cnt4"))) * Math.sin(rad_now) * -1.0;
                  z_power = Math.sin(rad) * (Math.cos(rad_now) + Math.abs(Math.cos(yaw_now) * Math.sin(rad_now)));
                  ParticleGeneratorProcedure.execute(world, range * 0.1, 2.0 * range, 5.0, 2.0, entity.getX() + x_power * dis_start, entity.getX() + x_power * dis_start + x_power, entity.getY() + (double)entity.getBbHeight() * 0.75 + y_power * dis_start, entity.getY() + (double)entity.getBbHeight() * 0.75 + y_power * dis_start + y_power, entity.getZ() + z_power * dis_start, entity.getZ() + z_power * dis_start + z_power, "minecraft:cloud");

                  for(int index1 = 0; (long)index1 < Math.round(20.0 * attack_reach * size * CNT6); ++index1) {
                     x_pos = entity.getX() + x_power * dis;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + y_power * dis;
                     z_pos = entity.getZ() + z_power * dis;
                     ++count;
                     counter -= 0.25;
                     if (counter <= 0.0) {
                        counter = 0.5;
                        entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
                        entity.getPersistentData().putDouble("knockback", 1.5 * CNT6);
                        entity.getPersistentData().putDouble("Range", 4.0);
                        entity.getPersistentData().putDouble("effect", 5.0);
                        entity.getPersistentData().putDouble("projectile_type", 1.0);
                        entity.getPersistentData().putBoolean("attack", true);
                        RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     }

                     if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 4, 0.1, 0.1, 0.1, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 4, 0.1, 0.1, 0.1, 0.5);
                        }

                        entity.getPersistentData().putDouble("BlockDamage", 2.0 + strength / 8.0);
                        entity.getPersistentData().putDouble("BlockRange", 1.0);
                        if (!logic_a) {
                           logic_a = true;
                           entity.getPersistentData().putBoolean("noEffect", false);
                        } else {
                           entity.getPersistentData().putBoolean("noEffect", true);
                        }

                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                           break;
                        }
                     }

                     dis += 0.5;
                  }

                  entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + Math.random() * 10.0 / size);
               }

               entity.getPersistentData().putDouble("cnt6", cnt6_old);
            }

            if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
