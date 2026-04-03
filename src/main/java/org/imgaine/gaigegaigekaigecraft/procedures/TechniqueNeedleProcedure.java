package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TechniqueNeedleProcedure {
   public TechniqueNeedleProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double NUM2 = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double NUM1 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity5 = (LivingEntity)entity;
            if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(207.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
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
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
               }
            }

            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.getTarget();
            } else {
               var10004 = null;
            }

            double var60 = ((Entity)var10004).getX();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.getTarget();
            } else {
               var10005 = null;
            }

            double var61 = ((Entity)var10005).getY();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var61 += (double)((Entity)var10006).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var10002 = new Vec3(var60, var61, ((Entity)var10006).getZ());
            entity.lookAt(var10001, var10002);
         }

         dis = 6.0;

         for(int index0 = 0; index0 < 10; ++index0) {
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getBlockPos().getZ();
            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                  SUCCESS = true;
                  x_pos = entityiterator.getX();
                  y_pos = entityiterator.getY();
                  z_pos = entityiterator.getZ();
                  break;
               }
            }

            if (SUCCESS) {
               break;
            }

            dis += 6.0;
         }

         NUM1 = Math.random() * 720.0;
         NUM2 = Math.random() * 3.0;
         x_pos += Math.sin(Math.toRadians(NUM1)) * NUM2;
         z_pos += Math.cos(Math.toRadians(NUM1)) * NUM2;

         for(int index1 = 0; index1 < 255 && !(y_pos < -64.0); ++index1) {
            if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
               --y_pos;
            } else {
               if (!world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).canOcclude() && !world.getBlockState(BlockPos.containing(x_pos, y_pos + 1.0, z_pos)).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  break;
               }

               ++y_pos;
            }
         }

         int var58;
         label200: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var58 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label200;
               }
            }

            var58 = 0;
         }

         HP = (double)(20 + var58 * 2);
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.NEEDLE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                  entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
               }

               entityinstance.setYRot((float)(NUM1 + 90.0));
               entityinstance.setXRot((float)(Math.random() * 20.0));
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
                  LivingEntity _livingEntity40 = (LivingEntity)entityinstance;
                  if (_livingEntity40.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                     _livingEntity40.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.setHealth((float)HP);
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity47 = (LivingEntity)entityinstance;
                  if (_livingEntity47.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     double var59;
                     AttributeInstance var52;
                     label184: {
                        var52 = _livingEntity47.getAttribute(Attributes.ATTACK_DAMAGE);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity44 = (LivingEntity)entityinstance;
                           if (_livingEntity44.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var59 = _livingEntity44.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label184;
                           }
                        }

                        var59 = 0.0;
                     }

                     var52.setBaseValue(var59 + entity.getPersistentData().getDouble("cnt1") * 0.02);
                  }
               }

               _serverLevel.addFreshEntity(entityinstance);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 6.0) {
                  label255: {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                        label248: {
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

                              if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                 break label248;
                              }
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                              break label255;
                           }
                        }
                     }

                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            if (entity.getPersistentData().getDouble("cnt2") > 60.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
