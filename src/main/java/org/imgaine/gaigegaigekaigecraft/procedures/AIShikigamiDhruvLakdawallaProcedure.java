package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

public class AIShikigamiDhruvLakdawallaProcedure {
   public AIShikigamiDhruvLakdawallaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logicStart = false;
         boolean placed = false;
         Entity owner_uuid = null;
         double distance = 0.0;
         double level = 0.0;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double x_pos = 0.0;
         double tick = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double NUM1 = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
               }
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               if (entity.getPersistentData().getDouble("skill") <= 0.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 10, 0.25, 0.25, 0.25, 0.0);
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof ShikigamiPterosaurEntity) {
                  AIActiveFlyingProcedure.execute(world, entity);
               } else if (entity instanceof ShikigamiHeterocephalusGlaberEntity) {
                  double var10000;
                  label225: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity5 = (LivingEntity)entity;
                        if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           var10000 = _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                           break label225;
                        }
                     }

                     var10000 = 0.0;
                  }

                  if (var10000 < 6.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity7 = (LivingEntity)entity;
                        if (_livingEntity7.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           double var10001;
                           AttributeInstance var57;
                           label217: {
                              var57 = _livingEntity7.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get());
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livingEntity6 = (LivingEntity)entity;
                                 if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                                    var10001 = _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).getBaseValue();
                                    break label217;
                                 }
                              }

                              var10001 = 0.0;
                           }

                           var57.setBaseValue(Math.min(var10001 + 0.1, 6.0));
                        }
                     }

                     entity.setMaxUpStep((float)((double)entity.getStepHeight() + 0.01));
                  }
               }

               double var60;
               label208: {
                  NUM1 = (double)(2L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity11 = (LivingEntity)entity;
                     if (_livingEntity11.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        var60 = _livingEntity11.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                        break label208;
                     }
                  }

                  var60 = 0.0;
               }

               label203: {
                  NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var60 * 3.0) / 4.0, 3.0)));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        break label203;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                     }
                  }
               }

               int var58;
               label198: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        var58 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                        break label198;
                     }
                  }

                  var58 = 0;
               }

               if ((double)var58 < NUM2 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 1.0) {
               AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("cnt_x", -100.0);
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  if (entity.getPersistentData().getDouble("continue") > 0.0) {
                     entity.getPersistentData().putDouble("continue", entity.getPersistentData().getDouble("continue") - 1.0);
                     entity.getPersistentData().putDouble("skill", 1.0);
                  }

                  ResetCounterProcedure.execute(entity);
               }
            } else {
               LivingEntity var59;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var59 = _mobEnt.getTarget();
               } else {
                  var59 = null;
               }

               if (var59 instanceof LivingEntity) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     if (entity instanceof ShikigamiPterosaurEntity) {
                        ResetCounterProcedure.execute(entity);
                        entity.getPersistentData().putDouble("cnt_x", -50.0);
                        entity.getPersistentData().putDouble("skill", 1.0);
                        entity.getPersistentData().putDouble("continue", (double)(Math.random() < 0.75 ? 1 : 0));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
               }
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
               placed = true;
            } else if (entity.getPersistentData().getDouble("skill") > 0.0) {
               if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 15.0) {
                  placed = true;
               }
            } else if (entity.getPersistentData().getDouble("skill") == 0.0 && Math.random() < 0.1) {
               placed = true;
            }

            if (placed) {
               x_pos = x + (Math.random() - 0.5) * (double)entity.getBbWidth() * 0.5;
               y_pos = y + Math.random() * (double)entity.getBbWidth() * 0.5;
               z_pos = z + (Math.random() - 0.5) * (double)entity.getBbWidth() * 0.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ gaigegaigekaigecraft:domain keep");
               }

               if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).getBlock() == JujutsucraftModBlocks.DOMAIN.get()) {
                  if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity) {
                     if (!world.isClientSide()) {
                        BlockPos _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                        BlockEntity _blockEntity = world.getBlockEntity(_bp);
                        BlockState _bs = world.getBlockState(_bp);
                        if (_blockEntity != null) {
                           _blockEntity.getPersistentData().putString("OWNER_UUID", entity.getPersistentData().getString("OWNER_UUID"));
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                        }
                     }
                  } else if (!world.isClientSide()) {
                     BlockPos _bp = BlockPos.containing(x_pos, y_pos, z_pos);
                     BlockEntity _blockEntity = world.getBlockEntity(_bp);
                     BlockState _bs = world.getBlockState(_bp);
                     if (_blockEntity != null) {
                        _blockEntity.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getBoolean("Shikigami")) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }

            if (owner_uuid instanceof LivingEntity) {
               LivingEntity _livEnt67 = (LivingEntity)owner_uuid;
               if (_livEnt67.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            }
         }

      }
   }
}
