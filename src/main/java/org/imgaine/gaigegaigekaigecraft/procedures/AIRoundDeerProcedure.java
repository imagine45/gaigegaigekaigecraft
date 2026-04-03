package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIRoundDeerProcedure {
   public AIRoundDeerProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double NUM3 = 0.0;
         double NUM1 = 0.0;
         if (entity.isAlive()) {
            double var10001;
            label96: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               NUM1 = (double)(4L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity2 = (LivingEntity)entity;
                  if (_livingEntity2.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity2.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label96;
                  }
               }

               var10001 = 0.0;
            }

            label91: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               NUM3 = -60.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label91;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label86: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label86;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
               }
            }

            LivingEntity var29;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var29 = _mobEnt.getTarget();
            } else {
               var29 = null;
            }

            if (var29 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var29 = _mobEnt.getTarget();
               } else {
                  var29 = null;
               }

               if (!((Entity)var29).getPersistentData().getBoolean("CursedSpirit")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                     }
                  }
               } else if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                  for(Entity entityiterator : new ArrayList<Entity>(world.players())) {
                     if (entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num")) {
                        if (entityiterator.isShiftKeyDown() && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
                           }
                        }
                        break;
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt21 = (LivingEntity)entity;
               if (_livEnt21.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                  entity.getPersistentData().putDouble("BaseCursePower", Math.max(entity.getPersistentData().getDouble("BaseCursePower") - 1.0, 0.0));
               }
            }
         }

      }
   }
}
