package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletBloodProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AILiquidArrowProcedure {
   public AILiquidArrowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean SUCCESS = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double loop_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         double damage = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double dis = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         num1 = Math.toRadians(Math.random() * 360.0);
         num2 = 1.5;

         for(int index0 = 0; index0 < 72; ++index0) {
            x_pos = x + Math.sin(num1) * num2;
            y_pos = y;
            z_pos = z + Math.cos(num1) * num2;
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_liquid_metal ~ ~ ~ 0.1 0.1 0.1 0 0 force");
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle dust 0.000 0.000 0.000 1 ~ ~ ~ 0.1 0.1 0.1 1 1 force");
            }

            num1 += Math.toRadians(Math.random() * 10.0);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).getX();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var74 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var74 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var75;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var75 = _mobEnt.getTarget();
                     } else {
                        var75 = null;
                     }

                     z_pos = ((Entity)var75).getZ();
                  } else {
                     dis = 6.0;

                     for(int index1 = 0; index1 < 8; ++index1) {
                        x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity_a)).getBlockPos().getX();
                        y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity_a)).getBlockPos().getY();
                        z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity_a)).getBlockPos().getZ();
                        Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                              SUCCESS = true;
                              x_pos = entityiterator.getX();
                              y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight();
                              z_pos = entityiterator.getZ();
                              break;
                           }
                        }

                        if (SUCCESS) {
                           break;
                        }

                        dis += 6.0;
                     }
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
               entity.getPersistentData().putDouble("Damage", 1.5);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().getDouble("Damage");
               yaw = (double)entity.getYRot();
               picth = (double)entity.getXRot();
               yaw2 = yaw + Mth.nextDouble(RandomSource.create(), -45.0, 45.0);
               pitch2 = 0.0;
               entity.setYRot((float)yaw2);
               entity.setXRot((float)pitch2);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = InlineMethodHandler.getArrowBulletBlood(projectileLevel, entity, (float)damage, 0);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 1.5F, 0.0F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.setYRot((float)yaw);
               entity.setXRot((float)picth);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
               entity.getPersistentData().putDouble("move", 0.0);
            }
         }

      }
   }
}
