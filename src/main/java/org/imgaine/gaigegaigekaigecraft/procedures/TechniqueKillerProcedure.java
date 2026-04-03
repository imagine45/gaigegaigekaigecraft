package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueKillerProcedure {
   public TechniqueKillerProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double strength = 0.0;
         double HP = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         boolean player = false;
         boolean target = false;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         player = entity instanceof Player;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 10, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            int var10001;
            label206: {
               entity.getPersistentData().putDouble("x_pos", entity.getX());
               entity.getPersistentData().putDouble("y_pos", entity.getY());
               entity.getPersistentData().putDouble("z_pos", entity.getZ());
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label206;
                  }
               }

               var10001 = 0;
            }

            HP = (double)(80 + var10001 * 10);

            for(int index0 = 0; index0 < 4; ++index0) {
               ++loop_num;
               y_pos = entity.getPersistentData().getDouble("y_pos") - 0.0;
               if (loop_num <= 2.0) {
                  x_pos = entity.getPersistentData().getDouble("x_pos") + (double)(loop_num % 2.0 == 1.0 ? 2 : -2);
                  z_pos = entity.getPersistentData().getDouble("z_pos");
               } else {
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos") + (double)(loop_num % 2.0 == 1.0 ? 2 : -2);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_DOOR.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                     }

                     entityinstance.setYRot(0.0F);
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

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity27 = (LivingEntity)entityinstance;
                        if (_livingEntity27.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity27.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putBoolean("Shikigami", true);
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            double var54;
            label195: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var54 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label195;
                  }
               }

               var54 = 0.0;
            }

            strength = var54;
            loop_num = Math.ceil(Math.random() * 4.0);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.KILLER_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
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

                  entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var59;
                        MobEffect var10003;
                        int var10005;
                        label185: {
                           var10003 = MobEffects.DAMAGE_RESISTANCE;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                                 break label185;
                              }
                           }

                           var10005 = 0;
                        }

                        var59 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                        _entity.addEffect(var59);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        MobEffectInstance var60;
                        MobEffect var64;
                        int var65;
                        label177: {
                           var64 = MobEffects.DAMAGE_BOOST;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var65 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label177;
                              }
                           }

                           var65 = 0;
                        }

                        var60 = new MobEffectInstance(var64, 2147483647, var65, false, false);
                        _entity.addEffect(var60);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity60 = (LivingEntity)entityinstance;
                     if (_livingEntity60.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        double var61;
                        AttributeInstance var55;
                        label169: {
                           var55 = _livingEntity60.getAttribute(Attributes.MAX_HEALTH);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity58 = (LivingEntity)entityinstance;
                              if (_livingEntity58.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                 var61 = _livingEntity58.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                                 break label169;
                              }
                           }

                           var61 = 0.0;
                        }

                        var55.setBaseValue(var61 + strength * 4.0);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                     if (_livingEntity64.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                        double var62;
                        AttributeInstance var56;
                        label161: {
                           var56 = _livingEntity64.getAttribute(Attributes.MOVEMENT_SPEED);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity62 = (LivingEntity)entityinstance;
                              if (_livingEntity62.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                                 var62 = _livingEntity62.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
                                 break label161;
                              }
                           }

                           var62 = 0.0;
                        }

                        var56.setBaseValue(var62 + 0.02);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity68 = (LivingEntity)entityinstance;
                     if (_livingEntity68.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        double var63;
                        AttributeInstance var57;
                        label153: {
                           var57 = _livingEntity68.getAttribute(Attributes.ATTACK_DAMAGE);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity66 = (LivingEntity)entityinstance;
                              if (_livingEntity66.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var63 = _livingEntity66.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label153;
                              }
                           }

                           var63 = 0.0;
                        }

                        var57.setBaseValue(var63 + strength * 3.0 * 0.5);
                     }
                  }

                  entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  entityinstance.getPersistentData().putBoolean("Player", player);
                  entityinstance.getPersistentData().putBoolean("Shikigami", true);
                  if (target) {
                     CompoundTag var58 = entityinstance.getPersistentData();
                     LivingEntity var10002;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.getTarget();
                     } else {
                        var10002 = null;
                     }

                     var58.putString("TARGET_UUID", ((Entity)var10002).getStringUUID());
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F, false);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
