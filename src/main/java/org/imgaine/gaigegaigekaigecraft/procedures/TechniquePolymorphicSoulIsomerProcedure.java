package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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

public class TechniquePolymorphicSoulIsomerProcedure {
   public TechniquePolymorphicSoulIsomerProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double size = 0.0;
         double dis = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         yaw = (double)entity.getYRot();
         pitch = (double)entity.getXRot();
         entity.setYRot((float)(yaw + (Math.random() - 0.5) * 120.0));
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

         x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
         y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
         z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
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

         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.POLYMORPHIC_SOUL_ISOMER.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
               entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
               entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity29 = (LivingEntity)entityinstance;
                  if (_livingEntity29.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     AttributeInstance var10000;
                     double var10001;
                     label72: {
                        var10000 = _livingEntity29.getAttribute(Attributes.ATTACK_DAMAGE);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                           if (_livingEntity25.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10001 = _livingEntity25.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label72;
                           }
                        }

                        var10001 = 0.0;
                     }

                     double var10002;
                     label67: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity26 = (LivingEntity)entity;
                           if (_livingEntity26.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              var10002 = _livingEntity26.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                              break label67;
                           }
                        }

                        var10002 = 0.0;
                     }

                     int var10003;
                     label62: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label62;
                           }
                        }

                        var10003 = 0;
                     }

                     var10000.setBaseValue(var10001 + (var10002 + (double)(var10003 * 3)) * 1.0);
                  }
               }

               entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
               entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
               entityinstance.getPersistentData().putBoolean("Player", entity.getPersistentData().getBoolean("Player") || entity instanceof Player);
               _serverLevel.addFreshEntity(entityinstance);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 2.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().getDouble("COOLDOWN_TICKS") * 2.0), 0, false, false));
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
