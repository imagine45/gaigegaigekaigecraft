package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MahoragaCutTheWorldProcedure {
   public MahoragaCutTheWorldProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         boolean logic_a = false;
         boolean pitch = false;
         boolean worldCutter = false;
         boolean mahoraga_exist = false;
         boolean canUseWorld = false;
         Entity entity_owner = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.getTarget();
            } else {
               var10004 = null;
            }

            double var71 = ((Entity)var10004).getX();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.getTarget();
            } else {
               var10005 = null;
            }

            double var72 = ((Entity)var10005).getY();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var72 += (double)((Entity)var10006).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var10002 = new Vec3(var71, var72, ((Entity)var10006).getZ());
            entity.lookAt(var10001, var10002);
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity16 = (LivingEntity)entity;
               if (_livingEntity16.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity16.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity17 = (LivingEntity)entity;
               if (_livingEntity17.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity17.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
            worldCutter = true;
            yaw = (double)entity.getYRot();
            picth = (double)entity.getXRot();
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.5F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 0.75F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(0.3 * CNT6), 1.0F, false);
               }
            }

            entity.getPersistentData().putDouble("cnt2", Math.random() * 4.0 - 2.0);
            entity.getPersistentData().putDouble("cnt3", Math.abs(entity.getPersistentData().getDouble("cnt2")) - 2.0);
            range = 2.0;
            yaw2 = yaw - entity.getPersistentData().getDouble("cnt2") * 15.0 * range;
            pitch2 = picth - entity.getPersistentData().getDouble("cnt3") * 15.0 * range;

            for(int index0 = 0; (long)index0 < Math.round(30.0 * range); ++index0) {
               entity.setYRot((float)yaw2);
               entity.setXRot((float)pitch2);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               yaw2 += entity.getPersistentData().getDouble("cnt2");
               pitch2 += entity.getPersistentData().getDouble("cnt3");
               dis = 0.0;

               for(int index1 = 0; (long)index1 < Math.round(20.0 + Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0) * 2.0); ++index1) {
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
                  entity.getPersistentData().putDouble("Damage", 15.0);
                  if (Math.round(Math.floor(dis)) > 0L) {
                     for(int index2 = 0; index2 < (int)Math.round(Math.floor(dis)); ++index2) {
                        entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.99);
                        if (entity.getPersistentData().getDouble("Damage") < 9.0) {
                           entity.getPersistentData().putDouble("Damage", 9.0);
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.max(CNT6, 0.75));
                  entity.getPersistentData().putDouble("Range", 3.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", (0.5 + Math.max(30.0 - dis, 0.0) / 20.0) * Math.min(CNT6, 1.0));
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  if (worldCutter) {
                     entity.getPersistentData().putBoolean("ignore", true);
                     entity.getPersistentData().putDouble("effectConfirm", 3.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     if (Math.random() > CNT6 * 0.5) {
                        if ((!worldCutter || entity.getPersistentData().getDouble("cnt6") >= 5.0) && world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 0.05F, 2.0F, false);
                           }
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                     }

                     logic_a = true;
                  }

                  if (!world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos))) {
                     entity.getPersistentData().putDouble("BlockRange", 1.0 * CNT6);
                     entity.getPersistentData().putDouble("BlockDamage", 6.0 * CNT6);
                     if (worldCutter) {
                        entity.getPersistentData().putBoolean("ExtinctionBlock", true);
                        entity.getPersistentData().putDouble("BlockDamage", 99999.0);
                     }

                     entity.getPersistentData().putBoolean("noEffect", true);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  ++dis;
                  if (!worldCutter && logic_a) {
                     logic_a = false;
                     break;
                  }
               }
            }

            entity.setYRot((float)yaw);
            entity.setXRot((float)picth);
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

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity_owner = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity_owner instanceof Player) {
               if (entity_owner instanceof ServerPlayer) {
                  ServerPlayer _player = (ServerPlayer)entity_owner;
                  Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_dismantle_cut_the_world"));
                  AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                  if (!_ap.isDone()) {
                     for(String criteria : _ap.getRemainingCriteria()) {
                        _player.getAdvancements().award(_adv, criteria);
                     }
                  }
               }
            } else if (entity_owner instanceof SukunaFushiguroEntity && entity_owner instanceof SukunaFushiguroEntity) {
               SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity_owner;
               _datEntSetL.getEntityData().set(SukunaFushiguroEntity.DATA_world_cut, true);
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
