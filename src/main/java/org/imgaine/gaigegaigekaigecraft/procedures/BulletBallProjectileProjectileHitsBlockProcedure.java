package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityDoorsEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class BulletBallProjectileProjectileHitsBlockProcedure {
   public BulletBallProjectileProjectileHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10001;
         label168: {
            double HP = 0.0;
            double rnd = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double old_rnd = 0.0;
            double NUM1 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label168;
               }
            }

            var10001 = 0;
         }

         double var26 = (double)(50 + var10001 * 5);
         double var29 = x;
         double var30 = y + 2.0;
         double var31 = z;
         Vec3 _center = new Vec3(x, var30, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> true)) {
            if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               var29 = entityiterator.getX();
               var30 = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.75;
               var31 = entityiterator.getZ();
               break;
            }
         }

         double var27;
         label151: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt8 = (LivingEntity)entity;
               if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().getBoolean("Failed")) {
                  int var10000;
                  label145: {
                     var27 = 0.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt10 = (LivingEntity)entity;
                        if (_livEnt10.hasEffect(MobEffects.LUCK)) {
                           label141: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.LUCK)) {
                                    var10000 = _livEnt.getEffect(MobEffects.LUCK).getAmplifier();
                                    break label141;
                                 }
                              }

                              var10000 = 0;
                           }

                           var10000 += 2;
                           break label145;
                        }
                     }

                     var10000 = 1;
                  }

                  double var33 = (double)var10000;
                  var33 += (double)(entity.getPersistentData().getDouble("mode_hakari") != 1.0 && entity.getPersistentData().getDouble("mode_hakari") != 2.0 ? 0 : 5);

                  for(int index0 = 0; index0 < (int)var33; ++index0) {
                     double var32 = var27;
                     var27 = Math.random();
                     if (var27 < 0.8) {
                        var27 = 1.0;
                     } else if (var27 < 0.9) {
                        var27 = 2.0;
                     } else if (var27 < 0.95) {
                        var27 = 3.0;
                     } else {
                        if (!(var27 < 0.99)) {
                           var27 = 5.0;
                           break;
                        }

                        var27 = 4.0;
                     }

                     if (var32 > var27) {
                        var27 = var32;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt14 = (LivingEntity)entity;
                     if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && entity.getPersistentData().getDouble("Reserve") == 0.0) {
                        entity.getPersistentData().putDouble("Reserve", (double)Math.round(var27));
                     }
                  }
                  break label151;
               }
            }

            var27 = 1.0;
         }

         if (world instanceof ServerLevel) {
            ServerLevel _serverLevel = (ServerLevel)world;
            Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOORS.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var29, var30, var31), MobSpawnType.MOB_SUMMONED, false, false);
            if (entityinstance != null) {
               entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
               SetRangedAmmoProcedure.execute(entity, entityinstance);
               if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                  entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
               }

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

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _livingEntity25 = (LivingEntity)entityinstance;
                  if (_livingEntity25.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                     _livingEntity25.getAttribute(Attributes.MAX_HEALTH).setBaseValue(var26);
                  }
               }

               if (entityinstance instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entityinstance;
                  _entity.setHealth((float)var26);
               }

               if (var27 == 1.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_white");
                  }
               } else if (var27 == 2.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_green");
                  }
               } else if (var27 == 3.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_red");
                  }
               } else if (var27 == 4.0) {
                  if (entityinstance instanceof EntityDoorsEntity) {
                     EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                     animatable.setTexture("door_gold");
                  }
               } else if (var27 == 5.0 && entityinstance instanceof EntityDoorsEntity) {
                  EntityDoorsEntity animatable = (EntityDoorsEntity)entityinstance;
                  animatable.setTexture("door_rainbow");
               }

               _serverLevel.addFreshEntity(entityinstance);
            }
         }

      }
   }
}
