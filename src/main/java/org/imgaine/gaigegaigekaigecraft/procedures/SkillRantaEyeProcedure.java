package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SkillRantaEyeProcedure {
   public SkillRantaEyeProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         String target_uuid = "";
         double x_center = 0.0;
         double size = 0.0;
         double z_center = 0.0;
         double HP = 0.0;
         double y_center = 0.0;
         double dis = 0.0;
         size = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
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
            if (entity.getPersistentData().getDouble("cnt2") % 10.0 == 1.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var53 = ((Entity)var10000).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var58 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var58 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var53, var58, ((Entity)var10002).getZ(), entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }

            entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
            entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity25 = (LivingEntity)entity;
            if (_livingEntity25.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity25.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity26 = (LivingEntity)entity;
            if (_livingEntity26.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
               _livingEntity26.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            dis = 6.0;

            for(int index0 = 0; index0 < 8; ++index0) {
               x_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
               y_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
               z_center = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
               Vec3 _center = new Vec3(x_center, y_center, z_center);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                     SUCCESS = true;
                     x_center = entityiterator.getX();
                     y_center = entityiterator.getY();
                     z_center = entityiterator.getZ();
                     target_uuid = entityiterator.getStringUUID();
                     break;
                  }
               }

               if (SUCCESS) {
                  break;
               }

               dis += 6.0;
            }

            double var54;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var54 = (double)_livEnt.getMaxHealth();
            } else {
               var54 = -1.0;
            }

            HP = var54;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_EYE_RANTA.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_center, y_center, z_center), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  entityinstance.getPersistentData().putString("TARGET", target_uuid);
                  entityinstance.setYRot(entity.getYRot());
                  entityinstance.setXRot(0.0F);
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
                     LivingEntity _livingEntity47 = (LivingEntity)entityinstance;
                     if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.5);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity50 = (LivingEntity)entityinstance;
                     if (_livingEntity50.getAttributes().hasAttribute(Attributes.ARMOR)) {
                        double var60;
                        AttributeInstance var55;
                        label201: {
                           var55 = _livingEntity50.getAttribute(Attributes.ARMOR);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity48 = (LivingEntity)entity;
                              if (_livingEntity48.getAttributes().hasAttribute(Attributes.ARMOR)) {
                                 var60 = _livingEntity48.getAttribute(Attributes.ARMOR).getValue();
                                 break label201;
                              }
                           }

                           var60 = 0.0;
                        }

                        var55.setBaseValue(var60);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity53 = (LivingEntity)entityinstance;
                     if (_livingEntity53.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                        double var61;
                        AttributeInstance var56;
                        label190: {
                           var56 = _livingEntity53.getAttribute(Attributes.ARMOR_TOUGHNESS);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity51 = (LivingEntity)entity;
                              if (_livingEntity51.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                                 var61 = _livingEntity51.getAttribute(Attributes.ARMOR_TOUGHNESS).getValue();
                                 break label190;
                              }
                           }

                           var61 = 0.0;
                        }

                        var56.setBaseValue(var61);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity56 = (LivingEntity)entityinstance;
                     if (_livingEntity56.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity56.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP * (double)(entity instanceof Player ? 5 : 1));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     float var62;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var62 = _livEnt.getHealth();
                     } else {
                        var62 = -1.0F;
                     }

                     _entity.setHealth(var62 * (float)(entity instanceof Player ? 5 : 1));
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt61 = (LivingEntity)entity;
                     if (_livEnt61.hasEffect(MobEffects.DAMAGE_RESISTANCE) && entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.level().isClientSide()) {
                           MobEffectInstance var63;
                           MobEffect var10003;
                           int var10005;
                           label176: {
                              var10003 = MobEffects.DAMAGE_RESISTANCE;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                    var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                    break label176;
                                 }
                              }

                              var10005 = 0;
                           }

                           var63 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                           _entity.addEffect(var63);
                        }
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10, 9, false, false));
                     }
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            entity.getPersistentData().putBoolean("PRESS_Z", true);
         } else if (!(entity instanceof Player)) {
            entity.getPersistentData().putBoolean("PRESS_Z", false);
         }

         if (entity.getPersistentData().getDouble("cnt2") >= 200.0) {
            entity.getPersistentData().putBoolean("PRESS_Z", false);
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("cnt3", Math.min(entity.getPersistentData().getDouble("cnt3"), 20.0));
         }

         ChargeParticleProcedure.execute(world, entity, 0.0);
         if (entity.getPersistentData().getDouble("cnt3") > 20.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
