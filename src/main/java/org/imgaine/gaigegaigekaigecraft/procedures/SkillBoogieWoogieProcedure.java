package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Iterator;
import java.util.List;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillBoogieWoogieProcedure {
   public SkillBoogieWoogieProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         boolean hasCursePower = false;
         boolean SUCCESS = false;
         boolean player = false;
         boolean logic_ = false;
         Entity entity_a = null;
         player = entity instanceof Player;
         SUCCESS = false;
         if (!player) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().getDouble("Damage") > 0.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (!((Entity)var10000).getPersistentData().getBoolean("attack")) {
                        SUCCESS = true;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        targetUUID = ((Entity)var10000).getStringUUID();
                     }
                  }
               }
            }
         }

         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
            if (entity != entityiterator) {
               logic_ = LogicAttackProcedure.execute(world, entity, entityiterator);
               if (logic_ && entityiterator.getPersistentData().getDouble("skill") != 0.0 && entityiterator.getPersistentData().getDouble("Damage") > 0.0) {
                  entityiterator.getPersistentData().putBoolean("betrayal", true);
                  if (!player && !SUCCESS && !entityiterator.getPersistentData().getBoolean("attack")) {
                     SUCCESS = true;
                     targetUUID = entityiterator.getStringUUID();
                  }
               }

               double var84;
               if (entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  var84 = _projEnt.getDeltaMovement().length();
               } else {
                  var84 = 0.0;
               }

               if (var84 != 0.0 && entityiterator instanceof Projectile) {
                  Projectile _projEnt = (Projectile)entityiterator;
                  if (entity instanceof LivingEntity) {
                     _projEnt.setOwner((LivingEntity)entity);
                  }
               }

               if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || !logic_) {
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var84 = _projEnt.getDeltaMovement().length();
                  } else {
                     var84 = 0.0;
                  }

                  if (!(var84 > 0.0)) {
                     continue;
                  }
               }

               if (!entityiterator.getPersistentData().getString("OWNER_UUID").equals(entity.getStringUUID())) {
                  targetUUID = entityiterator.getStringUUID();
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().getString("OWNER_UUID"));
                  if (entity_a instanceof LivingEntity) {
                     label301: {
                        if (entity_a instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0 || InlineMethodHandler.checkGamemodeCreative(entity_a) || InlineMethodHandler.checkGamemodeSpectator(entity_a)) {
                              break label301;
                           }
                        } else if (entity_a.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                           break label301;
                        }

                        SUCCESS = true;
                        targetUUID = entityiterator.getPersistentData().getString("OWNER_UUID");
                     }
                  }

                  entityiterator.getPersistentData().putString("OWNER_UUID", "");
                  entityiterator.getPersistentData().putBoolean("betrayal", true);
               }
            }
         }

         if (!SUCCESS) {
            _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(4.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator.getPersistentData().getDouble("skill") != 0.0 && entityiterator.getPersistentData().getBoolean("attack") && entityiterator.getPersistentData().getBoolean("PRESS_Z")) {
                  if (entityiterator instanceof Player) {
                     if (((JujutsucraftModVariables.PlayerVariables)entityiterator.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower == 0.0 || InlineMethodHandler.checkGamemodeCreative(entityiterator) || InlineMethodHandler.checkGamemodeSpectator(entityiterator)) {
                        continue;
                     }
                  } else if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                     continue;
                  }

                  if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     if (!entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                        entityiterator.getPersistentData().putDouble("cnt6", 0.0);
                     }

                     SUCCESS = true;
                     targetUUID = entityiterator.getStringUUID();
                     break;
                  }
               }
            }
         }

         if (player && !SUCCESS) {
            dis = 32.0;

            for(int index0 = 0; index0 < 6; ++index0) {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
               _center = new Vec3(x_pos, y_pos, z_pos);
               List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true);
               Iterator entityiterator = _entfound.iterator();

               label259: {
                  Entity _entity;
                  while(true) {
                     if (!entityiterator.hasNext()) {
                        break label259;
                     }

                     _entity = (Entity)entityiterator.next();
                     if (entity != _entity) {
                        if (_entity instanceof Player) {
                           if (((JujutsucraftModVariables.PlayerVariables)_entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower != 0.0 && !InlineMethodHandler.checkGamemodeCreative(_entity) && !InlineMethodHandler.checkGamemodeSpectator(_entity)) {
                              break;
                           }
                        } else if (!_entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:no_curse_power")))) {
                           break;
                        }
                     }
                  }

                  SUCCESS = true;
                  targetUUID = _entity.getStringUUID();
               }

               dis -= 4.0;
               if (SUCCESS) {
                  break;
               }
            }
         }

         if (player || SUCCESS) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity58 = (LivingEntity)entity;
               if (_livingEntity58.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity58.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-17.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:clap")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)(1.0F + entity.getBbWidth()))), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)(1.0F + entity.getBbWidth()))), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale((double)(1.0F + entity.getBbWidth()))), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ(), 1, 0.1, 0.1, 0.1, 0.2);
            }

            _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  entityiterator.getPersistentData().putDouble("cnt_target", -5.0);
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }
               }
            }
         }

         if (SUCCESS) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, targetUUID);
            if (entity_a instanceof LivingEntity) {
               label325: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt73 = (LivingEntity)entity;
                     if (_livEnt73.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        if (entity_a instanceof LivingEntity) {
                           LivingEntity _livEnt74 = (LivingEntity)entity_a;
                           if (_livEnt74.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              break label325;
                           }
                        }

                        int var86;
                        label217: {
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 var86 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                 break label217;
                              }
                           }

                           var86 = 0;
                        }

                        if (var86 > 0) {
                           break label325;
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt76 = (LivingEntity)entity;
                     if (_livEnt76.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        return;
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt77 = (LivingEntity)entity_a;
                     if (_livEnt77.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        return;
                     }
                  }
               }

               entity.stopRiding();
               entity_a.stopRiding();
               entity_a.getPersistentData().putBoolean("betrayal", true);
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity_a;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
               }

               entity_a.getPersistentData().putDouble("cnt_target", -5.0);
               x_pos = entity_a.getX();
               y_pos = entity_a.getY();
               z_pos = entity_a.getZ();
               entity_a.teleportTo(entity.getX(), entity.getY(), entity.getZ());
               if (entity_a instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_a;
                  _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ(), entity_a.getYRot(), entity_a.getXRot());
               }

               entity.teleportTo(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
               }

               entity.setYRot(entity.getYRot() + 180.0F);
               entity.setXRot(entity.getXRot() * -1.0F);
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
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 15, 9, false, false));
                  }
               }

               if (!player) {
                  entity.getPersistentData().putDouble("cnt_boogie_woogie", -40.0);
               }
            }
         }

      }
   }
}
