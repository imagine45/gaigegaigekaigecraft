package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueScissorsProcedure {
   public TechniqueScissorsProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean success = false;
         double HP = 0.0;
         double x_fix = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double z_fix = 0.0;
         double num1 = 0.0;
         double y_fix = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double MAX_ST = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 60, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 19, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
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

               x_pos = ((Entity)var10000).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var83 = ((Entity)var10000).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var83 + (double)((Entity)var10001).getBbHeight() * 0.7;
               LivingEntity var84;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var84 = _mobEnt.getTarget();
               } else {
                  var84 = null;
               }

               z_pos = ((Entity)var84).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            entity.setYRot(entity.getYRot());
            entity.setXRot(0.0F);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.getPersistentData().putDouble("yaw", (double)(entity.getYRot() + 90.0F));
            entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            entity.getPersistentData().putDouble("x_pos", entity.getX());
            entity.getPersistentData().putDouble("y_pos", entity.getY());
            entity.getPersistentData().putDouble("z_pos", entity.getZ());
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 2.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 2.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 2.0);
            entity.getPersistentData().putDouble("cnt6", 2.5);
            entity.setYRot((float)yaw);
            entity.setXRot((float)pitch);
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity35 = (LivingEntity)entity;
               if (_livingEntity35.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity35.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity36 = (LivingEntity)entity;
               if (_livingEntity36.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity36.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         int var87;
         label250: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var87 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label250;
               }
            }

            var87 = 0;
         }

         HP = (double)(40 + var87 * 4);

         for(int index0 = 0; index0 < 3; ++index0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            dis = entity.getPersistentData().getDouble("cnt1") * 1.0;
            num1 = Math.toRadians(entity.getPersistentData().getDouble("yaw") - 45.0);

            for(int index1 = 0; index1 < 18; ++index1) {
               x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(num1) * dis;
               z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(num1) * dis;
               num1 += Math.toRadians(Math.random() * 10.0);
               success = false;
               if (!success) {
                  y_pos = entity.getPersistentData().getDouble("y_pos");

                  for(int index2 = 0; index2 < (int)dis; ++index2) {
                     if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        success = true;
                        break;
                     }

                     y_pos += 0.5;
                  }
               }

               if (!success) {
                  y_pos = entity.getPersistentData().getDouble("y_pos");

                  for(int index3 = 0; index3 < (int)dis; ++index3) {
                     if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        success = true;
                        break;
                     }

                     y_pos -= 0.5;
                  }
               }

               if (success) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.749 0.984 1.000 1 ~ ~ ~ 0 0 0 1 1 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 1, 0.05, 0.05, 0.05, 0.0);
                  }
               }
            }

            num1 = Math.toRadians(entity.getPersistentData().getDouble("yaw"));
            x_pos = entity.getPersistentData().getDouble("x_pos") + Math.cos(num1) * dis;
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos") + Math.sin(num1) * dis;
            entity.getPersistentData().putDouble("Range", dis * 2.0);
            entity.getPersistentData().putBoolean("onlyLiving", true);
            entity_a = null;
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livEnt60 = (LivingEntity)entityiterator;
                     if (_livEnt60.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        continue;
                     }
                  }

                  if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     int var85;
                     label225: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var85 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label225;
                           }
                        }

                        var85 = 0;
                     }

                     if ((double)var85 >= MAX_ST) {
                        entity_a = entityiterator;
                     }
                     double var86;
                     label219: {
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var86 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label219;
                           }
                        }

                        var86 = 0.0;
                     }

                     MAX_ST = var86;
                  }
               }
            }

            if (entity_a instanceof LivingEntity) {
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 19, false, false));
                  }
               }

               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 50, 0, false, false));
                  }
               }

               entity_a.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:tinnitus")), SoundSource.NEUTRAL, 0.25F, 1.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:tinnitus")), SoundSource.NEUTRAL, 0.25F, 1.5F, false);
                  }
               }

               for(int index4 = 0; index4 < Math.min(10, Math.round(2.0F * (entity_a.getBbWidth() + entity_a.getBbHeight()))); ++index4) {
                  num1 = Math.toRadians(Math.random() * 720.0);
                  x_fix = Math.sin(num1) * ((double)(entity_a.getBbWidth() * 1.0F) + 0.5);
                  y_fix = (double)(entity_a.getBbHeight() + 2.0F) * Math.random() - 1.0;
                  z_fix = Math.cos(num1) * ((double)(entity_a.getBbWidth() * 1.0F) + 0.5);
                  x_pos = entity_a.getX() + x_fix;
                  y_pos = entity_a.getY() + y_fix;
                  z_pos = entity_a.getZ() + z_fix;
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_SCISSORS.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoGravity:1b,NoAI:1b}");
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity83 = (LivingEntity)entityinstance;
                           if (_livingEntity83.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity83.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        entityinstance.lookAt(Anchor.EYES, new Vec3(entity_a.getX(), entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + (double)entity_a.getBbHeight() * (Math.random() - 0.5) * 1.0, entity_a.getZ()));
                        entityinstance.getPersistentData().putDouble("x_pos", x_fix);
                        entityinstance.getPersistentData().putDouble("y_pos", y_fix);
                        entityinstance.getPersistentData().putDouble("z_pos", z_fix);
                        entityinstance.getPersistentData().putString("TARGET", entity_a.getStringUUID());
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("onlyLiving", false);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 22.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
