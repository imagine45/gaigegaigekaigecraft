package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.entity.EntityItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class LightningStrikeProcedure {
   public LightningStrikeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double max_power = 0.0;
         double energy = 0.0;
         double repeat_num_now = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double x_pos_test = 0.0;
         double y_pos_test = 0.0;
         double z_pos_test = 0.0;
         double CNT6 = 0.0;
         if ((entity.getPersistentData().m_128459_("cnt1") != 0.0 || !entity.m_20069_()) && !(entity.getPersistentData().m_128459_("cnt2") > 180.0)) {
            entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), 2, 0.33, 0.33, 0.33, 0.0);
            }

            if (entity.getPersistentData().m_128459_("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_5594_((Player)null, BlockPos.m_274561_(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F);
                  } else {
                     _level.m_7785_(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.m_5776_()) {
                     _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               for(int index0 = 0; index0 < 100; ++index0) {
                  logic_attack = false;
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(128.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entity != entityiterator) {
                        if (!LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (!(entityiterator instanceof EntityItemEntity)) {
                              continue;
                           }

                           ItemStack var10000;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entityiterator;
                              var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.f_41583_;
                           }

                           if (var10000.m_41720_() != JujutsucraftModItems.NYOI_STAFF.get() || !entity.m_20149_().equals(entityiterator.getPersistentData().m_128461_("OWNER_UUID"))) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("Thunder") >= 5.0) {
                           logic_a = true;
                           logic_attack = true;
                           power = Math.min(entityiterator.getPersistentData().m_128459_("Thunder"), 15.0) - 5.0;
                           dis = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           x_target = entityiterator.m_20185_();
                           y_target = entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5 + (double)entityiterator.m_20206_() * 0.5 * Math.random();
                           z_target = entityiterator.m_20189_();
                           entityiterator.getPersistentData().m_128347_("Thunder", 0.0);
                           break;
                        }
                     }
                  }

                  if (!logic_attack) {
                     entity.getPersistentData().m_128347_("Damage", max_power);
                     break;
                  }

                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
                  z_pos = entity.m_20189_();
                  energy = 1.0 + power * 0.05;
                  repeat_num = (double)Math.round(dis * 4.0 + 4.0);
                  repeat_num_now = 0.0;

                  for(int index1 = 0; index1 < (int)repeat_num; ++index1) {
                     repeat_num_now = (double)Math.round(repeat_num_now + 1.0);
                     x_power = x_target - x_pos;
                     y_power = y_target - y_pos;
                     z_power = z_target - z_pos;
                     dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                     if (dis != 0.0) {
                        x_power /= dis * 4.0;
                        y_power /= dis * 4.0;
                        z_power /= dis * 4.0;
                        if (repeat_num_now < repeat_num) {
                           if (repeat_num_now % 4.0 == 1.0 || world.m_8055_(BlockPos.m_274561_(x_pos + x_power * 2.0, y_pos + y_power * 2.0, z_pos + z_power * 2.0)).m_60815_()) {
                              for(int index2 = 0; index2 < 32; ++index2) {
                                 x_power = (Math.random() - 0.5) * dis * 3.0;
                                 y_power = (Math.random() - 0.5) * dis * 3.0;
                                 z_power = (Math.random() - 0.5) * dis * 3.0;
                                 x_power = x_target + x_power;
                                 y_power = y_target + y_power;
                                 z_power = z_target + z_power;
                                 entity.getPersistentData().m_128347_("x_power", x_power - x_pos);
                                 entity.getPersistentData().m_128347_("y_power", y_power - y_pos);
                                 entity.getPersistentData().m_128347_("z_power", z_power - z_pos);
                                 entity.getPersistentData().m_128347_("cnt2", Math.sqrt(Math.pow(entity.getPersistentData().m_128459_("x_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("y_power"), 2.0) + Math.pow(entity.getPersistentData().m_128459_("z_power"), 2.0)));
                                 if (entity.getPersistentData().m_128459_("cnt2") != 0.0) {
                                    entity.getPersistentData().m_128347_("x_power", entity.getPersistentData().m_128459_("x_power") / (entity.getPersistentData().m_128459_("cnt2") * 4.0));
                                    entity.getPersistentData().m_128347_("y_power", entity.getPersistentData().m_128459_("y_power") / (entity.getPersistentData().m_128459_("cnt2") * 4.0));
                                    entity.getPersistentData().m_128347_("z_power", entity.getPersistentData().m_128459_("z_power") / (entity.getPersistentData().m_128459_("cnt2") * 4.0));
                                 }

                                 x_power = entity.getPersistentData().m_128459_("x_power");
                                 y_power = entity.getPersistentData().m_128459_("y_power");
                                 z_power = entity.getPersistentData().m_128459_("z_power");
                                 x_pos_test = x_pos;
                                 y_pos_test = y_pos;
                                 z_pos_test = z_pos;
                                 logic_attack = true;

                                 for(int index3 = 0; index3 < 2; ++index3) {
                                    if (world.m_8055_(BlockPos.m_274561_(x_pos_test, y_pos_test, z_pos_test)).m_60815_()) {
                                       logic_attack = false;
                                       break;
                                    }

                                    x_pos_test += x_power;
                                    y_pos_test += y_power;
                                    z_pos_test += z_power;
                                 }

                                 if (logic_attack) {
                                    break;
                                 }
                              }
                           }

                           x_power = entity.getPersistentData().m_128459_("x_power");
                           y_power = entity.getPersistentData().m_128459_("y_power");
                           z_power = entity.getPersistentData().m_128459_("z_power");
                        }
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "particle dust 0.973 0.220 1.000 1 " + x_pos + " " + y_pos + " " + z_pos + " 0 0 0 1 1 force");
                     }

                     if (repeat_num_now % 2.0 == 0.0) {
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                        }

                        if (repeat_num_now % 4.0 == 0.0) {
                           if (world instanceof ServerLevel) {
                              ServerLevel _level = (ServerLevel)world;
                              _level.m_8767_(ParticleTypes.f_123747_, x_pos, y_pos, z_pos, 1, 0.1, 0.1, 0.1, 0.0);
                           }

                           entity.getPersistentData().m_128347_("Damage", 30.0 * energy);
                           entity.getPersistentData().m_128347_("Range", 5.0);
                           entity.getPersistentData().m_128347_("knockback", 0.1);
                           entity.getPersistentData().m_128347_("projectile_type", 1.0);
                           entity.getPersistentData().m_128347_("effect", 1.0);
                           entity.getPersistentData().m_128347_("effectConfirm", 2.0);
                           entity.getPersistentData().m_128379_("ignore", true);
                           RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)(20.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123813_, x_pos, y_pos, z_pos, (int)(4.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              if (world instanceof ServerLevel) {
                                 ServerLevel _level = (ServerLevel)world;
                                 _level.m_8767_(ParticleTypes.f_123796_, x_pos, y_pos, z_pos, (int)(4.0 * energy), 0.25, 0.25, 0.25, 0.5 * energy);
                              }

                              entity.getPersistentData().m_128347_("BlockRange", 1.0 * energy);
                              entity.getPersistentData().m_128347_("BlockDamage", 4.0 * energy);
                              entity.getPersistentData().m_128379_("noEffect", true);
                              BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                           }
                        }
                     }

                     if (repeat_num_now + 1.0 >= repeat_num) {
                        if (dis > 1.5) {
                           repeat_num = (double)Math.round(repeat_num + 1.0);
                        } else if (repeat_num_now >= repeat_num) {
                           if (dis < 0.3) {
                              break;
                           }

                           repeat_num = (double)Math.round(repeat_num + 1.0);
                        }
                     }

                     x_pos += x_power;
                     y_pos += y_power;
                     z_pos += z_power;
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:electric_shock")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.m_5776_()) {
                        _level.m_5594_((Player)null, BlockPos.m_274561_(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F);
                     } else {
                        _level.m_7785_(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jujutsucraft:thunder_impact")), SoundSource.NEUTRAL, (float)energy, 1.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_THUNDER_BLUE_MINI.get(), x_pos, y_pos, z_pos, (int)(25.0 * energy), 0.5, 0.5, 0.5, 1.0 * energy);
                  }

                  max_power = Math.max(max_power, entity.getPersistentData().m_128459_("Damage"));
               }

               if (logic_a) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21011_(InteractionHand.MAIN_HAND, true);
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s slowness 1 4 true");
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("cnt1") > 10.0) {
               entity.getPersistentData().m_128347_("skill", 0.0);
            }

            x_pos = entity.m_20185_();
            y_pos = entity.m_20186_() + (double)entity.m_20206_() * 0.5;
            z_pos = entity.m_20189_();
            power = entity.getPersistentData().m_128459_("Damage");
            entity.getPersistentData().m_128347_("Damage", 10.0);
            entity.getPersistentData().m_128347_("Range", (double)(2.0F + entity.m_20205_()));
            entity.getPersistentData().m_128347_("knockback", 0.1);
            entity.getPersistentData().m_128347_("effect", 9.0);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            entity.getPersistentData().m_128347_("Damage", Math.max(power, entity.getPersistentData().m_128459_("Damage")));
         } else {
            LightningStrike2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
