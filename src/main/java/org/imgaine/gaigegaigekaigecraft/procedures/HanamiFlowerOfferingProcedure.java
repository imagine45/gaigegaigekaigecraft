package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletCursePowerProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HanamiFlowerOfferingProcedure {
   public HanamiFlowerOfferingProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         BlockState block_a = Blocks.AIR.defaultBlockState();
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double distance = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double z_dis = 0.0;
         double energy = 0.0;
         double pitch = 0.0;
         double damage = 0.0;
         double CNT6 = 0.0;
         ItemStack target_item = ItemStack.EMPTY;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            target_item = var10000.copy();
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               target_item = var10000.copy();
            }
         }

         if (entity.getPersistentData().getDouble("cnt10") == 0.0) {
            if (entity instanceof Player) {
               if (target_item.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (target_item.getOrCreateTag().getDouble("C_Power") == 0.0) {
                     entity.getPersistentData().putDouble("cnt10", 1.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt10", 2.0);
                     entity.getPersistentData().putDouble("cnt1", 40.0);
                     entity.getPersistentData().putDouble("cnt2", 1.0);
                  }
               } else {
                  entity.getPersistentData().putDouble("cnt10", -1.0);
               }
            } else {
               entity.getPersistentData().putDouble("cnt10", -1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            if (entity.onGround()) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
               entity.getPersistentData().putDouble("cnt2", 1.0);
               entity.getPersistentData().putDouble("x_pos", x);
               entity.getPersistentData().putDouble("y_pos", y);
               entity.getPersistentData().putDouble("z_pos", z);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get() && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.OFF_HAND, true);
                  }
               }
            } else if (entity.getPersistentData().getDouble("cnt1") > 200.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") < 40.0) {
            if (!(entity.getPersistentData().getDouble("cnt1") < 30.0)) {
               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 38.0));
               }

               if (entity.getPersistentData().getDouble("cnt10") > 0.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 19, false, false));
                  }
               }

               range = entity.getPersistentData().getDouble("cnt1");
               x_pos = (double)Math.round(entity.getPersistentData().getDouble("x_pos") - range);

               for(int index0 = 0; index0 < (int)Math.round(range * 2.0); ++index0) {
                  x_dis = Math.pow(x_pos - entity.getPersistentData().getDouble("x_pos"), 2.0);
                  y_pos = (double)Math.round(entity.getPersistentData().getDouble("y_pos") + range);

                  for(int index1 = 0; index1 < (int)Math.round(range * 2.0); ++index1) {
                     y_dis = Math.pow(y_pos - entity.getPersistentData().getDouble("y_pos"), 2.0);
                     z_pos = (double)Math.round(entity.getPersistentData().getDouble("z_pos") - range);

                     for(int index2 = 0; index2 < (int)Math.round(range * 2.0); ++index2) {
                        z_dis = Math.pow(z_pos - entity.getPersistentData().getDouble("z_pos"), 2.0);
                        distance = Math.sqrt(x_dis + y_dis + z_dis);
                        if (distance < range && distance > range - 2.0) {
                           block_a = world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos));
                           if (!block_a.is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier"))) && block_a.getBlock() != Blocks.DEAD_BUSH && (block_a.getBlock() == Blocks.GRASS_BLOCK || block_a.is(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || block_a.is(BlockTags.create(new ResourceLocation("minecraft:tall_flowers"))) || block_a.is(BlockTags.create(new ResourceLocation("minecraft:saplings"))) || block_a.is(BlockTags.create(new ResourceLocation("minecraft:leaves"))) || block_a.getBlock() == Blocks.GRASS || block_a.getBlock() == Blocks.TALL_GRASS)) {
                              if (block_a.getBlock() == Blocks.GRASS_BLOCK) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ dirt");
                                 }
                              } else if (block_a.is(BlockTags.create(new ResourceLocation("minecraft:saplings")))) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ dead_bush");
                                 }
                              } else if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "setblock ~ ~ ~ air");
                              }

                              if (block_a.getBlock() != world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).getBlock()) {
                                 entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.7);
                                 if (target_item.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.getMainHandItem();
                                    } else {
                                       var10000 = ItemStack.EMPTY;
                                    }

                                    if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.getMainHandItem();
                                       } else {
                                          var10000 = ItemStack.EMPTY;
                                       }

                                       var10000.getOrCreateTag().putDouble("C_Power", entity.getPersistentData().getDouble("cnt6"));
                                    } else {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.getOffhandItem();
                                       } else {
                                          var10000 = ItemStack.EMPTY;
                                       }

                                       if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             var10000 = _livEnt.getOffhandItem();
                                          } else {
                                             var10000 = ItemStack.EMPTY;
                                          }

                                          var10000.getOrCreateTag().putDouble("C_Power", entity.getPersistentData().getDouble("cnt6"));
                                       }
                                    }
                                 }
                              }
                           }
                        }

                        z_pos = (double)Math.round(z_pos + 1.0);
                     }

                     y_pos = (double)Math.round(y_pos - 1.0);
                  }

                  x_pos = (double)Math.round(x_pos + 1.0);
               }
            }

            LivingEntity var124;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var124 = _mobEnt.getTarget();
            } else {
               var124 = null;
            }

            if (var124 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.getTarget();
               } else {
                  var124 = null;
               }

               Level var126 = ((Entity)var124).level();
               ClipContext var10001;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var141 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var143 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var143 = var143.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var147 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var10001 = new ClipContext(var141, var143, var147, var10006, var10007);
               double var127 = (double)var126.clip(var10001).getBlockPos().getX();
               LivingEntity var134;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var134 = _mobEnt.getTarget();
               } else {
                  var134 = null;
               }

               Level var135 = ((Entity)var134).level();
               ClipContext var10002;
               LivingEntity var145;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var145 = _mobEnt.getTarget();
               } else {
                  var145 = null;
               }

               Vec3 var146 = ((Entity)var145).getEyePosition(1.0F);
               LivingEntity var148;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var148 = _mobEnt.getTarget();
               } else {
                  var148 = null;
               }

               Vec3 var149 = ((Entity)var148).getEyePosition(1.0F);
               LivingEntity var153;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var153 = _mobEnt.getTarget();
               } else {
                  var153 = null;
               }

               var149 = var149.add(((Entity)var153).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var154 = Block.OUTLINE;
               ClipContext.Fluid var158 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.getTarget();
               } else {
                  var10008 = null;
               }

               var10002 = new ClipContext(var146, var149, var154, var158, var10008);
               double var136 = (double)var135.clip(var10002).getBlockPos().getY();
               LivingEntity var139;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var139 = _mobEnt.getTarget();
               } else {
                  var139 = null;
               }

               Level var140 = ((Entity)var139).level();
               ClipContext var142;
               LivingEntity var151;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var151 = _mobEnt.getTarget();
               } else {
                  var151 = null;
               }

               Vec3 var152 = ((Entity)var151).getEyePosition(1.0F);
               LivingEntity var155;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var155 = _mobEnt.getTarget();
               } else {
                  var155 = null;
               }

               Vec3 var156 = ((Entity)var155).getEyePosition(1.0F);
               LivingEntity var159;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var159 = _mobEnt.getTarget();
               } else {
                  var159 = null;
               }

               var156 = var156.add(((Entity)var159).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var160 = Block.OUTLINE;
               ClipContext.Fluid var161 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.getTarget();
               } else {
                  var10009 = null;
               }

               var142 = new ClipContext(var152, var156, var160, var161, var10009);
               RotateEntityProcedure.execute(var127, var136, (double)var140.clip(var142).getBlockPos().getZ(), entity);
            }
         } else {
            if (target_item.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
               entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), target_item.getOrCreateTag().getDouble("C_Power")));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("C_Power", 0.0);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemCooldowns var130 = _player.getCooldowns();
                     ItemStack var137;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var137 = _livEnt.getMainHandItem();
                     } else {
                        var137 = ItemStack.EMPTY;
                     }

                     var130.addCooldown(var137.getItem(), 100);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  if (var10000.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     var10000.getOrCreateTag().putDouble("C_Power", 0.0);
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemCooldowns var133 = _player.getCooldowns();
                        ItemStack var138;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var138 = _livEnt.getOffhandItem();
                        } else {
                           var138 = ItemStack.EMPTY;
                        }

                        var133.addCooldown(var138.getItem(), 100);
                     }
                  }
               }
            }

            energy = 1.0 + Math.sqrt(entity.getPersistentData().getDouble("cnt6")) * 0.5;
            CNT6 = 1.0 + energy * 0.03;
            range = 5.0 + Math.min(energy / 10.0, 10.0);
            if (entity.getPersistentData().getDouble("cnt1") <= 50.0 + energy * 0.5) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth());
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (0.5 + (double)entity.getBbWidth());
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.getBbWidth());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, (int)CNT6, 0.1 + CNT6 * 0.2, 0.1 + CNT6 * 0.2, 0.1 + CNT6 * 0.2, 1.0);
               }

               pitch = 0.8;

               for(int index3 = 0; index3 < (int)Math.round(CNT6 + 1.0); ++index3) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)pitch);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)pitch, false);
                     }
                  }

                  pitch -= 0.1;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 6, false, false));
                  }
               }

               entity.getPersistentData().putDouble("Damage", 1.0 * CNT6);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().getDouble("Damage");
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();

               for(int index4 = 0; index4 < 1; ++index4) {
                  entity.setYRot((float)(yaw + (Math.random() - 0.5) * (5.0 + CNT6 * 3.0)));
                  entity.setXRot((float)(pitch + (Math.random() - 0.5) * (5.0 + CNT6 * 3.0)));
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
                     Projectile _entityToSpawn = ((new InlineMethodHandler() {
                        public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BulletCursePowerProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CURSE_POWER_PROJECTILE.get(), level);
                           entityToSpawn.setOwner(shooter);
                           entityToSpawn.setBaseDamage((double)damage);
                           entityToSpawn.setKnockback(knockback);
                           entityToSpawn.setSilent(true);
                           entityToSpawn.setPierceLevel(piercing);
                           return entityToSpawn;
                        }
                     })).getArrowO(projectileLevel, entity, (float)damage, 0, (byte)1);
                     _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                     _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)(2.5 * CNT6 + Math.random() * 0.2), 0.0F);
                     projectileLevel.addFreshEntity(_entityToSpawn);
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

               entity.getPersistentData().putDouble("Damage", energy);
               entity.getPersistentData().putDouble("Range", range);
               entity.getPersistentData().putDouble("knockback", 2.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("cnt7", energy);
            } else if (entity.getPersistentData().getDouble("cnt1") > 60.0 + energy * 0.5) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
