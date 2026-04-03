package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.function.Consumer;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillExplodeAirProcedure {
   public SkillExplodeAirProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         boolean move_flag = false;
         String STR1 = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double size = 0.0;
         double dis = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_num = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         Entity entity_ = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            entity.getPersistentData().putDouble("cnt2", (double)(entity.getBbWidth() + 1.0F));
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.5);
         }

         dis = entity.getPersistentData().getDouble("cnt2");
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4, 4, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.FRAME.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
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

                  entityinstance.getPersistentData().putDouble("NameRanged_ranged", 0.0);
                  entityinstance.getPersistentData().putDouble("friend_num", 0.0);
                  entityinstance.getPersistentData().putString("OWNER_UUID", "");
                  entityinstance.getPersistentData().putDouble("NameRanged_ranged_keep", entity.getPersistentData().getDouble("NameRanged"));
                  entityinstance.getPersistentData().putDouble("friend_num_keep", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putString("OWNER_UUID_keep", entity.getStringUUID());
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity40 = (LivingEntity)entityinstance;
                     if (_livingEntity40.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity40.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(ReturnEntitySizeProcedure.execute(entity));
                     }
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label134: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label135: {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                    break label135;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label134;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }
               }

               if (!entity.getPersistentData().getBoolean("PRESS_Z") || entity.getPersistentData().getDouble("cnt1") >= 15.0) {
                  entity.getPersistentData().putDouble("cnt3", 1.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") != 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().putDouble("skill", 1900.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 5, 0, false, false));
                  }
               }

               entity.getPersistentData().putDouble("cnt1", 2.0);
               if (!(entity instanceof Player) && !world.getEntitiesOfClass(FrameEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.75, entity.getZ()), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity)), (e) -> true).isEmpty()) {
                  entity_ = (Entity)world.getEntitiesOfClass(FrameEntity.class, AABB.ofSize(new Vec3(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.75, entity.getZ()), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity), 8.0 * ReturnEntitySizeProcedure.execute(entity)), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.75, entity.getZ())).findFirst().orElse((FrameEntity) null);
                  RotateEntityProcedure.execute(entity_.getX(), entity_.getY() + (double)entity_.getBbHeight() * 0.5, entity_.getZ(), entity);
               }
            }
         }

      }
   }
}
