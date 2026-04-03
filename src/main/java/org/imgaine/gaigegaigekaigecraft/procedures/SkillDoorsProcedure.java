package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityDoorsEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkillDoorsProcedure {
   public SkillDoorsProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         String targetUUID = "";
         Entity entity_a = null;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double rnd = 0.0;
         double dis = 0.0;
         double old_rnd = 0.0;
         double NUM1 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var62 = ((Entity)var10000).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var65 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var65 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var62, var65, ((Entity)var10002).getZ(), entity);
            }

            dis = 6.0;

            for(int index0 = 0; index0 < 4; ++index0) {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_pos = entityiterator.getX();
                     y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.75;
                     z_pos = entityiterator.getZ();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += 6.0;
            }

            int var67;
            label214: {
               entity.getPersistentData().putDouble("x_pos", x_pos);
               entity.getPersistentData().putDouble("y_pos", y_pos);
               entity.getPersistentData().putDouble("z_pos", z_pos);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var67 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label214;
                  }
               }

               var67 = 0;
            }
            int var64;
            int var63;
            label209: {
               HP = (double)(50 + var67 * 5);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt29 = (LivingEntity)entity;
                  if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                     label204: {
                        rnd = 0.0;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt31 = (LivingEntity)entity;
                           if (_livEnt31.hasEffect(MobEffects.LUCK)) {
                              label199: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                       var64 = _livEnt.getEffect(MobEffects.LUCK).getAmplifier();
                                       break label199;
                                    }
                                 }

                                 var64 = 0;
                              }

                              var63 = var64 + 2;
                              break label204;
                           }
                        }

                        var63 = 1;
                     }

                     NUM1 = (double)var63;
                     NUM1 += (double)(entity.getPersistentData().getDouble("mode_hakari") != 1.0 && entity.getPersistentData().getDouble("mode_hakari") != 2.0 ? 0 : 5);

                     for(int index1 = 0; index1 < (int)NUM1; ++index1) {
                        old_rnd = rnd;
                        rnd = Math.random();
                        if (rnd < 0.8) {
                           rnd = 1.0;
                        } else if (rnd < 0.9) {
                           rnd = 2.0;
                        } else if (rnd < 0.95) {
                           rnd = 3.0;
                        } else {
                           if (!(rnd < 0.99)) {
                              rnd = 5.0;
                              break;
                           }

                           rnd = 4.0;
                        }

                        if (old_rnd > rnd) {
                           rnd = old_rnd;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().getDouble("Reserve") == 0.0) {
                           entity.getPersistentData().putDouble("Reserve", (double)Math.round(rnd));
                        }
                     }
                     break label209;
                  }
               }

               rnd = 1.0;
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOORS.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                  }

                  entityinstance.setYRot(entity.getYRot());
                  entityinstance.setXRot(entity.getXRot());
                  entityinstance.setYBodyRot(entityinstance.getYRot());
                  entityinstance.setYHeadRot(entityinstance.getYRot());
                  entityinstance.yRotO = entityinstance.getYRot();
                  entityinstance.xRotO = entityinstance.getXRot();
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity46 = (LivingEntity)entityinstance;
                     if (_livingEntity46.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity46.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (rnd == 1.0) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_white");
                     }
                  } else if (rnd == 2.0) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_green");
                     }
                  } else if (rnd == 3.0) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_red");
                     }
                  } else if (rnd == 4.0) {
                     if (entityinstance instanceof EntityDoorsEntity) {
                        EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                        animatable.setTexture("door_gold");
                     }
                  } else if (rnd == 5.0 && entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_rainbow");
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity61 = (LivingEntity)entity;
               if (_livingEntity61.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity61.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 5.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
