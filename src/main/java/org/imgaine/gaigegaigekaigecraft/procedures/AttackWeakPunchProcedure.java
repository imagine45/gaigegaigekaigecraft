package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackStrikeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;
import software.bernie.geckolib.animatable.GeoEntity;

public class AttackWeakPunchProcedure {
   public AttackWeakPunchProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean combo = false;
         double strength = 0.0;
         double d = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double old_cnt6 = 0.0;
         double weapon_size = 0.0;
         double loop_num = 0.0;
         double attack_reach = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt6") < 0.0) {
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         } else {
            double var10001;
            double var10002;
            label207: {
               var10001 = entity.getPersistentData().getDouble("cnt6");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var10002 = 0.3;
                     break label207;
                  }
               }

               var10002 = 0.2;
            }

            CNT6 = 1.0 + var10001 * var10002;
         }

         int var10000;
         label202: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label202;
               }
            }

            var10000 = 0;
         }

         strength = (double)Math.min(var10000, 50) * CNT6;
         weapon_size = GetWeaponSizeProcedure.execute(entity);
         attack_reach = GetReachProcedure.execute(entity);
         range = ReturnEntitySizeProcedure.execute(entity);
         range = range * range * Math.sqrt(weapon_size * attack_reach);
         combo = entity.getPersistentData().getDouble("cnt5") > 0.0 && entity.getPersistentData().getDouble("cnt5") < 100.0;
         if (entity.getPersistentData().getDouble("cnt1") < 2.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 3, false, false));
               }
            }

            entity.getPersistentData().putDouble("Damage", 4.0);
            DamageFixProcedure.execute(entity);
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               if (!combo) {
                  entity.getPersistentData().putDouble("cnt4", 3.0);
               } else {
                  entity.getPersistentData().putDouble("cnt4", (double)Mth.nextInt(RandomSource.create(), 1, 2));
               }

               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               dis = 2.5 * range;
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * dis;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * dis;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_ATTACK_STRIKE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b,NoAI:1b}");
                     }

                     entityinstance.teleportTo(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
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

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        EntityAttackStrikeEntity animatable = (EntityAttackStrikeEntity)entityinstance;
                        animatable.setTexture("slash_white");
                     }

                     if (entityinstance instanceof EntityAttackStrikeEntity) {
                        CompoundTag var92 = entity.getPersistentData();
                        PlayAnimationEntity2Procedure.execute(entityinstance, "idle" + Math.round(var92.getDouble("cnt4")));
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity40 = (LivingEntity)entityinstance;
                        if (_livingEntity40.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity40.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0 * range);
                        }
                     }

                     if (combo) {
                        entityinstance.setYRot((float)((double)entity.getYRot() + Mth.nextDouble(RandomSource.create(), -22.5, 22.5)));
                        entityinstance.setXRot((float)((double)entity.getXRot() + Mth.nextDouble(RandomSource.create(), -11.25, 11.25)));
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               ItemStack var90;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var90 = _livEnt.getMainHandItem();
               } else {
                  var90 = ItemStack.EMPTY;
               }

               if (var90.is(ItemTags.create(new ResourceLocation("forge:spear")))) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        BlockPos var93 = BlockPos.containing(x, y, z);
                        SoundEvent var10003 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var10004 = SoundSource.NEUTRAL;
                        float var10005 = (float)(range * 1.0);
                        ItemStack var10008;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10008 = _livEnt.getMainHandItem();
                        } else {
                           var10008 = ItemStack.EMPTY;
                        }

                        _level.playSound((Player)null, var93, var10003, var10004, var10005, (float)(1.0 / (weapon_size + var10008.getOrCreateTag().getDouble("Power"))));
                     } else {
                        SoundEvent var96 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep"));
                        SoundSource var99 = SoundSource.NEUTRAL;
                        float var10006 = (float)(range * 1.0);
                        ItemStack var10009;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10009 = _livEnt.getMainHandItem();
                        } else {
                           var10009 = ItemStack.EMPTY;
                        }

                        _level.playLocalSound(x, y, z, var96, var99, var10006, (float)(1.0 / (weapon_size + var10009.getOrCreateTag().getDouble("Power"))), false);
                     }
                  }
               } else if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     BlockPos var94 = BlockPos.containing(x, y, z);
                     SoundEvent var95 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var97 = SoundSource.NEUTRAL;
                     float var100 = (float)(range * 0.25);
                     ItemStack var103;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var103 = _livEnt.getMainHandItem();
                     } else {
                        var103 = ItemStack.EMPTY;
                     }

                     _level.playSound((Player)null, var94, var95, var97, var100, (float)(1.0 / (weapon_size + var103.getOrCreateTag().getDouble("Power"))));
                  } else {
                     SoundEvent var98 = (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot"));
                     SoundSource var101 = SoundSource.NEUTRAL;
                     float var102 = (float)(range * 0.25);
                     ItemStack var104;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var104 = _livEnt.getMainHandItem();
                     } else {
                        var104 = ItemStack.EMPTY;
                     }

                     _level.playLocalSound(x, y, z, var98, var101, var102, (float)(1.0 / (weapon_size + var104.getOrCreateTag().getDouble("Power"))), false);
                  }
               }
               double var91;
               label184: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity56 = (LivingEntity)entity;
                     if (_livingEntity56.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        var91 = _livingEntity56.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).getBaseValue();
                        break label184;
                     }
                  }

                  var91 = 0.0;
               }

               if (var91 == 0.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity57 = (LivingEntity)entity;
                     if (_livingEntity57.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity57.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(100.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity59 = (LivingEntity)entity;
                     if (_livingEntity59.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity59.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(entity.getPersistentData().getDouble("cnt5"));
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (entity instanceof GeoEntity) {
                     if (GetEntityAnimationProcedure.execute(entity).equals("empty") && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.swing(InteractionHand.MAIN_HAND, true);
                     }
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               }

               entity.getPersistentData().putDouble("x_pos", x);
               entity.getPersistentData().putDouble("y_pos", Math.max(y, entity.getY() + (double)entity.getBbHeight() * 0.75));
               entity.getPersistentData().putDouble("z_pos", z);
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 0.5 * range);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 0.5 * range);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 0.5 * range);
               loop_num = Math.max(11.0 * attack_reach, 1.0);
               old_cnt6 = entity.getPersistentData().getDouble("cnt6");
               if (combo) {
                  entity.getPersistentData().putDouble("cnt6", -1.0);
               }

               for(int index0 = 0; index0 < (int)loop_num; ++index0) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power"));
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", !combo ? 0.25 * (1.0 + Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0) * 0.5) : 0.01);
                  entity.getPersistentData().putDouble("Range", 2.0 * range);
                  entity.getPersistentData().putDouble("effect", 5.0);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               entity.getPersistentData().putDouble("cnt6", old_cnt6);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               weapon_size = GetWeaponSizeProcedure.execute(entity);
               attack_reach = GetReachProcedure.execute(entity);
               range = ReturnEntitySizeProcedure.execute(entity);
               range = range * range * Math.sqrt(weapon_size * attack_reach);
               dis = 2.5 * range;
               if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity)).getBlockPos().getZ();
                  d = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
                  entity.getPersistentData().putDouble("BlockDamage", (0.1 + strength / 16.0) * Math.max(d * 0.25, 1.0));
                  entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * range, Math.max(d * 0.5, 1.0)));
                  entity.getPersistentData().putDouble("knockback", 0.25 * (1.0 + Math.max(entity.getPersistentData().getDouble("cnt6"), 0.0) * 0.5));
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") >= 10.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
