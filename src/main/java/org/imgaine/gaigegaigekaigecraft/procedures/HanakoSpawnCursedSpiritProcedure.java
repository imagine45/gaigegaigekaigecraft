package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class HanakoSpawnCursedSpiritProcedure {
   public HanakoSpawnCursedSpiritProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double amount = 0.0;
         double strength = 0.0;
         double kind = 0.0;
         double grade = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         boolean player = false;
         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         double var10000;
         label184: {
            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label184;
               }
            }

            var10000 = 0.0;
         }

         strength = var10000;
         player = entity instanceof Player || entity.getPersistentData().getBoolean("Player");
         grade = Math.random() < 0.2 ? 2.0 : 3.0;
         if (grade == 3.0) {
            int index0 = 0;

            while(index0 < 256) {
               kind = Math.ceil(Math.random() * 18.0);
               if (kind != 1.0 && kind != 2.0 && kind != 3.0 && kind != 5.0 && kind != 16.0) {
                  if (kind == 4.0) {
                     amount = 4.0;
                     break;
                  }

                  if (kind != 6.0 && kind != 14.0 && kind != 15.0 && kind != 17.0) {
                     if (kind != 8.0 && kind != 10.0 && kind != 13.0) {
                        if (kind != 11.0 && kind != 12.0) {
                           if (kind != 9.0 && kind != 13.0 && kind != 18.0) {
                              ++index0;
                              continue;
                           }

                           amount = 4.0;
                           break;
                        }

                        amount = 1.0;
                        break;
                     }

                     amount = 2.0;
                     break;
                  }

                  amount = 4.0;
                  break;
               }

               amount = 2.0;
               break;
            }
         } else if (grade == 2.0) {
            for(int index1 = 0; index1 < 256; ++index1) {
               kind = Math.ceil(Math.random() * 9.0);
               if (kind == 1.0 || kind == 4.0 || kind == 5.0 || kind == 8.0 || kind == 9.0) {
                  amount = 1.0;
                  break;
               }
            }
         }

         for(int index2 = 0; index2 < (int)Math.round(amount); ++index2) {
            entity.setYRot((float)(yaw + (Math.random() - 0.5) * 360.0));
            entity.setXRot((float)Math.min(pitch, 0.0));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(1.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(1.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var45 = _level.getServer().getCommands();
               CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
               long var10002 = Math.round(grade);
               var45.performPrefixedCommand(var10001, "summon gaigegaigekaigecraft:cursed_spirit_grade_" + var10002 + Math.round(kind));
            }

            Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
               if (entityiterator instanceof LivingEntity && entityiterator.getPersistentData().getDouble("friend_num") == 0.0 && entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                  entityiterator.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                  entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.setYRot((float)yaw);
                  entityiterator.setXRot((float)pitch);
                  entityiterator.setYBodyRot(entityiterator.getYRot());
                  entityiterator.setYHeadRot(entityiterator.getYRot());
                  entityiterator.yRotO = entityiterator.getYRot();
                  entityiterator.xRotO = entityiterator.getXRot();
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 9, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _livingEntity24 = (LivingEntity)entityiterator;
                     if (_livingEntity24.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        double var47;
                        AttributeInstance var46;
                        label110: {
                           var46 = _livingEntity24.getAttribute(Attributes.ATTACK_DAMAGE);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity23 = (LivingEntity)entityiterator;
                              if (_livingEntity23.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var47 = _livingEntity23.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label110;
                              }
                           }

                           var47 = 0.0;
                        }

                        var46.setBaseValue(var47 + strength * 3.0 * 0.5);
                     }
                  }

                  entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityiterator.getPersistentData().putBoolean("Player", player);
                  entityiterator.getPersistentData().putBoolean("Shikigami", true);
                  break;
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 25, 0.5, 0.5, 0.5, 0.0);
            }
         }

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

      }
   }
}
