package org.imgaine.gaigegaigekaigecraft.procedures;

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
         BlockState block_a = Blocks.f_50016_.m_49966_();
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
         ItemStack target_item = ItemStack.f_41583_;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.m_21205_();
         } else {
            var10000 = ItemStack.f_41583_;
         }

         if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            target_item = var10000.m_41777_();
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21206_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               target_item = var10000.m_41777_();
            }
         }

         if (entity.getPersistentData().m_128459_("cnt10") == 0.0) {
            if (entity instanceof Player) {
               if (target_item.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (target_item.m_41784_().m_128459_("C_Power") == 0.0) {
                     entity.getPersistentData().m_128347_("cnt10", 1.0);
                  } else {
                     entity.getPersistentData().m_128347_("cnt10", 2.0);
                     entity.getPersistentData().m_128347_("cnt1", 40.0);
                     entity.getPersistentData().m_128347_("cnt2", 1.0);
                  }
               } else {
                  entity.getPersistentData().m_128347_("cnt10", -1.0);
               }
            } else {
               entity.getPersistentData().m_128347_("cnt10", -1.0);
            }
         }

         if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
            if (entity.m_20096_()) {
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               entity.getPersistentData().m_128347_("cnt2", 1.0);
               entity.getPersistentData().m_128347_("x_pos", x);
               entity.getPersistentData().m_128347_("y_pos", y);
               entity.getPersistentData().m_128347_("z_pos", z);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get() && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.OFF_HAND, true);
                  }
               }
            } else if (entity.getPersistentData().m_128459_("cnt1") > 200.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         } else if (entity.getPersistentData().m_128459_("cnt1") < 40.0) {
            if (!(entity.getPersistentData().m_128459_("cnt1") < 30.0)) {
               if (entity.getPersistentData().m_128471_("PRESS_Z")) {
                  entity.getPersistentData().m_128347_("cnt1", Math.min(entity.getPersistentData().m_128459_("cnt1"), 38.0));
               }

               if (entity.getPersistentData().m_128459_("cnt10") > 0.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 19, false, false));
                  }
               }

               range = entity.getPersistentData().m_128459_("cnt1");
               x_pos = (double)Math.round(entity.getPersistentData().m_128459_("x_pos") - range);

               for(int index0 = 0; index0 < (int)Math.round(range * 2.0); ++index0) {
                  x_dis = Math.pow(x_pos - entity.getPersistentData().m_128459_("x_pos"), 2.0);
                  y_pos = (double)Math.round(entity.getPersistentData().m_128459_("y_pos") + range);

                  for(int index1 = 0; index1 < (int)Math.round(range * 2.0); ++index1) {
                     y_dis = Math.pow(y_pos - entity.getPersistentData().m_128459_("y_pos"), 2.0);
                     z_pos = (double)Math.round(entity.getPersistentData().m_128459_("z_pos") - range);

                     for(int index2 = 0; index2 < (int)Math.round(range * 2.0); ++index2) {
                        z_dis = Math.pow(z_pos - entity.getPersistentData().m_128459_("z_pos"), 2.0);
                        distance = Math.sqrt(x_dis + y_dis + z_dis);
                        if (distance < range && distance > range - 2.0) {
                           block_a = world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos));
                           if (!block_a.m_204336_(BlockTags.create(new ResourceLocation("jujutsucraft:barrier"))) && block_a.m_60734_() != Blocks.f_50036_ && (block_a.m_60734_() == Blocks.f_50440_ || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:replaceable_plants"))) || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:tall_flowers"))) || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:saplings"))) || block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:leaves"))) || block_a.m_60734_() == Blocks.f_50034_ || block_a.m_60734_() == Blocks.f_50359_)) {
                              if (block_a.m_60734_() == Blocks.f_50440_) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ dirt");
                                 }
                              } else if (block_a.m_204336_(BlockTags.create(new ResourceLocation("minecraft:saplings")))) {
                                 if (world instanceof ServerLevel) {
                                    ServerLevel _level = (ServerLevel)world;
                                    _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ dead_bush");
                                 }
                              } else if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_7654_().m_129892_().m_230957_((new CommandSourceStack(CommandSource.f_80164_, new Vec3(x_pos, y_pos, z_pos), Vec2.f_82462_, _level, 4, "", Component.m_237113_(""), _level.m_7654_(), (Entity)null)).m_81324_(), "setblock ~ ~ ~ air");
                              }

                              if (block_a.m_60734_() != world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60734_()) {
                                 entity.getPersistentData().m_128347_("cnt6", entity.getPersistentData().m_128459_("cnt6") + 0.7);
                                 if (target_item.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10000 = _livEnt.m_21205_();
                                    } else {
                                       var10000 = ItemStack.f_41583_;
                                    }

                                    if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.m_21205_();
                                       } else {
                                          var10000 = ItemStack.f_41583_;
                                       }

                                       var10000.m_41784_().m_128347_("C_Power", entity.getPersistentData().m_128459_("cnt6"));
                                    } else {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          var10000 = _livEnt.m_21206_();
                                       } else {
                                          var10000 = ItemStack.f_41583_;
                                       }

                                       if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             var10000 = _livEnt.m_21206_();
                                          } else {
                                             var10000 = ItemStack.f_41583_;
                                          }

                                          var10000.m_41784_().m_128347_("C_Power", entity.getPersistentData().m_128459_("cnt6"));
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
               var124 = _mobEnt.m_5448_();
            } else {
               var124 = null;
            }

            if (var124 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.m_5448_();
               } else {
                  var124 = null;
               }

               Level var126 = ((Entity)var124).m_9236_();
               ClipContext var10001 = new ClipContext;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.m_5448_();
               } else {
                  var10003 = null;
               }

               Vec3 var141 = ((Entity)var10003).m_20299_(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.m_5448_();
               } else {
                  var10004 = null;
               }

               Vec3 var143 = ((Entity)var10004).m_20299_(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.m_5448_();
               } else {
                  var10005 = null;
               }

               var143 = var143.m_82549_(((Entity)var10005).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var147 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.m_5448_();
               } else {
                  var10007 = null;
               }

               var10001.<init>(var141, var143, var147, var10006, var10007);
               double var127 = (double)var126.m_45547_(var10001).m_82425_().m_123341_();
               LivingEntity var134;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var134 = _mobEnt.m_5448_();
               } else {
                  var134 = null;
               }

               Level var135 = ((Entity)var134).m_9236_();
               ClipContext var10002 = new ClipContext;
               LivingEntity var145;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var145 = _mobEnt.m_5448_();
               } else {
                  var145 = null;
               }

               Vec3 var146 = ((Entity)var145).m_20299_(1.0F);
               LivingEntity var148;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var148 = _mobEnt.m_5448_();
               } else {
                  var148 = null;
               }

               Vec3 var149 = ((Entity)var148).m_20299_(1.0F);
               LivingEntity var153;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var153 = _mobEnt.m_5448_();
               } else {
                  var153 = null;
               }

               var149 = var149.m_82549_(((Entity)var153).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var154 = Block.OUTLINE;
               ClipContext.Fluid var158 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.m_5448_();
               } else {
                  var10008 = null;
               }

               var10002.<init>(var146, var149, var154, var158, var10008);
               double var136 = (double)var135.m_45547_(var10002).m_82425_().m_123342_();
               LivingEntity var139;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var139 = _mobEnt.m_5448_();
               } else {
                  var139 = null;
               }

               Level var140 = ((Entity)var139).m_9236_();
               ClipContext var142 = new ClipContext;
               LivingEntity var151;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var151 = _mobEnt.m_5448_();
               } else {
                  var151 = null;
               }

               Vec3 var152 = ((Entity)var151).m_20299_(1.0F);
               LivingEntity var155;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var155 = _mobEnt.m_5448_();
               } else {
                  var155 = null;
               }

               Vec3 var156 = ((Entity)var155).m_20299_(1.0F);
               LivingEntity var159;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var159 = _mobEnt.m_5448_();
               } else {
                  var159 = null;
               }

               var156 = var156.m_82549_(((Entity)var159).m_20252_(1.0F).m_82490_(0.0));
               ClipContext.Block var160 = Block.OUTLINE;
               ClipContext.Fluid var161 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.m_5448_();
               } else {
                  var10009 = null;
               }

               var142.<init>(var152, var156, var160, var161, var10009);
               RotateEntityProcedure.execute(var127, var136, (double)var140.m_45547_(var142).m_82425_().m_123343_(), entity);
            }
         } else {
            if (target_item.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
               entity.getPersistentData().m_128347_("cnt6", Math.max(entity.getPersistentData().m_128459_("cnt6"), target_item.m_41784_().m_128459_("C_Power")));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  var10000.m_41784_().m_128347_("C_Power", 0.0);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemCooldowns var130 = _player.m_36335_();
                     ItemStack var137;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var137 = _livEnt.m_21205_();
                     } else {
                        var137 = ItemStack.f_41583_;
                     }

                     var130.m_41524_(var137.m_41720_(), 100);
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.HANAMI_HAND.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     var10000.m_41784_().m_128347_("C_Power", 0.0);
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        ItemCooldowns var133 = _player.m_36335_();
                        ItemStack var138;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var138 = _livEnt.m_21206_();
                        } else {
                           var138 = ItemStack.f_41583_;
                        }

                        var133.m_41524_(var138.m_41720_(), 100);
                     }
                  }
               }
            }

            energy = 1.0 + Math.sqrt(entity.getPersistentData().m_128459_("cnt6")) * 0.5;
            CNT6 = 1.0 + energy * 0.03;
            range = 5.0 + Math.min(energy / 10.0, 10.0);
            if (entity.getPersistentData().m_128459_("cnt1") <= 50.0 + energy * 0.5) {
               yaw = Math.toRadians((double)(entity.m_146908_() + 90.0F));
               pitch = Math.toRadians((double)entity.m_146909_());
               x_pos = entity.m_20185_() + Math.cos(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_());
               y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.75 + Math.sin(pitch) * -1.0 * (0.5 + (double)entity.m_20205_());
               z_pos = entity.m_20189_() + Math.sin(yaw) * Math.cos(pitch) * (double)(2.0F + entity.m_20205_());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, (int)CNT6, 0.1 + CNT6 * 0.2, 0.1 + CNT6 * 0.2, 0.1 + CNT6 * 0.2, 1.0);
               }

               pitch = 0.8;

               for(int index3 = 0; index3 < (int)Math.round(CNT6 + 1.0); ++index3) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)pitch);
                     } else {
                        _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)pitch, false);
                     }
                  }

                  pitch -= 0.1;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 5, 6, false, false));
                  }
               }

               entity.getPersistentData().m_128347_("Damage", 1.0 * CNT6);
               DamageFixProcedure.execute(entity);
               damage = entity.getPersistentData().m_128459_("Damage");
               yaw = (double)entity.m_146908_();
               pitch = (double)entity.m_146909_();

               for(int index4 = 0; index4 < 1; ++index4) {
                  entity.m_146922_((float)(yaw + (Math.random() - 0.5) * (5.0 + CNT6 * 3.0)));
                  entity.m_146926_((float)(pitch + (Math.random() - 0.5) * (5.0 + CNT6 * 3.0)));
                  entity.m_5618_(entity.m_146908_());
                  entity.m_5616_(entity.m_146908_());
                  entity.f_19859_ = entity.m_146908_();
                  entity.f_19860_ = entity.m_146909_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.f_20884_ = _entity.m_146908_();
                     _entity.f_20886_ = _entity.m_146908_();
                  }

                  Level projectileLevel = entity.m_9236_();
                  if (!projectileLevel.m_5776_()) {
                     Projectile _entityToSpawn = ((<undefinedtype>)(new Object() {
                        public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                           AbstractArrow entityToSpawn = new BulletCursePowerProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CURSE_POWER_PROJECTILE.get(), level);
                           entityToSpawn.m_5602_(shooter);
                           entityToSpawn.m_36781_((double)damage);
                           entityToSpawn.m_36735_(knockback);
                           entityToSpawn.m_20225_(true);
                           entityToSpawn.m_36767_(piercing);
                           return entityToSpawn;
                        }
                     })).getArrow(projectileLevel, entity, (float)damage, 0, (byte)1);
                     _entityToSpawn.m_6034_(entity.m_20185_(), entity.m_20188_() - 0.1, entity.m_20189_());
                     _entityToSpawn.m_6686_(entity.m_20154_().f_82479_, entity.m_20154_().f_82480_, entity.m_20154_().f_82481_, (float)(2.5 * CNT6 + Math.random() * 0.2), 0.0F);
                     projectileLevel.m_7967_(_entityToSpawn);
                  }
               }

               entity.m_146922_((float)yaw);
               entity.m_146926_((float)pitch);
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               entity.getPersistentData().m_128347_("Damage", energy);
               entity.getPersistentData().m_128347_("Range", range);
               entity.getPersistentData().m_128347_("knockback", 2.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt7", energy);
            } else if (entity.getPersistentData().m_128459_("cnt1") > 60.0 + energy * 0.5) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }
         }

      }
   }
}
