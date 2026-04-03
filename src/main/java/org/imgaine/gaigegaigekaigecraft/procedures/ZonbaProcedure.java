package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class ZonbaProcedure {
   public ZonbaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean SUCCESS;
         double dis;
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label259: {
            boolean logic_a = false;
            boolean pitch = false;
            SUCCESS = false;
            boolean logic_b = false;
            Entity entity_a = null;
            dis = 0.0;
            x_pos = 0.0;
            y_pos = 0.0;
            z_pos = 0.0;
            double yaw = 0.0;
            double picth = 0.0;
            double yaw2 = 0.0;
            double pitch2 = 0.0;
            double power = 0.0;
            double strength = 0.0;
            double distance = 0.0;
            double d = 0.0;
            double range = 0.0;
            double CNT6 = 0.0;
            double y_power = 0.0;
            double z_power = 0.0;
            double x_power = 0.0;
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label259;
               }
            }

            var10000 = 0;
         }

         double var71 = (double)Math.min(var10000, 50);
         double var77 = ReturnEntitySizeProcedure.execute(entity);
         double var80 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt2") % 3.0 == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity7 = (LivingEntity)entity;
               if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         LivingEntity var106;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var106 = _mobEnt.getTarget();
         } else {
            var106 = null;
         }

         Entity var54 = var106;
         if (!(var54 instanceof LivingEntity) && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
            var54 = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (var54 instanceof LivingEntity) {
               if (var54 instanceof Mob) {
                  Mob _mobEnt = (Mob)var54;
                  var106 = _mobEnt.getTarget();
               } else {
                  var106 = null;
               }

               if (var106 instanceof LivingEntity) {
                  if (var54 instanceof Mob) {
                     Mob _mobEnt = (Mob)var54;
                     var106 = _mobEnt.getTarget();
                  } else {
                     var106 = null;
                  }

                  var54 = var106;
               } else {
                  dis = 6.0;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     x_pos = (double)((Entity)var54).level().clip(new ClipContext(((Entity)var54).getEyePosition(1.0F), ((Entity)var54).getEyePosition(1.0F).add(((Entity)var54).getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).getBlockPos().getX();
                     y_pos = (double)((Entity)var54).level().clip(new ClipContext(((Entity)var54).getEyePosition(1.0F), ((Entity)var54).getEyePosition(1.0F).add(((Entity)var54).getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).getBlockPos().getY();
                     z_pos = (double)((Entity)var54).level().clip(new ClipContext(((Entity)var54).getEyePosition(1.0F), ((Entity)var54).getEyePosition(1.0F).add(((Entity)var54).getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, (Entity)var54)).getBlockPos().getZ();
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, (Entity)var54, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           var54 = entityiterator;
                           break;
                        }
                     }

                     if (SUCCESS) {
                        break;
                     }

                     dis += 6.0;
                  }

                  if (!SUCCESS) {
                     var54 = null;
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }
               }

               if (var54 instanceof LivingEntity && entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  if (var54 instanceof LivingEntity) {
                     LivingEntity _ent = (LivingEntity)var54;
                     _entity.setTarget(_ent);
                  }
               }
            } else {
               var54 = null;
            }
         }

         if (var54 instanceof LivingEntity) {
            RotateEntityProcedure.execute(((Entity)var54).getX(), ((Entity)var54).getY() + (double)((Entity)var54).getBbHeight() * 0.9, ((Entity)var54).getZ(), entity);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 9.0) {
               if (var54 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               } else if (!(entity instanceof Player)) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }
            }

            double var67 = Math.toRadians((double)(entity.getYRot() + 90.0F));
            dis = Math.toRadians((double)entity.getXRot());
            double var72 = 1.0 + 0.5 * (double)entity.getBbWidth();
            x_pos = entity.getX() + Math.cos(var67) * Math.cos(dis) * var72;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(dis) * -1.0 * var72;
            z_pos = entity.getZ() + Math.sin(var67) * Math.cos(dis) * var72;
            var72 = (double)(3.0F + entity.getBbWidth());

            for(int index1 = 0; index1 < (int)(2.0 * var77); ++index1) {
               var67 = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               dis = Math.toRadians(Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, var72, x_pos + Math.cos(var67) * Math.cos(dis) * var72, x_pos, y_pos + Math.sin(dis) * -1.0 * var72, y_pos, z_pos + Math.sin(var67) * Math.cos(dis) * var72, z_pos, entity.getPersistentData().getDouble("cnt6") >= 5.0 ? "minecraft:enchanted_hit" : "minecraft:crit");
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
            if (entity.getPersistentData().getDouble("cnt1") == 10.0) {
               if (entity instanceof Player) {
                  if (entity.isShiftKeyDown()) {
                     entity.getPersistentData().putDouble("cnt10", 1.0);
                  }
               } else {
                  dis = GetDistanceProcedure.execute(entity);
                  if (dis > 24.0) {
                     entity.getPersistentData().putDouble("cnt10", 1.0);
                  } else if (dis > 6.0 && Math.random() < 0.5) {
                     entity.getPersistentData().putDouble("cnt10", 1.0);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt10") > 0.0) {
               ZonbaFallProcedure.execute(world, entity);
            } else {
               if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
                  double var70 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  dis = Math.toRadians(0.0);
                  double var75 = (double)(2.0F + entity.getBbWidth());
                  x_pos = entity.getX() + Math.cos(var70) * Math.cos(dis) * var75;
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.65 + Math.sin(dis) * -1.0 * var75;
                  z_pos = entity.getZ() + Math.sin(var70) * Math.cos(dis) * var75;
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:flash ~ ~ ~ " + var77 * 1.0 + " " + var77 * 1.0 + " " + var77 * 1.0 + " 0 " + Math.round(10.0 * var77) + " force");
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
                  double var74 = (double)(1.0F + entity.getBbWidth());
                  if (entity.getPersistentData().getDouble("cnt1") <= 15.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, 4.0F, 1.0F, false);
                        }
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, 4.0F, 0.5F, false);
                        }
                     }

                     double var69 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     dis = Math.toRadians((double)entity.getXRot());
                     entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(var69) * Math.cos(dis) * var74);
                     entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(dis) * -1.0 * var74);
                     entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(var69) * Math.cos(dis) * var74);
                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z);
                  }

                  if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
                     x_pos = entity.getPersistentData().getDouble("x_pos");
                     y_pos = entity.getPersistentData().getDouble("y_pos");
                     z_pos = entity.getPersistentData().getDouble("z_pos");
                     double var83 = entity.getPersistentData().getDouble("x_power");
                     double var81 = entity.getPersistentData().getDouble("y_power");
                     double var82 = entity.getPersistentData().getDouble("z_power");
                     var77 = ReturnEntitySizeProcedure.execute(entity) * var80 * var80 * var80;

                     for(int index2 = 0; index2 < (int)(var77 * 12.0); ++index2) {
                        ParticleGeneratorProcedure.execute(world, var77 * 1.0, 4.0, 1.0, Mth.nextDouble(RandomSource.create(), 0.0, 6.0), x_pos, x_pos + var83, y_pos, y_pos + var81, z_pos, z_pos + var82, "end_rod");
                     }

                     var77 *= 0.5;

                     for(int index3 = 0; index3 < (int)Math.min(entity.getPersistentData().getDouble("cnt3") * 12.0, 48.0); ++index3) {
                        if (var74 > 0.0) {
                           var74 = 2.0 * var77 * -0.5;
                           entity.getPersistentData().putDouble("Damage", 15.0 * var80);
                           entity.getPersistentData().putDouble("Range", 4.0 * var77);
                           entity.getPersistentData().putDouble("knockback", 0.75);
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                              if (entity != entityiterator && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 boolean var53 = true;
                                 break;
                              }
                           }
                        }

                        if (InsideSolidCalculateProcedure.execute(world, x_pos, y_pos - 3.0 * var77, z_pos, 6.0 * var77, 6.0 * var77)) {
                           if (dis > 0.0) {
                              dis = 2.0 * var77 * -0.5;
                              double var76 = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                              entity.getPersistentData().putDouble("BlockDamage", 8.0 * var80);
                              entity.getPersistentData().putDouble("BlockRange", 4.0 * var77);
                              entity.getPersistentData().putBoolean("noParticle", true);
                              entity.getPersistentData().putBoolean("noEffect", true);
                              BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           }
                        } else if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle flash ~ ~ ~ " + var77 * 0.1 + " " + var77 * 0.1 + " " + var77 * 0.1 + " 0 " + Math.round(2.0 * var77) + " force");
                        }

                        x_pos += var83;
                        y_pos += var81;
                        z_pos += var82;
                        ++dis;
                        ++var74;
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

      }
   }
}
