package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class SetRangedAmmoProcedure {
   public SetRangedAmmoProcedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double str_level = 0.0;
         if (entityiterator instanceof LivingEntity) {
            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
               entity.getPersistentData().putDouble("NameRanged", Math.random());
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            entityiterator.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
            entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
            entityiterator.getPersistentData().putBoolean("jjkChara", true);
            if (entity instanceof Player || entity.getPersistentData().getBoolean("Player")) {
               entityiterator.getPersistentData().putBoolean("Player", true);
               entityiterator.getPersistentData().putString("PlayerName", entity.getDisplayName().getString());
            }

            if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               entityiterator.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
               entityiterator.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt20 = (LivingEntity)entity;
               if (_livEnt20.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  double var10000;
                  label87: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label87;
                        }
                     }

                     var10000 = 0.0;
                  }

                  str_level = var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt22 = (LivingEntity)entity;
                     if (_livEnt22.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        int var10001;
                        label79: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                 break label79;
                              }
                           }

                           var10001 = 0;
                        }

                        str_level = str_level + (double)var10001 + 1.0;
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)str_level, false, false));
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt25 = (LivingEntity)entity;
               if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) && entityiterator instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityiterator;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var14;
                     MobEffect var10003;
                     int var10004;
                     label68: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10004 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getDuration();
                              break label68;
                           }
                        }

                        var10004 = 0;
                     }

                     int var10005;
                     label63: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                              break label63;
                           }
                        }

                        var10005 = 0;
                     }

                     var14 = new MobEffectInstance(var10003, var10004, var10005, false, false);
                     _entity.addEffect(var14);
                  }
               }
            }

            entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
         }

      }
   }
}
