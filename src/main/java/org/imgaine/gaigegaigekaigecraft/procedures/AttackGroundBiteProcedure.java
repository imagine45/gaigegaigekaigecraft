package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade15Entity;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

public class AttackGroundBiteProcedure {
   public AttackGroundBiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double entity_height = 0.0;
         double z_power = 0.0;
         entity.f_19789_ = 0.0F;
         entity.getPersistentData().m_128347_("cnt1", entity.getPersistentData().m_128459_("cnt1") + 1.0);
         entity_height = (double)(entity.m_20206_() * 5.0F + 1.0F);
         if (entity.getPersistentData().m_128459_("cnt2") <= 2.0) {
            if (entity.getPersistentData().m_128459_("cnt2") == 0.0) {
               if (entity.m_20096_()) {
                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  entity.getPersistentData().m_128347_("cnt2", 1.0);
                  entity.getPersistentData().m_128347_("y_pos", y);
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {NoAI:1b}");
                  }
               } else if (entity.getPersistentData().m_128459_("cnt1") > 200.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            } else if (entity.getPersistentData().m_128459_("cnt2") == 1.0) {
               entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~5");
               }

               if (entity.m_146909_() > 80.0F) {
                  entity.getPersistentData().m_128347_("cnt2", 2.0);
               }
            } else {
               entity.m_6021_(x, y - 0.5, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.f_8906_.m_9774_(x, y - 0.5, z, entity.m_146908_(), entity.m_146909_());
               }

               y_pos = y - 1.0;

               for(int index0 = 0; index0 < (int)Math.round(entity_height) && !(y_pos > entity.getPersistentData().m_128459_("y_pos")); ++index0) {
                  if (world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_() && !world.m_8055_(BlockPos.m_274561_(x, y_pos + 1.0, z)).m_60815_()) {
                     world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + 0.5, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }

               if (y < entity.getPersistentData().m_128459_("y_pos") - entity_height) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     y_pos = ((Entity)var10000).m_20186_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     z_pos = ((Entity)var10000).m_20189_();
                  } else {
                     x_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_();
                     y_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_();
                     z_pos = (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_();
                  }

                  for(int index1 = 0; index1 < 255; ++index1) {
                     if (world.m_8055_(BlockPos.m_274561_(x_pos, y_pos, z_pos)).m_60815_()) {
                        entity.getPersistentData().m_128347_("y_pos", y_pos);
                        y_pos -= entity_height;
                        break;
                     }

                     --y_pos;
                  }

                  entity.m_6021_(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                  }

                  entity.getPersistentData().m_128347_("cnt1", 0.0);
                  entity.getPersistentData().m_128347_("cnt2", 3.0);
               }
            }
         } else if (entity.getPersistentData().m_128459_("cnt2") == 3.0) {
            if (entity instanceof CursedSpiritGrade15Entity) {
               ((CursedSpiritGrade15Entity)entity).setAnimation("empty");
            }

            if (entity instanceof CursedSpiritGrade15Entity) {
               ((CursedSpiritGrade15Entity)entity).setAnimation("right_arm_up");
            }

            entity.m_20256_(new Vec3(0.0, 0.0, 0.0));
            entity.m_6021_(x, y + 1.5, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.f_8906_.m_9774_(x, y + 1.5, z, entity.m_146908_(), entity.m_146909_());
            }

            y_pos = y;

            for(int index2 = 0; index2 < 6 && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_(); ++index2) {
               if (!world.m_8055_(BlockPos.m_274561_(x, y_pos + 1.0, z)).m_60815_() && world.m_8055_(BlockPos.m_274561_(x, y_pos, z)).m_60815_()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123796_, x, y_pos, z, 5, 0.5, 0.5, 0.5, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.m_8767_(ParticleTypes.f_123813_, x, y_pos, z, 5, 0.5, 0.5, 0.5, 0.5);
                  }

                  world.m_46796_(2001, BlockPos.m_274561_(x, y_pos + 0.5, z), Block.m_49956_(world.m_8055_(BlockPos.m_274561_(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            entity.getPersistentData().m_128347_("Damage", 14.0);
            entity.getPersistentData().m_128347_("knockback", 1.5);
            entity.getPersistentData().m_128347_("Range", 3.0 * ReturnEntitySizeProcedure.execute(entity));
            entity.getPersistentData().m_128347_("effect", 1.0);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            if (y > entity.getPersistentData().m_128459_("y_pos") + 2.0) {
               entity.getPersistentData().m_128347_("cnt2", 4.0);
            }

            if (entity.m_146909_() > -80.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         } else {
            entity.getPersistentData().m_128347_("cnt3", entity.getPersistentData().m_128459_("cnt3") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt3") > 10.0) {
               if (entity.getPersistentData().m_128459_("cnt3") > 20.0) {
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }

               if (entity.m_146909_() < -10.0F) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~10");
                  }
               } else if (entity.m_146909_() > 10.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-10");
               }
            } else if (entity.m_146909_() > -80.0F && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         }

         entity.getPersistentData().m_128347_("Damage", 0.0);
      }
   }
}
