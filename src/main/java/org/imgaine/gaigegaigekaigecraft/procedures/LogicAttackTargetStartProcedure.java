package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UraumeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModGameRules;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class LogicAttackTargetStartProcedure {
   public LogicAttackTargetStartProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (!(entity instanceof Mob mob)) {
         return false;
      } else {
         Entity target = mob.getTarget();
         if (!(target instanceof LivingEntity livingTarget)) {
            return true;
         } else {
            CompoundTag entityData = entity.getPersistentData();
            CompoundTag targetData = target.getPersistentData();
            double friendNum = entityData.getDouble("friend_num");
            if (friendNum != 0.0 && friendNum == targetData.getDouble("friend_num")) {
               return false;
            } else if (entityData.getString("TARGET_UUID").equals(target.getStringUUID())) {
               return true;
            } else {
               Entity event_owner = entity;
               Entity target_owner = target;
               int safeCounter = 0;

               for(String ownerUUID = entity.getPersistentData().getString("OWNER_UUID"); !ownerUUID.isEmpty() && safeCounter < 5; ++safeCounter) {
                  Entity found = GetEntityFromUUIDProcedure.execute(world, ownerUUID);
                  if (!(found instanceof LivingEntity)) {
                     break;
                  }

                  event_owner = found;
                  ownerUUID = found.getPersistentData().getString("OWNER_UUID");
               }

               safeCounter = 0;

               for(String t_ownerUUID = target.getPersistentData().getString("OWNER_UUID"); !t_ownerUUID.isEmpty() && safeCounter < 5; ++safeCounter) {
                  Entity found = GetEntityFromUUIDProcedure.execute(world, t_ownerUUID);
                  if (!(found instanceof LivingEntity)) {
                     break;
                  }

                  target_owner = found;
                  t_ownerUUID = found.getPersistentData().getString("OWNER_UUID");
               }

               boolean logic_a = true;
               boolean eOwnerIsPlayer = event_owner instanceof Player || event_owner.getPersistentData().getBoolean("Player");
               boolean tOwnerIsPlayer = target_owner instanceof Player || target_owner.getPersistentData().getBoolean("Player");
               if (eOwnerIsPlayer && tOwnerIsPlayer) {
                  if (!world.getLevelData().getGameRules().getBoolean(JujutsucraftModGameRules.JUJUTSUPVP)) {
                     logic_a = false;
                  }
               } else if (!event_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !entityData.getBoolean("JujutsuSorcerer") || !target_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !targetData.getBoolean("JujutsuSorcerer")) {
                  if (!event_owner.getPersistentData().getBoolean("CursedSpirit") && !event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:transfigured_human"))) || !target_owner.getPersistentData().getBoolean("CursedSpirit") && !target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:transfigured_human")))) {
                     if ((event_owner.getPersistentData().getBoolean("CurseUser") || entityData.getBoolean("CurseUser")) && !target_owner.getPersistentData().getBoolean("JujutsuSorcerer") && !target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("curseuser"))) && !target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("cursedspirit")))) {
                        logic_a = false;
                     }
                  } else {
                     logic_a = false;
                  }
               } else {
                  logic_a = false;
               }

               label239: {
                  label310: {
                     if (event_owner instanceof LivingEntity) {
                        LivingEntity le = (LivingEntity)event_owner;
                        if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label310;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity le2 = (LivingEntity)entity;
                        if (le2.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label310;
                        }
                     }

                     if (target_owner instanceof LivingEntity) {
                        LivingEntity le3 = (LivingEntity)target_owner;
                        if (le3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label310;
                        }
                     }

                     if (!livingTarget.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        break label239;
                     }
                  }

                  logic_a = true;
               }

               if (event_owner instanceof UraumeEntity) {
                  label222: {
                     if (ReturnInsideItemProcedure.execute(target_owner).getItem() != JujutsucraftModItems.SUKUNA_FINGER.get()) {
                        if (!(target_owner instanceof LivingEntity)) {
                           break label222;
                        }

                        LivingEntity le = (LivingEntity)target_owner;
                        if (!le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label222;
                        }
                     }

                     logic_a = false;
                  }
               }

               if (event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")))) {
                  boolean targetIsItadori = false;
                  if (!(target_owner instanceof Player)) {
                     targetIsItadori = target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:death_painting")));
                  } else {
                     Player pTarget = (Player)target_owner;
                     JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)pTarget.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                     targetIsItadori = pVars.PlayerCurseTechnique == 21.0 || pVars.PlayerCurseTechnique2 == 21.0;
                  }

                  if (targetIsItadori) {
                     logic_a = false;
                  }
               }

               boolean var10000;
               label204: {
                  if (event_owner instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)event_owner;
                     if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var10000 = true;
                        break label204;
                     }
                  }

                  var10000 = false;
               }

               boolean eSukuna;
               label199: {
                  eSukuna = var10000;
                  if (target_owner instanceof LivingEntity) {
                     LivingEntity le = (LivingEntity)target_owner;
                     if (le.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        var10000 = true;
                        break label199;
                     }
                  }

                  var10000 = false;
               }

               boolean tSukuna = var10000;
               if ((event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1"))) || event_owner instanceof Player && event_owner.getPersistentData().getBoolean("CurseUser") && !eSukuna) && (target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_1"))) || target_owner instanceof Player && target_owner.getPersistentData().getBoolean("CurseUser") && !tSukuna) || event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2"))) && target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_2"))) || event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) && target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_3"))) || event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4"))) && target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_4"))) || event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5"))) && target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:group_5"))) || event_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:zenin"))) && target_owner.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:zenin")))) {
                  logic_a = false;
               }

               LivingEntity var35;
               if (target instanceof Mob) {
                  Mob m = (Mob)target;
                  var35 = m.getTarget();
               } else {
                  var35 = null;
               }

               Entity targetsTarget = var35;
               if (targetsTarget instanceof LivingEntity && targetData.getDouble("cnt_target") > 6.0) {
                  if (friendNum != 0.0 && friendNum == targetsTarget.getPersistentData().getDouble("friend_num")) {
                     logic_a = true;
                  }

                  if (event_owner.isAlliedTo(targetsTarget)) {
                     logic_a = true;
                  }

                  if (targetsTarget == entity) {
                     logic_a = true;
                  }
               }

               if (event_owner == target_owner) {
                  logic_a = false;
               }

               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique"))) && !entityData.getBoolean("Ambush")) {
                  if (!target.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ten_shadows_technique")))) {
                     logic_a = true;
                  }

                  if (entity instanceof RabbitEscapeEntity && target instanceof RabbitEscapeEntity) {
                     logic_a = false;
                  }
               }

               return logic_a;
            }
         }
      }
   }
}
