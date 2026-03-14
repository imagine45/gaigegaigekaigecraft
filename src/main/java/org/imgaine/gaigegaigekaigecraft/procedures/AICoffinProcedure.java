package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class AICoffinProcedure {
   public AICoffinProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double y_pos = 0.0;
         boolean successed = false;
         boolean flag_kill = false;
         Entity entity_target = null;
         Entity entity_stone = null;
         Entity entity_owner = null;
         entity_owner = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
         entity_target = (new BiFunction<LevelAccessor, String, Entity>() {
            public Entity apply(LevelAccessor levelAccessor, String uuid) {
               if (levelAccessor instanceof ServerLevel serverLevel) {
                  try {
                     return serverLevel.m_8791_(UUID.fromString(uuid));
                  } catch (Exception var5) {
                  }
               }

               return null;
            }
         }).apply(world, entity.getPersistentData().m_128461_("TARGET"));
         if (entity.m_6084_()) {
            successed = false;
            entity.getPersistentData().m_128347_("cnt_life", entity.getPersistentData().m_128459_("cnt_life") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_life") == 15.0 && entity_owner instanceof LivingEntity) {
               entity_owner.getPersistentData().m_128379_("StartDomainAttack", true);
            }

            if (entity_target instanceof LivingEntity) {
               if (entity_target.m_6084_()) {
                  entity_target.m_20256_(new Vec3(0.0, 0.0, 0.0));
                  entity_target.m_6021_(entity.m_20185_(), entity.m_20186_() + 0.25, entity.m_20189_());
                  if (entity_target instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                     _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + 0.25, entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 2, 9, false, false));
                     }
                  }

                  if (entity_target instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_target;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get(), 2, 0, false, false));
                     }
                  }

                  y_pos = entity.m_20186_();

                  for(int index0 = 0; index0 < (int)entity.m_20206_(); ++index0) {
                     if (!world.m_46859_(BlockPos.m_274561_(entity.m_20185_(), y_pos, entity.m_20189_()))) {
                        successed = true;
                        break;
                     }

                     ++y_pos;
                  }

                  if (successed) {
                     entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
                     entity.getPersistentData().m_128347_("death_count1", entity.getPersistentData().m_128459_("death_count1") + 1.0);
                     if (entity.getPersistentData().m_128459_("death_count1") > 0.0) {
                        entity.getPersistentData().m_128347_("death_count1", -20.0);
                        entity.getPersistentData().m_128347_("death_count2", entity.getPersistentData().m_128459_("death_count2") + 1.0);

                        for(int index1 = 0; index1 < 2; ++index1) {
                           if (!entity_target.m_9236_().m_5776_() && entity_target.m_20194_() != null) {
                              entity_target.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_target.m_20182_(), entity_target.m_20155_(), entity_target.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_target.m_9236_() : null, 4, entity_target.m_7755_().getString(), entity_target.m_5446_(), entity_target.m_9236_().m_7654_(), entity_target), "playsound ui.button.click master @s");
                           }
                        }

                        if (entity.getPersistentData().m_128459_("death_count2") <= 3.0) {
                           if (!entity_target.m_9236_().m_5776_() && entity_target.m_20194_() != null) {
                              Commands var10000 = entity_target.m_20194_().m_129892_();
                              CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity_target.m_20182_(), entity_target.m_20155_(), entity_target.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_target.m_9236_() : null, 4, entity_target.m_7755_().getString(), entity_target.m_5446_(), entity_target.m_9236_().m_7654_(), entity_target);
                              CompoundTag var10003 = entity.getPersistentData();
                              var10000.m_230957_(var10001, "title @s title {\"text\":\"\\uE11" + Math.round(4.0 - var10003.m_128459_("death_count2")) + "\"}");
                           }
                        } else {
                           if (!entity_target.m_9236_().m_5776_() && entity_target.m_20194_() != null) {
                              entity_target.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_target.m_20182_(), entity_target.m_20155_(), entity_target.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_target.m_9236_() : null, 4, entity_target.m_7755_().getString(), entity_target.m_5446_(), entity_target.m_9236_().m_7654_(), entity_target), "title @s title {\"text\":\"\"}");
                           }

                           if (!entity_target.m_9236_().m_5776_() && entity_target.m_20194_() != null) {
                              entity_target.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_target.m_20182_(), entity_target.m_20155_(), entity_target.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_target.m_9236_() : null, 4, entity_target.m_7755_().getString(), entity_target.m_5446_(), entity_target.m_9236_().m_7654_(), entity_target), "kill @s");
                           }

                           if (!entity.m_9236_().m_5776_()) {
                              entity.m_146870_();
                           }

                           flag_kill = true;
                        }
                     }
                  } else {
                     entity.getPersistentData().m_128347_("death_count1", 0.0);
                     entity.getPersistentData().m_128347_("death_count2", 0.0);
                  }
               } else {
                  if (!entity.m_9236_().m_5776_()) {
                     entity.m_146870_();
                  }

                  flag_kill = true;
               }
            } else {
               entity.getPersistentData().m_128347_("death_count1", 0.0);
               entity.getPersistentData().m_128347_("death_count2", 0.0);
            }
         }

         if (!entity.m_6084_() || flag_kill) {
            entity_stone = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("CONNECT_UUID"));

            for(int index2 = 0; index2 < 100; ++index2) {
               y_pos = entity.m_20186_();
               successed = true;

               for(int index3 = 0; index3 < (int)entity.m_20206_(); ++index3) {
                  if (!world.m_46859_(BlockPos.m_274561_(entity.m_20185_(), y_pos, entity.m_20189_()))) {
                     successed = false;
                     break;
                  }

                  ++y_pos;
               }

               if (successed) {
                  break;
               }

               entity.m_6021_(entity.m_20185_(), entity.m_20186_() + 1.0, entity.m_20189_());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_() + 1.0, entity.m_20189_(), entity.m_146908_(), entity.m_146909_());
               }
            }

            if (entity_target instanceof LivingEntity) {
               entity_target.m_20256_(new Vec3(0.0, 0.0, 0.0));
               entity_target.m_6021_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_());
               if (entity_target instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity_target;
                  _serverPlayer.f_8906_.m_9774_(entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity_target.m_146908_(), entity_target.m_146909_());
               }

               if (!entity_target.m_9236_().m_5776_() && entity_target.m_20194_() != null) {
                  entity_target.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_target.m_20182_(), entity_target.m_20155_(), entity_target.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_target.m_9236_() : null, 4, entity_target.m_7755_().getString(), entity_target.m_5446_(), entity_target.m_9236_().m_7654_(), entity_target), "title @s title {\"text\":\"\"}");
               }
            }

            if (entity_stone instanceof LivingEntity) {
               if (flag_kill) {
                  if (!entity_stone.m_9236_().m_5776_()) {
                     entity_stone.m_146870_();
                  }
               } else if (!entity_stone.m_9236_().m_5776_() && entity_stone.m_20194_() != null) {
                  entity_stone.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity_stone.m_20182_(), entity_stone.m_20155_(), entity_stone.m_9236_() instanceof ServerLevel ? (ServerLevel)entity_stone.m_9236_() : null, 4, entity_stone.m_7755_().getString(), entity_stone.m_5446_(), entity_stone.m_9236_().m_7654_(), entity_stone), "kill @s");
               }
            }

            if (!flag_kill) {
               y_pos = entity.m_20186_();

               for(int index4 = 0; index4 < (int)entity.m_20206_(); ++index4) {
                  world.m_46796_(2001, BlockPos.m_274561_(entity.m_20185_(), y_pos, entity.m_20189_()), Block.m_49956_(Blocks.f_50045_.m_49966_()));
                  ++y_pos;
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
