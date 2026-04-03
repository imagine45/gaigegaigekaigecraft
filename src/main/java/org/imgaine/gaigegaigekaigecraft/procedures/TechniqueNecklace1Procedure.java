package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade39Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueNecklace1Procedure {
   public TechniqueNecklace1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean player = false;
         boolean target = false;
         double amount = 0.0;
         double strength = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
            entity.getPersistentData().putDouble("friend_num", Math.random());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.swing(InteractionHand.MAIN_HAND, true);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 10, false, false));
            }
         }

         amount = 8.0;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(32.0), (e) -> true)) {
            if (entityiterator instanceof CursedSpiritGrade39Entity) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0 && (entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num") || entityiterator.getPersistentData().getDouble("friend_num") == 0.0)) {
                  if (entityiterator instanceof Mob) {
                     Mob _entity = (Mob)entityiterator;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     LivingEntity var34 = var10000;
                     if (var34 instanceof LivingEntity) {
                        LivingEntity _ent = var34;
                        _entity.setTarget(_ent);
                     }
                  }

                  CompoundTag var70 = entityiterator.getPersistentData();
                  LivingEntity var10002;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10002 = _mobEnt.getTarget();
                  } else {
                     var10002 = null;
                  }

                  var70.putString("TARGET_UUID", ((Entity)var10002).getStringUUID());
                  entityiterator.getPersistentData().putDouble("cnt_target", Math.max(entityiterator.getPersistentData().getDouble("cnt_target"), 10.0));
                  entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
               }

               if (entity.getStringUUID().equals(entityiterator.getPersistentData().getString("OWNER_UUID"))) {
                  --amount;
               }
            }
         }

         double var71;
         label219: {
            yaw = (double)entity.getYRot();
            pitch = (double)entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var71 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label219;
               }
            }

            var71 = 0.0;
         }

         strength = var71;
         player = entity instanceof Player;
         LivingEntity var72;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var72 = _mobEnt.getTarget();
         } else {
            var72 = null;
         }

         target = var72 instanceof LivingEntity;
         if (amount > 0.0) {
            for(int index0 = 0; index0 < (int)amount; ++index0) {
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 180.0));
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

               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = entity.getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                  y_pos = entity.getY();

                  for(int index1 = 0; index1 < 12; ++index1) {
                     ++y_pos;
                     if (!world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        break;
                     }
                  }
               } else if (!world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                  y_pos = entity.getY();

                  for(int index2 = 0; index2 < 12; ++index2) {
                     --y_pos;
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos - 1.0, z_pos)).canOcclude()) {
                        break;
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.CURSED_SPIRIT_GRADE_39.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                     entityinstance.setYRot((float)yaw);
                     entityinstance.setXRot((float)pitch);
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
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 9, false, false));
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity59 = (LivingEntity)entityinstance;
                        if (_livingEntity59.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           double var10001;
                           AttributeInstance var73;
                           label200: {
                              var73 = _livingEntity59.getAttribute(Attributes.MAX_HEALTH);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity57 = (LivingEntity)entityinstance;
                                 if (_livingEntity57.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                                    var10001 = _livingEntity57.getAttribute(Attributes.MAX_HEALTH).getBaseValue();
                                    break label200;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           var73.setBaseValue(var10001 + strength * 4.0);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity63 = (LivingEntity)entityinstance;
                        if (_livingEntity63.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                           double var78;
                           AttributeInstance var74;
                           label189: {
                              var74 = _livingEntity63.getAttribute(Attributes.MOVEMENT_SPEED);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity61 = (LivingEntity)entityinstance;
                                 if (_livingEntity61.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                                    var78 = _livingEntity61.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
                                    break label189;
                                 }
                              }

                              var78 = 0.0;
                           }

                           var74.setBaseValue(var78 + 0.02);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity67 = (LivingEntity)entityinstance;
                        if (_livingEntity67.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                           double var79;
                           AttributeInstance var75;
                           label178: {
                              var75 = _livingEntity67.getAttribute(Attributes.ATTACK_DAMAGE);
                              if (entityinstance instanceof LivingEntity) {
                                 LivingEntity _livingEntity65 = (LivingEntity)entityinstance;
                                 if (_livingEntity65.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                    var79 = _livingEntity65.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                    break label178;
                                 }
                              }

                              var79 = 0.0;
                           }

                           var75.setBaseValue(var79 + strength * 3.0 * 0.5);
                        }
                     }

                     entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                     entityinstance.getPersistentData().putBoolean("CursedSpirit", entity.getPersistentData().getBoolean("CursedSpirit"));
                     entityinstance.getPersistentData().putBoolean("Player", player);
                     entityinstance.getPersistentData().putBoolean("Shikigami", true);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var72 = _mobEnt.getTarget();
                     } else {
                        var72 = null;
                     }

                     if (var72 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                        CompoundTag var77 = entityinstance.getPersistentData();
                        LivingEntity var80;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var80 = _mobEnt.getTarget();
                        } else {
                           var80 = null;
                        }

                        var77.putString("TARGET_UUID", ((Entity)var80).getStringUUID());
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos, z_pos, 20, 0.5, 0.0, 0.5, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos, z_pos, 5, 0.5, 0.5, 0.5, 0.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 0.1F, 0.5F, false);
                  }
               }
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

         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
