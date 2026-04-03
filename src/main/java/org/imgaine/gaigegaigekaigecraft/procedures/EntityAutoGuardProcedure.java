package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import software.bernie.geckolib.animatable.GeoEntity;

public class EntityAutoGuardProcedure {
   public EntityAutoGuardProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         double distance = 0.0;
         double attacker_lv = 0.0;
         double defender_lv = 0.0;
         double guard_chance = 0.0;
         if (!(entity instanceof Player)) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().getBoolean("jjkChara") && entity instanceof GeoEntity && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:no_guard"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  int var25;
                  label71: {
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)sourceentity;
                        if (_livEnt9.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           label67: {
                              if (sourceentity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)sourceentity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var25 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label67;
                                 }
                              }

                              var25 = 0;
                           }

                           ++var25;
                           break label71;
                        }
                     }

                     var25 = 0;
                  }
                  int var27;
                  label61: {
                     attacker_lv = (double)var25;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           label57: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var27 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label57;
                                 }
                              }

                              var27 = 0;
                           }

                           ++var27;
                           break label61;
                        }
                     }

                     var27 = 0;
                  }

                  defender_lv = (double)var27;
                  guard_chance = Math.max((defender_lv - attacker_lv) * 10.0, 0.0);
                  distance = GetDistanceIteratorProcedure.execute(entity, sourceentity);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 == sourceentity) {
                     guard_chance += distance * 3.0;
                  } else {
                     guard_chance += Math.max(100.0 - distance * 3.0, 0.0);
                  }

                  if (guard_chance > 0.0 && guard_chance > Mth.nextDouble(RandomSource.create(), 0.0, 100.0)) {
                     StartGuardProcedure.execute(world, entity);
                  }
               }
            }
         }

      }
   }
}
