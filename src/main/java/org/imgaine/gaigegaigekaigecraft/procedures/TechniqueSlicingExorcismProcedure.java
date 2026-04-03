package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class TechniqueSlicingExorcismProcedure {
   public TechniqueSlicingExorcismProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean strong = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double strength = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity7 = (LivingEntity)entity;
            if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
               _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
            }
         }

         PlayAnimationProcedure.execute(world, entity);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label185: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label185;
                  }
               }

               var10001 = 0;
            }

            int var10000;
            label180: {
               HP = (double)(40 + var10001 * 4);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label180;
                  }
               }

               var10000 = 0;
            }

            strong = var10000 < 10;

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth()) + (Math.random() - 0.5) * 0.1;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth()) + Math.random() * 0.1;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth()) + (Math.random() - 0.5) * 0.1;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.SLICING_EXORCISM.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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

                     entityinstance.getPersistentData().putBoolean("death_painting", entity instanceof Player ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 10.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 10.0 : entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting"))));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity31 = (LivingEntity)entityinstance;
                        if (_livingEntity31.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity31.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     if (strong) {
                        entityinstance.getPersistentData().putDouble("move", 1.0);
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (strong) {
                  break;
               }
            }
         }

         LivingEntity var49;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var49 = _mobEnt.getTarget();
         } else {
            var49 = null;
         }

         if (var49 instanceof LivingEntity) {
            entity.getPersistentData().putBoolean("PRESS_Z", false);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
               label206: {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var49 = _mobEnt.getTarget();
                  } else {
                     var49 = null;
                  }

                  if (((Entity)var49).getPersistentData().getDouble("skill") != 0.0) {
                     label202: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var49 = _mobEnt.getTarget();
                        } else {
                           var49 = null;
                        }

                        if (((Entity)var49).getPersistentData().getDouble("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var49 = _mobEnt.getTarget();
                           } else {
                              var49 = null;
                           }

                           if (((Entity)var49).getPersistentData().getBoolean("attack")) {
                              break label202;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var49 = _mobEnt.getTarget();
                        } else {
                           var49 = null;
                        }

                        if (((Entity)var49).getPersistentData().getDouble("Damage") != 0.0) {
                           break label206;
                        }
                     }
                  }

                  entity.getPersistentData().putBoolean("PRESS_Z", true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") > 30.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", false);
            }
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 14.0));
            strength = 0.1;
            if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
               entity.getPersistentData().putDouble("cnt6", 5.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               strength = 0.5;
            } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
               entity.getPersistentData().putDouble("cnt6", 5.0);
               strength = 0.5;
            } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
               entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
               if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
               }

               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               ChargeParticleProcedure.execute(world, entity, 1.0);
            } else {
               ChargeParticleProcedure.execute(world, entity, 0.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 15.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
