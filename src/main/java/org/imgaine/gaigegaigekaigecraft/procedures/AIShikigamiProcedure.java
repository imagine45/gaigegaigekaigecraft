package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVessel2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class AIShikigamiProcedure {
   public AIShikigamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double count_a = 0.0;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         boolean failed = false;
         boolean old_sneak = false;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof RozetsuShikigamiVesselEntity) {
               NUM1 = 3.0;
               NUM2 = 1.0;
            } else if (entity instanceof RozetsuShikigamiVessel2Entity) {
               NUM1 = 6.0;
               NUM2 = 2.0;
            } else {
               double var10001;
               label155: {
                  NUM1 = (double)(2L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity4 = (LivingEntity)entity;
                     if (_livingEntity4.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var10001 = _livingEntity4.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label155;
                     }
                  }

                  var10001 = 0.0;
               }

               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
            }

            label148: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label148;
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
            label143: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label143;
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

            LivingEntity var35;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var35 = _mobEnt.getTarget();
            } else {
               var35 = null;
            }

            if (var35 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               entity.getPersistentData().putDouble("cnt_x2", 0.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  if (entity instanceof RozetsuShikigamiVessel2Entity) {
                     rnd = 0.0;
                     if (LogicStartProcedure.execute(entity)) {
                        rnd = Math.random() < 0.75 ? 8.0 : 7.0;
                        tick = 100.0;
                     }

                     if (rnd > 0.0) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().putDouble("TenShadowsTechnique4", 1.0);
                        entity.getPersistentData().putDouble("skill", (double)(600L + Math.round(rnd)));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
               if (entity instanceof RozetsuShikigamiVessel2Entity && entity.getPersistentData().getDouble("cnt_x2") > 120.0) {
                  entity.getPersistentData().putDouble("cnt_x2", 0.0);
                  entity.getPersistentData().putDouble("skill", 1.0);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         if (entity.getPersistentData().getBoolean("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_life") > (double)(entity instanceof RozetsuShikigamiEntity ? 400 : 600)) {
                  old_sneak = owner_uuid.isShiftKeyDown();
                  owner_uuid.setShiftKeyDown(true);
                  ShikigamiRightClickedOnEntityProcedure.execute(world, entity, owner_uuid);
                  owner_uuid.setShiftKeyDown(old_sneak);
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               }

               if (!owner_uuid.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }

            if ((!(entity instanceof RozetsuShikigamiEntity) || entity.getPersistentData().getBoolean("domain_entity")) && owner_uuid instanceof LivingEntity) {
               LivingEntity _livEnt47 = (LivingEntity)owner_uuid;
               if (_livEnt47.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
