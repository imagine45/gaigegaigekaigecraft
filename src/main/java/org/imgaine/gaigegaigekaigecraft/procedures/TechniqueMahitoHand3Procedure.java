package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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
import net.minecraft.world.level.LevelAccessor;

public class TechniqueMahitoHand3Procedure {
   public TechniqueMahitoHand3Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double distance = 0.0;
         double rad1 = 0.0;
         double width = 0.0;
         double picth = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") % 6.0 == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity8 = (LivingEntity)entity;
               if (_livingEntity8.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity8.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label100: {
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)(entity.getBbHeight() * 0.0F);
               z_pos = entity.getZ();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label100;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(50 + var10001 * 10);
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_MAHITO_HAND_3.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entityinstance;
                     if (_livingEntity20.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity20.getAttribute(Attributes.MAX_HEALTH).setBaseValue((double)Math.round(HP));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)Math.round(HP));
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entityinstance;
                     if (_livingEntity24.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity24.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(ReturnEntitySizeProcedure.execute(entity));
                     }
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
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
            entity.getPersistentData().putBoolean("PRESS_Z", false);
            if (entity.getPersistentData().getDouble("cnt2") < 50.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            } else if (entity.getPersistentData().getDouble("cnt2") < 80.0 && GetDistanceNearestEnemyProcedure.execute(world, entity) < 8.0) {
               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }
         } else if (!(entity instanceof Player)) {
            entity.getPersistentData().putBoolean("PRESS_Z", false);
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 30.0));
         }

         if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
            if (entity instanceof Player) {
               label116: {
                  if (entity instanceof Player) {
                     Player _plr = (Player)entity;
                     if (_plr.getAbilities().instabuild) {
                        break label116;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 80, 0, false, false));
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
