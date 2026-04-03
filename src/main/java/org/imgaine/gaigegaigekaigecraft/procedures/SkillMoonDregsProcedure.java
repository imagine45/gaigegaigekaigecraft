package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.MoonDregsEntity;
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

public class SkillMoonDregsProcedure {
   public SkillMoonDregsProcedure() {
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
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("SHIKIGAMI_MOON_DREGS_UUID"));
         if (entity_a instanceof MoonDregsEntity && !entity_a.level().isClientSide()) {
            entity_a.discard();
         }

         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         yaw = (double)entity.getYRot();
         pitch = (double)entity.getXRot();
         x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
         y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
         z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.MOON_DREGS.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
               entity.getPersistentData().putString("SHIKIGAMI_MOON_DREGS_UUID", entityinstance.getStringUUID());
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity29 = (LivingEntity)entityinstance;
                  if (_livingEntity29.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     AttributeInstance var10000;
                     double var10001;
                     label86: {
                        var10000 = _livingEntity29.getAttribute(Attributes.ATTACK_DAMAGE);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                           if (_livingEntity25.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10001 = _livingEntity25.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label86;
                           }
                        }

                        var10001 = 0.0;
                     }

                     double var10002;
                     label81: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity26 = (LivingEntity)entity;
                           if (_livingEntity26.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10002 = _livingEntity26.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label81;
                           }
                        }

                        var10002 = 0.0;
                     }

                     int var10003;
                     label76: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label76;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 0.5);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var38;
                     MobEffect var39;
                     int var10005;
                     label65: {
                        var39 = MobEffects.DAMAGE_RESISTANCE;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                              break label65;
                           }
                        }

                        var10005 = 0;
                     }

                     var38 = new MobEffectInstance(var39, 2147483647, Math.max(var10005, 0), false, false);
                     _entity.addEffect(var38);
                  }
               }

               entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putBoolean("Shikigami", true);
               entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
               entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
               entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
               entityinstance.getPersistentData().putDouble("cnt_x", 100.0);
               if (entity instanceof Player) {
                  entityinstance.getPersistentData().putDouble("BaseCursePower", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
               }

               _serverLevel.addFreshEntity(entityinstance);
            }
         }

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
