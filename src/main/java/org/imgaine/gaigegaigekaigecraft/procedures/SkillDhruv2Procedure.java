package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;

public class SkillDhruv2Procedure {
   public SkillDhruv2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double pitch = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            entity.getPersistentData().putDouble("cnt1", -6.0);
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               entity.getPersistentData().putDouble("cnt3", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            CompoundTag var10001 = entity.getPersistentData();
            CompoundTag var10002 = entity.getPersistentData();
            entity_a = GetEntityFromUUIDProcedure.execute(world, var10001.getString("SHIKIGAMI_DHRUV2_" + Math.round(var10002.getDouble("cnt2"))));
            if (entity_a instanceof ShikigamiPterosaurEntity && !entity_a.level().isClientSide()) {
               entity_a.discard();
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.SHIKIGAMI_PTEROSAUR.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
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

                  entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  entity.getPersistentData().putString("SHIKIGAMI_DHRUV2_" + Math.round(entity.getPersistentData().getDouble("cnt2")), entityinstance.getStringUUID());
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity37 = (LivingEntity)entityinstance;
                     if (_livingEntity37.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        AttributeInstance var10000;
                        double var38;
                        label94: {
                           var10000 = _livingEntity37.getAttribute(Attributes.ATTACK_DAMAGE);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entityinstance;
                              if (_livingEntity33.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var38 = _livingEntity33.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label94;
                              }
                           }

                           var38 = 0.0;
                        }
                        double var40;
                        label89: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity34 = (LivingEntity)entity;
                              if (_livingEntity34.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var40 = _livingEntity34.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label89;
                              }
                           }

                           var40 = 0.0;
                        }

                        int var10003;
                        label84: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label84;
                              }
                           }

                           var10003 = 0;
                        }

                        var10000.setBaseValue(var38 + (var40 + (double)(var10003 * 3)) * 0.75);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffect var41;
                        int var10005;
                        MobEffectInstance var39;
                        label73: {
                           var41 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label73;
                              }
                           }

                           var10005 = 0;
                        }

                        var39 = new MobEffectInstance(var41, 2147483647, Math.max(var10005, 0), false, false);
                        _entity.addEffect(var39);
                     }
                  }

                  entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putBoolean("Shikigami", true);
                  entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                  entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityinstance.getPersistentData().putDouble("old_x", entity.getX());
                  entityinstance.getPersistentData().putDouble("old_y", entity.getY());
                  entityinstance.getPersistentData().putDouble("old_z", entity.getZ());
                  entityinstance.getPersistentData().putDouble("mode", 1.0);
                  entityinstance.getPersistentData().putDouble("skill", 1.0);
                  entityinstance.getPersistentData().putDouble("cnt1", 50.0);
                  if (entity instanceof Player) {
                     entityinstance.getPersistentData().putDouble("BaseCursePower", entity.getPersistentData().getDouble("cnt3") * 0.25);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") > 3.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
