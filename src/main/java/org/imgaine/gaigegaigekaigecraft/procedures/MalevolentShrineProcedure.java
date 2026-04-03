package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class MalevolentShrineProcedure {
   public MalevolentShrineProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double var10000;
         int var10001;
         label207: {
            boolean logic_a = false;
            boolean failed = false;
            boolean logic_attack = false;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double range = 0.0;
            double dis = 0.0;
            double pitch = 0.0;
            double yaw = 0.0;
            Entity entity_a = null;
            Entity entity_ = null;
            var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                  break label207;
               }
            }

            var10001 = 0;
         }

         double var36 = var10000 * (double)(var10001 > 0 ? 6 : 2);
         entity.getPersistentData().putDouble("select", 1.0);
         DomainExpansionCreateBarrierProcedure.execute(world, x, y, z, entity);
         if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(var36 / 2.0), (e) -> true)) {
                  if (entityiterator instanceof LivingEntity && !entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                     entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "effect give @s blindness 2 0 true");
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:wind_chime")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:wind_chime")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 33.0 && entity.getPersistentData().getDouble("cnt1") == 34.0) {
               double var38 = (double)entity.getYRot();
               double var37 = (double)entity.getXRot();
               LivingEntity var58;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var58 = _mobEnt.getTarget();
               } else {
                  var58 = null;
               }

               if (var58 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.getTarget();
                  } else {
                     var58 = null;
                  }

                  double var60 = ((Entity)var58).getX();
                  LivingEntity var63;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var63 = _mobEnt.getTarget();
                  } else {
                     var63 = null;
                  }

                  double var64 = ((Entity)var63).getY();
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.getTarget();
                  } else {
                     var10002 = null;
                  }

                  RotateEntityProcedure.execute(var60, var64, ((Entity)var10002).getZ(), entity);
               } else {
                  RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"), entity);
               }

               entity.setYRot(entity.getYRot());
               entity.setXRot(0.0F);
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s slowness 1 10 true");
               }

               entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos_doma"));
               entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos_doma"));
               entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos_doma"));

               for(int index0 = 0; index0 < 100 && !world.getBlockState(BlockPos.containing(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos") - 1.0, entity.getPersistentData().getDouble("z_pos"))).canOcclude(); ++index0) {
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") - 1.0);
                  if (entity.getPersistentData().getDouble("y_pos") <= 0.0) {
                     entity.getPersistentData().putDouble("y_pos", 0.0);
                     break;
                  }
               }

               double var33 = entity.getPersistentData().getDouble("x_pos_doma") - Math.cos(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 5.0);
               double var34 = entity.getPersistentData().getDouble("y_pos");
               double var35 = entity.getPersistentData().getDouble("z_pos_doma") - Math.sin(Math.toRadians((double)(entity.getYRot() + 90.0F))) * Math.cos(Math.toRadians(0.0)) * (JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius - 5.0);
               if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
                  entity.getPersistentData().putDouble("NameRanged", Math.random());
               }

               float var61;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var61 = _livEnt.getHealth();
               } else {
                  var61 = -1.0F;
               }

               double var62 = (double)var61;
               float var65;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var65 = _livEnt.getMaxHealth();
               } else {
                  var65 = -1.0F;
               }

               if (var62 > (double)var65 * 0.5) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_MALEVOLENT_SHRINE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var33, var34, var35), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
                        }

                        entityinstance.setYRot((float)(entity.getDirection() != Direction.NORTH && entity.getDirection() != Direction.SOUTH ? 90 : 0));
                        entityinstance.setXRot(0.0F);
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                        entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_MALEVOLENT_SHRINE_2.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(var33, var34, var35), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b,Invulnerable:1b}");
                     }

                     entityinstance.setYRot(entity.getYRot());
                     entityinstance.setXRot(0.0F);
                     entityinstance.setYBodyRot(entityinstance.getYRot());
                     entityinstance.setYHeadRot(entityinstance.getYRot());
                     entityinstance.yRotO = entityinstance.getYRot();
                     entityinstance.xRotO = entityinstance.getXRot();
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(var33, var34, var35), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 3.0F, 0.75F);
                  } else {
                     _level.playLocalSound(var33, var34, var35, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 3.0F, 0.75F, false);
                  }
               }

               entity.getPersistentData().putDouble("y_pos_doma", var34 + 1.0);
               entity.setYRot((float)var38);
               entity.setXRot((float)var37);
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

         PlayAnimationProcedure.execute(world, entity);
      }
   }
}
